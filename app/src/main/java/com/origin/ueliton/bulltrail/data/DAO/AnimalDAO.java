package com.origin.ueliton.bulltrail.data.DAO;

import com.origin.ueliton.bulltrail.data.AnimalRepository;
import com.origin.ueliton.bulltrail.model.Animal;

import se.emilsjolander.sprinkles.Query;

/**
 * Created by ueliton on 7/31/16.
 */
public class AnimalDAO {
    public static void findAllAnimals(AnimalRepository.LoadAnimalsCallBack loadAnimalCallBack) {
        Animal.findAnimals(loadAnimalCallBack);
    }

    public static void save(Animal animal) {
        animal.save();
    }
}
