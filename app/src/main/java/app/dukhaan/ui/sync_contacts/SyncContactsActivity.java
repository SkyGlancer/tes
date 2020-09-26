/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.AnimationUtils
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.databinding.ViewDataBinding
 *  app.dukhaan.base.BaseViewModel
 *  app.dukhaan.data.local.AppPref
 *  app.dukhaan.databinding.ActivitySyncContactsBinding
 *  app.dukhaan.ui.sync_contacts.-$
 *  app.dukhaan.ui.sync_contacts.-$$Lambda
 *  app.dukhaan.ui.sync_contacts.-$$Lambda$SyncContactsActivity
 *  app.dukhaan.ui.sync_contacts.-$$Lambda$SyncContactsActivity$3rDh4ugw1zzZMfz1fHAVWP6KsPU
 *  app.dukhaan.ui.sync_contacts.-$$Lambda$SyncContactsActivity$TMzntF2eWVPcjfo9Mz57DYk6YHE
 *  app.dukhaan.ui.sync_contacts.-$$Lambda$SyncContactsActivity$mdaKhuMb1DeLCby7mBbVfKbKJRs
 *  app.dukhaan.ui.sync_contacts.-$$Lambda$SyncContactsActivity$nbHcTcHpLJPqLQ9iZ6jDw-MbiOQ
 *  app.dukhaan.ui.sync_contacts.-$$Lambda$SyncContactsActivity$qx2KDLwUCcEFrD_dOkmfYTrLpQ8
 *  app.dukhaan.ui.sync_contacts.-$$Lambda$SyncContactsActivity$y64mNuXuwZMNwlLwJ46BlonJE8Q
 *  app.dukhaan.ui.sync_contacts.-$$Lambda$iFPPxUcq1SSKK_VPCn_NME3UcBc
 *  app.dukhaan.ui.sync_contacts.SyncContactsActivity$1
 *  app.dukhaan.ui.sync_contacts.SyncContactsActivity$2
 *  app.dukhaan.ui.sync_contacts.SyncContactsActivity$3
 *  app.dukhaan.ui.sync_contacts.SyncContactsNavigator
 *  app.dukhaan.ui.sync_contacts.SyncContactsViewModel
 *  com.airbnb.lottie.LottieAnimationView
 *  com.karumi.dexter.Dexter
 *  io.reactivex.Completable
 *  io.reactivex.Observable
 *  io.reactivex.Scheduler
 *  io.reactivex.Single
 *  io.reactivex.android.schedulers.AndroidSchedulers
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.functions.Function
 *  io.reactivex.functions.Predicate
 *  io.reactivex.schedulers.Schedulers
 *  ir.mirrajabi.rxcontacts.Contact
 *  ir.mirrajabi.rxcontacts.RxContacts
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.UnknownHostException
 *  java.util.ArrayList
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.List
 */
package app.dukhaan.ui.sync_contacts;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.base.BaseViewModel;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.databinding.ActivitySyncContactsBinding;
import app.dukhaan.network.ApiService;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.interceptor.NoConnectivityException;
import app.dukhaan.network.model.SyncContactPayload;
import app.dukhaan.network.model.SyncContactsRequest;
import app.dukhaan.ui.main.MainActivity;
import app.dukhaan.ui.sync_contacts.-$;
import app.dukhaan.ui.sync_contacts.-$$Lambda$SyncContactsActivity$dGza82vdBwEXfV_VcfeNMeaZfHk;
import app.dukhaan.ui.sync_contacts.-$$Lambda$SyncContactsActivity$v1NNiyTLd9bJrfa2Ed2F2WXnXME;
import app.dukhaan.ui.sync_contacts.-$$Lambda$jKgnYVHqkTwCarxlDEpPCggV5xs;
import app.dukhaan.ui.sync_contacts.SyncContactsActivity;
import app.dukhaan.ui.sync_contacts.SyncContactsNavigator;
import app.dukhaan.ui.sync_contacts.SyncContactsViewModel;
import app.dukhaan.ui.views.PrimaryButtonWhite;
import app.dukhaan.util.ModalDialogs;
import com.airbnb.lottie.LottieAnimationView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.DexterBuilder;
import com.karumi.dexter.listener.single.PermissionListener;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import ir.mirrajabi.rxcontacts.Contact;
import ir.mirrajabi.rxcontacts.RxContacts;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class SyncContactsActivity
extends BaseActivity<ActivitySyncContactsBinding, SyncContactsViewModel>
implements SyncContactsNavigator {
    private ActivitySyncContactsBinding binding;
    private SyncContactsViewModel mViewModel;

    static /* synthetic */ void access$000(SyncContactsActivity syncContactsActivity) {
        syncContactsActivity.syncContacts();
    }

    static /* synthetic */ Completable access$100(SyncContactsActivity syncContactsActivity, List list) {
        return syncContactsActivity.syncBatch((List<Contact>)list);
    }

    static /* synthetic */ void access$200(SyncContactsActivity syncContactsActivity) {
        syncContactsActivity.launchHome();
    }

    static /* synthetic */ void access$300(SyncContactsActivity syncContactsActivity) {
        syncContactsActivity.showContent();
    }

    static /* synthetic */ ActivitySyncContactsBinding access$400(SyncContactsActivity syncContactsActivity) {
        return syncContactsActivity.binding;
    }

    private void animateLoader() {
        this.binding.loader.setMinAndMaxFrame(60, 130);
        this.binding.loader.playAnimation();
        this.binding.loader.addAnimatorListener(new Animator.AnimatorListener(this){
            final /* synthetic */ SyncContactsActivity this$0;
            {
                this.this$0 = syncContactsActivity;
            }

            public void onAnimationCancel(Animator animator2) {
            }

            public void onAnimationEnd(Animator animator2) {
                SyncContactsActivity.access$300(this.this$0);
            }

            public void onAnimationRepeat(Animator animator2) {
            }

            public void onAnimationStart(Animator animator2) {
            }
        });
    }

    private Observable<List<Contact>> fetchContactsObservable() {
        return RxContacts.fetch((Context)this).filter((Predicate)-$.Lambda.SyncContactsActivity.nbHcTcHpLJPqLQ9iZ6jDw-MbiOQ.INSTANCE).toSortedList((Comparator)-$$Lambda$jKgnYVHqkTwCarxlDEpPCggV5xs.INSTANCE).observeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).toObservable();
    }

    static /* synthetic */ boolean lambda$fetchContactsObservable$7(Contact contact) throws Exception {
        return contact.getInVisibleGroup() == 1;
    }

    static /* synthetic */ Iterable lambda$syncContacts$2(List list) throws Exception {
        return list;
    }

    private void launchHome() {
        Intent intent = new Intent((Context)this, MainActivity.class);
        intent.setFlags(268468224);
        this.startActivity(intent);
    }

    private void requestPermission() {
        Dexter.withContext((Context)this).withPermission("android.permission.READ_CONTACTS").withListener((PermissionListener)new 1(this)).check();
    }

    private void showContent() {
        Animation animation = AnimationUtils.loadAnimation((Context)this, (int)2130771997);
        this.binding.title.startAnimation(animation);
        this.binding.icClose.startAnimation(animation);
        this.binding.description.startAnimation(animation);
        this.binding.btnContinue.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener(this){
            final /* synthetic */ SyncContactsActivity this$0;
            {
                this.this$0 = syncContactsActivity;
            }

            public void onAnimationEnd(Animation animation) {
                SyncContactsActivity.access$400((SyncContactsActivity)this.this$0).title.setVisibility(0);
                SyncContactsActivity.access$400((SyncContactsActivity)this.this$0).description.setVisibility(0);
                SyncContactsActivity.access$400((SyncContactsActivity)this.this$0).icClose.setVisibility(0);
                SyncContactsActivity.access$400((SyncContactsActivity)this.this$0).btnContinue.setVisibility(0);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
    }

    private void showSyncErrorDialog() {
        ModalDialogs.showDialog((Activity)this, this.getString(2131951767), this.getString(2131951779), (ModalDialogs.ButtonClickListener)new 3(this));
    }

    private Completable syncBatch(List<Contact> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                arrayList.add((Object)new SyncContactPayload((Contact)iterator.next()));
            }
        }
        SyncContactsRequest syncContactsRequest = new SyncContactsRequest();
        syncContactsRequest.phonebook = arrayList;
        return this.mViewModel.getApiService().syncContacts(syncContactsRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    private void syncContacts() {
        this.mViewModel.getCompositeDisposable().
                add(this.fetchContactsObservable()
                        .flatMapIterable((Function)-$.Lambda.SyncContactsActivity.TMzntF2eWVPcjfo9Mz57DYk6YHE.INSTANCE)
                        .buffer(50).flatMapCompletable((Function)new 2(this))
        .observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                .doOnSubscribe((Consumer)new -$.Lambda.SyncContactsActivity.y64mNuXuwZMNwlLwJ46BlonJE8Q(this)).doOnComplete((Action)new -$.Lambda.iFPPxUcq1SSKK_VPCn_NME3UcBc(this)).doOnError((Consumer)new -$.Lambda.SyncContactsActivity.qx2KDLwUCcEFrD_dOkmfYTrLpQ8(this)).subscribe((Action)new -$.Lambda.SyncContactsActivity.mdaKhuMb1DeLCby7mBbVfKbKJRs(this), (Consumer)new -$.Lambda.SyncContactsActivity.3rDh4ugw1zzZMfz1fHAVWP6KsPU(this)));
    }

    @Override
    public int getLayoutId() {
        return 2131558449;
    }

    @Override
    public Class<SyncContactsViewModel> getViewModel() {
        return SyncContactsViewModel.class;
    }

    public /* synthetic */ void lambda$onCreate$0$SyncContactsActivity(View view) {
        this.requestPermission();
    }

    public /* synthetic */ void lambda$onCreate$1$SyncContactsActivity(View view) {
        AppPref.getInstance().setContactsSynced(false);
        this.launchHome();
    }

    public /* synthetic */ void lambda$syncContacts$3$SyncContactsActivity(Disposable disposable) throws Exception {
        this.showFullscreenLoader();
    }

    public /* synthetic */ void lambda$syncContacts$4$SyncContactsActivity(Throwable throwable) throws Exception {
        this.hideFullscreenLoader();
    }

    public /* synthetic */ void lambda$syncContacts$5$SyncContactsActivity() throws Exception {
        AppPref.getInstance().setContactsSynced(true);
        this.launchHome();
    }

    public /* synthetic */ void lambda$syncContacts$6$SyncContactsActivity(Throwable throwable) throws Exception {
        if (!(throwable instanceof UnknownHostException)) {
            if (throwable instanceof NoConnectivityException) {
                return;
            }
            this.showSyncErrorDialog();
        }
    }

    public void onApiError(ErrorResponse errorResponse) {
    }

    @Override
    protected void onCreate(Bundle bundle, SyncContactsViewModel syncContactsViewModel, ActivitySyncContactsBinding activitySyncContactsBinding) {
        this.binding = activitySyncContactsBinding;
        this.mViewModel = syncContactsViewModel;
        syncContactsViewModel.setNavigator((Object)this);
        this.animateLoader();
        activitySyncContactsBinding.btnContinue.setOnClickListener(new -$$Lambda$SyncContactsActivity$dGza82vdBwEXfV_VcfeNMeaZfHk(this));
        activitySyncContactsBinding.icClose.setOnClickListener((View.OnClickListener)new -$$Lambda$SyncContactsActivity$v1NNiyTLd9bJrfa2Ed2F2WXnXME(this));
    }
}

