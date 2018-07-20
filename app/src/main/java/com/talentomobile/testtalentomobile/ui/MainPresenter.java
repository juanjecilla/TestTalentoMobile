package com.talentomobile.testtalentomobile.ui;

import com.talentomobile.testtalentomobile.base.BasePresenter;
import com.talentomobile.testtalentomobile.data.managers.DatabaseManager;
import com.talentomobile.testtalentomobile.data.model.Account;
import com.talentomobile.testtalentomobile.data.sources.DataSource;

import java.util.ArrayList;

public class MainPresenter extends BasePresenter<MainContract.View> implements
        MainContract.Presenter {

    private DatabaseManager databaseManager;

    public MainPresenter(MainContract.View view, DatabaseManager databaseManager) {
        this.view = view;
        this.databaseManager = databaseManager;
    }

    @Override
    public void getAccounts(boolean orderByVisible) {
        if (view == null) {
            return;
        }

        view.setProgressBar(true);

        databaseManager.getAccounts(orderByVisible, new DataSource.GetAccountsCallback() {

            @Override
            public void onSuccess(ArrayList<Account> accounts) {
                if (view != null) {
                    view.showAccounts(accounts);
                    view.setProgressBar(false);
                    view.shouldShowPlaceholderText();
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                if (view != null) {
                    view.setProgressBar(false);
                    view.shouldShowPlaceholderText();
                }
            }

            @Override
            public void onNetworkFailure() {
                if (view != null) {
                    view.setProgressBar(false);
                    view.shouldShowPlaceholderText();
                }
            }
        });
    }
}

