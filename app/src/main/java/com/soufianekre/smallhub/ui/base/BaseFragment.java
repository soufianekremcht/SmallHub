package com.soufianekre.smallhub.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment implements BaseMvpView {

    private BaseActivity mActivity;
    private Unbinder mUnBinder;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
        }
    }

    @Override
    public void onDetach() {
        if (mActivity != null) mActivity = null;
        super.onDetach();
    }


    @Override
    public void onError(int resId) {
        if (mActivity != null) {
            mActivity.onError(resId);
        }
    }

    @Override
    public void onError(String message) {
        if (mActivity != null) {
            mActivity.onError(message);
        }
    }

    @Override
    public void showMessage(String message) {
        if (mActivity != null) {
            mActivity.showMessage(message);
        }
    }

    @Override
    public void showMessage(int resId) {
        if (mActivity != null) {
            mActivity.showMessage(resId);
        }
    }

    @Override
    public void hideKeyboard() {
        if (mActivity != null) {
            mActivity.hideKeyboard();
        }
    }

    @Override
    public void onDestroy() {
        if (mUnBinder != null){
            mUnBinder.unbind();

        }
        super.onDestroy();
    }


    public BaseActivity getBaseActivity(){
        return mActivity;
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }


    @Override
    public void showProgress(int ResId) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public boolean checkInternetConnection() {
        return getBaseActivity().checkInternetConnection();
    }


}
