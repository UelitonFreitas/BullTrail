package com.origin.ueliton.bulltrail.AnimalDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.origin.ueliton.bulltrail.R;
import com.origin.ueliton.bulltrail.model.Animal;
import com.origin.ueliton.bulltrail.util.Constants;

import java.util.Date;

import butterknife.ButterKnife;

/**
 * Created by ueliton on 02/04/16.
 */
public class AnimalDetailFragment extends Fragment implements AnimalDetailContract.View{

    private AnimalDetailPresenter mAnimalDetailPresenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mAnimalDetailPresenter = new AnimalDetailPresenter(Injection.provideAnimalRepository(),
//                this,
//                Injection.providesImageFile());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_animal, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public static Fragment newInstance(Long animalId) {

        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.AnimalFragment.Extras.ANIMAL_ID, animalId);

        AnimalDetailFragment animalDetailFragment = new AnimalDetailFragment();
        animalDetailFragment.setArguments(bundle);
        return animalDetailFragment;
    }

    @Override
    public void setProgressIndicator(boolean active) {

    }

    @Override
    public void showAnimalName(String animalName) {

    }

    @Override
    public void showAnimalRegisterNumber(String animalRegisterNumberTest) {

    }

    @Override
    public void showAnimalBirthDate(Date animalBirthDateTest) {

    }

    @Override
    public void showAnimalRace(String animalRaceTest) {

    }

    @Override
    public void showAnimalCoat(String animalCoatNameTest) {

    }

    @Override
    public void showAnimalFatherName(String animalFatherNameTest) {

    }

    @Override
    public void showAnimalMotherName(String animalMotherName) {

    }

    @Override
    public void showAnimalEthnicity(String animalEthnicityTest) {

    }

    @Override
    public void showAnimalWeight(Integer animalWeightTest) {

    }

    @Override
    public void showAnimalAge(Integer animalBirthDateTest) {

    }

    @Override
    public void showAnimalNotFoundView() {

    }

    @Override
    public void showEmptyImage() {

    }

    @Override
    public void showAnimalImage(String imagePath) {

    }

    @Override
    public void showAnimalsList() {

    }

    @Override
    public void showEmptyAnimalMessage() {

    }

    @Override
    public void openCamera(String imagePath) {

    }

    @Override
    public Animal getAnimal() {
        return null;
    }

    @Override
    public void showInvalidAnimalMessage() {

    }
}
