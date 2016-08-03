package com.origin.ueliton.bulltrail.AnimalDetail;

import android.support.annotation.NonNull;

import com.origin.ueliton.bulltrail.data.AnimalRepository;
import com.origin.ueliton.bulltrail.exceptions.EmptyFieldException;
import com.origin.ueliton.bulltrail.model.Animal;
import com.origin.ueliton.bulltrail.util.ImageFile;
import com.origin.ueliton.bulltrail.util.StringUtil;
import com.origin.ueliton.bulltrail.util.Validate;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by ueliton on 5/21/16.
 */
public class AnimalDetailPresenter implements AnimalDetailContract.UserActionsListener {


    private final AnimalDetailContract.View mAnimalDetailView;
    private final AnimalRepository mAnimalDetailRepository;
    private ImageFile mImageFile;

    public AnimalDetailPresenter(@NonNull AnimalRepository animalDetailRepository,
                                 @NonNull AnimalDetailContract.View animalDetailView,
                                 ImageFile imageFile) {
        mAnimalDetailRepository = checkNotNull(animalDetailRepository, "animalDetailRepository cannot be null!");
        mAnimalDetailView = checkNotNull(animalDetailView, "animalDetailView cannot be null!");
        mImageFile = checkNotNull(imageFile, "imageFile cannot be null");
    }

    @Override
    public void loadAnimal(Long animalId) {

        mAnimalDetailView.setProgressIndicator(true);

        mAnimalDetailRepository.getAnimal(animalId, new AnimalRepository.LoadAnimalCallBack() {
            @Override
            public void onAnimalLoaded(Animal animal) {

                mAnimalDetailView.setProgressIndicator(false);
                if (animal == null)
                    mAnimalDetailView.showAnimalNotFoundView();
                else {
                    showAnimal(animal);
                }
            }
        });
    }

    @Override
    public void saveAnimal(Animal animal) {

        try {
            validateFields(animal);
            mAnimalDetailRepository.saveAnimal(animal);
            mAnimalDetailView.showAnimalsList();
        } catch (EmptyFieldException e) {
            e.printStackTrace();
            mAnimalDetailView.showInvalidAnimalMessage();
        }

    }

    private void validateFields(Animal animalToBeSaved) throws EmptyFieldException {

        Validate.validateEmptyField(animalToBeSaved.getRegisterNumber());
        Validate.validateEmptyField(animalToBeSaved.getName());
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

        if (StringUtil.isEmpty(animal.getImagePath())) {
            mAnimalDetailView.showEmptyImage();
        } else {
            mAnimalDetailView.showAnimalImage(animal.getImagePath());
        }
    }
}
