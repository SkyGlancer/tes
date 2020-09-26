/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  app.dukhaan.network.model.Category
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package app.dukhaan.network.model;

import app.dukhaan.network.model.Category;
import java.util.ArrayList;

public class CategoryListResponse {
    private int count;
    private String next;
    private String previous;
    private ArrayList<Category> results;

    public int getCount() {
        return this.count;
    }

    public String getNext() {
        return this.next;
    }

    public String getPrevious() {
        return this.previous;
    }

    public ArrayList<Category> getResults() {
        return this.results;
    }

    public void setCount(int n) {
        this.count = n;
    }

    public void setNext(String string2) {
        this.next = string2;
    }

    public void setPrevious(String string2) {
        this.previous = string2;
    }

    public void setResults(ArrayList<Category> arrayList) {
        this.results = arrayList;
    }
}

