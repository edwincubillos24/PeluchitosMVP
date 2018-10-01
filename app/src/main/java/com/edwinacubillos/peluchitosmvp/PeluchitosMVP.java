package com.edwinacubillos.peluchitosmvp;

import android.app.Application;
import android.content.Context;

public class PeluchitosMVP extends Application {

    private static Context mContext;

    public static Context getmContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
