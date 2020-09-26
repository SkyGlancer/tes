/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  io.realm.RealmList
 *  io.realm.RealmObject
 *  io.realm.annotations.PrimaryKey
 *  io.realm.app_dukhaan_data_model_BusinessStatsRealmProxyInterface
 *  io.realm.internal.RealmObjectProxy
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 */
package app.dukhaan.data.model;

import app.dukhaan.data.model.BusinessStatPeriod;
import com.google.gson.annotations.SerializedName;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.app_dukhaan_data_model_BusinessStatsRealmProxyInterface;
import io.realm.internal.RealmObjectProxy;
import java.util.Iterator;

public class BusinessStats
extends RealmObject
implements app_dukhaan_data_model_BusinessStatsRealmProxyInterface {
    @PrimaryKey
    private int id;
    @SerializedName(value="pending_orders")
    public int pendingOrderCount;
    @SerializedName(value="stats")
    RealmList<BusinessStatPeriod> periods;

    public BusinessStats() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy)this).realm$injectObjectContext();
        }
        this.realmSet$id(0);
    }

    public int getPendingOrderCount() {
        return this.realmGet$pendingOrderCount();
    }

    public BusinessStatPeriod getStatus(String string) {
        BusinessStatPeriod businessStatPeriod;
        block2 : {
            BusinessStatPeriod businessStatPeriod2;
            if (this.realmGet$periods() == null) {
                return null;
            }
            Iterator iterator = this.realmGet$periods().iterator();
            do {
                boolean bl = iterator.hasNext();
                businessStatPeriod = null;
                if (!bl) break block2;
            } while (!(businessStatPeriod2 = (BusinessStatPeriod)((Object)iterator.next())).realmGet$duration().equalsIgnoreCase(string));
            businessStatPeriod = businessStatPeriod2;
        }
        return businessStatPeriod;
    }

    public int realmGet$id() {
        return this.id;
    }

    public int realmGet$pendingOrderCount() {
        return this.pendingOrderCount;
    }

    public RealmList realmGet$periods() {
        return this.periods;
    }

    public void realmSet$id(int n) {
        this.id = n;
    }

    public void realmSet$pendingOrderCount(int n) {
        this.pendingOrderCount = n;
    }

    public void realmSet$periods(RealmList realmList) {
        this.periods = realmList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BusinessStats{id=");
        stringBuilder.append(this.realmGet$id());
        stringBuilder.append(", periods=");
        stringBuilder.append((Object)this.realmGet$periods());
        stringBuilder.append(", pendingOrderCount=");
        stringBuilder.append(this.realmGet$pendingOrderCount());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

