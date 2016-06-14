package com.origin.ueliton.bulltrail.data;

import com.origin.ueliton.bulltrail.model.Animal;

import java.util.List;

/**
 * Created by ueliton on 11/06/16.
 */
public interface AnimalsServiceApi {

    void getAnimals(LoadAnimalsCallBack loadAnimalsCallBack);
    void getAnimal(Long animalId, LoadAnimalCallBack callBack);
    void saveAnimal(Animal animal);

    interface LoadAnimalsCallBack<T> {
        void onAnimalsLoaded(T animals);
    }

    interface LoadAnimalCallBack{
        void onLoadedAnimal(Animal animal);
    }

}
