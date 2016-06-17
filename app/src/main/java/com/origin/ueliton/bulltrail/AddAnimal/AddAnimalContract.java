package com.origin.ueliton.bulltrail.AddAnimal;

import com.origin.ueliton.bulltrail.model.Animal;

import java.io.IOException;

/**
 * Created by ueliton on 14/06/16.
 */
public class AddAnimalContract {
    public interface View {
        void showAnimalsList();
        void showEmptyAnimalMessage();
        void openCamera(String imagePath);
        Animal getAnimal();
        void showInvalidAnimalMessage();
    }

    public interface UserActionsListener {
        void saveAnimal(Animal animalName);
        void takePicture() throws IOException;
    }
}
