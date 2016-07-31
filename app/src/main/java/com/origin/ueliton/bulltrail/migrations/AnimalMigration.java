package com.origin.ueliton.bulltrail.migrations;

import android.database.sqlite.SQLiteDatabase;

import se.emilsjolander.sprinkles.Migration;

/**
 * Created by ueliton on 02/04/16.
 */
public class AnimalMigration extends Migration {
    @Override
    protected void doMigration(SQLiteDatabase db) {

        db.execSQL(
                "CREATE TABLE "+Attribute.TABLE_NAME+" ("+
                        Attribute.ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        Attribute.REGISTER+" TEXT,"+
                        Attribute.NAME+" TEXT,"+
                        Attribute.RACE+" TEXT,"+
                        Attribute.COAT+" TEXT,"+
                        Attribute.FATHER+" TEXT,"+
                        Attribute.MOTHER+" TEXT,"+
                        Attribute.ETHNICITY+" TEXT,"+
                        Attribute.WEIGHT+" INTEGER,"+
                        Attribute.BIRTH_DATE+" INTEGER,"+
                        Attribute.IMAGE_PATH+" TEXT,"+
                        Attribute.AGE+" INTEGER"+
                        ")"
        );
    }


    public class Attribute {
        public static final String TABLE_NAME = "animals";
        public static final String ID = "id";
        public static final String REGISTER = "register";
        public static final String NAME = "name";
        public static final String BIRTH_DATE = "birth_date";
        public static final String RACE = "race";
        public static final String COAT = "coat";
        public static final String FATHER = "father";
        public static final String MOTHER = "mother";
        public static final String ETHNICITY = "ethnicity";
        public static final String WEIGHT = "weight";
        public static final String IMAGE_PATH = "image_path";
        public static final String AGE = "age";
    }
}
