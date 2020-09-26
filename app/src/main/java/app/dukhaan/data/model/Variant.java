/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.realm.RealmObject
 *  io.realm.app_dukhaan_data_model_VariantRealmProxyInterface
 *  io.realm.internal.RealmObjectProxy
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.data.model;

import io.realm.RealmObject;
import io.realm.app_dukhaan_data_model_VariantRealmProxyInterface;
import io.realm.internal.RealmObjectProxy;

public class Variant
extends RealmObject
implements app_dukhaan_data_model_VariantRealmProxyInterface {
    public int id;
    public int product;
    public int type;
    public String value;

    public Variant() {
        if (this instanceof RealmObjectProxy) {
            ((RealmObjectProxy)this).realm$injectObjectContext();
        }
    }

    public int realmGet$id() {
        return this.id;
    }

    public int realmGet$product() {
        return this.product;
    }

    public int realmGet$type() {
        return this.type;
    }

    public String realmGet$value() {
        return this.value;
    }

    public void realmSet$id(int n) {
        this.id = n;
    }

    public void realmSet$product(int n) {
        this.product = n;
    }

    public void realmSet$type(int n) {
        this.type = n;
    }

    public void realmSet$value(String string) {
        this.value = string;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Variant{value='");
        stringBuilder.append(this.realmGet$value());
        stringBuilder.append('\'');
        stringBuilder.append(", id=");
        stringBuilder.append(this.realmGet$id());
        stringBuilder.append(", type=");
        stringBuilder.append(this.realmGet$type());
        stringBuilder.append(", product=");
        stringBuilder.append(this.realmGet$product());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

