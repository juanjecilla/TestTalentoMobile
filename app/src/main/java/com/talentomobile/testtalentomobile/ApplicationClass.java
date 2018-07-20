package com.talentomobile.testtalentomobile;

import android.app.Application;

import com.talentomobile.testtalentomobile.di.MainModule;
import com.talentomobile.testtalentomobile.di.components.DaggerMainComponent;
import com.talentomobile.testtalentomobile.di.components.MainComponent;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class ApplicationClass extends Application {

    private MainComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mainComponent = DaggerMainComponent.builder().mainModule(new MainModule(this)).build();

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(config);
    }

    public MainComponent getComponent() {
        return mainComponent;
    }}
