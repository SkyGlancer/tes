/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.data.local.-$
 *  app.dukhaan.data.local.-$$Lambda
 *  app.dukhaan.data.local.-$$Lambda$AppDatabase
 *  app.dukhaan.data.local.-$$Lambda$AppDatabase$19Z_5yVr-06fPgdRk2fyqeVH4ek
 *  app.dukhaan.data.local.-$$Lambda$AppDatabase$3VDTB9aeO-Au3rWps56Exv8JaUI
 *  app.dukhaan.data.local.-$$Lambda$AppDatabase$6fstw2TPMUPoLRKP1CpqWXLhiOo
 *  app.dukhaan.data.local.-$$Lambda$AppDatabase$I79_vVtIj7-5qmqQ25bDSgHgIgs
 *  app.dukhaan.data.local.-$$Lambda$AppDatabase$J6KyEVQdeKZWb0Vc-w_nxzQPi78
 *  app.dukhaan.data.local.-$$Lambda$AppDatabase$PuZbBVeJ-J4-jAK_SpOidQGHJvw
 *  app.dukhaan.data.local.-$$Lambda$AppDatabase$TMLuLWrv2uHPdhoOTz161Bro4BE
 *  app.dukhaan.data.local.-$$Lambda$AppDatabase$mVqjO6Oj5lu1PL9LwzcTa7VCyWA
 *  app.dukhaan.data.local.-$$Lambda$AppDatabase$nj4tnSHisIKVOgPnW1yB4kxCCh8
 *  app.dukhaan.data.local.-$$Lambda$AppDatabase$w7xp3t54QGsx_iFjBkuCIooJJgo
 *  app.dukhaan.data.model.Business
 *  app.dukhaan.data.model.BusinessStats
 *  app.dukhaan.data.model.Product
 *  app.dukhaan.network.model.Category
 *  app.dukhaan.network.model.Order
 *  io.realm.ImportFlag
 *  io.realm.Realm
 *  io.realm.Realm$Transaction
 *  io.realm.RealmAsyncTask
 *  io.realm.RealmList
 *  io.realm.RealmModel
 *  io.realm.RealmQuery
 *  io.realm.RealmResults
 *  java.lang.Class
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.atomic.AtomicReference
 */
package app.dukhaan.data.local;

import app.dukhaan.data.local.-$;
import app.dukhaan.data.model.Business;
import app.dukhaan.data.model.BusinessStats;
import app.dukhaan.data.model.Product;
import app.dukhaan.network.model.Category;
import app.dukhaan.network.model.Order;
import io.realm.ImportFlag;
import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class AppDatabase {
    static /* synthetic */ void lambda$clearSessionData$0(Realm realm) {
        realm.deleteAll();
    }

    static /* synthetic */ void lambda$getBusiness$2(AtomicReference atomicReference, Realm realm) {
        atomicReference.set(realm.where(Business.class).findFirst());
    }

    static /* synthetic */ void lambda$getBusinessStats$9(AtomicReference atomicReference, Realm realm) {
        atomicReference.set(realm.where(BusinessStats.class).findFirst());
    }

    static /* synthetic */ void lambda$getCategory$7(AtomicReference atomicReference, Realm realm) {
        atomicReference.set(realm.where(Category.class).findFirst());
    }

    static /* synthetic */ void lambda$saveBusiness$1(Business business, Realm realm) {
        realm.insertOrUpdate((RealmModel)business);
    }

    static /* synthetic */ void lambda$saveBusinessStats$8(BusinessStats businessStats, Realm realm) {
        (BusinessStats)realm.copyToRealmOrUpdate((RealmModel)businessStats, new ImportFlag[0]);
    }

    static /* synthetic */ void lambda$saveCategories$5(boolean bl, List list, Realm realm) {
        if (bl) {
            realm.where(Category.class).findAll().deleteAllFromRealm();
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            realm.copyToRealmOrUpdate((RealmModel)((Category)iterator.next()), new ImportFlag[0]);
        }
    }

    static /* synthetic */ void lambda$saveCategory$6(Category category, Realm realm) {
        realm.where(Category.class).findAll().deleteAllFromRealm();
        realm.insertOrUpdate((RealmModel)category);
    }

    static /* synthetic */ void lambda$saveOrders$4(boolean bl, List list, Realm realm) {
        if (bl) {
            realm.where(Order.class).findAll().deleteAllFromRealm();
        }
        for (Order order : list) {
            Iterator iterator = order.realmGet$products().iterator();
            while (iterator.hasNext()) {
                ((Product)iterator.next()).setOrderId(order.realmGet$orderId());
            }
            realm.insertOrUpdate((RealmModel)order);
        }
    }

    static /* synthetic */ void lambda$saveProducts$3(boolean bl, List list, Realm realm) {
        if (bl) {
            realm.where(Product.class).findAll().deleteAllFromRealm();
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            realm.insertOrUpdate((RealmModel)((Product)iterator.next()));
        }
    }

    public void clearSessionData() {
        Realm.getDefaultInstance().executeTransaction((Realm.Transaction)-$.Lambda.AppDatabase.w7xp3t54QGsx_iFjBkuCIooJJgo.INSTANCE);
    }

    public Business getBusiness() {
        AtomicReference atomicReference = new AtomicReference(null);
        Realm.getDefaultInstance().executeTransaction((Realm.Transaction)new -$.Lambda.AppDatabase.I79_vVtIj7-5qmqQ25bDSgHgIgs(atomicReference));
        if (atomicReference.get() == null) {
            return null;
        }
        return (Business)Realm.getDefaultInstance().copyFromRealm((RealmModel)atomicReference.get());
    }

    public BusinessStats getBusinessStats() {
        AtomicReference atomicReference = new AtomicReference(null);
        Realm.getDefaultInstance().executeTransaction((Realm.Transaction)new -$.Lambda.AppDatabase.mVqjO6Oj5lu1PL9LwzcTa7VCyWA(atomicReference));
        if (atomicReference.get() == null) {
            return null;
        }
        return (BusinessStats)Realm.getDefaultInstance().copyFromRealm((RealmModel)atomicReference.get());
    }

    public RealmResults<Category> getCategories() {
        return Realm.getDefaultInstance().where(Category.class).findAll();
    }

    public Category getCategory() {
        AtomicReference atomicReference = new AtomicReference(null);
        Realm.getDefaultInstance().executeTransaction((Realm.Transaction)new -$.Lambda.AppDatabase.nj4tnSHisIKVOgPnW1yB4kxCCh8(atomicReference));
        if (atomicReference.get() == null) {
            return null;
        }
        return (Category)Realm.getDefaultInstance().copyFromRealm((RealmModel)atomicReference.get());
    }

    public List<Order> getOrders() {
        Realm realm = Realm.getDefaultInstance();
        return realm.copyFromRealm((Iterable)realm.where(Order.class).findAll());
    }

    public List<Order> getOrders(String string2) {
        Realm realm = Realm.getDefaultInstance();
        return realm.copyFromRealm((Iterable)realm.where(Order.class).equalTo("status", string2).findAll());
    }

    public long getProductCount() {
        return Realm.getDefaultInstance().where(Product.class).isNull("orderId").or().isEmpty("orderId").count();
    }

    public List<Product> getProducts() {
        Realm realm = Realm.getDefaultInstance();
        return realm.copyFromRealm((Iterable)realm.where(Product.class).isNull("orderId").or().isEmpty("orderId").findAll());
    }

    public void saveBusiness(Business business) {
        Realm.getDefaultInstance().executeTransaction((Realm.Transaction)new -$.Lambda.AppDatabase.3VDTB9aeO-Au3rWps56Exv8JaUI(business));
    }

    public void saveBusinessStats(BusinessStats businessStats) {
        Realm.getDefaultInstance().executeTransaction((Realm.Transaction)new -$.Lambda.AppDatabase.19Z_5yVr-06fPgdRk2fyqeVH4ek(businessStats));
    }

    public void saveCategories(List<Category> list, boolean bl) {
        Realm.getDefaultInstance().executeTransaction((Realm.Transaction)new -$.Lambda.AppDatabase.PuZbBVeJ-J4-jAK_SpOidQGHJvw(bl, list));
    }

    public void saveCategory(Category category) {
        Realm.getDefaultInstance().executeTransactionAsync((Realm.Transaction)new -$.Lambda.AppDatabase.J6KyEVQdeKZWb0Vc-w_nxzQPi78(category));
    }

    public void saveOrders(List<Order> list, boolean bl) {
        Realm.getDefaultInstance().executeTransaction((Realm.Transaction)new -$.Lambda.AppDatabase.TMLuLWrv2uHPdhoOTz161Bro4BE(bl, list));
    }

    public void saveProducts(List<Product> list, boolean bl) {
        Realm.getDefaultInstance().executeTransactionAsync((Realm.Transaction)new -$.Lambda.AppDatabase.6fstw2TPMUPoLRKP1CpqWXLhiOo(bl, list));
    }
}

