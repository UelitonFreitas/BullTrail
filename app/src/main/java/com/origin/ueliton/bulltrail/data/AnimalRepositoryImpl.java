package com.origin.ueliton.bulltrail.data;

import com.origin.ueliton.bulltrail.data.DAO.AnimalDAO;
import com.origin.ueliton.bulltrail.model.Animal;

/**
 * Created by ueliton on 02/04/16.
 */
public class AnimalRepositoryImpl implements AnimalRepository {

    @Override
    public void getAnimals(LoadAnimalsCallBack loadAnimalCallBack) {
        AnimalDAO.findAllAnimals(loadAnimalCallBack);
    }

    @Override
    public void getAnimal(Long animalId, LoadAnimalCallBack loadAnimalCallBack) {

    }

    @Override
    public void saveAnimal(Animal animal) {
        AnimalDAO.save(animal);
    }

    @Override
    public void refreshData() {

    }

}
