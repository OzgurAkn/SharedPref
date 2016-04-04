package com.example.ozgur.sharedpref_2048;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ozgur on 27/03/2016.
 */
public class PreferencesHelper {
    private static final String PREFERENCES_NAME = "userPrefs";
    private static final String NAME = "name";
    private static final String AGE = "age";
    private static final String ADRESS = "adress";
    private static final String ZIPCODE = "zipcode";
    private static final String CITY = "city";
    private static final String SAVED = "saved";

    public static SharedPreferences getPreferences(final Context context) {
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public static void saveName(Context context, String name) {
        getPreferences(context)
                .edit()
                .putString(NAME, name)
                .commit();

        setUserSaved(context, true);
    }

    private static void setUserSaved(Context context, boolean saved) {
        getPreferences(context)
                .edit()
                .putBoolean(SAVED, saved)
                .commit();
    }

    public static boolean isUserSaved(Context context){
        return getPreferences(context).getBoolean(SAVED, false);
    }

    public static String getName(Context context) {
        return getPreferences(context).getString(NAME, "");
    }

    public static void saveAge(Context context, int age) {
        getPreferences(context)
                .edit()
                .putInt(AGE, age)
                .commit();
    }

    public static int getAge(Context context) {
        return getPreferences(context).getInt(AGE, 0);
    }

    public static void saveAdress(Context context, String adress) {
        getPreferences(context)
                .edit()
                .putString(ADRESS, adress)
                .commit();
    }

    public static String getAdress(Context context) {
        return getPreferences(context).getString(ADRESS, "");
    }

    public static void saveZipcode(Context context, int zipcode) {
        getPreferences(context)
                .edit()
                .putInt(ZIPCODE, zipcode)
                .commit();
    }

    public static int getZipcode(Context context) {
        return getPreferences(context).getInt(ZIPCODE, 0);
    }

    public static void saveCity(Context context, String city) {
        getPreferences(context)
                .edit()
                .putString(CITY, city)
                .commit();
    }

    public static String getCity(Context context) {
        return getPreferences(context).getString(CITY, "");
    }
}
