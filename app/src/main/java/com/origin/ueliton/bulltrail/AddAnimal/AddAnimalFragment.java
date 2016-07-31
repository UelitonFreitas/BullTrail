package com.origin.ueliton.bulltrail.AddAnimal;

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
import com.origin.ueliton.bulltrail.util.DateUtil;
import com.origin.ueliton.bulltrail.util.StringUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ueliton on 14/06/16.
 */
public class AddAnimalFragment extends Fragment implements AddAnimalContract.View {

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

    @Bind(R.id.edit_text_animal_weight)
    EditText weigth;

    private AddAnimalContract.UserActionsListener userActionsListener;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        userActionsListener = new AddAnimalPresenter(Injection.provideAnimalRepository(),
                this,
                Injection.providesImageFile());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animal, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.button_save)
    public void onButtonSaveClick() {
        userActionsListener.saveAnimal(getAnimal());
    }

    public static Fragment getInstance() {
        return new AddAnimalFragment();
    }

    @Override
    public void showAnimalsList() {
        startActivity(AnimalsActivity.getIntent(getContext()));
    }

    @Override
    public void showEmptyAnimalMessage() {

    }

    @Override
    public void openCamera(String imagePath) {

    }

    @Override
    public Animal getAnimal() {

        Animal animal = new Animal();

        animal.setRegisterNumber(registerNumber.getText().toString().trim());
        animal.setName(name.getText().toString().trim());
        animal.setBirthDate(DateUtil.stringToDate(birthDate.getText().toString().trim()));
        animal.setRace(race.getText().toString().trim());
        animal.setCoat(coat.getText().toString().trim());
        animal.setFather(fatherName.getText().toString().trim());
        animal.setMother(motherName.getText().toString().trim());

        String animalWeigh = StringUtil.isEmpty(weigth.getText().toString().trim())? "0" : weigth.getText().toString().trim();

        animal.setWeight(Integer.valueOf(animalWeigh));

        return animal;
    }

    @Override
    public void showInvalidAnimalMessage() {

    }
}
