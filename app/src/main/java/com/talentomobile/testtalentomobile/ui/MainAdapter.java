package com.talentomobile.testtalentomobile.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.talentomobile.testtalentomobile.R;
import com.talentomobile.testtalentomobile.data.model.Account;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Account> data;

    public MainAdapter(ArrayList<Account> data) {
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new MainAdapter.MainViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MainAdapter.MainViewHolder)holder).bindItem(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void clear() {
        int size = getItemCount();
        data.clear();
        notifyItemRangeRemoved(0, size);
    }

    public void addAll(ArrayList<Account> accounts) {
        int prevSize = getItemCount();
        this.data.addAll(accounts);
        notifyItemRangeInserted(prevSize, accounts.size());
    }

    public void add(Account item) {
        data.add(item);
        notifyItemInserted(0);
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        private Account account;

        @BindView(R.id.account_number) TextView accountNumber;

        public MainViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bindItem(Account account){
            this.account = account;
            accountNumber.setText(account.getAccountNumber());
        }
    }
}