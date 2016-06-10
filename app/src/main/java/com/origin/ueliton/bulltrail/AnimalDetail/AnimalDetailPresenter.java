package com.origin.ueliton.bulltrail.AnimalDetail;

import android.support.annotation.NonNull;

import com.origin.ueliton.bulltrail.data.AnimalRepository;
import com.origin.ueliton.bulltrail.model.Animal;
import com.origin.ueliton.bulltrail.util.DateUtil;
import com.origin.ueliton.bulltrail.util.ImageFile;
import com.origin.ueliton.bulltrail.util.StringUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by ueliton on 5/21/16.
 */
public class AnimalDetailPresenter implements AnimalDetailContract.UserActionsListener {


    private final AnimalDetailContract.View mAnimalDetailView;
    private final AnimalRepository mAnimalDetailRepository;
    private ImageFile mImageFile;

    public AnimalDetailPresenter(@NonNull AnimalRepository animalDetailRepository, @NonNull AnimalDetailContract.View animalDetailView, ImageFile imageFile) {
        mAnimalDetailRepository = checkNotNull(animalDetailRepository, "animalDetailRepository cannot be null!");
        mAnimalDetailView = checkNotNull(animalDetailView, "animalDetailView cannot be null!");
        mImageFile = checkNotNull(imageFile, "imageFile cannot be null");
    }

    @Override
    public void loadAnimal(Long animalId) {

        mAnimalDetailView.setProgressIndicator(true);

        mAnimalDetailRepository.getAnimal(animalId, new AnimalRepository.LoadAnimalCallBack(){
            @Override
            public void onAnimalLoaded(Animal animal) {

                mAnimalDetailView.setProgressIndicator(false);
                if(animal == null)
                    mAnimalDetailView.showAnimalNotFoundView();
                else {
                    showAnimal(animal);
                }
            }
        });
    }

    @Override
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

        if(animal.isEmpty()){
            mAnimalDetailView.showEmptyAnimalMessage();
        }
        else {
            mAnimalDetailRepository.saveAnimal(animal);
            mAnimalDetailView.showAnimalsList();
        }

    }

    @Override
    public void takePicture() throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        mImageFile.create(imageFileName, ".jpg");
        String imagePath = mImageFile.getPath();
        mAnimalDetailView.openCamera(imagePath);
    }


    private void showAnimal(Animal animal) {

        mAnimalDetailView.showAnimalName(animal.getName());

        mAnimalDetailView.showAnimalRegisterNumber(animal.getRegisterNumber());

        mAnimalDetailView.showAnimalBirthDate(animal.getBirthDate());

        mAnimalDetailView.showAnimalRace(animal.getRace());

        mAnimalDetailView.showAnimalCoat(animal.getCoat());

        mAnimalDetailView.showAnimalFatherName(animal.getFather());

        mAnimalDetailView.showAnimalMotherName(animal.getMother());

        mAnimalDetailView.showAnimalEthnicity(animal.getEthnicity());

        mAnimalDetailView.showAnimalWeight(animal.getWeight());

        mAnimalDetailView.showAnimalAge(animal.getAge());

        if(StringUtil.isEmpty(animal.getImagePath())){
            mAnimalDetailView.showEmptyImage();
        }
        else {
            mAnimalDetailView.showAnimalImage(animal.getImagePath());
        }
    }
}
