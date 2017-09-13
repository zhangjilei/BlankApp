package org.blankapp;

import android.content.Context;

import org.blankapp.util.Config;
import org.blankapp.util.Log;

/**
 *
 *    ___    __    _        __        _      ___  ___
 *   / __\  / /   /_\    /\ \ \/\ /\ /_\    / _ \/ _ \
 *  /__\// / /   //_\\  /  \/ / //_///_\\  / /_)/ /_)/
 * / \/  \/ /___/  _  \/ /\  / __ \/  _  \/ ___/ ___/
 * \_____/\____/\_/ \_/\_\ \/\/  \/\_/ \_/\/   \/
 * ===================================================
 *                                 http://blankapp.org
 */
public class BlankApp {

    public static void initialize(Context context) {
        initialize(context, new Configuration.Builder().create());
    }

    public static void initialize(Context context, boolean loggingEnabled) {
        initialize(context, new Configuration.Builder().setLoggingEnabled(loggingEnabled).create());
    }

    public static void initialize(Context context, Configuration configuration) {
        Log.e("    ___    __    _        __        _      ___  ___ ");
        Log.e("   / __\\  / /   /_\\    /\\ \\ \\/\\ /\\ /_\\    / _ \\/ _ \\");
        Log.e("  /__\\// / /   //_\\\\  /  \\/ / //_///_\\\\  / /_)/ /_)/");
        Log.e(" / \\/  \\/ /___/  _  \\/ /\\  / __ \\/  _  \\/ ___/ ___/ ");
        Log.e(" \\_____/\\____/\\_/ \\_/\\_\\ \\/\\/  \\/\\_/ \\_/\\/   \\/     ");
        Log.e(" ===================================================");
        Log.e("                                 http://blankapp.org");
        if (configuration != null) {
            Log.setEnabled(configuration.isLoggingEnabled());
        }
        Config.initialize(context);
    }

    public static void dispose() {
    }


}
