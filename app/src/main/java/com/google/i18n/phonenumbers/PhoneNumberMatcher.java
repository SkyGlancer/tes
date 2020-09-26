/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Character$UnicodeBlock
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 *  java.util.List
 *  java.util.NoSuchElementException
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package app.dukhaan.src.java.com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.MetadataManager;
import com.google.i18n.phonenumbers.PhoneNumberMatch;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.Phonenumber;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class PhoneNumberMatcher
implements Iterator<PhoneNumberMatch> {
    private static final Pattern[] INNER_MATCHES;
    private static final Pattern LEAD_CLASS;
    private static final Pattern MATCHING_BRACKETS;
    private static final Pattern PATTERN;
    private static final Pattern PUB_PAGES;
    private static final Pattern SLASH_SEPARATED_DATES;
    private static final Pattern TIME_STAMPS;
    private static final Pattern TIME_STAMPS_SUFFIX;
    private PhoneNumberMatch lastMatch = null;
    private final PhoneNumberUtil.Leniency leniency;
    private long maxTries;
    private final PhoneNumberUtil phoneUtil;
    private final String preferredRegion;
    private int searchIndex = 0;
    private State state = State.NOT_READY;
    private final CharSequence text;

    static {
        PUB_PAGES = Pattern.compile((String)"\\d{1,5}-+\\d{1,5}\\s{0,4}\\(\\d{1,4}");
        SLASH_SEPARATED_DATES = Pattern.compile((String)"(?:(?:[0-3]?\\d/[01]?\\d)|(?:[01]?\\d/[0-3]?\\d))/(?:[12]\\d)?\\d{2}");
        TIME_STAMPS = Pattern.compile((String)"[12]\\d{3}[-/]?[01]\\d[-/]?[0-3]\\d +[0-2]\\d$");
        TIME_STAMPS_SUFFIX = Pattern.compile((String)":[0-5]\\d");
        Pattern[] arrpattern = new Pattern[]{Pattern.compile((String)"/+(.*)"), Pattern.compile((String)"(\\([^(]*)"), Pattern.compile((String)"(?:\\p{Z}-|-\\p{Z})\\p{Z}*(.+)"), Pattern.compile((String)"[\u2012-\u2015\uff0d]\\p{Z}*(.+)"), Pattern.compile((String)"\\.+\\p{Z}*([^.]+)"), Pattern.compile((String)"\\p{Z}+(\\P{Z}+)")};
        INNER_MATCHES = arrpattern;
        String string2 = PhoneNumberMatcher.limit(0, 3);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(?:[");
        stringBuilder.append("(\\[\uff08\uff3b");
        stringBuilder.append("])?(?:");
        stringBuilder.append("[^(\\[\uff08\uff3b)\\]\uff09\uff3d]");
        stringBuilder.append("+[");
        stringBuilder.append(")\\]\uff09\uff3d");
        stringBuilder.append("])?");
        stringBuilder.append("[^(\\[\uff08\uff3b)\\]\uff09\uff3d]");
        stringBuilder.append("+(?:[");
        stringBuilder.append("(\\[\uff08\uff3b");
        stringBuilder.append("]");
        stringBuilder.append("[^(\\[\uff08\uff3b)\\]\uff09\uff3d]");
        stringBuilder.append("+[");
        stringBuilder.append(")\\]\uff09\uff3d");
        stringBuilder.append("])");
        stringBuilder.append(string2);
        stringBuilder.append("[^(\\[\uff08\uff3b)\\]\uff09\uff3d]");
        stringBuilder.append("*");
        MATCHING_BRACKETS = Pattern.compile((String)stringBuilder.toString());
        String string3 = PhoneNumberMatcher.limit(0, 2);
        String string4 = PhoneNumberMatcher.limit(0, 4);
        String string5 = PhoneNumberMatcher.limit(0, 20);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("[-x\u2010-\u2015\u2212\u30fc\uff0d-\uff0f \u00a0\u00ad\u200b\u2060\u3000()\uff08\uff09\uff3b\uff3d.\\[\\]/~\u2053\u223c\uff5e]");
        stringBuilder2.append(string4);
        String string6 = stringBuilder2.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("\\p{Nd}");
        stringBuilder3.append(PhoneNumberMatcher.limit(1, 20));
        String string7 = stringBuilder3.toString();
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("[");
        stringBuilder4.append("(\\[\uff08\uff3b+\uff0b");
        stringBuilder4.append("]");
        String string8 = stringBuilder4.toString();
        LEAD_CLASS = Pattern.compile((String)string8);
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append("(?:");
        stringBuilder5.append(string8);
        stringBuilder5.append(string6);
        stringBuilder5.append(")");
        stringBuilder5.append(string3);
        stringBuilder5.append(string7);
        stringBuilder5.append("(?:");
        stringBuilder5.append(string6);
        stringBuilder5.append(string7);
        stringBuilder5.append(")");
        stringBuilder5.append(string5);
        stringBuilder5.append("(?:");
        stringBuilder5.append(PhoneNumberUtil.EXTN_PATTERNS_FOR_MATCHING);
        stringBuilder5.append(")?");
        PATTERN = Pattern.compile((String)stringBuilder5.toString(), (int)66);
    }

    PhoneNumberMatcher(PhoneNumberUtil phoneNumberUtil, CharSequence charSequence, String string2, PhoneNumberUtil.Leniency leniency, long l) {
        if (phoneNumberUtil != null && leniency != null) {
            if (l >= 0L) {
                this.phoneUtil = phoneNumberUtil;
                if (charSequence == null) {
                    charSequence = "";
                }
                this.text = charSequence;
                this.preferredRegion = string2;
                this.leniency = leniency;
                this.maxTries = l;
                return;
            }
            throw new IllegalArgumentException();
        }
        throw null;
    }

    static boolean allNumberGroupsAreExactlyPresent(PhoneNumberUtil phoneNumberUtil, Phonenumber.PhoneNumber phoneNumber, StringBuilder stringBuilder, String[] arrstring) {
        String[] arrstring2 = PhoneNumberUtil.NON_DIGITS_PATTERN.split((CharSequence)stringBuilder.toString());
        boolean bl = phoneNumber.hasExtension();
        boolean bl2 = true;
        int n = bl ? -2 + arrstring2.length : arrstring2.length - bl2;
        if (arrstring2.length != bl2) {
            if (arrstring2[n].contains((CharSequence)phoneNumberUtil.getNationalSignificantNumber(phoneNumber))) {
                return bl2;
            }
            for (int i = arrstring.length - bl2; i > 0 && n >= 0; --i, --n) {
                if (arrstring2[n].equals((Object)arrstring[i])) continue;
                return false;
            }
            if (n >= 0 && arrstring2[n].endsWith(arrstring[0])) {
                return bl2;
            }
            bl2 = false;
        }
        return bl2;
    }

    static boolean allNumberGroupsRemainGrouped(PhoneNumberUtil phoneNumberUtil, Phonenumber.PhoneNumber phoneNumber, StringBuilder stringBuilder, String[] arrstring) {
        int n;
        if (phoneNumber.getCountryCodeSource() != Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            String string2 = Integer.toString((int)phoneNumber.getCountryCode());
            n = stringBuilder.indexOf(string2) + string2.length();
        } else {
            n = 0;
        }
        for (int i = 0; i < arrstring.length; ++i) {
            int n2 = stringBuilder.indexOf(arrstring[i], n);
            if (n2 < 0) {
                return false;
            }
            n = n2 + arrstring[i].length();
            if (i != 0 || n >= stringBuilder.length() || phoneNumberUtil.getNddPrefixForRegion(phoneNumberUtil.getRegionCodeForCountryCode(phoneNumber.getCountryCode()), true) == null || !Character.isDigit((char)stringBuilder.charAt(n))) continue;
            String string3 = phoneNumberUtil.getNationalSignificantNumber(phoneNumber);
            return stringBuilder.substring(n - arrstring[i].length()).startsWith(string3);
        }
        return stringBuilder.substring(n).contains((CharSequence)phoneNumber.getExtension());
    }

    static boolean checkNumberGroupingIsValid(Phonenumber.PhoneNumber phoneNumber, String string2, PhoneNumberUtil phoneNumberUtil, NumberGroupingChecker numberGroupingChecker) {
        StringBuilder stringBuilder = PhoneNumberUtil.normalizeDigits(string2, true);
        if (numberGroupingChecker.checkGroups(phoneNumberUtil, phoneNumber, stringBuilder, PhoneNumberMatcher.getNationalNumberGroups(phoneNumberUtil, phoneNumber, null))) {
            return true;
        }
        Phonemetadata.PhoneMetadata phoneMetadata = MetadataManager.getAlternateFormatsForCountry(phoneNumber.getCountryCode());
        if (phoneMetadata != null) {
            Iterator iterator = phoneMetadata.numberFormats().iterator();
            while (iterator.hasNext()) {
                if (!numberGroupingChecker.checkGroups(phoneNumberUtil, phoneNumber, stringBuilder, PhoneNumberMatcher.getNationalNumberGroups(phoneNumberUtil, phoneNumber, (Phonemetadata.NumberFormat)iterator.next()))) continue;
                return true;
            }
        }
        return false;
    }

    static boolean containsMoreThanOneSlashInNationalNumber(Phonenumber.PhoneNumber phoneNumber, String string2) {
        int n = string2.indexOf(47);
        if (n < 0) {
            return false;
        }
        int n2 = string2.indexOf(47, n + 1);
        if (n2 < 0) {
            return false;
        }
        boolean bl = phoneNumber.getCountryCodeSource() == Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN || phoneNumber.getCountryCodeSource() == Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN;
        if (bl && PhoneNumberUtil.normalizeDigitsOnly(string2.substring(0, n)).equals((Object)Integer.toString((int)phoneNumber.getCountryCode()))) {
            return string2.substring(n2 + 1).contains((CharSequence)"/");
        }
        return true;
    }

    static boolean containsOnlyValidXChars(Phonenumber.PhoneNumber phoneNumber, String string2, PhoneNumberUtil phoneNumberUtil) {
        for (int i = 0; i < string2.length() - 1; ++i) {
            char c = string2.charAt(i);
            if (c != 'x' && c != 'X') continue;
            int n = i + 1;
            char c2 = string2.charAt(n);
            if (c2 != 'x' && c2 != 'X') {
                if (PhoneNumberUtil.normalizeDigitsOnly(string2.substring(i)).equals((Object)phoneNumber.getExtension())) continue;
                return false;
            }
            if (phoneNumberUtil.isNumberMatch(phoneNumber, string2.substring(n)) != PhoneNumberUtil.MatchType.NSN_MATCH) {
                return false;
            }
            i = n;
        }
        return true;
    }

    private PhoneNumberMatch extractInnerMatch(String string2, int n) {
        Pattern[] arrpattern = INNER_MATCHES;
        int n2 = arrpattern.length;
        for (int i = 0; i < n2; ++i) {
            Matcher matcher = arrpattern[i].matcher((CharSequence)string2);
            boolean bl = true;
            while (matcher.find() && this.maxTries > 0L) {
                PhoneNumberMatch phoneNumberMatch;
                if (bl) {
                    PhoneNumberMatch phoneNumberMatch2 = this.parseAndVerify(PhoneNumberMatcher.trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN, string2.substring(0, matcher.start())).toString(), n);
                    if (phoneNumberMatch2 != null) {
                        return phoneNumberMatch2;
                    }
                    --this.maxTries;
                    bl = false;
                }
                if ((phoneNumberMatch = this.parseAndVerify(PhoneNumberMatcher.trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN, matcher.group(1)).toString(), n + matcher.start(1))) != null) {
                    return phoneNumberMatch;
                }
                --this.maxTries;
            }
        }
        return null;
    }

    private PhoneNumberMatch extractMatch(CharSequence charSequence, int n) {
        String string2;
        if (SLASH_SEPARATED_DATES.matcher(charSequence).find()) {
            return null;
        }
        if (TIME_STAMPS.matcher(charSequence).find() && TIME_STAMPS_SUFFIX.matcher((CharSequence)(string2 = this.text.toString().substring(n + charSequence.length()))).lookingAt()) {
            return null;
        }
        String string3 = charSequence.toString();
        PhoneNumberMatch phoneNumberMatch = this.parseAndVerify(string3, n);
        if (phoneNumberMatch != null) {
            return phoneNumberMatch;
        }
        return this.extractInnerMatch(string3, n);
    }

    private PhoneNumberMatch find(int n) {
        Matcher matcher = PATTERN.matcher(this.text);
        while (this.maxTries > 0L && matcher.find(n)) {
            int n2 = matcher.start();
            CharSequence charSequence = this.text.subSequence(n2, matcher.end());
            CharSequence charSequence2 = PhoneNumberMatcher.trimAfterFirstMatch(PhoneNumberUtil.SECOND_NUMBER_START_PATTERN, charSequence);
            PhoneNumberMatch phoneNumberMatch = this.extractMatch(charSequence2, n2);
            if (phoneNumberMatch != null) {
                return phoneNumberMatch;
            }
            n = n2 + charSequence2.length();
            --this.maxTries;
        }
        return null;
    }

    private static String[] getNationalNumberGroups(PhoneNumberUtil phoneNumberUtil, Phonenumber.PhoneNumber phoneNumber, Phonemetadata.NumberFormat numberFormat) {
        if (numberFormat == null) {
            String string2 = phoneNumberUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.RFC3966);
            int n = string2.indexOf(59);
            if (n < 0) {
                n = string2.length();
            }
            return string2.substring(1 + string2.indexOf(45), n).split("-");
        }
        return phoneNumberUtil.formatNsnUsingPattern(phoneNumberUtil.getNationalSignificantNumber(phoneNumber), numberFormat, PhoneNumberUtil.PhoneNumberFormat.RFC3966).split("-");
    }

    private static boolean isInvalidPunctuationSymbol(char c) {
        return c == '%' || Character.getType((char)c) == 26;
        {
        }
    }

    static boolean isLatinLetter(char c) {
        boolean bl;
        block5 : {
            block4 : {
                if (!Character.isLetter((char)c) && Character.getType((char)c) != 6) {
                    return false;
                }
                Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.of((char)c);
                if (unicodeBlock.equals((Object)Character.UnicodeBlock.BASIC_LATIN) || unicodeBlock.equals((Object)Character.UnicodeBlock.LATIN_1_SUPPLEMENT) || unicodeBlock.equals((Object)Character.UnicodeBlock.LATIN_EXTENDED_A) || unicodeBlock.equals((Object)Character.UnicodeBlock.LATIN_EXTENDED_ADDITIONAL) || unicodeBlock.equals((Object)Character.UnicodeBlock.LATIN_EXTENDED_B)) break block4;
                boolean bl2 = unicodeBlock.equals((Object)Character.UnicodeBlock.COMBINING_DIACRITICAL_MARKS);
                bl = false;
                if (!bl2) break block5;
            }
            bl = true;
        }
        return bl;
    }

    static boolean isNationalPrefixPresentIfRequired(Phonenumber.PhoneNumber phoneNumber, PhoneNumberUtil phoneNumberUtil) {
        if (phoneNumber.getCountryCodeSource() != Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            return true;
        }
        Phonemetadata.PhoneMetadata phoneMetadata = phoneNumberUtil.getMetadataForRegion(phoneNumberUtil.getRegionCodeForCountryCode(phoneNumber.getCountryCode()));
        if (phoneMetadata == null) {
            return true;
        }
        String string2 = phoneNumberUtil.getNationalSignificantNumber(phoneNumber);
        Phonemetadata.NumberFormat numberFormat = phoneNumberUtil.chooseFormattingPatternForNumber(phoneMetadata.numberFormats(), string2);
        if (numberFormat != null && numberFormat.getNationalPrefixFormattingRule().length() > 0) {
            if (numberFormat.isNationalPrefixOptionalWhenFormatting()) {
                return true;
            }
            if (PhoneNumberUtil.formattingRuleHasFirstGroupOnly(numberFormat.getNationalPrefixFormattingRule())) {
                return true;
            }
            return phoneNumberUtil.maybeStripNationalPrefixAndCarrierCode(new StringBuilder(PhoneNumberUtil.normalizeDigitsOnly(phoneNumber.getRawInput())), phoneMetadata, null);
        }
        return true;
    }

    private static String limit(int n, int n2) {
        if (n >= 0 && n2 > 0 && n2 >= n) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{");
            stringBuilder.append(n);
            stringBuilder.append(",");
            stringBuilder.append(n2);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
        throw new IllegalArgumentException();
    }

    /*
     * Exception decompiling
     */
    private PhoneNumberMatch parseAndVerify(String var1, int var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl125.1 : ACONST_NULL : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    private static CharSequence trimAfterFirstMatch(Pattern pattern, CharSequence charSequence) {
        Matcher matcher = pattern.matcher(charSequence);
        if (matcher.find()) {
            charSequence = charSequence.subSequence(0, matcher.start());
        }
        return charSequence;
    }

    public boolean hasNext() {
        if (this.state == State.NOT_READY) {
            PhoneNumberMatch phoneNumberMatch;
            this.lastMatch = phoneNumberMatch = this.find(this.searchIndex);
            if (phoneNumberMatch == null) {
                this.state = State.DONE;
            } else {
                this.searchIndex = phoneNumberMatch.end();
                this.state = State.READY;
            }
        }
        return this.state == State.READY;
    }

    public PhoneNumberMatch next() {
        if (this.hasNext()) {
            PhoneNumberMatch phoneNumberMatch = this.lastMatch;
            this.lastMatch = null;
            this.state = State.NOT_READY;
            return phoneNumberMatch;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    static interface NumberGroupingChecker {
        public boolean checkGroups(PhoneNumberUtil var1, Phonenumber.PhoneNumber var2, StringBuilder var3, String[] var4);
    }

    private static final class State
    extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES;
        public static final /* enum */ State DONE;
        public static final /* enum */ State NOT_READY;
        public static final /* enum */ State READY;

        static {
            State state;
            NOT_READY = new State();
            READY = new State();
            DONE = state = new State();
            State[] arrstate = new State[]{NOT_READY, READY, state};
            $VALUES = arrstate;
        }

        public static State valueOf(String string2) {
            return (State)Enum.valueOf(State.class, (String)string2);
        }

        public static State[] values() {
            return (State[])$VALUES.clone();
        }
    }

}

