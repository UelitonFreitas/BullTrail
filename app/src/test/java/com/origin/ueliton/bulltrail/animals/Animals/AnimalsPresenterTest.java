package com.origin.ueliton.bulltrail.animals.Animals;

import com.google.common.collect.Lists;
import com.origin.ueliton.bulltrail.Animals.AnimalsContract;
import com.origin.ueliton.bulltrail.Animals.AnimalsPresenter;
import com.origin.ueliton.bulltrail.data.AnimalRepository;
import com.origin.ueliton.bulltrail.model.Animal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by ueliton on 07/05/16.
 */
public class AnimalsPresenterTest {

    private static List<Animal> ANIMALS = Lists.newArrayList(
            new Animal("0000-0000", "Fantasma", new Date(), "Canino", "asd", "Lobo", "Loba", "Albino", 4547, 2, "image_path"),
            new Animal("0000-0000", "Nimeria", new Date(), "Canino", "asd", "Lobo", "Loba", "Albino", 4547, 2, "image_path"));


    private AnimalsPresenter mAnimalsPresenter;

    @Mock
    private AnimalRepository mAnimalRepository;

    @Mock
    private AnimalsContract.View mAnimalsView;

    @Captor
    private ArgumentCaptor<AnimalRepository.LoadAnimalsCallBack> mLoadAnimalsCallBackCaptor;

    @Before
    public void setUpPresenter(){

        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        mAnimalsPresenter = new AnimalsPresenter(mAnimalRepository, mAnimalsView);
    }

    @Test
    public void clickOnFab_showAnimalUI(){

        // When adding a new animal
        mAnimalsPresenter.addAnimal();

        // Then add animal UI is shown
        verify(mAnimalsView).showAddAnimal();
    }

    @Test
    public void loadAnimalsFromRepositoryAndShowOnView(){

        mAnimalsPresenter.loadAnimals();

        verify(mAnimalRepository).getAnimals(mLoadAnimalsCallBackCaptor.capture());
        mLoadAnimalsCallBackCaptor.getValue().onAnimalsLoaded(ANIMALS);

        verify(mAnimalsView).setProgressIndicator(false);
        verify(mAnimalsView).showAnimals(ANIMALS);
    }

    @Test
    public void clickOnAnimal_showAnimalUI(){
        Animal animal = new Animal("0000-0000", "Fantasma", new Date(), "Canino", "asd", "Lobo", "Loba", "Albino", 4547, 2, "image_path");

        mAnimalsPresenter.showAnimalDetail(animal);

        verify(mAnimalsView).showAnimalDetail(any(Long.class));
    }
}
