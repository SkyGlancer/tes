/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  android.provider.ContactsContract
 *  android.provider.ContactsContract$Data
 *  io.reactivex.Observable
 *  io.reactivex.ObservableEmitter
 *  io.reactivex.ObservableOnSubscribe
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Set
 */
package app.dukhaan.src.java.ir.mirrajabi.rxcontacts;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import ir.mirrajabi.rxcontacts.ColumnMapper;
import ir.mirrajabi.rxcontacts.Contact;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class RxContacts {
    private static final String[] PROJECTION = new String[]{"contact_id", "display_name", "starred", "photo_uri", "photo_thumb_uri", "data1", "mimetype", "in_visible_group"};
    private ContentResolver mResolver;

    private RxContacts(Context context) {
        this.mResolver = context.getContentResolver();
    }

    private Cursor createCursor() {
        return this.mResolver.query(ContactsContract.Data.CONTENT_URI, PROJECTION, null, null, "contact_id");
    }

    public static Observable<Contact> fetch(final Context context) {
        return Observable.create((ObservableOnSubscribe)new ObservableOnSubscribe<Contact>(){

            public void subscribe(ObservableEmitter<Contact> observableEmitter) throws Exception {
                new RxContacts(context).fetch((ObservableEmitter<Contact>)observableEmitter);
            }
        });
    }

    private void fetch(ObservableEmitter<Contact> observableEmitter) {
        HashMap hashMap = new HashMap();
        Cursor cursor = this.createCursor();
        cursor.moveToFirst();
        int n = cursor.getColumnIndex("contact_id");
        int n2 = cursor.getColumnIndex("in_visible_group");
        int n3 = cursor.getColumnIndex("display_name");
        int n4 = cursor.getColumnIndex("starred");
        int n5 = cursor.getColumnIndex("photo_uri");
        int n6 = cursor.getColumnIndex("photo_thumb_uri");
        int n7 = cursor.getColumnIndex("mimetype");
        int n8 = cursor.getColumnIndex("data1");
        while (!cursor.isAfterLast()) {
            long l = cursor.getLong(n);
            Contact contact = (Contact)hashMap.get((Object)l);
            if (contact == null) {
                contact = new Contact(l);
                ColumnMapper.mapInVisibleGroup(cursor, contact, n2);
                ColumnMapper.mapDisplayName(cursor, contact, n3);
                ColumnMapper.mapStarred(cursor, contact, n4);
                ColumnMapper.mapPhoto(cursor, contact, n5);
                ColumnMapper.mapThumbnail(cursor, contact, n6);
                hashMap.put((Object)l, (Object)contact);
            }
            String string2 = cursor.getString(n7);
            int n9 = -1;
            int n10 = string2.hashCode();
            if (n10 != -1569536764) {
                if (n10 == 684173810 && string2.equals((Object)"vnd.android.cursor.item/phone_v2")) {
                    n9 = 1;
                }
            } else if (string2.equals((Object)"vnd.android.cursor.item/email_v2")) {
                n9 = 0;
            }
            if (n9 != 0) {
                if (n9 == 1) {
                    ColumnMapper.mapPhoneNumber(cursor, contact, n8);
                }
            } else {
                ColumnMapper.mapEmail(cursor, contact, n8);
            }
            cursor.moveToNext();
        }
        cursor.close();
        Iterator iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            observableEmitter.onNext(hashMap.get((Object)((Long)iterator.next())));
        }
        observableEmitter.onComplete();
    }

}

