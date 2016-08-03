package com.origin.ueliton.bulltrail.AddAnimal;

import com.origin.ueliton.bulltrail.model.Animal;

import java.io.IOException;
import java.util.Date;

/**
 * Created by ueliton on 14/06/16.
 */
public class AddAnimalContract {
    public interface View {
        void showAnimalsList();

        void showEmptyRegisterAnimalMessage();

        void openCamera(String imagePath);

        Animal getAnimal();

        void showInvalidRegisterNumberAnimalMessage();

        void showEmptyNameMessage();

        void showDatePicker();

        void setDate(Date date);
    }

    public interface UserActionsListener {
        void onSaveAnimal();

        void onTakePicture() throws IOException;

        void onDateClick();

        void onDateSelected(Date date);
    }
}
