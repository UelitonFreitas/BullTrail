package com.origin.ueliton.bulltrail.AnimalDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.origin.ueliton.bulltrail.Animals.AnimalsActivity;
import com.origin.ueliton.bulltrail.Injection;
import com.origin.ueliton.bulltrail.R;
import com.origin.ueliton.bulltrail.model.Animal;
import com.origin.ueliton.bulltrail.util.Constants;

import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ueliton on 02/04/16.
 */
public class AnimalDetailFragment extends Fragment implements AnimalDetailContract.View {

    private AnimalDetailContract.UserActionsListener userInteraction;


    @Bind(R.id.edit_text_register_number)
    EditText registerNumber;

    @Bind(R.id.edit_text_animal_name)
    EditText name;

    @Bind(R.id.edit_text_animal_birth_date)
    EditText birthDate;

    @Bind(R.id.edit_text_race)
    EditText race;

    @Bind(R.id.edit_text_animal_coat)
    EditText coat;

    @Bind(R.id.edit_text_animal_father_name)
    EditText fatherName;

    @Bind(R.id.edit_text_animal_mother_name)
    EditText motherName;

    @Bind(R.id.edit_text_animal_ethnicity)
    EditText ethnicity;

    @Bind(R.id.edit_text_animal_weight)
    EditText weight;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        userInteraction = new AnimalDetailPresenter(Injection.provideAnimalRepository(),
                this,
                Injection.providesImageFile());

        Bundle args = getArguments();
        if(args != null) {
            long animalId = args.getLong(Constants.AnimalFragment.Extras.ANIMAL_ID, -1);
            userInteraction.loadAnimal(animalId);
        }
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
        name.setText(animalName);
    }

    @Override
    public void showAnimalRegisterNumber(String registerName) {
        registerNumber.setText(registerName);
    }

    @Override
    public void showAnimalBirthDate(Date birthDate) {
        this.birthDate.setText(birthDate.toString());
    }

    @Override
    public void showAnimalRace(String animalRace) {
        race.setText(animalRace);
    }

    @Override
    public void showAnimalCoat(String coat) {
        this.coat.setText(coat);
    }

    @Override
    public void showAnimalFatherName(String animalFatherName) {
        fatherName.setText(animalFatherName);
    }

    @Override
    public void showAnimalMotherName(String animalMother) {
        motherName.setText(animalMother);
    }

    @Override
    public void showAnimalEthnicity(String ethnicity) {
        this.ethnicity.setText(ethnicity);
    }

    @Override
    public void showAnimalWeight(Integer weight) {
        this.weight.setText(weight);
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
        AnimalsActivity.getIntent(getContext());
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
