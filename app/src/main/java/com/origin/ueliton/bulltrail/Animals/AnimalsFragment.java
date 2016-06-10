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

import com.origin.ueliton.bulltrail.R;
import com.origin.ueliton.bulltrail.AnimalDetail.AnimalDetailActivity;
import com.origin.ueliton.bulltrail.adapter.AnimalAdapter;
import com.origin.ueliton.bulltrail.interfaces.AnimalListOperation;
import com.origin.ueliton.bulltrail.model.Animal;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ueliton on 28/03/2016.
 */
public class AnimalsFragment extends Fragment implements AnimalListOperation {

    @Bind(R.id.recycler_view_pasture)
    RecyclerView pastureList;

    @Bind(R.id.float_action_button_new)
    FloatingActionButton fab;

    private AnimalAdapter animalAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.float_action_button_new)
    public void newAnimal(){
        startActivity(AnimalDetailActivity.getIntent(getContext()));
    }

    @Override
    public void onResume() {
        super.onResume();

        if(animalAdapter == null){
            setUpPastureAdapter();
        }
        else {
            animalAdapter.notifyDataSetChanged();
        }
    }

    private void setUpPastureAdapter() {
        animalAdapter = new AnimalAdapter(getContext(), this);
        pastureList.setLayoutManager(new LinearLayoutManager(getContext()));
        pastureList.setAdapter(animalAdapter);
    }

    @Override
    public void click(Animal animal, int position) {
        startActivity(AnimalDetailActivity.getIntent(getContext(), animal));
    }
}
