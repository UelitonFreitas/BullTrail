package com.origin.ueliton.bulltrail.animals.AddAnimal;

import com.origin.ueliton.bulltrail.AddAnimal.AddAnimalContract;
import com.origin.ueliton.bulltrail.AddAnimal.AddAnimalPresenter;
import com.origin.ueliton.bulltrail.data.AnimalRepository;
import com.origin.ueliton.bulltrail.model.Animal;
import com.origin.ueliton.bulltrail.util.ImageFile;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.Date;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ueliton on 6/1/16.
 */
public class AddAnimalPresenterTest {

    private static final String ANIMAL_NAME_TEST = "Fantasma";
    private static final String ANIMAL_REGISTER_NUMBER_TEST = "0000-0000";
    private static final Date ANIMAL_BIRTH_DATE_TEST = new Date();
    private static final String ANIMAL_RACE_TEST = "Canino";
    private static final String ANIMAL_COAT_NAME_TEST = "escura";
    private static final String ANIMAL_FATHER_NAME_TEST = "Lobo";
    private static final String ANIMAL_MOTHER_NAME = "Loba";
    private static final String ANIMAL_ETHNICITY_TEST = "Albino";
    private static final Integer ANIMAL_WEIGHT_TEST = 4547;
    private static final String ANIMAL_IMAGE_TEST = "path_to_a_image";
    private static final Integer ANIMAL_AGE_TEST = 2;

    private AddAnimalPresenter mAddAnimalPresenter;

    @Mock
    private AddAnimalContract.View mAddAnimalView;

    @Mock
    private AnimalRepository animalRepository;

    @Captor
    private ArgumentCaptor<AnimalRepository.LoadAnimalCallBack> mLoadAnimalCallBackCaptor;

    @Mock
    private ImageFile mImageFile;

    @Before
    public void setUpPresenter(){

        MockitoAnnotations.initMocks(this);

        mAddAnimalPresenter = new AddAnimalPresenter(animalRepository, mAddAnimalView, mImageFile);
    }

    @Test
    public void saveAnimal_showSuccessOnUI(){

        //When the presenter is asked to save a animal
        mAddAnimalPresenter.saveAnimal(ANIMAL_NAME_TEST,
                ANIMAL_REGISTER_NUMBER_TEST,
                ANIMAL_BIRTH_DATE_TEST,
                ANIMAL_RACE_TEST,
                ANIMAL_COAT_NAME_TEST,
                ANIMAL_FATHER_NAME_TEST,
                ANIMAL_MOTHER_NAME,
                ANIMAL_ETHNICITY_TEST,
                ANIMAL_WEIGHT_TEST,
                ANIMAL_AGE_TEST,
                ANIMAL_IMAGE_TEST);

        //Then the animals,
        verify(animalRepository).saveAnimal(any(Animal.class)); // is save on repository
        verify(mAddAnimalView).showAnimalsList(); // show animal list
    }

    @Test
    public void saveAnimalWithoutRegisterNumber_showInvalidAnimalUiError(){

        Animal animal = new Animal(ANIMAL_NAME_TEST,
                "",
                ANIMAL_BIRTH_DATE_TEST,
                ANIMAL_RACE_TEST,
                ANIMAL_COAT_NAME_TEST,
                ANIMAL_FATHER_NAME_TEST,
                ANIMAL_MOTHER_NAME,
                ANIMAL_ETHNICITY_TEST,
                ANIMAL_WEIGHT_TEST,
                ANIMAL_AGE_TEST,
                ANIMAL_IMAGE_TEST);

        when(mAddAnimalView.getAnimal()).thenReturn(animal);
        Animal animalToBeSaved = mAddAnimalView.getAnimal();

        //When the presenter is asked to save a animal without register number
        mAddAnimalPresenter.saveAnimal(animalToBeSaved);

        //Then show animal empty error message.
        verify(mAddAnimalView).showInvalidAnimalMessage();
    }

    @Test
    public void takePicture_createFileAndOpenCamera() throws IOException {

        mAddAnimalPresenter.takePicture();

        verify(mImageFile).create(anyString(), anyString());
        verify(mImageFile).getPath();
        verify(mAddAnimalView).openCamera(anyString());
    }

    @Test
    public void saveEmptyAnimal_showEmptyAnimalUiError(){

        when(mAddAnimalView.getAnimal()).thenReturn(new Animal());
        Animal animalToBeSaved = mAddAnimalView.getAnimal();

        mAddAnimalPresenter.saveAnimal(animalToBeSaved);

        verify(mAddAnimalView).showEmptyAnimalMessage();
    }
}
