package com.origin.ueliton.bulltrail.AddAnimal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.origin.ueliton.bulltrail.R;

import butterknife.ButterKnife;

/**
 * Created by ueliton on 14/06/16.
 */
public class AddAnimalFragment extends Fragment{
    public static Fragment getInstance() {
        return new AddAnimalFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animal, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
