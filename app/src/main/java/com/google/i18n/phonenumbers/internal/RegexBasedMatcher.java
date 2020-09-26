/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package app.dukhaan.src.java.com.google.i18n.phonenumbers.internal;

import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.RegexCache;
import com.google.i18n.phonenumbers.internal.MatcherApi;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexBasedMatcher
implements MatcherApi {
    private final RegexCache regexCache = new RegexCache(100);

    private RegexBasedMatcher() {
    }

    public static MatcherApi create() {
        return new RegexBasedMatcher();
    }

    @Override
    public boolean matchesNationalNumber(String string2, Phonemetadata.PhoneNumberDesc phoneNumberDesc, boolean bl) {
        Matcher matcher = this.regexCache.getPatternForRegex(phoneNumberDesc.getNationalNumberPattern()).matcher((CharSequence)string2);
        return matcher.matches() || bl && matcher.lookingAt();
        {
        }
    }
}

