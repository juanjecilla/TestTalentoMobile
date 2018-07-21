package com.talentomobile.testtalentomobile.data.model;

import io.realm.RealmObject;

public class Account extends RealmObject {

    private int accountBalanceInCents;
    private String accountCurrency;
    private long accountId;
    private String accountName;
    private String accountNumber;
    private String accountType;
    private String alias;
    private boolean isVisible;
    private String iban;
    private long linkedAccountId;
    private String productName;
    private int productType;
    private int savingsTargetReached;
    private int targetAmountInCents;

    public Account() {
    }

    public Account(long accountId, boolean isVisible){
        this.accountId = accountId;
        this.isVisible = isVisible;
    }

    public int getAccountBalanceInCents() {
        return accountBalanceInCents;
    }

    public void setAccountBalanceInCents(int accountBalanceInCents) {
        this.accountBalanceInCents = accountBalanceInCents;
    }

    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = String.valueOf(accountNumber);
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public long getLinkedAccountId() {
        return linkedAccountId;
    }

    public void setLinkedAccountId(long linkedAccountId) {
        this.linkedAccountId = linkedAccountId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public int getSavingsTargetReached() {
        return savingsTargetReached;
    }

    public void setSavingsTargetReached(int savingsTargetReached) {
        this.savingsTargetReached = savingsTargetReached;
    }

    public int getTargetAmountInCents() {
        return targetAmountInCents;
    }

    public void setTargetAmountInCents(int targetAmountInCents) {
        this.targetAmountInCents = targetAmountInCents;
    }
}
