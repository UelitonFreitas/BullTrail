package com.origin.ueliton.bulltrail.AddAnimal;

import android.support.annotation.NonNull;

import com.origin.ueliton.bulltrail.data.AnimalRepository;
import com.origin.ueliton.bulltrail.model.Animal;
import com.origin.ueliton.bulltrail.util.ImageFile;
import com.origin.ueliton.bulltrail.util.StringUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by ueliton on 14/06/16.
 */
public class AddAnimalPresenter {
    private final AnimalRepository mAnimalRepository;
    private final AddAnimalContract.View mAddAnimalView;
    private final ImageFile mImageFile;

    public AddAnimalPresenter(@NonNull AnimalRepository animalRepository,
                              @NonNull AddAnimalContract.View addAnimalView,
                              @NonNull ImageFile imageFile) {

        checkNotNull(animalRepository, "AnimalRepository can not be null");
        checkNotNull(addAnimalView, "AddAnimalContract can not be null");
        checkNotNull(imageFile, "ImageFile can not be null");

        mAnimalRepository = animalRepository;
        mAddAnimalView = addAnimalView;
        mImageFile = imageFile;

    }

    public void saveAnimal(String animalName,
                           String animalRegisterNumber,
                           Date animalBirthDate,
                           String animalRace,
                           String animalCoatName,
                           String animalFatherName,
                           String animalMotherName,
                           String animalEthinicity,
                           Integer animalWeight,
                           Integer animalAge,
                           String animalImage) {

        if (StringUtil.isEmpty(animalRegisterNumber)) {
            mAddAnimalView.showEmptyAnimalMessage();
        } else {
            Animal animal = new Animal(animalName,
                    animalRegisterNumber,
                    animalBirthDate,
                    animalRace,
                    animalCoatName,
                    animalFatherName,
                    animalMotherName,
                    animalEthinicity,
                    animalWeight,
                    animalAge,
                    animalImage);

            mAnimalRepository.saveAnimal(animal);

            mAddAnimalView.showAnimalsList();
        }
    }

    public void takePicture() throws IOException {

        String timeStamp = new SimpleDateFormat("yyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        mImageFile.create(imageFileName, ".jpg");
        mAddAnimalView.openCamera(mImageFile.getPath());
    }

    public void saveAnimal(Animal animalToBeSaved) {

        if (animalToBeSaved.isEmpty()) {
            mAddAnimalView.showEmptyAnimalMessage();
            return;
        }

        if (!animalToBeSaved.isValid()) {
            mAddAnimalView.showInvalidAnimalMessage();
            return;
        }

        mAnimalRepository.saveAnimal(animalToBeSaved);
        mAddAnimalView.showAnimalsList();


    }
}
