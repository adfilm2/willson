/*
package com.example.appjam_willson;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SaveSharedPreference {

    static final String user_token = null;

    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    // 계정 정보 저장
    public static void setUserToken(Context ctx, String userToken) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(user_token, userToken);
        editor.commit();
    }

    // 저장된 정보 가져오기
    public static String getUserToken(Context ctx) {
        return getSharedPreferences(ctx).getString(user_token, "");
    }

    // 로그아웃
    public static void clearUserToken(Context ctx) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.clear();
        editor.commit();
    }
}
*/
