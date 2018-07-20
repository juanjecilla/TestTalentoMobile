package com.talentomobile.testtalentomobile.data.sources;

import com.talentomobile.testtalentomobile.data.model.Account;

import java.util.ArrayList;

public abstract class DataSource {

    public interface GetAccountsCallback {
        void onSuccess(ArrayList<Account> accounts);

        void onFailure(Throwable throwable);

        void onNetworkFailure();
    }

    public abstract void getAccounts(boolean orderByVisible, GetAccountsCallback callback);
}
