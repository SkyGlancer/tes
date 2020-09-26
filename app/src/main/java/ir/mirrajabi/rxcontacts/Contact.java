/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  java.util.Set
 */
package app.dukhaan.src.java.ir.mirrajabi.rxcontacts;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

public class Contact
implements Comparable<Contact> {
    private String mDisplayName;
    private Set<String> mEmails = new HashSet();
    private final long mId;
    private int mInVisibleGroup;
    private Set<String> mPhoneNumbers = new HashSet();
    private Uri mPhoto;
    private boolean mStarred;
    private Uri mThumbnail;

    Contact(long l) {
        this.mId = l;
    }

    public int compareTo(Contact contact) {
        String string2;
        String string3 = this.mDisplayName;
        if (string3 != null && (string2 = contact.mDisplayName) != null) {
            return string3.compareTo(string2);
        }
        return -1;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            Contact contact = (Contact)object;
            return this.mId == contact.mId;
        }
        return false;
    }

    public String getDisplayName() {
        return this.mDisplayName;
    }

    public Set<String> getEmails() {
        return this.mEmails;
    }

    public long getId() {
        return this.mId;
    }

    public int getInVisibleGroup() {
        return this.mInVisibleGroup;
    }

    public Set<String> getPhoneNumbers() {
        return this.mPhoneNumbers;
    }

    public Uri getPhoto() {
        return this.mPhoto;
    }

    public Uri getThumbnail() {
        return this.mThumbnail;
    }

    public int hashCode() {
        long l = this.mId;
        return (int)(l ^ l >>> 32);
    }

    public boolean isStarred() {
        return this.mStarred;
    }

    public void setDisplayName(String string2) {
        this.mDisplayName = string2;
    }

    public void setEmails(Set<String> set) {
        this.mEmails = set;
    }

    public void setInVisibleGroup(int n) {
        this.mInVisibleGroup = n;
    }

    public void setPhoneNumbers(Set<String> set) {
        this.mPhoneNumbers = set;
    }

    public void setPhoto(Uri uri) {
        this.mPhoto = uri;
    }

    public void setStarred(boolean bl) {
        this.mStarred = bl;
    }

    public void setThumbnail(Uri uri) {
        this.mThumbnail = uri;
    }
}

