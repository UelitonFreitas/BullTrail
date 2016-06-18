package com.origin.ueliton.bulltrail.Animals;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.origin.ueliton.bulltrail.AddAnimal.AddAnimalActivity;
import com.origin.ueliton.bulltrail.Injection;
import com.origin.ueliton.bulltrail.R;
import com.origin.ueliton.bulltrail.AnimalDetail.AnimalDetailActivity;
import com.origin.ueliton.bulltrail.adapter.AnimalAdapter;
import com.origin.ueliton.bulltrail.interfaces.AnimalListOperation;
import com.origin.ueliton.bulltrail.model.Animal;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ueliton on 28/03/2016.
 */
public class AnimalsFragment extends Fragment implements AnimalsContract.View, AnimalListOperation {

    @Bind(R.id.recycler_view_pasture)
    RecyclerView pastureList;

    @Bind(R.id.float_action_button_new)
    FloatingActionButton fab;

    private AnimalAdapter animalAdapter;

    private AnimalsPresenter userActionsListener;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        userActionsListener = new AnimalsPresenter(Injection.provideAnimalRepository(), this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.float_action_button_new)
    public void newAnimal() {
        startActivity(AddAnimalActivity.getIntent(getContext()));
    }

    @Override
    public void onResume() {
        super.onResume();
        userActionsListener.loadAnimals();
    }

    private void setUpPastureAdapter(List<Animal> animals) {
        if (animalAdapter == null) {
            animalAdapter = new AnimalAdapter(getContext(), this, animals);
            pastureList.setLayoutManager(new LinearLayoutManager(getContext()));
            pastureList.setAdapter(animalAdapter);
        }
        else {
            animalAdapter.addAnimals(animals);
            animalAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void click(Animal animal, int position) {
        startActivity(AnimalDetailActivity.getIntent(getContext(), animal));
    }

    @Override
    public void addAnimal() {
        startActivity(AddAnimalActivity.getIntent(getContext()));
    }

    @Override
    public void showAnimalDetail(Long animalId) {

    }

    @Override
    public void showAnimals(List<Animal> animals) {
        setUpPastureAdapter(animals);
    }

    @Override
    public void setProgressIndicator(boolean active) {

    }
}
