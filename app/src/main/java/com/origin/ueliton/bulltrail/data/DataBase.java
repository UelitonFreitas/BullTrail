package com.origin.ueliton.bulltrail.data;

/**
 * Created by ueliton on 02/04/16.
 */
public abstract class DataBase {
    private static AnimalRepository animalsRepository;

    public static AnimalRepository getAnimalsRepository() {
        if(animalsRepository == null)
            animalsRepository = new AnimalRepositoryImpl();
        return animalsRepository;
    }
}
