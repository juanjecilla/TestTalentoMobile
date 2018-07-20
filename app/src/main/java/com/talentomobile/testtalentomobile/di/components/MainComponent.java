package com.talentomobile.testtalentomobile.di.components;

import com.talentomobile.testtalentomobile.ApplicationClass;
import com.talentomobile.testtalentomobile.data.managers.DatabaseManager;
import com.talentomobile.testtalentomobile.data.sources.LocalDataSource;
import com.talentomobile.testtalentomobile.di.MainModule;
import com.talentomobile.testtalentomobile.ui.MainActivity;
import com.talentomobile.testtalentomobile.ui.MainActivityFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MainModule.class})
public interface MainComponent {
    void inject(ApplicationClass app);
    void inject(MainActivity activity);
    void inject(MainActivityFragment fragment);
    void inject(DatabaseManager manager);
    void inject(LocalDataSource source);
}
