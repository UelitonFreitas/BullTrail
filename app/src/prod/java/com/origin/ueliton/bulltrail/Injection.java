package com.origin.ueliton.bulltrail;

import com.origin.ueliton.bulltrail.data.AnimalRepository;
import com.origin.ueliton.bulltrail.data.InMemoryAnimalRepositoryImpl;

public class Injection {

    public static AnimalRepository provideAnimalRepository() {
        return new InMemoryAnimalRepositoryImpl();
    }
}
