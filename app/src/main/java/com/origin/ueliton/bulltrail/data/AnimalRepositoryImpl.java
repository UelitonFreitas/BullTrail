package com.origin.ueliton.bulltrail.data;

import com.origin.ueliton.bulltrail.model.Animal;

/**
 * Created by ueliton on 02/04/16.
 */
public class AnimalRepositoryImpl implements AnimalRepository {
    @Override
    public void getAnimals(LoadAnimalsCallBack capture) {
        
    }

    @Override
    public void getAnimal(Long animalId, LoadAnimalCallBack caploadAnimalCallBackture) {

    }

    @Override
    public boolean saveAnimal(Animal animal) {
        return false;
    }

//    @Override
//    public List<Animal> findAll() {
////        return Animal.findAll();
//        return null;
//    }
//
//    @Override
//    public Animal findById(long animalId) {
////        return Animal.findById(animalId);
//        return null;
//    }
}