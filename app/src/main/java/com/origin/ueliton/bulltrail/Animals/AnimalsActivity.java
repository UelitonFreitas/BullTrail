package com.origin.ueliton.bulltrail.Animals;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v4.app.Fragment;

import com.origin.ueliton.bulltrail.activity.SingleFragmentActivity;
import com.origin.ueliton.bulltrail.util.EspressoIdlingResource;

public class AnimalsActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new AnimalsFragment();
    }

    @VisibleForTesting
    public IdlingResource getCountingIdlingResource() {
        return EspressoIdlingResource.getIdlingResource();
    }

    public static Intent getIntent(Context context){
        return new Intent(context, AnimalsActivity.class);
    }
}
