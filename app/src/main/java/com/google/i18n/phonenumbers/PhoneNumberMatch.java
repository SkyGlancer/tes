/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 */
package app.dukhaan.src.java.com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.Phonenumber;
import java.util.Arrays;

public final class PhoneNumberMatch {
    private final Phonenumber.PhoneNumber number;
    private final String rawString;
    private final int start;

    PhoneNumberMatch(int n, String string2, Phonenumber.PhoneNumber phoneNumber) {
        if (n >= 0) {
            if (string2 != null && phoneNumber != null) {
                this.start = n;
                this.rawString = string2;
                this.number = phoneNumber;
                return;
            }
            throw null;
        }
        throw new IllegalArgumentException("Start index must be >= 0.");
    }

    public int end() {
        return this.start + this.rawString.length();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PhoneNumberMatch)) {
            return false;
        }
        PhoneNumberMatch phoneNumberMatch = (PhoneNumberMatch)object;
        return this.rawString.equals((Object)phoneNumberMatch.rawString) && this.start == phoneNumberMatch.start && this.number.equals(phoneNumberMatch.number);
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.start, this.rawString, this.number};
        return Arrays.hashCode((Object[])arrobject);
    }

    public Phonenumber.PhoneNumber number() {
        return this.number;
    }

    public String rawString() {
        return this.rawString;
    }

    public int start() {
        return this.start;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PhoneNumberMatch [");
        stringBuilder.append(this.start());
        stringBuilder.append(",");
        stringBuilder.append(this.end());
        stringBuilder.append(") ");
        stringBuilder.append(this.rawString);
        return stringBuilder.toString();
    }
}

