package com.talentomobile.testtalentomobile.data.sources;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.talentomobile.testtalentomobile.ApplicationClass;
import com.talentomobile.testtalentomobile.R;
import com.talentomobile.testtalentomobile.data.model.Account;
import com.talentomobile.testtalentomobile.utils.FileUtils;

import java.util.ArrayList;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;

public class LocalDataSource extends DataSource {

    @Inject Realm realm;

    private Context context;

    public LocalDataSource(Context context){
        ((ApplicationClass)context.getApplicationContext()).getComponent().inject(this);
        this.context = context;
    }

    @Override
    public void getAccounts(boolean orderByVisible, GetAccountsCallback callback) {
        RealmResults<Account> realmResults;
        if (orderByVisible){
            realmResults = realm.where(Account.class).equalTo("isVisible", true).findAll();
        } else {
            realmResults = realm.where(Account.class).findAll();
        }

        if (realmResults.size() == 0){
            initLocalDatabase();
            callback.onFailure(new Throwable());

            getAccounts(orderByVisible, callback);
        } else {
            ArrayList<Account> results = new ArrayList<>(realmResults);
            callback.onSuccess(results);
        }
    }

    private void initLocalDatabase(){
        JsonObject localJson = FileUtils.readLocalJsonFile(context.getApplicationContext(), R.raw.local_json);

        if (localJson != null){
            Gson gson = new Gson();
            JsonArray accounts = localJson.getAsJsonArray("accounts");
            for (JsonElement element: accounts){
                Account account = gson.fromJson(element, Account.class);
                realm.beginTransaction();
                realm.copyToRealm(account);
                realm.commitTransaction();
            }
        }
    }
}
