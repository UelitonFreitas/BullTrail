package com.origin.ueliton.bulltrail;

import com.origin.ueliton.bulltrail.data.AnimalRepository;
import com.origin.ueliton.bulltrail.data.AnimalsRepository;
import com.origin.ueliton.bulltrail.data.AnimalsServiceApiImpl;
import com.origin.ueliton.bulltrail.util.ImageFile;
import com.origin.ueliton.bulltrail.util.ImageFileImpl;

/**
 * Injeção das implementações de produção.
 */
public class Injection {

    public static AnimalRepository provideAnimalRepository() {
        return AnimalsRepository.getInMemoryRepositoryInstance(new AnimalsServiceApiImpl());
    }

    public static ImageFile providesImageFile() {
        return new ImageFileImpl();
    }
}
