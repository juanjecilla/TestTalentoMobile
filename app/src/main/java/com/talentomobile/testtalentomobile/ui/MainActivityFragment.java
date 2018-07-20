package com.talentomobile.testtalentomobile.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.talentomobile.testtalentomobile.ApplicationClass;
import com.talentomobile.testtalentomobile.R;
import com.talentomobile.testtalentomobile.base.BaseView;
import com.talentomobile.testtalentomobile.data.managers.DatabaseManager;
import com.talentomobile.testtalentomobile.data.model.Account;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends BaseView implements MainContract.View {

    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.empty_list) TextView emptyList;
    @BindView(R.id.filter_visible) ToggleButton filterVisible;

    private MainAdapter adapter;
    private ArrayList<Account> accounts;

    private MainPresenter presenter;

    @Inject DatabaseManager databaseManager;

    public MainActivityFragment() {
        // Required empty public constructor
    }

    public static MainActivityFragment newInstance() {
        MainActivityFragment fragment = new MainActivityFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((ApplicationClass)getContext().getApplicationContext()).getComponent().inject(this);

        if (getArguments() != null) {
        }
        accounts = new ArrayList<>();
        adapter = new MainAdapter(accounts);
        presenter = new MainPresenter(this, databaseManager);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        getAccounts();
    }


    @Override
    public void onResume() {
        super.onResume();
        presenter.onViewActive(this);
    }

    @Override
    public void onPause() {
        presenter.onViewInactive();
        super.onPause();
    }

    @Override
    public void showAccounts(ArrayList<Account> accounts) {
        adapter.clear();
        adapter.addAll(accounts);
    }

    @Override
    public void shouldShowPlaceholderText() {
        if (accounts.isEmpty()) {
            emptyList.setVisibility(View.VISIBLE);
        } else {
            emptyList.setVisibility(View.GONE);
        }
    }

    @OnCheckedChanged(R.id.filter_visible)
    public void filterResults(){
        getAccounts();
    }

    private void getAccounts(){
        presenter.getAccounts(filterVisible.isChecked());
    }
}
