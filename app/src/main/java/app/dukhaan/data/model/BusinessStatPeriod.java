/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.realm.RealmObject
 *  io.realm.app_dukhaan_data_model_BusinessStatPeriodRealmProxyInterface
 *  io.realm.internal.RealmObjectProxy
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.data.model;

import io.realm.RealmObject;
import io.realm.app_dukhaan_data_model_BusinessStatPeriodRealmProxyInterface;
import io.realm.internal.RealmObjectProxy;

public class BusinessStatPeriod
extends RealmObject
implements app_dukhaan_data_model_BusinessStatPeriodRealmProxyInterface {
    public String duration;
    public int orders;
    public double revenue;

    public BusinessStatPeriod() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy)this).realm$injectObjectContext();
        }
    }

    public String realmGet$duration() {
        return this.duration;
    }

    public int realmGet$orders() {
        return this.orders;
    }

    public double realmGet$revenue() {
        return this.revenue;
    }

    public void realmSet$duration(String string) {
        this.duration = string;
    }

    public void realmSet$orders(int n) {
        this.orders = n;
    }

    public void realmSet$revenue(double d) {
        this.revenue = d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BusinessStatPeriod{duration='");
        stringBuilder.append(this.realmGet$duration());
        stringBuilder.append('\'');
        stringBuilder.append(", orders=");
        stringBuilder.append(this.realmGet$orders());
        stringBuilder.append(", revenue=");
        stringBuilder.append(this.realmGet$revenue());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

