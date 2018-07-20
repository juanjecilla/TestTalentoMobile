package com.talentomobile.testtalentomobile.ui;

import com.talentomobile.testtalentomobile.base.IBasePresenter;
import com.talentomobile.testtalentomobile.base.IBaseView;
import com.talentomobile.testtalentomobile.data.model.Account;

import java.util.ArrayList;

public interface MainContract {
    interface View extends IBaseView {

        void showAccounts(ArrayList<Account> accounts);

        void shouldShowPlaceholderText();
    }

    interface Presenter extends IBasePresenter<View> {

        void getAccounts(boolean orderByVisible);
    }
}
