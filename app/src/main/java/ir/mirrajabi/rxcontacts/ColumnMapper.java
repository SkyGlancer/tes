/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.net.Uri
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Set
 */
package app.dukhaan.src.java.ir.mirrajabi.rxcontacts;

import android.database.Cursor;
import android.net.Uri;
import ir.mirrajabi.rxcontacts.Contact;
import java.util.Set;

class ColumnMapper {
    private ColumnMapper() {
    }

    static void mapDisplayName(Cursor cursor, Contact contact, int n) {
        String string2 = cursor.getString(n);
        if (string2 != null && !string2.isEmpty()) {
            contact.setDisplayName(string2);
        }
    }

    static void mapEmail(Cursor cursor, Contact contact, int n) {
        String string2 = cursor.getString(n);
        if (string2 != null && !string2.isEmpty()) {
            contact.getEmails().add((Object)string2);
        }
    }

    static void mapInVisibleGroup(Cursor cursor, Contact contact, int n) {
        contact.setInVisibleGroup(cursor.getInt(n));
    }

    static void mapPhoneNumber(Cursor cursor, Contact contact, int n) {
        String string2 = cursor.getString(n);
        if (string2 != null && !string2.isEmpty()) {
            String string3 = string2.replaceAll("\\s+", "");
            contact.getPhoneNumbers().add((Object)string3);
        }
    }

    static void mapPhoto(Cursor cursor, Contact contact, int n) {
        String string2 = cursor.getString(n);
        if (string2 != null && !string2.isEmpty()) {
            contact.setPhoto(Uri.parse((String)string2));
        }
    }

    static void mapStarred(Cursor cursor, Contact contact, int n) {
        boolean bl = cursor.getInt(n) != 0;
        contact.setStarred(bl);
    }

    static void mapThumbnail(Cursor cursor, Contact contact, int n) {
        String string2 = cursor.getString(n);
        if (string2 != null && !string2.isEmpty()) {
            contact.setThumbnail(Uri.parse((String)string2));
        }
    }
}

