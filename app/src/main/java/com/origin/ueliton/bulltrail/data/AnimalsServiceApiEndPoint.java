package com.origin.ueliton.bulltrail.data;

import android.util.ArrayMap;

import com.origin.ueliton.bulltrail.model.Animal;

import java.util.Date;

/**
 * Created by ueliton on 13/06/16.
 * Endooint dos dados. No momento está sendo criado em tempo de execução
 * mas posteriormente o SQlite.
 */
public class AnimalsServiceApiEndPoint {

    private static final ArrayMap<Long, Animal> DATA;

    static {
        DATA = new ArrayMap<>(2);
        addAnimal("Trovão",
                "12345678",
                new Date(),
                "Nelori",
                "Branco",
                "Nuvem",
                "Eletricidade",
                "Negro",
                200,
                10,
                null);

        addAnimal("Relâmpago",
                "87654321",
                new Date(),
                "Nelori",
                "Branco",
                "Nuvem",
                "Som",
                "Branco",
                300,
                20,
                null);
    }

    private static void addAnimal(String animalName,
                                  String animalRegisterNumber,
                                  Date animalBirthDate,
                                  String animalRace,
                                  String animalCoatName,
                                  String animalFatherName,
                                  String animalMotherName,
                                  String animalEthnicity,
                                  Integer animalWeight,
                                  Integer animalAge,
                                  String animalImage) {

        Animal animal = new Animal(animalName,
                animalRegisterNumber,
                animalBirthDate,
                animalRace,
                animalCoatName,
                animalFatherName,
                animalMotherName,
                animalEthnicity,
                animalWeight,
                animalAge,
                animalImage);

        DATA.put(animal.getId(), animal);
    }


    /**
    *Animals mostrados no inicio do app.
    */
    public static ArrayMap<Long,Animal> loadPersistenceAnimals() {
        return DATA;
    }
}
