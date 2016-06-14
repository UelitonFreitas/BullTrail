package com.origin.ueliton.bulltrail.data;

import android.support.annotation.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by ueliton on 11/06/16.
 */
public class AnimalsRepository {

    private static AnimalRepository repository;

    public static AnimalRepository getInMemoryRepositoryInstance(@NonNull AnimalsServiceApi animalsServiceApi) {
        checkNotNull(animalsServiceApi);

        if(repository == null){
            repository = new InMemoryAnimalRepositoryImpl(animalsServiceApi);
        }
        return repository;
    }
}
