package com.talentomobile.testtalentomobile.base;

public interface IBasePresenter<ViewT> {

    void onViewActive(ViewT view);

    void onViewInactive();
}

