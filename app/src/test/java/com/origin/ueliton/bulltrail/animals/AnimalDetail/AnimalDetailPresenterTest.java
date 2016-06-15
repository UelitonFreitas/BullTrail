package com.origin.ueliton.bulltrail.animals.AnimalDetail;

import com.origin.ueliton.bulltrail.AnimalDetail.AnimalDetailContract;
import com.origin.ueliton.bulltrail.AnimalDetail.AnimalDetailPresenter;
import com.origin.ueliton.bulltrail.data.AnimalRepository;
import com.origin.ueliton.bulltrail.model.Animal;
import com.origin.ueliton.bulltrail.util.ImageFile;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ueliton on 5/21/16.
 */
public class AnimalDetailPresenterTest {

    private static final String ANIMAL_NAME_TEST = "Fantasma";
    private static final String ANIMAL_REGISTER_NUMBER_TEST = "0000-0000";
    private static final Date ANIMAL_BIRTH_DATE_TEST = new Date();
    private static final String ANIMAL_RACE_TEST = "Canino";
    private static final String ANIMAL_COAT_NAME_TEST = "escura";
    private static final String ANIMAL_FATHER_NAME_TEST = "Lobo";
    private static final String ANIMAL_MOTHER_NAME = "Loba";
    private static final String ANIMAL_ETHINICITY_TEST = "Albino";
    private static final Integer ANIMAL_WEIGHT_TEST = 4547;
    private static final String ANIMAL_IMAGE_TEST = "path_to_a_image";
    private static final Integer ANIMAL_AGE_TEST = 2;

    private AnimalDetailPresenter mAnimalDetailPresenter;

    @Mock
    private AnimalDetailContract.View mAnimalDetailView;

    @Mock
    private AnimalRepository mAnimalRepository;

    @Captor
    private ArgumentCaptor<AnimalRepository.LoadAnimalCallBack> mLoadAnimalCallBackCaptor;

    @Mock
    private ImageFile mImageFile;

    @Before
    public void setUpPresenter(){

        MockitoAnnotations.initMocks(this);

        mAnimalDetailPresenter = new AnimalDetailPresenter(mAnimalRepository, mAnimalDetailView, mImageFile);
    }

    @Test
    public void loadAnimalFromRepositoryAndShowIntoView(){

        Animal animal = new Animal(ANIMAL_NAME_TEST, ANIMAL_REGISTER_NUMBER_TEST, ANIMAL_BIRTH_DATE_TEST, ANIMAL_RACE_TEST, ANIMAL_COAT_NAME_TEST, ANIMAL_FATHER_NAME_TEST, ANIMAL_MOTHER_NAME, ANIMAL_ETHINICITY_TEST, ANIMAL_WEIGHT_TEST,ANIMAL_AGE_TEST, ANIMAL_IMAGE_TEST);

        mAnimalDetailPresenter.loadAnimal(animal.getId());

        verify(mAnimalRepository).getAnimal(eq(animal.getId()), mLoadAnimalCallBackCaptor.capture());
        mLoadAnimalCallBackCaptor.getValue().onAnimalLoaded(animal);

        verify(mAnimalDetailView).setProgressIndicator(false);

        verify(mAnimalDetailView).showAnimalName(ANIMAL_NAME_TEST);
        verify(mAnimalDetailView).showAnimalRegisterNumber(ANIMAL_REGISTER_NUMBER_TEST);
        verify(mAnimalDetailView).showAnimalBirthDate(ANIMAL_BIRTH_DATE_TEST);
        verify(mAnimalDetailView).showAnimalRace(ANIMAL_RACE_TEST);
        verify(mAnimalDetailView).showAnimalCoat(ANIMAL_COAT_NAME_TEST);
        verify(mAnimalDetailView).showAnimalFatherName(ANIMAL_FATHER_NAME_TEST);
        verify(mAnimalDetailView).showAnimalMotherName(ANIMAL_MOTHER_NAME);
        verify(mAnimalDetailView).showAnimalEthnicity(ANIMAL_ETHINICITY_TEST);
        verify(mAnimalDetailView).showAnimalWeight(ANIMAL_WEIGHT_TEST);
        verify(mAnimalDetailView).showAnimalAge(ANIMAL_AGE_TEST);
        verify(mAnimalDetailView).showAnimalImage(ANIMAL_IMAGE_TEST);
    }


    @Test
    public void loadInvalidAnimalFromRepository_ShowIntoView(){

        mAnimalDetailPresenter.loadAnimal(any(Long.class));

        verify(mAnimalDetailView).setProgressIndicator(true);

        verify(mAnimalRepository).getAnimal(any(Long.class), mLoadAnimalCallBackCaptor.capture());
        mLoadAnimalCallBackCaptor.getValue().onAnimalLoaded(null);

        verify(mAnimalDetailView).setProgressIndicator(false);

        verify(mAnimalDetailView).showAnimalNotFoundView();
    }

    @Test
    public void saveAnimal_showSuccessOnUi(){

        Animal animal = new Animal(ANIMAL_NAME_TEST, ANIMAL_REGISTER_NUMBER_TEST, ANIMAL_BIRTH_DATE_TEST, ANIMAL_RACE_TEST, ANIMAL_COAT_NAME_TEST, ANIMAL_FATHER_NAME_TEST, ANIMAL_MOTHER_NAME, ANIMAL_ETHINICITY_TEST, ANIMAL_WEIGHT_TEST,ANIMAL_AGE_TEST, ANIMAL_IMAGE_TEST);

        when(mAnimalDetailView.getAnimal()).thenReturn((animal));
        Animal animalToSave = mAnimalDetailView.getAnimal();

        mAnimalDetailPresenter.saveAnimal(animalToSave);

        verify(mAnimalRepository).saveAnimal(any(Animal.class));
        verify(mAnimalDetailView).showAnimalsList();
    }

    @Test
    public void saveInvalidAnimal_showInvalidAnimalMessage(){

        when(mAnimalDetailView.getAnimal()).thenReturn(new Animal());
        Animal animalToBeSaved = mAnimalDetailView.getAnimal();

        mAnimalDetailPresenter.saveAnimal(animalToBeSaved);

        verify(mAnimalDetailView).showInvalidAnimalMessage();
    }
}
