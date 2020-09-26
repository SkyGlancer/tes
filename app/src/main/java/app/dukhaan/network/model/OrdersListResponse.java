/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.network.model.Order
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package app.dukhaan.network.model;

import app.dukhaan.network.model.Order;
import java.util.ArrayList;

public class OrdersListResponse {
    private int count;
    public String next;
    private ArrayList<Order> results;

    public int getCount() {
        return this.count;
    }

    public ArrayList<Order> getResults() {
        return this.results;
    }

    public void setCount(int n) {
        this.count = n;
    }

    public void setResults(ArrayList<Order> arrayList) {
        this.results = arrayList;
    }
}

