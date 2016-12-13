package com.fiap.mob.persistencia;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.inspector.database.ContentProviderDatabaseDriver;
import com.fiap.mob.persistencia.dao.DBHelper;
import com.fiap.mob.persistencia.dao.DatabaseManager;

/**
 * Created by doido on 12/12/2016.
 */

public class MinhaAplicacao extends Application {
    private static Context context;
    public void onCreate(){

        super.onCreate();
        Stetho.initializeWithDefaults(this);
        this.context = getApplicationContext();
        DatabaseManager.initializeInstance(new DBHelper());
    }

    public static Context getContext(){

       return context;
    }
}
