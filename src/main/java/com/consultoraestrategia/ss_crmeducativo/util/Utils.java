package com.consultoraestrategia.ss_crmeducativo.util;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by irvinmarin on 13/04/2017.
 */

public class Utils {

    public static boolean isOnlineNet() {

        try {
            Process p = java.lang.Runtime.getRuntime().exec("ping -c 1 192.168.0.151");

            int val = p.waitFor();
            boolean reachable = (val == 0);
            return reachable;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isSuccess(JSONObject jsonObject) {
        boolean estado;
        try {
            estado = jsonObject.getBoolean("Successful");
        } catch (JSONException e) {
            e.printStackTrace();
            estado = false;
        }
        return estado;
    }

    public static String getJsonObResult(JSONObject jsonObject) {
        String s = "";
        try {
            s = jsonObject.getJSONObject("Value").toString();
            Log.d("JSON RESULT", "" + jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static String getJsonObResultArray(JSONObject jsonObject) {
        String s = "";
        try {
            s = jsonObject.getJSONArray("Value").toString();

            Log.d("JSON RESULT", "" + jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return s;
    }
}
