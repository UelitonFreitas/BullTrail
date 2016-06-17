package com.origin.ueliton.bulltrail.AddAnimal;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.origin.ueliton.bulltrail.activity.SingleFragmentActivity;

/**
 * Created by ueliton on 14/06/16.
 */
public class AddAnimalActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return AddAnimalFragment.getInstance();
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, AddAnimalActivity.class);
    }
}
