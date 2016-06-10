package com.origin.ueliton.bulltrail;

import android.app.Application;

import com.origin.ueliton.bulltrail.migrations.AnimalMigration;

import se.emilsjolander.sprinkles.Migration;
import se.emilsjolander.sprinkles.Sprinkles;

/**
 * Created by ueliton on 02/04/16.
 */
public class BullTrail extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Sprinkles sprinkles = Sprinkles.getInstance(getApplicationContext());
        sprinkles.addMigration(new AnimalMigration());
    }
}
