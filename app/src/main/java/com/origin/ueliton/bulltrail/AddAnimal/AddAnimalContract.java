package com.origin.ueliton.bulltrail.AddAnimal;

import com.origin.ueliton.bulltrail.model.Animal;

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
}
