package com.origin.ueliton.bulltrail.data;

import com.origin.ueliton.bulltrail.model.Animal;

import java.util.List;

/**
 * Created by ueliton on 02/04/16.
 */
public interface AnimalRepository {

    void getAnimals(LoadAnimalsCallBack loadAnimalsCallBack);
    void getAnimal(Long animalId, LoadAnimalCallBack caploadAnimalCallBackture);
    boolean saveAnimal(Animal animal);

    interface LoadAnimalsCallBack {
        void onAnimalsLoaded(List<Animal> animals);
    }

    interface LoadAnimalCallBack{
        void onAnimalLoaded(Animal animal);
    }
}
