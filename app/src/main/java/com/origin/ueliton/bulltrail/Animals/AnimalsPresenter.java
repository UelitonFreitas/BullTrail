package com.origin.ueliton.bulltrail.Animals;

import android.support.annotation.NonNull;

import com.origin.ueliton.bulltrail.data.AnimalRepository;
import com.origin.ueliton.bulltrail.model.Animal;
import com.origin.ueliton.bulltrail.util.EspressoIdlingResource;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by ueliton on 07/05/16.
 */
public class AnimalsPresenter implements AnimalsContract.UserActionsListener{

    private final AnimalRepository mAnimalsRepository;
    private final AnimalsContract.View mAnimalsView;

    public AnimalsPresenter(@NonNull AnimalRepository animalRepository,@NonNull AnimalsContract.View animalsView) {
        mAnimalsRepository = checkNotNull(animalRepository, "animalRepository cannot be null");
        mAnimalsView= checkNotNull(animalsView, "animalsView cannot be null");

    }

    @Override
    public void addAnimal() {
        mAnimalsView.showAddAnimal();
    }

    @Override
    public void loadAnimals() {

        mAnimalsView.setProgressIndicator(true);

        EspressoIdlingResource.increment();

        mAnimalsRepository.getAnimals(new AnimalRepository.LoadAnimalsCallBack() {
            @Override
            public void onAnimalsLoaded(List<Animal> animals) {
                EspressoIdlingResource.decrement();
                mAnimalsView.setProgressIndicator(false);
                mAnimalsView.showAnimals(animals);
            }
        });
    }


}
