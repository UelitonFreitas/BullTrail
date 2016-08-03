package com.origin.ueliton.bulltrail.AddAnimal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.origin.ueliton.bulltrail.Animals.AnimalsActivity;
import com.origin.ueliton.bulltrail.Injection;
import com.origin.ueliton.bulltrail.R;
import com.origin.ueliton.bulltrail.model.Animal;
import com.origin.ueliton.bulltrail.util.AlertDialogUtilBuilder;
import com.origin.ueliton.bulltrail.util.DatePickerFragment;
import com.origin.ueliton.bulltrail.util.DateUtil;
import com.origin.ueliton.bulltrail.util.StringUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ueliton on 14/06/16.
 */
public class AddAnimalFragment extends Fragment implements AddAnimalContract.View {

    private static final String DIALOG_DATE = "dialog_date";
    private static final int REQUEST_DATE = 0;

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

        birthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userActionsListener.onDateClick();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animal, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.button_save)
    public void onButtonSaveClick() {
        userActionsListener.onSaveAnimal();
    }

    public static Fragment getInstance() {
        return new AddAnimalFragment();
    }

    @Override
    public void showAnimalsList() {
        startActivity(AnimalsActivity.getIntent(getContext()));
    }

    @Override
    public void showEmptyRegisterAnimalMessage() {
        (new AlertDialogUtilBuilder(getContext()))
                .alert()
                .setTitle("Campos vazios")
                .setMessage("Por favor, digite algumas informações dos animais")
                .setPositiveButton(android.R.string.ok, null)
                .show();
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
    public void showInvalidRegisterNumberAnimalMessage() {
        (new AlertDialogUtilBuilder(getContext()))
                .error()
                .setTitle("Campos vazios")
                .setMessage("Por favor, digite algumas informações dos animais")
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    @Override
    public void showEmptyNameMessage() {
        (new AlertDialogUtilBuilder(getContext()))
                .error()
                .setTitle("Nome")
                .setMessage("Por favor, digite um nome")
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }


    @Override
    public void showDatePicker() {
        FragmentManager manager = getFragmentManager();
        DatePickerFragment dialog = DatePickerFragment
                .newInstance(DateUtil.stringToDate(birthDate.getText().toString()));
        dialog.setTargetFragment(this, REQUEST_DATE);
        dialog.show(manager, DIALOG_DATE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_DATE) {
            Date date = (Date) data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            userActionsListener.onDateSelected(date);
        }
    }

    private String getFormatedDate(Date date) {
        String pattern = "EEEE, MMM d, yyy";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, new Locale("en", "US"));
        return formatter.format(date);
    }

    @Override
    public void setDate(Date date) {
        birthDate.setText(getFormatedDate(date));
    }
}
