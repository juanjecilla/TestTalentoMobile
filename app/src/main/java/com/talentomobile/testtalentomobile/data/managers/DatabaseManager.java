package com.talentomobile.testtalentomobile.data.managers;

import android.content.Context;

import com.talentomobile.testtalentomobile.ApplicationClass;
import com.talentomobile.testtalentomobile.data.sources.DataSource;
import com.talentomobile.testtalentomobile.data.sources.LocalDataSource;
import com.talentomobile.testtalentomobile.data.sources.RemoteDataSource;

import javax.inject.Inject;

public class DatabaseManager {

    private static final boolean GET_LOCALLY = true;
    @Inject RemoteDataSource remoteSource;
    @Inject LocalDataSource localSource;

    public DatabaseManager(Context context) {
        ((ApplicationClass)context.getApplicationContext()).getComponent().inject(this);
    }

    public void getAccounts(boolean orderByVisible, DataSource.GetAccountsCallback callback) {
        if (GET_LOCALLY){
            localSource.getAccounts(orderByVisible, callback);
        } else {
            remoteSource.getAccounts(orderByVisible, callback);
        }
    }
}
