package com.origin.ueliton.bulltrail.data;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.google.common.collect.ImmutableList;
import com.origin.ueliton.bulltrail.model.Animal;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by ueliton on 07/05/16.
 */
public class InMemoryAnimalRepositoryImpl implements AnimalRepository{

    private final AnimalsServiceApi mAnimalServiceApi;

    /**
     * Reduz a visibilidade para o teste. É visível apenas para testes no mesmo pachage.
     */
    @VisibleForTesting
    List<Animal> mCachedAnimals;

    public InMemoryAnimalRepositoryImpl(@NonNull AnimalsServiceApi animalsServiceApi) {
        mAnimalServiceApi = checkNotNull(animalsServiceApi);
    }

    @Override
    public void getAnimals(@NonNull final LoadAnimalsCallBack callback) {
        checkNotNull(callback);

        if(mCachedAnimals == null){
            mAnimalServiceApi.getAnimals(new AnimalsServiceApi.LoadAnimalsCallBack<List<Animal>>() {
                @Override
                public void onAnimalsLoaded(List<Animal> animals) {
                    mCachedAnimals = ImmutableList.copyOf(animals);
                    callback.onAnimalsLoaded(mCachedAnimals);
                }
            });
        }
        else {
            callback.onAnimalsLoaded(mCachedAnimals);
        }
    }

    @Override
    public void getAnimal(@NonNull Long animalId, @NonNull final LoadAnimalCallBack callBack) {
        checkNotNull(animalId);
        checkNotNull(callBack);
        mAnimalServiceApi.getAnimal(animalId, new AnimalsServiceApi.LoadAnimalCallBack() {
            @Override
            public void onLoadedAnimal(Animal animal) {
                callBack.onAnimalLoaded(animal);
            }
        });
    }

    @Override
    public void saveAnimal(@NonNull Animal animal) {
        checkNotNull(animal);
        mAnimalServiceApi.saveAnimal(animal);
        refreshData();
    }

    @Override
    public void refreshData() {
        mCachedAnimals = null;
    }

}
