package org.blankapp.util;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Log {

    private static final int JSON_INDENT = 4;

    private static String sTag = "BlankApp";
    private static boolean sEnabled = false;

    private Log() {
    }

    public static boolean isEnabled() {
        return sEnabled;
    }

    public static void setEnabled(boolean enabled) {
        sEnabled = enabled;
    }

    public static void appInfo() {

    }

    public static int v(String msg) {
        return v(sTag, msg);
    }

    public static int v(String msg, Throwable tr) {
        return v(sTag, msg, tr);
    }

    public static int v(String tag, String msg) {
        if (sEnabled) {
            return android.util.Log.v(tag, msg);
        }
        return 0;
    }

    public static int v(String tag, String msg, Throwable tr) {
        if (sEnabled) {
            return android.util.Log.v(tag, msg, tr);
        }
        return 0;
    }

    public static int d(String msg) {
        return d(sTag, msg);
    }

    public static int d(String msg, Throwable tr) {
        return d(sTag, msg, tr);
    }

    public static int d(String tag, String msg) {
        if (sEnabled) {
            return android.util.Log.d(tag, msg);
        }
        return 0;
    }

    public static int d(String tag, String msg, Throwable tr) {
        if (sEnabled) {
            return android.util.Log.d(tag, msg, tr);
        }
        return 0;
    }

    public static int i(String msg) {
        return i(sTag, msg);
    }

    public static int i(String msg, Throwable tr) {
        return i(sTag, tr);
    }

    public static int i(String tag, String msg) {
        if (sEnabled) {
            return android.util.Log.i(tag, msg);
        }
        return 0;
    }

    public static int i(String tag, String msg, Throwable tr) {
        if (sEnabled) {
            return android.util.Log.i(tag, msg, tr);
        }
        return 0;
    }

    public static int w(String msg) {
        return w(sTag, msg);
    }

    public static int w(String tag, String msg) {
        if (sEnabled) {
            return android.util.Log.w(tag, msg);
        }
        return 0;
    }

    public static int w(String tag, String msg, Throwable tr) {
        if (sEnabled) {
            return android.util.Log.w(tag, msg, tr);
        }
        return 0;
    }

    public static int w(String tag, Throwable tr) {
        if (sEnabled) {
            return android.util.Log.w(tag, tr);
        }
        return 0;
    }

    public static int e(String msg) {
        return e(sTag, msg);
    }

    public static int e(String msg, Throwable tr) {
        return e(sTag, msg, tr);
    }

    public static int e(String tag, String msg) {
        if (sEnabled) {
            return android.util.Log.e(tag, msg);
        }
        return 0;
    }

    public static int e(String tag, String msg, Throwable tr) {
        if (sEnabled) {
            return android.util.Log.e(tag, msg, tr);
        }
        return 0;
    }


    public static int json(String json) {
        return json(sTag, json);
    }

    public static int json(String tag, String json) {
        if (sEnabled) {
            if (TextUtils.isEmpty(json)) {
                return w(tag, "Empty/Null json content.");
            }
            try {
                json = json.trim();
                if (json.startsWith("[")) {
                    JSONArray jsonArray = new JSONArray(json);
                    String message = jsonArray.toString(JSON_INDENT);
                    return d(tag, message);
                } else {
                    JSONObject jsonObject = new JSONObject(json);
                    String message = jsonObject.toString(JSON_INDENT);
                    return d(tag, message);
                }
            } catch (JSONException e) {
                return e(tag, e.getCause().getMessage() + "\n" + json);
            }
        }
        return 0;
    }
}
