package com.origin.ueliton.bulltrail.AnimalDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.origin.ueliton.bulltrail.R;
import com.origin.ueliton.bulltrail.util.Constants;

import butterknife.ButterKnife;

/**
 * Created by ueliton on 02/04/16.
 */
public class AnimalDetailFragment extends Fragment {

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
}
