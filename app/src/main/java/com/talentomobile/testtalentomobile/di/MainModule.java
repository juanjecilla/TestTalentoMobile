package com.talentomobile.testtalentomobile.di;


import android.app.Application;
import android.content.Context;

import com.talentomobile.testtalentomobile.data.managers.DatabaseManager;
import com.talentomobile.testtalentomobile.data.sources.LocalDataSource;
import com.talentomobile.testtalentomobile.data.sources.RemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class MainModule {

    private Application application;
    public MainModule(Application app) {
        application = app;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    DatabaseManager provideDataManager(Context context) {
        return new DatabaseManager(context);
    }

    @Provides
    @Singleton
    LocalDataSource provideLocalDataSource(Context context) {
        return new LocalDataSource(context);
    }

    @Provides
    @Singleton
    RemoteDataSource provideRemoteDataSource(Context context) {
        return new RemoteDataSource(context);
    }

    @Provides
    @Singleton
    Realm provideRealm() {
        return Realm.getDefaultInstance();
    }

}
