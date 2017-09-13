package org.blankapp.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Config {

    private static boolean sIsInitialized;
    private static Context sContext;
    private static SharedPreferences sSharedPreferences;

    public static synchronized void initialize(Context context) {
        if (sIsInitialized) {
            return;
        }
        sContext = context;
        sIsInitialized = true;
    }

    private static SharedPreferences getSharedPreferences() {
        if (sSharedPreferences == null) {
            sSharedPreferences = PreferenceManager.getDefaultSharedPreferences(sContext);
        }
        return sSharedPreferences;
    }

    public static String getString(String key, String defValue) {
        return getSharedPreferences().getString(key, defValue);
    }

    public static void putString(String key, String value) {
        getSharedPreferences().edit().putString(key, value).commit();
    }
}
