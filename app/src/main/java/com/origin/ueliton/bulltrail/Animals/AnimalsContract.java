package com.origin.ueliton.bulltrail.Animals;

import com.origin.ueliton.bulltrail.model.Animal;

import java.util.Date;
import java.util.List;

/**
 * Created by ueliton on 07/05/16.
 */
public interface AnimalsContract {

    interface UserActionsListener{
        void addAnimal();
        void loadAnimals();
    }

    interface View {
        void showAddAnimal();
        void showAnimalDetail(Animal animal);
        void showAnimals(List<Animal> animals);
        void setProgressIndicator(boolean active);
    }
}
