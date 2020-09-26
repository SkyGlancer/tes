/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.MutableLiveData
 *  androidx.lifecycle.ViewModel
 *  io.reactivex.disposables.CompositeDisposable
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 */
package app.dukhaan.base;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;

public abstract class BaseViewModel<N>
extends ViewModel {
    private final ApiService apiService;
    private final DataRepository dataRepository;
    private MutableLiveData<Throwable> error = new MutableLiveData();
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private final MutableLiveData<Boolean> mIsLoading = new MutableLiveData();
    private WeakReference<N> mNavigator;

    public BaseViewModel(DataRepository dataRepository, ApiService apiService) {
        this.dataRepository = dataRepository;
        this.apiService = apiService;
    }

    public ApiService getApiService() {
        return this.apiService;
    }

    public CompositeDisposable getCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    public DataRepository getDataManager() {
        return this.dataRepository;
    }

    public LiveData<Throwable> getError() {
        return this.error;
    }

    public LiveData<Boolean> getLoading() {
        return this.mIsLoading;
    }

    public N getNavigator() {
        return (N)this.mNavigator.get();
    }

    protected void onCleared() {
        this.mCompositeDisposable.dispose();
        super.onCleared();
    }

    public void setError(Throwable throwable) {
        this.error.setValue((Object)throwable);
    }

    public void setIsLoading(boolean bl) {
        this.mIsLoading.setValue((Object)bl);
    }

    public void setNavigator(N n) {
        this.mNavigator = new WeakReference(n);
    }
}

