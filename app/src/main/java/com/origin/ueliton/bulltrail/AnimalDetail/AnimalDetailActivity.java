package com.origin.ueliton.bulltrail.AnimalDetail;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.origin.ueliton.bulltrail.activity.SingleFragmentActivity;
import com.origin.ueliton.bulltrail.model.Animal;
import com.origin.ueliton.bulltrail.util.Constants;

/**
 * Created by ueliton on 02/04/16.
 */
public class AnimalDetailActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        long animalId = getIntent(this).getLongExtra(Constants.AnimalActivity.Extras.ANIMAL, -1);
        return AnimalDetailFragment.newInstance(animalId);
    }

    public static Intent getIntent(Context context, Animal animal){
        Intent intent = new Intent(context, AnimalDetailActivity.class);
        intent.putExtra(Constants.AnimalActivity.Extras.ANIMAL, animal.getId());
        return intent;
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, AnimalDetailActivity.class);
        return intent;
    }


}
