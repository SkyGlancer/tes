/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.realm.DynamicRealm
 *  io.realm.FieldAttribute
 *  io.realm.RealmMigration
 *  io.realm.RealmObjectSchema
 *  io.realm.RealmSchema
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.data.local;

import io.realm.DynamicRealm;
import io.realm.FieldAttribute;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

public class DatabaseMigrations
implements RealmMigration {
    public void migrate(DynamicRealm dynamicRealm, long l, long l2) {
        RealmObjectSchema realmObjectSchema;
        RealmSchema realmSchema = dynamicRealm.getSchema();
        if (l == 1L) {
            RealmObjectSchema realmObjectSchema2 = realmSchema.get("Product");
            if (!realmObjectSchema2.hasField("orderId")) {
                realmObjectSchema2.addField("orderId", String.class, new FieldAttribute[0]);
            }
            ++l;
        }
        if (l == 2L) {
            RealmObjectSchema realmObjectSchema3 = realmSchema.get("Business");
            if (!realmObjectSchema3.hasField("isWhatsAppChatEnabled")) {
                realmObjectSchema3.addField("isWhatsAppChatEnabled", Boolean.TYPE, new FieldAttribute[0]);
            }
            ++l;
        }
        if (l == 3L) {
            RealmObjectSchema realmObjectSchema4 = realmSchema.get("Product");
            if (!realmObjectSchema4.hasField("originalCost")) {
                realmObjectSchema4.addField("originalCost", Double.class, new FieldAttribute[0]);
            }
            ++l;
        }
        if (l == 4L) {
            RealmObjectSchema realmObjectSchema5 = realmSchema.get("Product");
            if (!realmObjectSchema5.hasField("variants")) {
                realmObjectSchema5.addRealmListField("variants", String.class);
            }
            ++l;
        }
        if (l == 5L) {
            realmSchema.create("Variant").addField("id", Integer.TYPE, new FieldAttribute[0]).addField("product", Integer.TYPE, new FieldAttribute[0]).addField("type", Integer.TYPE, new FieldAttribute[0]).addField("value", String.class, new FieldAttribute[0]);
            ++l;
        }
        if (l == 6L && !(realmObjectSchema = realmSchema.get("Business")).hasField("referredBy")) {
            realmObjectSchema.addField("referredBy", String.class, new FieldAttribute[0]);
        }
    }
}

