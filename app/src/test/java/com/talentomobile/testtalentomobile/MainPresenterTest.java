package com.talentomobile.testtalentomobile;

import com.talentomobile.testtalentomobile.data.managers.DatabaseManager;
import com.talentomobile.testtalentomobile.data.model.Account;
import com.talentomobile.testtalentomobile.data.sources.DataSource;
import com.talentomobile.testtalentomobile.ui.MainContract;
import com.talentomobile.testtalentomobile.ui.MainPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;

public class MainPresenterTest {

    private ArrayList<Account> dummy_accounts;

    @Mock
    DatabaseManager databaseManager;

    @Mock
    MainContract.View mainView;

    @Captor
    private ArgumentCaptor<DataSource.GetAccountsCallback> callback;

    @Captor
    private ArgumentCaptor<Boolean> orderBy;

    private MainPresenter mainPresenter;

    @Before
    public void setupMainPresenter() {
        MockitoAnnotations.initMocks(this);

        // Get a reference to the class under test
        mainPresenter = new MainPresenter(mainView, databaseManager);
        dummy_accounts = new ArrayList<>();
        dummy_accounts.add(new Account(1, true));
        dummy_accounts.add(new Account(2, false));
        dummy_accounts.add(new Account(3, true));
    }

    @Test
    public void loadAllAccountsFromDatabase(){
        mainPresenter.getAccounts(true);

        verify(databaseManager).getAccounts(orderBy.capture(), callback.capture());
        callback.getValue().onSuccess(dummy_accounts);

        // Then progress indicator is hidden and notes are shown in UI
        InOrder inOrder = Mockito.inOrder(mainView);
        inOrder.verify(mainView).setProgressBar(true);
        inOrder.verify(mainView).setProgressBar(false);
        verify(mainView).showAccounts(dummy_accounts);
    }
}
