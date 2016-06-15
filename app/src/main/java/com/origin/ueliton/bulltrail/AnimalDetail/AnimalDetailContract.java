package com.origin.ueliton.bulltrail.AnimalDetail;

import com.origin.ueliton.bulltrail.model.Animal;

import java.io.IOException;
import java.util.Date;

/**
 * Created by ueliton on 5/21/16.
 */
public interface AnimalDetailContract {

    interface View{

        void setProgressIndicator(boolean active);

        void showAnimalName(String animalName);

        void showAnimalRegisterNumber(String animalRegisterNumberTest);

        void showAnimalBirthDate(Date animalBirthDateTest);

        void showAnimalRace(String animalRaceTest);

        void showAnimalCoat(String animalCoatNameTest);

        void showAnimalFatherName(String animalFatherNameTest);

        void showAnimalMotherName(String animalMotherName);

        void showAnimalEthnicity(String animalEthnicityTest);

        void showAnimalWeight(Integer animalWeightTest);

        void showAnimalAge(Integer animalBirthDateTest);

        void showAnimalNotFoundView();

        void showEmptyImage();

        void showAnimalImage(String imagePath);

        void showAnimalsList();

        void showEmptyAnimalMessage();

        void openCamera(String imagePath);

        Animal getAnimal();

        void showInvalidAnimalMessage();
    }

    interface UserActionsListener{

        void loadAnimal(Long id);

        void saveAnimal(Animal animal);
    }
}
