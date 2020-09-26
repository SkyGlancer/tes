package app.dukhaan.ui.ui.sync_contacts;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import app.dukhaan.base.BaseActivity;
import app.dukhaan.databinding.ActivitySyncContactsBinding;
import app.dukhaan.network.ErrorResponse;
import app.dukhaan.network.model.SyncContactPayload;
import app.dukhaan.network.model.SyncContactsRequest;
import app.dukhaan.ui.main.MainActivity;
import app.dukhaan.ui.sync_contacts.SyncContactsActivity.1;
import app.dukhaan.ui.sync_contacts.SyncContactsActivity.2;
import app.dukhaan.ui.sync_contacts.SyncContactsActivity.3;
import app.dukhaan.ui.sync_contacts.SyncContactsActivity.4;
import app.dukhaan.ui.sync_contacts.SyncContactsActivity.5;
import app.dukhaan.ui.sync_contacts.SyncContactsNavigator;
import app.dukhaan.ui.sync_contacts.SyncContactsViewModel;
import app.dukhaan.util.ModalDialogs;
import com.karumi.dexter.Dexter;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ir.mirrajabi.rxcontacts.Contact;
import ir.mirrajabi.rxcontacts.RxContacts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SyncContactsActivity extends BaseActivity<ActivitySyncContactsBinding, SyncContactsViewModel> implements SyncContactsNavigator {
   private ActivitySyncContactsBinding binding;
   private SyncContactsViewModel mViewModel;

   public SyncContactsActivity() {
   }

   private void animateLoader() {
      this.binding.loader.setMinAndMaxFrame(60, 130);
      this.binding.loader.playAnimation();
      this.binding.loader.addAnimatorListener(new 4(this));
   }

   private Observable<List<Contact>> fetchContactsObservable() {
      return RxContacts.fetch(this).filter(_$$Lambda$SyncContactsActivity$nbHcTcHpLJPqLQ9iZ6jDw_MbiOQ.INSTANCE).toSortedList(_$$Lambda$jKgnYVHqkTwCarxlDEpPCggV5xs.INSTANCE).observeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).toObservable();
   }

   private void launchHome() {
      Intent var1 = new Intent(this, MainActivity.class);
      var1.setFlags(268468224);
      this.startActivity(var1);
   }

   private void requestPermission() {
      Dexter.withContext(this).withPermission("android.permission.READ_CONTACTS").withListener(new 1(this)).check();
   }

   private void showContent() {
      Animation var1 = AnimationUtils.loadAnimation(this, fade_in_store_created);
      this.binding.title.startAnimation(var1);
      this.binding.icClose.startAnimation(var1);
      this.binding.description.startAnimation(var1);
      this.binding.btnContinue.startAnimation(var1);
      var1.setAnimationListener(new 5(this));
   }

   private void showSyncErrorDialog() {
      ModalDialogs.showDialog(this, this.getString(R.string.error), this.getString(R.string.error_sync_contacts_message), new 3(this));
   }

   private Completable syncBatch(List<Contact> var1) {
      ArrayList var2 = new ArrayList();
      if (var1 != null) {
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            var2.add(new SyncContactPayload((Contact)var3.next()));
         }
      }

      SyncContactsRequest var4 = new SyncContactsRequest();
      var4.phonebook = var2;
      return this.mViewModel.getApiService().syncContacts(var4).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
   }

   private void syncContacts() {
      this.mViewModel.getCompositeDisposable().add(this.fetchContactsObservable().flatMapIterable(_$$Lambda$SyncContactsActivity$TMzntF2eWVPcjfo9Mz57DYk6YHE.INSTANCE).buffer(50).flatMapCompletable(new 2(this)).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).doOnSubscribe(new _$$Lambda$SyncContactsActivity$y64mNuXuwZMNwlLwJ46BlonJE8Q(this)).doOnComplete(new _$$Lambda$iFPPxUcq1SSKK_VPCn_NME3UcBc(this)).doOnError(new _$$Lambda$SyncContactsActivity$qx2KDLwUCcEFrD_dOkmfYTrLpQ8(this)).subscribe(new _$$Lambda$SyncContactsActivity$mdaKhuMb1DeLCby7mBbVfKbKJRs(this), new _$$Lambda$SyncContactsActivity$3rDh4ugw1zzZMfz1fHAVWP6KsPU(this)));
   }

   public int getLayoutId() {
      return activity_sync_contacts;
   }

   public Class<SyncContactsViewModel> getViewModel() {
      return SyncContactsViewModel.class;
   }

   public void onApiError(ErrorResponse var1) {
   }

   protected void onCreate(Bundle var1, SyncContactsViewModel var2, ActivitySyncContactsBinding var3) {
      this.binding = var3;
      this.mViewModel = var2;
      var2.setNavigator(this);
      this.animateLoader();
      var3.btnContinue.setOnClickListener(new _$$Lambda$SyncContactsActivity$dGza82vdBwEXfV_VcfeNMeaZfHk(this));
      var3.icClose.setOnClickListener(new _$$Lambda$SyncContactsActivity$v1NNiyTLd9bJrfa2Ed2F2WXnXME(this));
   }
}
