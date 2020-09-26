/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.data.model.Business
 *  app.dukhaan.data.model.BusinessStats
 *  app.dukhaan.data.model.Product
 *  app.dukhaan.network.model.Category
 *  app.dukhaan.network.model.Order
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.data.local;

import app.dukhaan.data.model.Business;
import app.dukhaan.data.model.BusinessStats;
import app.dukhaan.data.model.Product;
import app.dukhaan.network.model.Category;
import app.dukhaan.network.model.Order;
import java.util.List;

public interface AppDatabaseHelper {
    public Business getBusiness();

    public BusinessStats getBusinessStats();

    public List<Category> getCategories();

    public Category getCategory();

    public List<Order> getOrders();

    public List<Order> getOrders(String var1);

    public List<Product> getProducts();

    public long getProductsCount();

    public void saveBusiness(Business var1);

    public void saveBusinessStats(BusinessStats var1);

    public void saveCategories(List<Category> var1, boolean var2);

    public void saveCategory(Category var1);

    public void saveOrders(List<Order> var1, boolean var2);

    public void saveProducts(List<Product> var1, boolean var2);
}

