package com.example.highcash.di.module;


import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.highcash.di.ActivityContext;
import com.example.highcash.di.PerActivity;
import com.example.highcash.ui.accounts.AccountsAdapter;
import com.example.highcash.ui.accounts.AccountsInteractor.AccountsMvpPresenter;
import com.example.highcash.ui.accounts.AccountsInteractor.AccountsMvpView;
import com.example.highcash.ui.accounts.AccountsPresenter;
import com.example.highcash.ui.add_account.AddAccountInteractor.AddAccountMvpPresenter;
import com.example.highcash.ui.add_account.AddAccountInteractor.AddAccountMvpView;
import com.example.highcash.ui.add_account.AddAccountPresenter;
import com.example.highcash.ui.add_transaction.AddTransactionInteractor;
import com.example.highcash.ui.add_transaction.AddTransactionInteractor.AddTransactionMvpPresenter;
import com.example.highcash.ui.add_transaction.AddTransactionInteractor.AddTransactionMvpView;
import com.example.highcash.ui.add_transaction.AddTransactionPresenter;
import com.example.highcash.ui.main.MainInteractor.MainMvpPresenter;
import com.example.highcash.ui.main.MainInteractor.MainMvpView;
import com.example.highcash.ui.main.MainPresenter;
import com.example.highcash.ui.overview.OverViewInteractor.OverViewMvpPresenter;
import com.example.highcash.ui.overview.OverViewInteractor.OverViewMvpView;
import com.example.highcash.ui.overview.OverViewPresenter;
import com.example.highcash.ui.overview.RecentTransactionsAdapter;
import com.example.highcash.ui.overview.RecentUsedAccountsAdapter;
import com.example.highcash.ui.transactions.TransactionsAdapter;
import com.example.highcash.ui.transactions.TransactionsInteractor.TransactionsMvpPresenter;
import com.example.highcash.ui.transactions.TransactionsInteractor.TransactionsMvpView;
import com.example.highcash.ui.transactions.TransactionsPresenter;
import com.example.highcash.utils.rx.AppSchedulerProvider;
import com.example.highcash.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;



@Module
public class ActivityModule {
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    public Context provideContext(){
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter){
        return presenter;
    }
    @Provides
    AccountsMvpPresenter<AccountsMvpView> provideAccountMvpPresenter(
            AccountsPresenter<AccountsMvpView> presenter){
        return presenter;
    }
    @Provides
    AccountsAdapter provideAccountsAdapter(){
        return new AccountsAdapter(mActivity,null,false);
    }
    @Provides
    TransactionsMvpPresenter<TransactionsMvpView> provideTransactionsMvpPresenter(
            TransactionsPresenter<TransactionsMvpView> presenter){
        return presenter;
    }
    @Provides
    TransactionsAdapter provideTransactionsAdapter(){
        return new TransactionsAdapter(mActivity,new ArrayList<>(),null);
    }
    @Provides
    OverViewMvpPresenter<OverViewMvpView> provideOverViewMvpPresenter(
            OverViewPresenter<OverViewMvpView> presenter){
        return presenter;
    }
    @Provides
    RecentTransactionsAdapter provideRecentTransactionsAdapter(){
        return new RecentTransactionsAdapter(mActivity,new ArrayList<>());
    }
    @Provides
    RecentUsedAccountsAdapter provideRecentUsedAccountsAdapter(){
        return new RecentUsedAccountsAdapter(mActivity, new ArrayList<>());
    }

    @Provides
    AddAccountMvpPresenter<AddAccountMvpView> provideAddAccountPresenter(
            AddAccountPresenter<AddAccountMvpView> presenter){
        return presenter;
    }
    @Provides
    AddTransactionMvpPresenter<AddTransactionMvpView> provideAddTransactionPresenter(
            AddTransactionPresenter<AddTransactionMvpView> presenter){
        return presenter;
    }


}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  