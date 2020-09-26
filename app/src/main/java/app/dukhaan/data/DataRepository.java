/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.data.model.Business
 *  app.dukhaan.data.model.BusinessStats
 *  app.dukhaan.data.model.Product
 *  app.dukhaan.network.model.Category
 *  app.dukhaan.network.model.Order
 *  io.realm.RealmResults
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.data;

import app.dukhaan.data.local.AppDatabase;
import app.dukhaan.data.local.AppDatabaseHelper;
import app.dukhaan.data.local.AppPref;
import app.dukhaan.data.local.AppPrefHelper;
import app.dukhaan.data.model.Business;
import app.dukhaan.data.model.BusinessStats;
import app.dukhaan.data.model.Product;
import app.dukhaan.network.model.Category;
import app.dukhaan.network.model.Order;
import io.realm.RealmResults;
import java.util.List;

public class DataRepository
implements AppDatabaseHelper,
AppPrefHelper {
    private final AppDatabase appDatabase;
    private final AppPref appPref;

    public DataRepository(AppDatabase appDatabase, AppPref appPref) {
        this.appDatabase = appDatabase;
        this.appPref = appPref;
    }

    @Override
    public String getAuthToken() {
        return this.appPref.getAuthToken();
    }

    @Override
    public Business getBusiness() {
        return this.appDatabase.getBusiness();
    }

    @Override
    public BusinessStats getBusinessStats() {
        return this.appDatabase.getBusinessStats();
    }

    @Override
    public List<Category> getCategories() {
        return this.appDatabase.getCategories();
    }

    @Override
    public Category getCategory() {
        return this.appDatabase.getCategory();
    }

    @Override
    public List<Order> getOrders() {
        return this.appDatabase.getOrders();
    }

    @Override
    public List<Order> getOrders(String string2) {
        return this.appDatabase.getOrders(string2);
    }

    @Override
    public List<Product> getProducts() {
        return this.appDatabase.getProducts();
    }

    @Override
    public long getProductsCount() {
        return this.appDatabase.getProductCount();
    }

    public void logout() {
        this.appDatabase.clearSessionData();
        this.appPref.clearSession();
    }

    @Override
    public void saveAuthToken(String string2) {
        this.appPref.saveAuthToken(string2);
    }

    @Override
    public void saveBusiness(Business business) {
        this.appDatabase.saveBusiness(business);
    }

    @Override
    public void saveBusinessStats(BusinessStats businessStats) {
        this.appDatabase.saveBusinessStats(businessStats);
    }

    @Override
    public void saveCategories(List<Category> list, boolean bl) {
        this.appDatabase.saveCategories(list, bl);
    }

    @Override
    public void saveCategory(Category category) {
        this.appDatabase.saveCategory(category);
    }

    @Override
    public void saveOrders(List<Order> list, boolean bl) {
        this.appDatabase.saveOrders(list, bl);
    }

    @Override
    public void saveProducts(List<Product> list, boolean bl) {
        this.appDatabase.saveProducts(list, bl);
    }
}

