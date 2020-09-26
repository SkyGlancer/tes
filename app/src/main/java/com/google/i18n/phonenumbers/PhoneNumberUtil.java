/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.i18n.phonenumbers.MultiFileMetadataSourceImpl
 *  com.google.i18n.phonenumbers.PhoneNumberUtil$Leniency$1
 *  com.google.i18n.phonenumbers.PhoneNumberUtil$Leniency$2
 *  com.google.i18n.phonenumbers.PhoneNumberUtil$Leniency$3
 *  com.google.i18n.phonenumbers.PhoneNumberUtil$Leniency$4
 *  com.google.i18n.phonenumbers.Phonemetadata$NumberFormat$Builder
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Long
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package app.dukhaan.src.java.com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.AsYouTypeFormatter;
import com.google.i18n.phonenumbers.CountryCodeToRegionCodeMap;
import com.google.i18n.phonenumbers.MetadataLoader;
import com.google.i18n.phonenumbers.MetadataManager;
import com.google.i18n.phonenumbers.MetadataSource;
import com.google.i18n.phonenumbers.MultiFileMetadataSourceImpl;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberMatch;
import com.google.i18n.phonenumbers.PhoneNumberMatcher;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.RegexCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberUtil {
    private static final Map<Character, Character> ALL_PLUS_NUMBER_GROUPING_SYMBOLS;
    private static final Map<Character, Character> ALPHA_MAPPINGS;
    private static final Map<Character, Character> ALPHA_PHONE_MAPPINGS;
    private static final Pattern CAPTURING_DIGIT_PATTERN;
    private static final String CAPTURING_EXTN_DIGITS = "(\\p{Nd}{1,7})";
    private static final Pattern CC_PATTERN;
    private static final String COLOMBIA_MOBILE_TO_FIXED_LINE_PREFIX = "3";
    private static final String DEFAULT_EXTN_PREFIX = " ext. ";
    private static final Map<Character, Character> DIALLABLE_CHAR_MAPPINGS;
    private static final String DIGITS = "\\p{Nd}";
    private static final Pattern EXTN_PATTERN;
    static final String EXTN_PATTERNS_FOR_MATCHING;
    private static final String EXTN_PATTERNS_FOR_PARSING;
    private static final Pattern FG_PATTERN;
    private static final Pattern FIRST_GROUP_ONLY_PREFIX_PATTERN;
    private static final Pattern FIRST_GROUP_PATTERN;
    private static final Set<Integer> GEO_MOBILE_COUNTRIES;
    private static final Set<Integer> GEO_MOBILE_COUNTRIES_WITHOUT_MOBILE_AREA_CODES;
    private static final int MAX_INPUT_STRING_LENGTH = 250;
    static final int MAX_LENGTH_COUNTRY_CODE = 3;
    static final int MAX_LENGTH_FOR_NSN = 17;
    private static final int MIN_LENGTH_FOR_NSN = 2;
    private static final Map<Integer, String> MOBILE_TOKEN_MAPPINGS;
    private static final int NANPA_COUNTRY_CODE = 1;
    static final Pattern NON_DIGITS_PATTERN;
    private static final Pattern NP_PATTERN;
    static final String PLUS_CHARS = "+\uff0b";
    static final Pattern PLUS_CHARS_PATTERN;
    static final char PLUS_SIGN = '+';
    static final int REGEX_FLAGS = 66;
    public static final String REGION_CODE_FOR_NON_GEO_ENTITY = "001";
    private static final String RFC3966_EXTN_PREFIX = ";ext=";
    private static final String RFC3966_ISDN_SUBADDRESS = ";isub=";
    private static final String RFC3966_PHONE_CONTEXT = ";phone-context=";
    private static final String RFC3966_PREFIX = "tel:";
    private static final String SECOND_NUMBER_START = "[\\\\/] *x";
    static final Pattern SECOND_NUMBER_START_PATTERN;
    private static final Pattern SEPARATOR_PATTERN;
    private static final char STAR_SIGN = '*';
    private static final Pattern UNIQUE_INTERNATIONAL_PREFIX;
    private static final String UNKNOWN_REGION = "ZZ";
    private static final String UNWANTED_END_CHARS = "[[\\P{N}&&\\P{L}]&&[^#]]+$";
    static final Pattern UNWANTED_END_CHAR_PATTERN;
    private static final String VALID_ALPHA;
    private static final Pattern VALID_ALPHA_PHONE_PATTERN;
    private static final String VALID_PHONE_NUMBER;
    private static final Pattern VALID_PHONE_NUMBER_PATTERN;
    static final String VALID_PUNCTUATION = "-x\u2010-\u2015\u2212\u30fc\uff0d-\uff0f \u00a0\u00ad\u200b\u2060\u3000()\uff08\uff09\uff3b\uff3d.\\[\\]/~\u2053\u223c\uff5e";
    private static final String VALID_START_CHAR = "[+\uff0b\\p{Nd}]";
    private static final Pattern VALID_START_CHAR_PATTERN;
    private static PhoneNumberUtil instance;
    private static final Logger logger;
    private final Map<Integer, List<String>> countryCallingCodeToRegionCodeMap;
    private final Set<Integer> countryCodesForNonGeographicalRegion = new HashSet();
    private final MetadataSource metadataSource;
    private final Set<String> nanpaRegions = new HashSet(35);
    private final RegexCache regexCache = new RegexCache(100);
    private final Set<String> supportedRegions = new HashSet(320);

    static {
        logger = Logger.getLogger((String)PhoneNumberUtil.class.getName());
        HashMap hashMap = new HashMap();
        Integer n = 52;
        Character c = Character.valueOf((char)'4');
        hashMap.put((Object)n, (Object)"1");
        Integer n2 = 54;
        Character c2 = Character.valueOf((char)'6');
        hashMap.put((Object)n2, (Object)"9");
        MOBILE_TOKEN_MAPPINGS = Collections.unmodifiableMap((Map)hashMap);
        HashSet hashSet = new HashSet();
        hashSet.add((Object)86);
        GEO_MOBILE_COUNTRIES_WITHOUT_MOBILE_AREA_CODES = Collections.unmodifiableSet((Set)hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add((Object)n);
        hashSet2.add((Object)n2);
        Character c3 = Character.valueOf((char)'7');
        hashSet2.add((Object)55);
        hashSet2.add((Object)62);
        hashSet2.addAll((Collection)hashSet);
        GEO_MOBILE_COUNTRIES = Collections.unmodifiableSet((Set)hashSet2);
        HashMap hashMap2 = new HashMap();
        Character c4 = Character.valueOf((char)'0');
        hashMap2.put((Object)c4, (Object)c4);
        Character c5 = Character.valueOf((char)'1');
        hashMap2.put((Object)c5, (Object)c5);
        Character c6 = Character.valueOf((char)'2');
        hashMap2.put((Object)c6, (Object)c6);
        Character c7 = Character.valueOf((char)'3');
        hashMap2.put((Object)c7, (Object)c7);
        hashMap2.put((Object)c, (Object)c);
        Character c8 = Character.valueOf((char)'5');
        hashMap2.put((Object)c8, (Object)c8);
        hashMap2.put((Object)c2, (Object)c2);
        hashMap2.put((Object)c3, (Object)c3);
        Character c9 = Character.valueOf((char)'8');
        hashMap2.put((Object)c9, (Object)c9);
        Character c10 = Character.valueOf((char)'9');
        hashMap2.put((Object)c10, (Object)c10);
        HashMap hashMap3 = new HashMap(40);
        hashMap3.put((Object)Character.valueOf((char)'A'), (Object)c6);
        hashMap3.put((Object)Character.valueOf((char)'B'), (Object)c6);
        hashMap3.put((Object)Character.valueOf((char)'C'), (Object)c6);
        hashMap3.put((Object)Character.valueOf((char)'D'), (Object)c7);
        hashMap3.put((Object)Character.valueOf((char)'E'), (Object)c7);
        hashMap3.put((Object)Character.valueOf((char)'F'), (Object)c7);
        hashMap3.put((Object)Character.valueOf((char)'G'), (Object)c);
        hashMap3.put((Object)Character.valueOf((char)'H'), (Object)c);
        hashMap3.put((Object)Character.valueOf((char)'I'), (Object)c);
        hashMap3.put((Object)Character.valueOf((char)'J'), (Object)c8);
        hashMap3.put((Object)Character.valueOf((char)'K'), (Object)c8);
        hashMap3.put((Object)Character.valueOf((char)'L'), (Object)c8);
        hashMap3.put((Object)Character.valueOf((char)'M'), (Object)c2);
        hashMap3.put((Object)Character.valueOf((char)'N'), (Object)c2);
        hashMap3.put((Object)Character.valueOf((char)'O'), (Object)c2);
        hashMap3.put((Object)Character.valueOf((char)'P'), (Object)c3);
        hashMap3.put((Object)Character.valueOf((char)'Q'), (Object)c3);
        hashMap3.put((Object)Character.valueOf((char)'R'), (Object)c3);
        hashMap3.put((Object)Character.valueOf((char)'S'), (Object)c3);
        hashMap3.put((Object)Character.valueOf((char)'T'), (Object)c9);
        hashMap3.put((Object)Character.valueOf((char)'U'), (Object)c9);
        hashMap3.put((Object)Character.valueOf((char)'V'), (Object)c9);
        hashMap3.put((Object)Character.valueOf((char)'W'), (Object)c10);
        hashMap3.put((Object)Character.valueOf((char)'X'), (Object)c10);
        hashMap3.put((Object)Character.valueOf((char)'Y'), (Object)c10);
        hashMap3.put((Object)Character.valueOf((char)'Z'), (Object)c10);
        ALPHA_MAPPINGS = Collections.unmodifiableMap((Map)hashMap3);
        HashMap hashMap4 = new HashMap(100);
        hashMap4.putAll(ALPHA_MAPPINGS);
        hashMap4.putAll((Map)hashMap2);
        ALPHA_PHONE_MAPPINGS = Collections.unmodifiableMap((Map)hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.putAll((Map)hashMap2);
        Character c11 = Character.valueOf((char)'+');
        hashMap5.put((Object)c11, (Object)c11);
        Character c12 = Character.valueOf((char)'*');
        hashMap5.put((Object)c12, (Object)c12);
        Character c13 = Character.valueOf((char)'#');
        hashMap5.put((Object)c13, (Object)c13);
        DIALLABLE_CHAR_MAPPINGS = Collections.unmodifiableMap((Map)hashMap5);
        HashMap hashMap6 = new HashMap();
        Iterator iterator = ALPHA_MAPPINGS.keySet().iterator();
        while (iterator.hasNext()) {
            char c14 = ((Character)iterator.next()).charValue();
            hashMap6.put((Object)Character.valueOf((char)Character.toLowerCase((char)c14)), (Object)Character.valueOf((char)c14));
            hashMap6.put((Object)Character.valueOf((char)c14), (Object)Character.valueOf((char)c14));
        }
        hashMap6.putAll((Map)hashMap2);
        hashMap6.put((Object)Character.valueOf((char)'-'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\uff0d'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\u2010'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\u2011'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\u2012'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\u2013'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\u2014'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\u2015'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'\u2212'), (Object)Character.valueOf((char)'-'));
        hashMap6.put((Object)Character.valueOf((char)'/'), (Object)Character.valueOf((char)'/'));
        hashMap6.put((Object)Character.valueOf((char)'\uff0f'), (Object)Character.valueOf((char)'/'));
        hashMap6.put((Object)Character.valueOf((char)' '), (Object)Character.valueOf((char)' '));
        hashMap6.put((Object)Character.valueOf((char)'\u3000'), (Object)Character.valueOf((char)' '));
        hashMap6.put((Object)Character.valueOf((char)'\u2060'), (Object)Character.valueOf((char)' '));
        hashMap6.put((Object)Character.valueOf((char)'.'), (Object)Character.valueOf((char)'.'));
        hashMap6.put((Object)Character.valueOf((char)'\uff0e'), (Object)Character.valueOf((char)'.'));
        ALL_PLUS_NUMBER_GROUPING_SYMBOLS = Collections.unmodifiableMap((Map)hashMap6);
        UNIQUE_INTERNATIONAL_PREFIX = Pattern.compile((String)"[\\d]+(?:[~\u2053\u223c\uff5e][\\d]+)?");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Arrays.toString((Object[])ALPHA_MAPPINGS.keySet().toArray()).replaceAll("[, \\[\\]]", ""));
        stringBuilder.append(Arrays.toString((Object[])ALPHA_MAPPINGS.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
        VALID_ALPHA = stringBuilder.toString();
        PLUS_CHARS_PATTERN = Pattern.compile((String)"[+\uff0b]+");
        SEPARATOR_PATTERN = Pattern.compile((String)"[-x\u2010-\u2015\u2212\u30fc\uff0d-\uff0f \u00a0\u00ad\u200b\u2060\u3000()\uff08\uff09\uff3b\uff3d.\\[\\]/~\u2053\u223c\uff5e]+");
        CAPTURING_DIGIT_PATTERN = Pattern.compile((String)"(\\p{Nd})");
        VALID_START_CHAR_PATTERN = Pattern.compile((String)VALID_START_CHAR);
        SECOND_NUMBER_START_PATTERN = Pattern.compile((String)SECOND_NUMBER_START);
        UNWANTED_END_CHAR_PATTERN = Pattern.compile((String)UNWANTED_END_CHARS);
        VALID_ALPHA_PHONE_PATTERN = Pattern.compile((String)"(?:.*?[A-Za-z]){3}.*");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("\\p{Nd}{2}|[+\uff0b]*+(?:[-x\u2010-\u2015\u2212\u30fc\uff0d-\uff0f \u00a0\u00ad\u200b\u2060\u3000()\uff08\uff09\uff3b\uff3d.\\[\\]/~\u2053\u223c\uff5e*]*\\p{Nd}){3,}[-x\u2010-\u2015\u2212\u30fc\uff0d-\uff0f \u00a0\u00ad\u200b\u2060\u3000()\uff08\uff09\uff3b\uff3d.\\[\\]/~\u2053\u223c\uff5e*");
        stringBuilder2.append(VALID_ALPHA);
        stringBuilder2.append(DIGITS);
        stringBuilder2.append("]*");
        VALID_PHONE_NUMBER = stringBuilder2.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(",;");
        stringBuilder3.append("x\uff58#\uff03~\uff5e");
        EXTN_PATTERNS_FOR_PARSING = PhoneNumberUtil.createExtnPattern(stringBuilder3.toString());
        EXTN_PATTERNS_FOR_MATCHING = PhoneNumberUtil.createExtnPattern("x\uff58#\uff03~\uff5e");
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("(?:");
        stringBuilder4.append(EXTN_PATTERNS_FOR_PARSING);
        stringBuilder4.append(")$");
        EXTN_PATTERN = Pattern.compile((String)stringBuilder4.toString(), (int)66);
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append(VALID_PHONE_NUMBER);
        stringBuilder5.append("(?:");
        stringBuilder5.append(EXTN_PATTERNS_FOR_PARSING);
        stringBuilder5.append(")?");
        VALID_PHONE_NUMBER_PATTERN = Pattern.compile((String)stringBuilder5.toString(), (int)66);
        NON_DIGITS_PATTERN = Pattern.compile((String)"(\\D+)");
        FIRST_GROUP_PATTERN = Pattern.compile((String)"(\\$\\d)");
        NP_PATTERN = Pattern.compile((String)"\\$NP");
        FG_PATTERN = Pattern.compile((String)"\\$FG");
        CC_PATTERN = Pattern.compile((String)"\\$CC");
        FIRST_GROUP_ONLY_PREFIX_PATTERN = Pattern.compile((String)"\\(?\\$1\\)?");
        instance = null;
    }

    PhoneNumberUtil(MetadataSource metadataSource, Map<Integer, List<String>> map) {
        this.metadataSource = metadataSource;
        this.countryCallingCodeToRegionCodeMap = map;
        for (Map.Entry entry : map.entrySet()) {
            List list = (List)entry.getValue();
            if (list.size() == 1 && REGION_CODE_FOR_NON_GEO_ENTITY.equals(list.get(0))) {
                this.countryCodesForNonGeographicalRegion.add(entry.getKey());
                continue;
            }
            this.supportedRegions.addAll((Collection)list);
        }
        if (this.supportedRegions.remove((Object)REGION_CODE_FOR_NON_GEO_ENTITY)) {
            logger.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.nanpaRegions.addAll((Collection)map.get((Object)1));
    }

    private void buildNationalNumberForParsing(String string2, StringBuilder stringBuilder) {
        int n = string2.indexOf(RFC3966_PHONE_CONTEXT);
        if (n > 0) {
            int n2;
            int n3 = n + 15;
            if (string2.charAt(n3) == '+') {
                int n4 = string2.indexOf(59, n3);
                if (n4 > 0) {
                    stringBuilder.append(string2.substring(n3, n4));
                } else {
                    stringBuilder.append(string2.substring(n3));
                }
            }
            int n5 = (n2 = string2.indexOf(RFC3966_PREFIX)) >= 0 ? n2 + 4 : 0;
            stringBuilder.append(string2.substring(n5, n));
        } else {
            stringBuilder.append(PhoneNumberUtil.extractPossibleNumber(string2));
        }
        int n6 = stringBuilder.indexOf(RFC3966_ISDN_SUBADDRESS);
        if (n6 > 0) {
            stringBuilder.delete(n6, stringBuilder.length());
        }
    }

    private boolean checkRegionForParsing(String string2, String string3) {
        return this.isValidRegionCode(string3) || string2 != null && string2.length() != 0 && PLUS_CHARS_PATTERN.matcher((CharSequence)string2).lookingAt();
    }

    public static String convertAlphaCharactersInNumber(String string2) {
        return PhoneNumberUtil.normalizeHelper(string2, ALPHA_PHONE_MAPPINGS, false);
    }

    private static String createExtnPattern(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(";ext=(\\p{Nd}{1,7})|[ \u00a0\\t,]*(?:e?xt(?:ensi(?:o\u0301?|\u00f3))?n?|\uff45?\uff58\uff54\uff4e?|[");
        stringBuilder.append(string2);
        stringBuilder.append("]|int|anexo|\uff49\uff4e\uff54)[:\\.\uff0e]?[ \u00a0\\t,-]*");
        stringBuilder.append(CAPTURING_EXTN_DIGITS);
        stringBuilder.append("#?|[- ]+(");
        stringBuilder.append(DIGITS);
        stringBuilder.append("{1,5})#");
        return stringBuilder.toString();
    }

    public static PhoneNumberUtil createInstance(MetadataLoader metadataLoader) {
        if (metadataLoader != null) {
            return PhoneNumberUtil.createInstance((MetadataSource)new MultiFileMetadataSourceImpl(metadataLoader));
        }
        throw new IllegalArgumentException("metadataLoader could not be null.");
    }

    private static PhoneNumberUtil createInstance(MetadataSource metadataSource) {
        if (metadataSource != null) {
            return new PhoneNumberUtil(metadataSource, CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap());
        }
        throw new IllegalArgumentException("metadataSource could not be null.");
    }

    static String extractPossibleNumber(String string2) {
        Matcher matcher = VALID_START_CHAR_PATTERN.matcher((CharSequence)string2);
        if (matcher.find()) {
            Matcher matcher2;
            String string3 = string2.substring(matcher.start());
            Matcher matcher3 = UNWANTED_END_CHAR_PATTERN.matcher((CharSequence)string3);
            if (matcher3.find()) {
                string3 = string3.substring(0, matcher3.start());
                Logger logger = PhoneNumberUtil.logger;
                Level level = Level.FINER;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Stripped trailing characters: ");
                stringBuilder.append(string3);
                logger.log(level, stringBuilder.toString());
            }
            if ((matcher2 = SECOND_NUMBER_START_PATTERN.matcher((CharSequence)string3)).find()) {
                string3 = string3.substring(0, matcher2.start());
            }
            return string3;
        }
        return "";
    }

    private String formatNsn(String string2, Phonemetadata.PhoneMetadata phoneMetadata, PhoneNumberFormat phoneNumberFormat) {
        return this.formatNsn(string2, phoneMetadata, phoneNumberFormat, null);
    }

    private String formatNsn(String string2, Phonemetadata.PhoneMetadata phoneMetadata, PhoneNumberFormat phoneNumberFormat, String string3) {
        List<Phonemetadata.NumberFormat> list = phoneMetadata.intlNumberFormats().size() != 0 && phoneNumberFormat != PhoneNumberFormat.NATIONAL ? phoneMetadata.intlNumberFormats() : phoneMetadata.numberFormats();
        Phonemetadata.NumberFormat numberFormat = this.chooseFormattingPatternForNumber(list, string2);
        if (numberFormat == null) {
            return string2;
        }
        return this.formatNsnUsingPattern(string2, numberFormat, phoneNumberFormat, string3);
    }

    private String formatNsnUsingPattern(String string2, Phonemetadata.NumberFormat numberFormat, PhoneNumberFormat phoneNumberFormat, String string3) {
        String string4;
        String string5 = numberFormat.getFormat();
        Matcher matcher = this.regexCache.getPatternForRegex(numberFormat.getPattern()).matcher((CharSequence)string2);
        if (phoneNumberFormat == PhoneNumberFormat.NATIONAL && string3 != null && string3.length() > 0 && numberFormat.getDomesticCarrierCodeFormattingRule().length() > 0) {
            String string6 = numberFormat.getDomesticCarrierCodeFormattingRule();
            String string7 = CC_PATTERN.matcher((CharSequence)string6).replaceFirst(string3);
            string4 = matcher.replaceAll(FIRST_GROUP_PATTERN.matcher((CharSequence)string5).replaceFirst(string7));
        } else {
            String string8 = numberFormat.getNationalPrefixFormattingRule();
            string4 = phoneNumberFormat == PhoneNumberFormat.NATIONAL && string8 != null && string8.length() > 0 ? matcher.replaceAll(FIRST_GROUP_PATTERN.matcher((CharSequence)string5).replaceFirst(string8)) : matcher.replaceAll(string5);
        }
        if (phoneNumberFormat == PhoneNumberFormat.RFC3966) {
            Matcher matcher2 = SEPARATOR_PATTERN.matcher((CharSequence)string4);
            if (matcher2.lookingAt()) {
                string4 = matcher2.replaceFirst("");
            }
            string4 = matcher2.reset((CharSequence)string4).replaceAll("-");
        }
        return string4;
    }

    static boolean formattingRuleHasFirstGroupOnly(String string2) {
        return string2.length() == 0 || FIRST_GROUP_ONLY_PREFIX_PATTERN.matcher((CharSequence)string2).matches();
        {
        }
    }

    private int getCountryCodeForValidRegion(String string2) {
        Phonemetadata.PhoneMetadata phoneMetadata = this.getMetadataForRegion(string2);
        if (phoneMetadata != null) {
            return phoneMetadata.getCountryCode();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid region code: ");
        stringBuilder.append(string2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static String getCountryMobileToken(int n) {
        if (MOBILE_TOKEN_MAPPINGS.containsKey((Object)n)) {
            return (String)MOBILE_TOKEN_MAPPINGS.get((Object)n);
        }
        return "";
    }

    public static PhoneNumberUtil getInstance() {
        Class<PhoneNumberUtil> class_ = PhoneNumberUtil.class;
        synchronized (PhoneNumberUtil.class) {
            if (instance == null) {
                PhoneNumberUtil.setInstance(PhoneNumberUtil.createInstance(MetadataManager.DEFAULT_METADATA_LOADER));
            }
            PhoneNumberUtil phoneNumberUtil = instance;
            // ** MonitorExit[var2] (shouldn't be in output)
            return phoneNumberUtil;
        }
    }

    private Phonemetadata.PhoneMetadata getMetadataForRegionOrCallingCode(int n, String string2) {
        if (REGION_CODE_FOR_NON_GEO_ENTITY.equals((Object)string2)) {
            return this.getMetadataForNonGeographicalRegion(n);
        }
        return this.getMetadataForRegion(string2);
    }

    private PhoneNumberType getNumberTypeHelper(String string2, Phonemetadata.PhoneMetadata phoneMetadata) {
        if (!this.isNumberMatchingDesc(string2, phoneMetadata.getGeneralDesc())) {
            return PhoneNumberType.UNKNOWN;
        }
        if (this.isNumberMatchingDesc(string2, phoneMetadata.getPremiumRate())) {
            return PhoneNumberType.PREMIUM_RATE;
        }
        if (this.isNumberMatchingDesc(string2, phoneMetadata.getTollFree())) {
            return PhoneNumberType.TOLL_FREE;
        }
        if (this.isNumberMatchingDesc(string2, phoneMetadata.getSharedCost())) {
            return PhoneNumberType.SHARED_COST;
        }
        if (this.isNumberMatchingDesc(string2, phoneMetadata.getVoip())) {
            return PhoneNumberType.VOIP;
        }
        if (this.isNumberMatchingDesc(string2, phoneMetadata.getPersonalNumber())) {
            return PhoneNumberType.PERSONAL_NUMBER;
        }
        if (this.isNumberMatchingDesc(string2, phoneMetadata.getPager())) {
            return PhoneNumberType.PAGER;
        }
        if (this.isNumberMatchingDesc(string2, phoneMetadata.getUan())) {
            return PhoneNumberType.UAN;
        }
        if (this.isNumberMatchingDesc(string2, phoneMetadata.getVoicemail())) {
            return PhoneNumberType.VOICEMAIL;
        }
        if (this.isNumberMatchingDesc(string2, phoneMetadata.getFixedLine())) {
            if (phoneMetadata.isSameMobileAndFixedLinePattern()) {
                return PhoneNumberType.FIXED_LINE_OR_MOBILE;
            }
            if (this.isNumberMatchingDesc(string2, phoneMetadata.getMobile())) {
                return PhoneNumberType.FIXED_LINE_OR_MOBILE;
            }
            return PhoneNumberType.FIXED_LINE;
        }
        if (!phoneMetadata.isSameMobileAndFixedLinePattern() && this.isNumberMatchingDesc(string2, phoneMetadata.getMobile())) {
            return PhoneNumberType.MOBILE;
        }
        return PhoneNumberType.UNKNOWN;
    }

    private String getRegionCodeForNumberFromRegionList(Phonenumber.PhoneNumber phoneNumber, List<String> list) {
        String string2 = this.getNationalSignificantNumber(phoneNumber);
        for (String string3 : list) {
            Phonemetadata.PhoneMetadata phoneMetadata = this.getMetadataForRegion(string3);
            if (!(phoneMetadata.hasLeadingDigits() ? this.regexCache.getPatternForRegex(phoneMetadata.getLeadingDigits()).matcher((CharSequence)string2).lookingAt() : this.getNumberTypeHelper(string2, phoneMetadata) != PhoneNumberType.UNKNOWN)) continue;
            return string3;
        }
        return null;
    }

    private boolean hasFormattingPatternForNumber(Phonenumber.PhoneNumber phoneNumber) {
        int n = phoneNumber.getCountryCode();
        Phonemetadata.PhoneMetadata phoneMetadata = this.getMetadataForRegionOrCallingCode(n, this.getRegionCodeForCountryCode(n));
        if (phoneMetadata == null) {
            return false;
        }
        String string2 = this.getNationalSignificantNumber(phoneNumber);
        Phonemetadata.NumberFormat numberFormat = this.chooseFormattingPatternForNumber(phoneMetadata.numberFormats(), string2);
        boolean bl = false;
        if (numberFormat != null) {
            bl = true;
        }
        return bl;
    }

    private boolean hasUnexpectedItalianLeadingZero(Phonenumber.PhoneNumber phoneNumber) {
        return phoneNumber.isItalianLeadingZero() && !this.isLeadingZeroPossible(phoneNumber.getCountryCode());
    }

    private boolean hasValidCountryCallingCode(int n) {
        return this.countryCallingCodeToRegionCodeMap.containsKey((Object)n);
    }

    private boolean isNationalNumberSuffixOfTheOther(Phonenumber.PhoneNumber phoneNumber, Phonenumber.PhoneNumber phoneNumber2) {
        String string2;
        String string3 = String.valueOf((long)phoneNumber.getNationalNumber());
        return string3.endsWith(string2 = String.valueOf((long)phoneNumber2.getNationalNumber())) || string2.endsWith(string3);
        {
        }
    }

    private boolean isValidRegionCode(String string2) {
        return string2 != null && this.supportedRegions.contains((Object)string2);
    }

    static boolean isViablePhoneNumber(String string2) {
        if (string2.length() < 2) {
            return false;
        }
        return VALID_PHONE_NUMBER_PATTERN.matcher((CharSequence)string2).matches();
    }

    private void maybeAppendFormattedExtension(Phonenumber.PhoneNumber phoneNumber, Phonemetadata.PhoneMetadata phoneMetadata, PhoneNumberFormat phoneNumberFormat, StringBuilder stringBuilder) {
        if (phoneNumber.hasExtension() && phoneNumber.getExtension().length() > 0) {
            if (phoneNumberFormat == PhoneNumberFormat.RFC3966) {
                stringBuilder.append(RFC3966_EXTN_PREFIX);
                stringBuilder.append(phoneNumber.getExtension());
                return;
            }
            if (phoneMetadata.hasPreferredExtnPrefix()) {
                stringBuilder.append(phoneMetadata.getPreferredExtnPrefix());
                stringBuilder.append(phoneNumber.getExtension());
                return;
            }
            stringBuilder.append(DEFAULT_EXTN_PREFIX);
            stringBuilder.append(phoneNumber.getExtension());
        }
    }

    static String normalize(String string2) {
        if (VALID_ALPHA_PHONE_PATTERN.matcher((CharSequence)string2).matches()) {
            return PhoneNumberUtil.normalizeHelper(string2, ALPHA_PHONE_MAPPINGS, true);
        }
        return PhoneNumberUtil.normalizeDigitsOnly(string2);
    }

    static void normalize(StringBuilder stringBuilder) {
        String string2 = PhoneNumberUtil.normalize(stringBuilder.toString());
        stringBuilder.replace(0, stringBuilder.length(), string2);
    }

    public static String normalizeDiallableCharsOnly(String string2) {
        return PhoneNumberUtil.normalizeHelper(string2, DIALLABLE_CHAR_MAPPINGS, true);
    }

    static StringBuilder normalizeDigits(String string2, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder(string2.length());
        for (char c : string2.toCharArray()) {
            int n = Character.digit((char)c, (int)10);
            if (n != -1) {
                stringBuilder.append(n);
                continue;
            }
            if (!bl) continue;
            stringBuilder.append(c);
        }
        return stringBuilder;
    }

    public static String normalizeDigitsOnly(String string2) {
        return PhoneNumberUtil.normalizeDigits(string2, false).toString();
    }

    private static String normalizeHelper(String string2, Map<Character, Character> map, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder(string2.length());
        for (int i = 0; i < string2.length(); ++i) {
            char c = string2.charAt(i);
            Character c2 = (Character)map.get((Object)Character.valueOf((char)Character.toUpperCase((char)c)));
            if (c2 != null) {
                stringBuilder.append((Object)c2);
                continue;
            }
            if (bl) continue;
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private void parseHelper(String string2, String string3, boolean bl, boolean bl2, Phonenumber.PhoneNumber phoneNumber) throws NumberParseException {
        if (string2 != null) {
            if (string2.length() <= 250) {
                StringBuilder stringBuilder = new StringBuilder();
                this.buildNationalNumberForParsing(string2, stringBuilder);
                if (PhoneNumberUtil.isViablePhoneNumber(stringBuilder.toString())) {
                    NumberParseException numberParseException2;
                    block20 : {
                        block21 : {
                            int n;
                            String string4;
                            if (bl2 && !this.checkRegionForParsing(stringBuilder.toString(), string3)) {
                                throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
                            }
                            if (bl) {
                                phoneNumber.setRawInput(string2);
                            }
                            if ((string4 = this.maybeStripExtension(stringBuilder)).length() > 0) {
                                phoneNumber.setExtension(string4);
                            }
                            Phonemetadata.PhoneMetadata phoneMetadata = this.getMetadataForRegion(string3);
                            StringBuilder stringBuilder2 = new StringBuilder();
                            try {
                                n = this.maybeExtractCountryCode(stringBuilder.toString(), phoneMetadata, stringBuilder2, bl, phoneNumber);
                            }
                            catch (NumberParseException numberParseException2) {
                                Matcher matcher = PLUS_CHARS_PATTERN.matcher((CharSequence)stringBuilder.toString());
                                if (numberParseException2.getErrorType() != NumberParseException.ErrorType.INVALID_COUNTRY_CODE || !matcher.lookingAt()) break block20;
                                n = this.maybeExtractCountryCode(stringBuilder.substring(matcher.end()), phoneMetadata, stringBuilder2, bl, phoneNumber);
                                if (n == 0) break block21;
                            }
                            if (n != 0) {
                                String string5 = this.getRegionCodeForCountryCode(n);
                                if (!string5.equals((Object)string3)) {
                                    phoneMetadata = this.getMetadataForRegionOrCallingCode(n, string5);
                                }
                            } else {
                                PhoneNumberUtil.normalize(stringBuilder);
                                stringBuilder2.append((CharSequence)stringBuilder);
                                if (string3 != null) {
                                    phoneNumber.setCountryCode(phoneMetadata.getCountryCode());
                                } else if (bl) {
                                    phoneNumber.clearCountryCodeSource();
                                }
                            }
                            if (stringBuilder2.length() >= 2) {
                                int n2;
                                if (phoneMetadata != null) {
                                    StringBuilder stringBuilder3 = new StringBuilder();
                                    StringBuilder stringBuilder4 = new StringBuilder((CharSequence)stringBuilder2);
                                    this.maybeStripNationalPrefixAndCarrierCode(stringBuilder4, phoneMetadata, stringBuilder3);
                                    if (this.testNumberLength(stringBuilder4.toString(), phoneMetadata.getGeneralDesc()) != ValidationResult.TOO_SHORT) {
                                        if (bl && stringBuilder3.length() > 0) {
                                            phoneNumber.setPreferredDomesticCarrierCode(stringBuilder3.toString());
                                        }
                                        stringBuilder2 = stringBuilder4;
                                    }
                                }
                                if ((n2 = stringBuilder2.length()) >= 2) {
                                    if (n2 <= 17) {
                                        PhoneNumberUtil.setItalianLeadingZerosForPhoneNumber(stringBuilder2.toString(), phoneNumber);
                                        phoneNumber.setNationalNumber(Long.parseLong((String)stringBuilder2.toString()));
                                        return;
                                    }
                                    throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied is too long to be a phone number.");
                                }
                                throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                            }
                            throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                        }
                        throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
                    }
                    throw new NumberParseException(numberParseException2.getErrorType(), numberParseException2.getMessage());
                }
                throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
            }
            throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied was too long to parse.");
        }
        throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The phone number supplied was null.");
    }

    private boolean parsePrefixAsIdd(Pattern pattern, StringBuilder stringBuilder) {
        Matcher matcher = pattern.matcher((CharSequence)stringBuilder);
        if (matcher.lookingAt()) {
            int n = matcher.end();
            Matcher matcher2 = CAPTURING_DIGIT_PATTERN.matcher((CharSequence)stringBuilder.substring(n));
            if (matcher2.find() && PhoneNumberUtil.normalizeDigitsOnly(matcher2.group(1)).equals((Object)"0")) {
                return false;
            }
            stringBuilder.delete(0, n);
            return true;
        }
        return false;
    }

    private void prefixNumberWithCountryCallingCode(int n, PhoneNumberFormat phoneNumberFormat, StringBuilder stringBuilder) {
        int n2 = 2.$SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat[phoneNumberFormat.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    return;
                }
                stringBuilder.insert(0, "-").insert(0, n).insert(0, '+').insert(0, RFC3966_PREFIX);
                return;
            }
            stringBuilder.insert(0, " ").insert(0, n).insert(0, '+');
            return;
        }
        stringBuilder.insert(0, n).insert(0, '+');
    }

    /*
     * Exception decompiling
     */
    private boolean rawInputContainsNationalPrefix(String var1, String var2, String var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl20.1 : ICONST_0 : trying to set 0 previously set to 1
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

    static void setInstance(PhoneNumberUtil phoneNumberUtil) {
        Class<PhoneNumberUtil> class_ = PhoneNumberUtil.class;
        synchronized (PhoneNumberUtil.class) {
            instance = phoneNumberUtil;
            // ** MonitorExit[var2_1] (shouldn't be in output)
            return;
        }
    }

    static void setItalianLeadingZerosForPhoneNumber(String string2, Phonenumber.PhoneNumber phoneNumber) {
        if (string2.length() > 1 && string2.charAt(0) == '0') {
            int n;
            phoneNumber.setItalianLeadingZero(true);
            for (n = 1; n < string2.length() - 1 && string2.charAt(n) == '0'; ++n) {
            }
            if (n != 1) {
                phoneNumber.setNumberOfLeadingZeros(n);
            }
        }
    }

    private ValidationResult testNumberLength(String string2, Phonemetadata.PhoneNumberDesc phoneNumberDesc) {
        int n;
        List<Integer> list = phoneNumberDesc.getPossibleLengthList();
        List<Integer> list2 = phoneNumberDesc.getPossibleLengthLocalOnlyList();
        if (list2.contains((Object)(n = string2.length()))) {
            return ValidationResult.IS_POSSIBLE;
        }
        int n2 = (Integer)list.get(0);
        if (n2 == n) {
            return ValidationResult.IS_POSSIBLE;
        }
        if (n2 > n) {
            return ValidationResult.TOO_SHORT;
        }
        if ((Integer)list.get(list.size() - 1) < n) {
            return ValidationResult.TOO_LONG;
        }
        if (list.subList(1, list.size()).contains((Object)n)) {
            return ValidationResult.IS_POSSIBLE;
        }
        return ValidationResult.TOO_LONG;
    }

    boolean canBeInternationallyDialled(Phonenumber.PhoneNumber phoneNumber) {
        Phonemetadata.PhoneMetadata phoneMetadata = this.getMetadataForRegion(this.getRegionCodeForNumber(phoneNumber));
        if (phoneMetadata == null) {
            return true;
        }
        return true ^ this.isNumberMatchingDesc(this.getNationalSignificantNumber(phoneNumber), phoneMetadata.getNoInternationalDialling());
    }

    Phonemetadata.NumberFormat chooseFormattingPatternForNumber(List<Phonemetadata.NumberFormat> list, String string2) {
        for (Phonemetadata.NumberFormat numberFormat : list) {
            int n = numberFormat.leadingDigitsPatternSize();
            if (n != 0 && !this.regexCache.getPatternForRegex(numberFormat.getLeadingDigitsPattern(n - 1)).matcher((CharSequence)string2).lookingAt() || !this.regexCache.getPatternForRegex(numberFormat.getPattern()).matcher((CharSequence)string2).matches()) continue;
            return numberFormat;
        }
        return null;
    }

    int extractCountryCode(StringBuilder stringBuilder, StringBuilder stringBuilder2) {
        if (stringBuilder.length() != 0) {
            if (stringBuilder.charAt(0) == '0') {
                return 0;
            }
            int n = stringBuilder.length();
            for (int i = 1; i <= 3 && i <= n; ++i) {
                int n2 = Integer.parseInt((String)stringBuilder.substring(0, i));
                if (!this.countryCallingCodeToRegionCodeMap.containsKey((Object)n2)) continue;
                stringBuilder2.append(stringBuilder.substring(i));
                return n2;
            }
        }
        return 0;
    }

    public Iterable<PhoneNumberMatch> findNumbers(CharSequence charSequence, String string2) {
        return this.findNumbers(charSequence, string2, Leniency.VALID, Long.MAX_VALUE);
    }

    public Iterable<PhoneNumberMatch> findNumbers(final CharSequence charSequence, final String string2, final Leniency leniency, final long l) {
        Iterable<PhoneNumberMatch> iterable = new Iterable<PhoneNumberMatch>(){

            public Iterator<PhoneNumberMatch> iterator() {
                PhoneNumberMatcher phoneNumberMatcher = new PhoneNumberMatcher(PhoneNumberUtil.this, charSequence, string2, leniency, l);
                return phoneNumberMatcher;
            }
        };
        return iterable;
    }

    public String format(Phonenumber.PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat) {
        String string2;
        if (phoneNumber.getNationalNumber() == 0L && phoneNumber.hasRawInput() && (string2 = phoneNumber.getRawInput()).length() > 0) {
            return string2;
        }
        StringBuilder stringBuilder = new StringBuilder(20);
        this.format(phoneNumber, phoneNumberFormat, stringBuilder);
        return stringBuilder.toString();
    }

    public void format(Phonenumber.PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat, StringBuilder stringBuilder) {
        stringBuilder.setLength(0);
        int n = phoneNumber.getCountryCode();
        String string2 = this.getNationalSignificantNumber(phoneNumber);
        if (phoneNumberFormat == PhoneNumberFormat.E164) {
            stringBuilder.append(string2);
            this.prefixNumberWithCountryCallingCode(n, PhoneNumberFormat.E164, stringBuilder);
            return;
        }
        if (!this.hasValidCountryCallingCode(n)) {
            stringBuilder.append(string2);
            return;
        }
        Phonemetadata.PhoneMetadata phoneMetadata = this.getMetadataForRegionOrCallingCode(n, this.getRegionCodeForCountryCode(n));
        stringBuilder.append(this.formatNsn(string2, phoneMetadata, phoneNumberFormat));
        this.maybeAppendFormattedExtension(phoneNumber, phoneMetadata, phoneNumberFormat, stringBuilder);
        this.prefixNumberWithCountryCallingCode(n, phoneNumberFormat, stringBuilder);
    }

    public String formatByPattern(Phonenumber.PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat, List<Phonemetadata.NumberFormat> list) {
        int n = phoneNumber.getCountryCode();
        String string2 = this.getNationalSignificantNumber(phoneNumber);
        if (!this.hasValidCountryCallingCode(n)) {
            return string2;
        }
        Phonemetadata.PhoneMetadata phoneMetadata = this.getMetadataForRegionOrCallingCode(n, this.getRegionCodeForCountryCode(n));
        StringBuilder stringBuilder = new StringBuilder(20);
        Phonemetadata.NumberFormat numberFormat = this.chooseFormattingPatternForNumber(list, string2);
        if (numberFormat == null) {
            stringBuilder.append(string2);
        } else {
            Phonemetadata.NumberFormat.Builder builder = Phonemetadata.NumberFormat.newBuilder();
            builder.mergeFrom(numberFormat);
            String string3 = numberFormat.getNationalPrefixFormattingRule();
            if (string3.length() > 0) {
                String string4 = phoneMetadata.getNationalPrefix();
                if (string4.length() > 0) {
                    String string5 = NP_PATTERN.matcher((CharSequence)string3).replaceFirst(string4);
                    builder.setNationalPrefixFormattingRule(FG_PATTERN.matcher((CharSequence)string5).replaceFirst("\\$1"));
                } else {
                    builder.clearNationalPrefixFormattingRule();
                }
            }
            stringBuilder.append(this.formatNsnUsingPattern(string2, (Phonemetadata.NumberFormat)builder, phoneNumberFormat));
        }
        this.maybeAppendFormattedExtension(phoneNumber, phoneMetadata, phoneNumberFormat, stringBuilder);
        this.prefixNumberWithCountryCallingCode(n, phoneNumberFormat, stringBuilder);
        return stringBuilder.toString();
    }

    public String formatInOriginalFormat(Phonenumber.PhoneNumber phoneNumber, String string2) {
        String string3;
        if (phoneNumber.hasRawInput() && (this.hasUnexpectedItalianLeadingZero(phoneNumber) || !this.hasFormattingPatternForNumber(phoneNumber))) {
            return phoneNumber.getRawInput();
        }
        if (!phoneNumber.hasCountryCodeSource()) {
            return this.format(phoneNumber, PhoneNumberFormat.NATIONAL);
        }
        int n = 2.$SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource[phoneNumber.getCountryCodeSource().ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    String string4 = this.getRegionCodeForCountryCode(phoneNumber.getCountryCode());
                    String string5 = this.getNddPrefixForRegion(string4, true);
                    string3 = this.format(phoneNumber, PhoneNumberFormat.NATIONAL);
                    if (string5 != null && string5.length() != 0 && !this.rawInputContainsNationalPrefix(phoneNumber.getRawInput(), string5, string4)) {
                        String string6;
                        int n2;
                        Phonemetadata.PhoneMetadata phoneMetadata = this.getMetadataForRegion(string4);
                        String string7 = this.getNationalSignificantNumber(phoneNumber);
                        Phonemetadata.NumberFormat numberFormat = this.chooseFormattingPatternForNumber(phoneMetadata.numberFormats(), string7);
                        if (numberFormat != null && (n2 = (string6 = numberFormat.getNationalPrefixFormattingRule()).indexOf("$1")) > 0 && PhoneNumberUtil.normalizeDigitsOnly(string6.substring(0, n2)).length() != 0) {
                            Phonemetadata.NumberFormat.Builder builder = Phonemetadata.NumberFormat.newBuilder();
                            builder.mergeFrom(numberFormat);
                            builder.clearNationalPrefixFormattingRule();
                            ArrayList arrayList = new ArrayList(1);
                            arrayList.add((Object)builder);
                            string3 = this.formatByPattern(phoneNumber, PhoneNumberFormat.NATIONAL, (List<Phonemetadata.NumberFormat>)arrayList);
                        }
                    }
                } else {
                    string3 = this.format(phoneNumber, PhoneNumberFormat.INTERNATIONAL).substring(1);
                }
            } else {
                string3 = this.formatOutOfCountryCallingNumber(phoneNumber, string2);
            }
        } else {
            string3 = this.format(phoneNumber, PhoneNumberFormat.INTERNATIONAL);
        }
        String string8 = phoneNumber.getRawInput();
        if (string3 != null && string8.length() > 0 && !PhoneNumberUtil.normalizeDiallableCharsOnly(string3).equals((Object)PhoneNumberUtil.normalizeDiallableCharsOnly(string8))) {
            string3 = string8;
        }
        return string3;
    }

    public String formatNationalNumberWithCarrierCode(Phonenumber.PhoneNumber phoneNumber, String string2) {
        int n = phoneNumber.getCountryCode();
        String string3 = this.getNationalSignificantNumber(phoneNumber);
        if (!this.hasValidCountryCallingCode(n)) {
            return string3;
        }
        Phonemetadata.PhoneMetadata phoneMetadata = this.getMetadataForRegionOrCallingCode(n, this.getRegionCodeForCountryCode(n));
        StringBuilder stringBuilder = new StringBuilder(20);
        stringBuilder.append(this.formatNsn(string3, phoneMetadata, PhoneNumberFormat.NATIONAL, string2));
        this.maybeAppendFormattedExtension(phoneNumber, phoneMetadata, PhoneNumberFormat.NATIONAL, stringBuilder);
        this.prefixNumberWithCountryCallingCode(n, PhoneNumberFormat.NATIONAL, stringBuilder);
        return stringBuilder.toString();
    }

    public String formatNationalNumberWithPreferredCarrierCode(Phonenumber.PhoneNumber phoneNumber, String string2) {
        if (phoneNumber.getPreferredDomesticCarrierCode().length() > 0) {
            string2 = phoneNumber.getPreferredDomesticCarrierCode();
        }
        return this.formatNationalNumberWithCarrierCode(phoneNumber, string2);
    }

    String formatNsnUsingPattern(String string2, Phonemetadata.NumberFormat numberFormat, PhoneNumberFormat phoneNumberFormat) {
        return this.formatNsnUsingPattern(string2, numberFormat, phoneNumberFormat, null);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public String formatNumberForMobileDialing(Phonenumber.PhoneNumber var1_1, String var2_2, boolean var3_3) {
        block17 : {
            block13 : {
                block16 : {
                    block15 : {
                        block14 : {
                            var4_4 = var1_1.getCountryCode();
                            var5_5 = this.hasValidCountryCallingCode(var4_4);
                            var6_6 = "";
                            if (!var5_5) {
                                if (var1_1.hasRawInput() == false) return var6_6;
                                return var1_1.getRawInput();
                            }
                            var7_7 = new Phonenumber.PhoneNumber().mergeFrom(var1_1).clearExtension();
                            var8_8 = this.getRegionCodeForCountryCode(var4_4);
                            var9_9 = this.getNumberType(var7_7);
                            var10_10 = var9_9 != PhoneNumberType.UNKNOWN;
                            if (!var2_2.equals((Object)var8_8)) break block13;
                            if (var9_9 == PhoneNumberType.FIXED_LINE || var9_9 == PhoneNumberType.MOBILE) break block14;
                            var18_11 = PhoneNumberType.FIXED_LINE_OR_MOBILE;
                            var11_12 = false;
                            if (var9_9 != var18_11) break block15;
                        }
                        var11_12 = true;
                    }
                    if (!var8_8.equals((Object)"CO") || var9_9 != PhoneNumberType.FIXED_LINE) break block16;
                    var12_13 = this.formatNationalNumberWithCarrierCode(var7_7, "3");
                    ** GOTO lbl39
                }
                if (var8_8.equals((Object)"BR") && var11_12) {
                    if (var7_7.getPreferredDomesticCarrierCode().length() > 0) {
                        var6_6 = this.formatNationalNumberWithPreferredCarrierCode(var7_7, var6_6);
                    }
                } else {
                    if (var10_10 && var8_8.equals((Object)"HU")) {
                        var14_14 = new StringBuilder();
                        var14_14.append(this.getNddPrefixForRegion(var8_8, true));
                        var14_14.append(" ");
                        var14_14.append(this.format(var7_7, PhoneNumberFormat.NATIONAL));
                        var12_13 = var14_14.toString();
                    } else if (var4_4 == 1) {
                        var13_15 = this.getMetadataForRegion(var2_2);
                        var12_13 = this.canBeInternationallyDialled(var7_7) && this.testNumberLength(this.getNationalSignificantNumber(var7_7), var13_15.getGeneralDesc()) != ValidationResult.TOO_SHORT ? this.format(var7_7, PhoneNumberFormat.INTERNATIONAL) : this.format(var7_7, PhoneNumberFormat.NATIONAL);
                    } else {
                        var12_13 = (var8_8.equals((Object)"001") != false || (var8_8.equals((Object)"MX") != false || var8_8.equals((Object)"CL") != false) && var11_12 != false) && this.canBeInternationallyDialled(var7_7) != false ? this.format(var7_7, PhoneNumberFormat.INTERNATIONAL) : this.format(var7_7, PhoneNumberFormat.NATIONAL);
                    }
lbl39: // 4 sources:
                    var6_6 = var12_13;
                }
                break block17;
            }
            if (var10_10 && this.canBeInternationallyDialled(var7_7)) {
                if (var3_3 == false) return this.format(var7_7, PhoneNumberFormat.E164);
                return this.format(var7_7, PhoneNumberFormat.INTERNATIONAL);
            }
        }
        if (var3_3 == false) return PhoneNumberUtil.normalizeDiallableCharsOnly(var6_6);
        return var6_6;
    }

    public String formatOutOfCountryCallingNumber(Phonenumber.PhoneNumber phoneNumber, String string2) {
        Phonemetadata.PhoneMetadata phoneMetadata;
        String string3;
        if (!this.isValidRegionCode(string2)) {
            Logger logger = PhoneNumberUtil.logger;
            Level level = Level.WARNING;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Trying to format number from invalid region ");
            stringBuilder.append(string2);
            stringBuilder.append(". International formatting applied.");
            logger.log(level, stringBuilder.toString());
            return this.format(phoneNumber, PhoneNumberFormat.INTERNATIONAL);
        }
        int n = phoneNumber.getCountryCode();
        String string4 = this.getNationalSignificantNumber(phoneNumber);
        if (!this.hasValidCountryCallingCode(n)) {
            return string4;
        }
        if (n == 1) {
            if (this.isNANPACountry(string2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(n);
                stringBuilder.append(" ");
                stringBuilder.append(this.format(phoneNumber, PhoneNumberFormat.NATIONAL));
                return stringBuilder.toString();
            }
        } else if (n == this.getCountryCodeForValidRegion(string2)) {
            return this.format(phoneNumber, PhoneNumberFormat.NATIONAL);
        }
        if (!UNIQUE_INTERNATIONAL_PREFIX.matcher((CharSequence)(string3 = (phoneMetadata = this.getMetadataForRegion(string2)).getInternationalPrefix())).matches()) {
            string3 = phoneMetadata.hasPreferredInternationalPrefix() ? phoneMetadata.getPreferredInternationalPrefix() : "";
        }
        Phonemetadata.PhoneMetadata phoneMetadata2 = this.getMetadataForRegionOrCallingCode(n, this.getRegionCodeForCountryCode(n));
        StringBuilder stringBuilder = new StringBuilder(this.formatNsn(string4, phoneMetadata2, PhoneNumberFormat.INTERNATIONAL));
        this.maybeAppendFormattedExtension(phoneNumber, phoneMetadata2, PhoneNumberFormat.INTERNATIONAL, stringBuilder);
        if (string3.length() > 0) {
            stringBuilder.insert(0, " ").insert(0, n).insert(0, " ").insert(0, string3);
        } else {
            this.prefixNumberWithCountryCallingCode(n, PhoneNumberFormat.INTERNATIONAL, stringBuilder);
        }
        return stringBuilder.toString();
    }

    public String formatOutOfCountryKeepingAlphaChars(Phonenumber.PhoneNumber phoneNumber, String string2) {
        String string3;
        int n;
        String string4 = phoneNumber.getRawInput();
        if (string4.length() == 0) {
            return this.formatOutOfCountryCallingNumber(phoneNumber, string2);
        }
        int n2 = phoneNumber.getCountryCode();
        if (!this.hasValidCountryCallingCode(n2)) {
            return string4;
        }
        String string5 = PhoneNumberUtil.normalizeHelper(string4, ALL_PLUS_NUMBER_GROUPING_SYMBOLS, true);
        String string6 = this.getNationalSignificantNumber(phoneNumber);
        if (string6.length() > 3 && (n = string5.indexOf(string6.substring(0, 3))) != -1) {
            string5 = string5.substring(n);
        }
        Phonemetadata.PhoneMetadata phoneMetadata = this.getMetadataForRegion(string2);
        if (n2 == 1) {
            if (this.isNANPACountry(string2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(n2);
                stringBuilder.append(" ");
                stringBuilder.append(string5);
                return stringBuilder.toString();
            }
        } else if (phoneMetadata != null && n2 == this.getCountryCodeForValidRegion(string2)) {
            Phonemetadata.NumberFormat numberFormat = this.chooseFormattingPatternForNumber(phoneMetadata.numberFormats(), string6);
            if (numberFormat == null) {
                return string5;
            }
            Phonemetadata.NumberFormat.Builder builder = Phonemetadata.NumberFormat.newBuilder();
            builder.mergeFrom(numberFormat);
            builder.setPattern("(\\d+)(.*)");
            builder.setFormat("$1$2");
            return this.formatNsnUsingPattern(string5, (Phonemetadata.NumberFormat)builder, PhoneNumberFormat.NATIONAL);
        }
        if (phoneMetadata != null) {
            string3 = phoneMetadata.getInternationalPrefix();
            if (!UNIQUE_INTERNATIONAL_PREFIX.matcher((CharSequence)string3).matches()) {
                string3 = phoneMetadata.getPreferredInternationalPrefix();
            }
        } else {
            string3 = "";
        }
        StringBuilder stringBuilder = new StringBuilder(string5);
        this.maybeAppendFormattedExtension(phoneNumber, this.getMetadataForRegionOrCallingCode(n2, this.getRegionCodeForCountryCode(n2)), PhoneNumberFormat.INTERNATIONAL, stringBuilder);
        if (string3.length() > 0) {
            stringBuilder.insert(0, " ").insert(0, n2).insert(0, " ").insert(0, string3);
        } else {
            if (!this.isValidRegionCode(string2)) {
                Logger logger = PhoneNumberUtil.logger;
                Level level = Level.WARNING;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Trying to format number from invalid region ");
                stringBuilder2.append(string2);
                stringBuilder2.append(". International formatting applied.");
                logger.log(level, stringBuilder2.toString());
            }
            this.prefixNumberWithCountryCallingCode(n2, PhoneNumberFormat.INTERNATIONAL, stringBuilder);
        }
        return stringBuilder.toString();
    }

    public AsYouTypeFormatter getAsYouTypeFormatter(String string2) {
        return new AsYouTypeFormatter(string2);
    }

    public int getCountryCodeForRegion(String string2) {
        if (!this.isValidRegionCode(string2)) {
            Logger logger = PhoneNumberUtil.logger;
            Level level = Level.WARNING;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid or missing region code (");
            if (string2 == null) {
                string2 = "null";
            }
            stringBuilder.append(string2);
            stringBuilder.append(") provided.");
            logger.log(level, stringBuilder.toString());
            return 0;
        }
        return this.getCountryCodeForValidRegion(string2);
    }

    public Phonenumber.PhoneNumber getExampleNumber(String string2) {
        return this.getExampleNumberForType(string2, PhoneNumberType.FIXED_LINE);
    }

    public Phonenumber.PhoneNumber getExampleNumberForNonGeoEntity(int n) {
        Phonemetadata.PhoneMetadata phoneMetadata = this.getMetadataForNonGeographicalRegion(n);
        if (phoneMetadata != null) {
            Object[] arrobject = new Phonemetadata.PhoneNumberDesc[]{phoneMetadata.getMobile(), phoneMetadata.getTollFree(), phoneMetadata.getSharedCost(), phoneMetadata.getVoip(), phoneMetadata.getVoicemail(), phoneMetadata.getUan(), phoneMetadata.getPremiumRate()};
            for (Phonemetadata.PhoneNumberDesc phoneNumberDesc : Arrays.asList((Object[])arrobject)) {
                if (phoneNumberDesc == null) continue;
                try {
                    if (!phoneNumberDesc.hasExampleNumber()) continue;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("+");
                    stringBuilder.append(n);
                    stringBuilder.append(phoneNumberDesc.getExampleNumber());
                    Phonenumber.PhoneNumber phoneNumber = this.parse(stringBuilder.toString(), UNKNOWN_REGION);
                    return phoneNumber;
                }
                catch (NumberParseException numberParseException) {
                    logger.log(Level.SEVERE, numberParseException.toString());
                }
            }
        } else {
            Logger logger = PhoneNumberUtil.logger;
            Level level = Level.WARNING;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid or unknown country calling code provided: ");
            stringBuilder.append(n);
            logger.log(level, stringBuilder.toString());
        }
        return null;
    }

    public Phonenumber.PhoneNumber getExampleNumberForType(PhoneNumberType phoneNumberType) {
        Iterator iterator = this.getSupportedRegions().iterator();
        while (iterator.hasNext()) {
            Phonenumber.PhoneNumber phoneNumber = this.getExampleNumberForType((String)iterator.next(), phoneNumberType);
            if (phoneNumber == null) continue;
            return phoneNumber;
        }
        Iterator iterator2 = this.getSupportedGlobalNetworkCallingCodes().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            Phonemetadata.PhoneNumberDesc phoneNumberDesc = this.getNumberDescByType(this.getMetadataForNonGeographicalRegion(n), phoneNumberType);
            try {
                if (!phoneNumberDesc.hasExampleNumber()) continue;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("+");
                stringBuilder.append(n);
                stringBuilder.append(phoneNumberDesc.getExampleNumber());
                Phonenumber.PhoneNumber phoneNumber = this.parse(stringBuilder.toString(), UNKNOWN_REGION);
                return phoneNumber;
            }
            catch (NumberParseException numberParseException) {
                logger.log(Level.SEVERE, numberParseException.toString());
            }
        }
        return null;
    }

    public Phonenumber.PhoneNumber getExampleNumberForType(String string2, PhoneNumberType phoneNumberType) {
        if (!this.isValidRegionCode(string2)) {
            Logger logger = PhoneNumberUtil.logger;
            Level level = Level.WARNING;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid or unknown region code provided: ");
            stringBuilder.append(string2);
            logger.log(level, stringBuilder.toString());
            return null;
        }
        Phonemetadata.PhoneNumberDesc phoneNumberDesc = this.getNumberDescByType(this.getMetadataForRegion(string2), phoneNumberType);
        try {
            if (phoneNumberDesc.hasExampleNumber()) {
                Phonenumber.PhoneNumber phoneNumber = this.parse(phoneNumberDesc.getExampleNumber(), string2);
                return phoneNumber;
            }
        }
        catch (NumberParseException numberParseException) {
            logger.log(Level.SEVERE, numberParseException.toString());
        }
        return null;
    }

    /*
     * Exception decompiling
     */
    public Phonenumber.PhoneNumber getInvalidExampleNumber(String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl69.1 : IINC : trying to set 1 previously set to 0
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

    public int getLengthOfGeographicalAreaCode(Phonenumber.PhoneNumber phoneNumber) {
        Phonemetadata.PhoneMetadata phoneMetadata = this.getMetadataForRegion(this.getRegionCodeForNumber(phoneNumber));
        if (phoneMetadata == null) {
            return 0;
        }
        if (!phoneMetadata.hasNationalPrefix() && !phoneNumber.isItalianLeadingZero()) {
            return 0;
        }
        PhoneNumberType phoneNumberType = this.getNumberType(phoneNumber);
        int n = phoneNumber.getCountryCode();
        if (phoneNumberType == PhoneNumberType.MOBILE && GEO_MOBILE_COUNTRIES_WITHOUT_MOBILE_AREA_CODES.contains((Object)n)) {
            return 0;
        }
        if (!this.isNumberGeographical(phoneNumberType, n)) {
            return 0;
        }
        return this.getLengthOfNationalDestinationCode(phoneNumber);
    }

    public int getLengthOfNationalDestinationCode(Phonenumber.PhoneNumber phoneNumber) {
        Phonenumber.PhoneNumber phoneNumber2;
        if (phoneNumber.hasExtension()) {
            phoneNumber2 = new Phonenumber.PhoneNumber();
            phoneNumber2.mergeFrom(phoneNumber);
            phoneNumber2.clearExtension();
        } else {
            phoneNumber2 = phoneNumber;
        }
        String string2 = this.format(phoneNumber2, PhoneNumberFormat.INTERNATIONAL);
        String[] arrstring = NON_DIGITS_PATTERN.split((CharSequence)string2);
        if (arrstring.length <= 3) {
            return 0;
        }
        if (this.getNumberType(phoneNumber) == PhoneNumberType.MOBILE && !PhoneNumberUtil.getCountryMobileToken(phoneNumber.getCountryCode()).equals((Object)"")) {
            return arrstring[2].length() + arrstring[3].length();
        }
        return arrstring[2].length();
    }

    Phonemetadata.PhoneMetadata getMetadataForNonGeographicalRegion(int n) {
        if (!this.countryCallingCodeToRegionCodeMap.containsKey((Object)n)) {
            return null;
        }
        return this.metadataSource.getMetadataForNonGeographicalRegion(n);
    }

    Phonemetadata.PhoneMetadata getMetadataForRegion(String string2) {
        if (!this.isValidRegionCode(string2)) {
            return null;
        }
        return this.metadataSource.getMetadataForRegion(string2);
    }

    public String getNationalSignificantNumber(Phonenumber.PhoneNumber phoneNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        if (phoneNumber.isItalianLeadingZero()) {
            char[] arrc = new char[phoneNumber.getNumberOfLeadingZeros()];
            Arrays.fill((char[])arrc, (char)'0');
            stringBuilder.append(new String(arrc));
        }
        stringBuilder.append(phoneNumber.getNationalNumber());
        return stringBuilder.toString();
    }

    public String getNddPrefixForRegion(String string2, boolean bl) {
        Phonemetadata.PhoneMetadata phoneMetadata = this.getMetadataForRegion(string2);
        if (phoneMetadata == null) {
            Logger logger = PhoneNumberUtil.logger;
            Level level = Level.WARNING;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid or missing region code (");
            if (string2 == null) {
                string2 = "null";
            }
            stringBuilder.append(string2);
            stringBuilder.append(") provided.");
            logger.log(level, stringBuilder.toString());
            return null;
        }
        String string3 = phoneMetadata.getNationalPrefix();
        if (string3.length() == 0) {
            return null;
        }
        if (bl) {
            string3 = string3.replace((CharSequence)"~", (CharSequence)"");
        }
        return string3;
    }

    Phonemetadata.PhoneNumberDesc getNumberDescByType(Phonemetadata.PhoneMetadata phoneMetadata, PhoneNumberType phoneNumberType) {
        switch (2.$SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[phoneNumberType.ordinal()]) {
            default: {
                return phoneMetadata.getGeneralDesc();
            }
            case 11: {
                return phoneMetadata.getVoicemail();
            }
            case 10: {
                return phoneMetadata.getUan();
            }
            case 9: {
                return phoneMetadata.getPager();
            }
            case 8: {
                return phoneMetadata.getPersonalNumber();
            }
            case 7: {
                return phoneMetadata.getVoip();
            }
            case 6: {
                return phoneMetadata.getSharedCost();
            }
            case 4: 
            case 5: {
                return phoneMetadata.getFixedLine();
            }
            case 3: {
                return phoneMetadata.getMobile();
            }
            case 2: {
                return phoneMetadata.getTollFree();
            }
            case 1: 
        }
        return phoneMetadata.getPremiumRate();
    }

    public PhoneNumberType getNumberType(Phonenumber.PhoneNumber phoneNumber) {
        String string2 = this.getRegionCodeForNumber(phoneNumber);
        Phonemetadata.PhoneMetadata phoneMetadata = this.getMetadataForRegionOrCallingCode(phoneNumber.getCountryCode(), string2);
        if (phoneMetadata == null) {
            return PhoneNumberType.UNKNOWN;
        }
        return this.getNumberTypeHelper(this.getNationalSignificantNumber(phoneNumber), phoneMetadata);
    }

    public String getRegionCodeForCountryCode(int n) {
        List list = (List)this.countryCallingCodeToRegionCodeMap.get((Object)n);
        if (list == null) {
            return UNKNOWN_REGION;
        }
        return (String)list.get(0);
    }

    public String getRegionCodeForNumber(Phonenumber.PhoneNumber phoneNumber) {
        int n = phoneNumber.getCountryCode();
        List list = (List)this.countryCallingCodeToRegionCodeMap.get((Object)n);
        if (list == null) {
            String string2 = this.getNationalSignificantNumber(phoneNumber);
            Logger logger = PhoneNumberUtil.logger;
            Level level = Level.INFO;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Missing/invalid country_code (");
            stringBuilder.append(n);
            stringBuilder.append(") for number ");
            stringBuilder.append(string2);
            logger.log(level, stringBuilder.toString());
            return null;
        }
        if (list.size() == 1) {
            return (String)list.get(0);
        }
        return this.getRegionCodeForNumberFromRegionList(phoneNumber, (List<String>)list);
    }

    public List<String> getRegionCodesForCountryCode(int n) {
        List list = (List)this.countryCallingCodeToRegionCodeMap.get((Object)n);
        if (list == null) {
            list = new ArrayList(0);
        }
        return Collections.unmodifiableList((List)list);
    }

    public Set<Integer> getSupportedGlobalNetworkCallingCodes() {
        return Collections.unmodifiableSet(this.countryCodesForNonGeographicalRegion);
    }

    public Set<String> getSupportedRegions() {
        return Collections.unmodifiableSet(this.supportedRegions);
    }

    public boolean isAlphaNumber(String string2) {
        if (!PhoneNumberUtil.isViablePhoneNumber(string2)) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder(string2);
        this.maybeStripExtension(stringBuilder);
        return VALID_ALPHA_PHONE_PATTERN.matcher((CharSequence)stringBuilder).matches();
    }

    boolean isLeadingZeroPossible(int n) {
        Phonemetadata.PhoneMetadata phoneMetadata = this.getMetadataForRegionOrCallingCode(n, this.getRegionCodeForCountryCode(n));
        if (phoneMetadata == null) {
            return false;
        }
        return phoneMetadata.isLeadingZeroPossible();
    }

    public boolean isMobileNumberPortableRegion(String string2) {
        Phonemetadata.PhoneMetadata phoneMetadata = this.getMetadataForRegion(string2);
        if (phoneMetadata == null) {
            Logger logger = PhoneNumberUtil.logger;
            Level level = Level.WARNING;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid or unknown region code provided: ");
            stringBuilder.append(string2);
            logger.log(level, stringBuilder.toString());
            return false;
        }
        return phoneMetadata.isMobileNumberPortableRegion();
    }

    public boolean isNANPACountry(String string2) {
        return this.nanpaRegions.contains((Object)string2);
    }

    public boolean isNumberGeographical(PhoneNumberType phoneNumberType, int n) {
        return phoneNumberType == PhoneNumberType.FIXED_LINE || phoneNumberType == PhoneNumberType.FIXED_LINE_OR_MOBILE || GEO_MOBILE_COUNTRIES.contains((Object)n) && phoneNumberType == PhoneNumberType.MOBILE;
        {
        }
    }

    public boolean isNumberGeographical(Phonenumber.PhoneNumber phoneNumber) {
        return this.isNumberGeographical(this.getNumberType(phoneNumber), phoneNumber.getCountryCode());
    }

    public MatchType isNumberMatch(Phonenumber.PhoneNumber phoneNumber, Phonenumber.PhoneNumber phoneNumber2) {
        Phonenumber.PhoneNumber phoneNumber3 = new Phonenumber.PhoneNumber();
        phoneNumber3.mergeFrom(phoneNumber);
        Phonenumber.PhoneNumber phoneNumber4 = new Phonenumber.PhoneNumber();
        phoneNumber4.mergeFrom(phoneNumber2);
        phoneNumber3.clearRawInput();
        phoneNumber3.clearCountryCodeSource();
        phoneNumber3.clearPreferredDomesticCarrierCode();
        phoneNumber4.clearRawInput();
        phoneNumber4.clearCountryCodeSource();
        phoneNumber4.clearPreferredDomesticCarrierCode();
        if (phoneNumber3.hasExtension() && phoneNumber3.getExtension().length() == 0) {
            phoneNumber3.clearExtension();
        }
        if (phoneNumber4.hasExtension() && phoneNumber4.getExtension().length() == 0) {
            phoneNumber4.clearExtension();
        }
        if (phoneNumber3.hasExtension() && phoneNumber4.hasExtension() && !phoneNumber3.getExtension().equals((Object)phoneNumber4.getExtension())) {
            return MatchType.NO_MATCH;
        }
        int n = phoneNumber3.getCountryCode();
        int n2 = phoneNumber4.getCountryCode();
        if (n != 0 && n2 != 0) {
            if (phoneNumber3.exactlySameAs(phoneNumber4)) {
                return MatchType.EXACT_MATCH;
            }
            if (n == n2 && this.isNationalNumberSuffixOfTheOther(phoneNumber3, phoneNumber4)) {
                return MatchType.SHORT_NSN_MATCH;
            }
            return MatchType.NO_MATCH;
        }
        phoneNumber3.setCountryCode(n2);
        if (phoneNumber3.exactlySameAs(phoneNumber4)) {
            return MatchType.NSN_MATCH;
        }
        if (this.isNationalNumberSuffixOfTheOther(phoneNumber3, phoneNumber4)) {
            return MatchType.SHORT_NSN_MATCH;
        }
        return MatchType.NO_MATCH;
    }

    /*
     * Exception decompiling
     */
    public MatchType isNumberMatch(Phonenumber.PhoneNumber var1, String var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl56.1 : GETSTATIC : trying to set 0 previously set to 1
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

    /*
     * Exception decompiling
     */
    public MatchType isNumberMatch(String var1, String var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl60.1 : GETSTATIC : trying to set 0 previously set to 1
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

    boolean isNumberMatchingDesc(String string2, Phonemetadata.PhoneNumberDesc phoneNumberDesc) {
        int n = string2.length();
        List<Integer> list = phoneNumberDesc.getPossibleLengthList();
        if (list.size() > 0 && !list.contains((Object)n)) {
            return false;
        }
        return this.regexCache.getPatternForRegex(phoneNumberDesc.getNationalNumberPattern()).matcher((CharSequence)string2).matches();
    }

    public boolean isPossibleNumber(Phonenumber.PhoneNumber phoneNumber) {
        return this.isPossibleNumberWithReason(phoneNumber) == ValidationResult.IS_POSSIBLE;
    }

    public boolean isPossibleNumber(String string2, String string3) {
        try {
            boolean bl = this.isPossibleNumber(this.parse(string2, string3));
            return bl;
        }
        catch (NumberParseException numberParseException) {
            return false;
        }
    }

    public ValidationResult isPossibleNumberWithReason(Phonenumber.PhoneNumber phoneNumber) {
        String string2 = this.getNationalSignificantNumber(phoneNumber);
        int n = phoneNumber.getCountryCode();
        if (!this.hasValidCountryCallingCode(n)) {
            return ValidationResult.INVALID_COUNTRY_CODE;
        }
        return this.testNumberLength(string2, this.getMetadataForRegionOrCallingCode(n, this.getRegionCodeForCountryCode(n)).getGeneralDesc());
    }

    public boolean isValidNumber(Phonenumber.PhoneNumber phoneNumber) {
        return this.isValidNumberForRegion(phoneNumber, this.getRegionCodeForNumber(phoneNumber));
    }

    public boolean isValidNumberForRegion(Phonenumber.PhoneNumber phoneNumber, String string2) {
        int n = phoneNumber.getCountryCode();
        Phonemetadata.PhoneMetadata phoneMetadata = this.getMetadataForRegionOrCallingCode(n, string2);
        boolean bl = false;
        if (phoneMetadata != null) {
            if (!REGION_CODE_FOR_NON_GEO_ENTITY.equals((Object)string2) && n != this.getCountryCodeForValidRegion(string2)) {
                return false;
            }
            PhoneNumberType phoneNumberType = this.getNumberTypeHelper(this.getNationalSignificantNumber(phoneNumber), phoneMetadata);
            PhoneNumberType phoneNumberType2 = PhoneNumberType.UNKNOWN;
            bl = false;
            if (phoneNumberType != phoneNumberType2) {
                bl = true;
            }
        }
        return bl;
    }

    int maybeExtractCountryCode(String string2, Phonemetadata.PhoneMetadata phoneMetadata, StringBuilder stringBuilder, boolean bl, Phonenumber.PhoneNumber phoneNumber) throws NumberParseException {
        if (string2.length() == 0) {
            return 0;
        }
        StringBuilder stringBuilder2 = new StringBuilder(string2);
        String string3 = phoneMetadata != null ? phoneMetadata.getInternationalPrefix() : "NonMatch";
        Phonenumber.PhoneNumber.CountryCodeSource countryCodeSource = this.maybeStripInternationalPrefixAndNormalize(stringBuilder2, string3);
        if (bl) {
            phoneNumber.setCountryCodeSource(countryCodeSource);
        }
        if (countryCodeSource != Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            if (stringBuilder2.length() > 2) {
                int n = this.extractCountryCode(stringBuilder2, stringBuilder);
                if (n != 0) {
                    phoneNumber.setCountryCode(n);
                    return n;
                }
                throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
            }
            throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
        }
        if (phoneMetadata != null) {
            int n = phoneMetadata.getCountryCode();
            String string4 = String.valueOf((int)n);
            String string5 = stringBuilder2.toString();
            if (string5.startsWith(string4)) {
                StringBuilder stringBuilder3 = new StringBuilder(string5.substring(string4.length()));
                Phonemetadata.PhoneNumberDesc phoneNumberDesc = phoneMetadata.getGeneralDesc();
                Pattern pattern = this.regexCache.getPatternForRegex(phoneNumberDesc.getNationalNumberPattern());
                this.maybeStripNationalPrefixAndCarrierCode(stringBuilder3, phoneMetadata, null);
                if (!pattern.matcher((CharSequence)stringBuilder2).matches() && pattern.matcher((CharSequence)stringBuilder3).matches() || this.testNumberLength(stringBuilder2.toString(), phoneNumberDesc) == ValidationResult.TOO_LONG) {
                    stringBuilder.append((CharSequence)stringBuilder3);
                    if (bl) {
                        phoneNumber.setCountryCodeSource(Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN);
                    }
                    phoneNumber.setCountryCode(n);
                    return n;
                }
            }
        }
        phoneNumber.setCountryCode(0);
        return 0;
    }

    String maybeStripExtension(StringBuilder stringBuilder) {
        Matcher matcher = EXTN_PATTERN.matcher((CharSequence)stringBuilder);
        if (matcher.find() && PhoneNumberUtil.isViablePhoneNumber(stringBuilder.substring(0, matcher.start()))) {
            int n = matcher.groupCount();
            for (int i = 1; i <= n; ++i) {
                if (matcher.group(i) == null) continue;
                String string2 = matcher.group(i);
                stringBuilder.delete(matcher.start(), stringBuilder.length());
                return string2;
            }
        }
        return "";
    }

    Phonenumber.PhoneNumber.CountryCodeSource maybeStripInternationalPrefixAndNormalize(StringBuilder stringBuilder, String string2) {
        if (stringBuilder.length() == 0) {
            return Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
        }
        Matcher matcher = PLUS_CHARS_PATTERN.matcher((CharSequence)stringBuilder);
        if (matcher.lookingAt()) {
            stringBuilder.delete(0, matcher.end());
            PhoneNumberUtil.normalize(stringBuilder);
            return Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        }
        Pattern pattern = this.regexCache.getPatternForRegex(string2);
        PhoneNumberUtil.normalize(stringBuilder);
        if (this.parsePrefixAsIdd(pattern, stringBuilder)) {
            return Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD;
        }
        return Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
    }

    boolean maybeStripNationalPrefixAndCarrierCode(StringBuilder stringBuilder, Phonemetadata.PhoneMetadata phoneMetadata, StringBuilder stringBuilder2) {
        int n = stringBuilder.length();
        String string2 = phoneMetadata.getNationalPrefixForParsing();
        if (n != 0) {
            if (string2.length() == 0) {
                return false;
            }
            Matcher matcher = this.regexCache.getPatternForRegex(string2).matcher((CharSequence)stringBuilder);
            if (matcher.lookingAt()) {
                Pattern pattern = this.regexCache.getPatternForRegex(phoneMetadata.getGeneralDesc().getNationalNumberPattern());
                boolean bl = pattern.matcher((CharSequence)stringBuilder).matches();
                int n2 = matcher.groupCount();
                String string3 = phoneMetadata.getNationalPrefixTransformRule();
                if (string3 != null && string3.length() != 0 && matcher.group(n2) != null) {
                    StringBuilder stringBuilder3 = new StringBuilder((CharSequence)stringBuilder);
                    stringBuilder3.replace(0, n, matcher.replaceFirst(string3));
                    if (bl && !pattern.matcher((CharSequence)stringBuilder3.toString()).matches()) {
                        return false;
                    }
                    if (stringBuilder2 != null && n2 > 1) {
                        stringBuilder2.append(matcher.group(1));
                    }
                    stringBuilder.replace(0, stringBuilder.length(), stringBuilder3.toString());
                    return true;
                }
                if (bl && !pattern.matcher((CharSequence)stringBuilder.substring(matcher.end())).matches()) {
                    return false;
                }
                if (stringBuilder2 != null && n2 > 0 && matcher.group(n2) != null) {
                    stringBuilder2.append(matcher.group(1));
                }
                stringBuilder.delete(0, matcher.end());
                return true;
            }
        }
        return false;
    }

    public Phonenumber.PhoneNumber parse(String string2, String string3) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumber = new Phonenumber.PhoneNumber();
        this.parse(string2, string3, phoneNumber);
        return phoneNumber;
    }

    public void parse(String string2, String string3, Phonenumber.PhoneNumber phoneNumber) throws NumberParseException {
        this.parseHelper(string2, string3, false, true, phoneNumber);
    }

    public Phonenumber.PhoneNumber parseAndKeepRawInput(String string2, String string3) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumber = new Phonenumber.PhoneNumber();
        this.parseAndKeepRawInput(string2, string3, phoneNumber);
        return phoneNumber;
    }

    public void parseAndKeepRawInput(String string2, String string3, Phonenumber.PhoneNumber phoneNumber) throws NumberParseException {
        this.parseHelper(string2, string3, true, true, phoneNumber);
    }

    public boolean truncateTooLongNumber(Phonenumber.PhoneNumber phoneNumber) {
        block2 : {
            if (this.isValidNumber(phoneNumber)) {
                return true;
            }
            Phonenumber.PhoneNumber phoneNumber2 = new Phonenumber.PhoneNumber();
            phoneNumber2.mergeFrom(phoneNumber);
            long l = phoneNumber.getNationalNumber();
            do {
                phoneNumber2.setNationalNumber(l /= 10L);
                if (this.isPossibleNumberWithReason(phoneNumber2) == ValidationResult.TOO_SHORT || l == 0L) break block2;
            } while (!this.isValidNumber(phoneNumber2));
            phoneNumber.setNationalNumber(l);
            return true;
        }
        return false;
    }

    public static abstract class Leniency
    extends Enum<Leniency> {
        private static final /* synthetic */ Leniency[] $VALUES;
        public static final /* enum */ Leniency EXACT_GROUPING;
        public static final /* enum */ Leniency POSSIBLE;
        public static final /* enum */ Leniency STRICT_GROUPING;
        public static final /* enum */ Leniency VALID;

        static {
            POSSIBLE = new 1("POSSIBLE", 0);
            VALID = new 2("VALID", 1);
            STRICT_GROUPING = new 3("STRICT_GROUPING", 2);
            4 var0 = new 4("EXACT_GROUPING", 3);
            EXACT_GROUPING = var0;
            Leniency[] arrleniency = new Leniency[]{POSSIBLE, VALID, STRICT_GROUPING, var0};
            $VALUES = arrleniency;
        }

        private Leniency() {
        }

        public static Leniency valueOf(String string2) {
            return (Leniency)Enum.valueOf(Leniency.class, (String)string2);
        }

        public static Leniency[] values() {
            return (Leniency[])$VALUES.clone();
        }

        abstract boolean verify(Phonenumber.PhoneNumber var1, String var2, PhoneNumberUtil var3);
    }

    public static final class MatchType
    extends Enum<MatchType> {
        private static final /* synthetic */ MatchType[] $VALUES;
        public static final /* enum */ MatchType EXACT_MATCH;
        public static final /* enum */ MatchType NOT_A_NUMBER;
        public static final /* enum */ MatchType NO_MATCH;
        public static final /* enum */ MatchType NSN_MATCH;
        public static final /* enum */ MatchType SHORT_NSN_MATCH;

        static {
            MatchType matchType;
            NOT_A_NUMBER = new MatchType();
            NO_MATCH = new MatchType();
            SHORT_NSN_MATCH = new MatchType();
            NSN_MATCH = new MatchType();
            EXACT_MATCH = matchType = new MatchType();
            MatchType[] arrmatchType = new MatchType[]{NOT_A_NUMBER, NO_MATCH, SHORT_NSN_MATCH, NSN_MATCH, matchType};
            $VALUES = arrmatchType;
        }

        public static MatchType valueOf(String string2) {
            return (MatchType)Enum.valueOf(MatchType.class, (String)string2);
        }

        public static MatchType[] values() {
            return (MatchType[])$VALUES.clone();
        }
    }

    public static final class PhoneNumberFormat
    extends Enum<PhoneNumberFormat> {
        private static final /* synthetic */ PhoneNumberFormat[] $VALUES;
        public static final /* enum */ PhoneNumberFormat E164;
        public static final /* enum */ PhoneNumberFormat INTERNATIONAL;
        public static final /* enum */ PhoneNumberFormat NATIONAL;
        public static final /* enum */ PhoneNumberFormat RFC3966;

        static {
            PhoneNumberFormat phoneNumberFormat;
            E164 = new PhoneNumberFormat();
            INTERNATIONAL = new PhoneNumberFormat();
            NATIONAL = new PhoneNumberFormat();
            RFC3966 = phoneNumberFormat = new PhoneNumberFormat();
            PhoneNumberFormat[] arrphoneNumberFormat = new PhoneNumberFormat[]{E164, INTERNATIONAL, NATIONAL, phoneNumberFormat};
            $VALUES = arrphoneNumberFormat;
        }

        public static PhoneNumberFormat valueOf(String string2) {
            return (PhoneNumberFormat)Enum.valueOf(PhoneNumberFormat.class, (String)string2);
        }

        public static PhoneNumberFormat[] values() {
            return (PhoneNumberFormat[])$VALUES.clone();
        }
    }

    public static final class PhoneNumberType
    extends Enum<PhoneNumberType> {
        private static final /* synthetic */ PhoneNumberType[] $VALUES;
        public static final /* enum */ PhoneNumberType FIXED_LINE;
        public static final /* enum */ PhoneNumberType FIXED_LINE_OR_MOBILE;
        public static final /* enum */ PhoneNumberType MOBILE;
        public static final /* enum */ PhoneNumberType PAGER;
        public static final /* enum */ PhoneNumberType PERSONAL_NUMBER;
        public static final /* enum */ PhoneNumberType PREMIUM_RATE;
        public static final /* enum */ PhoneNumberType SHARED_COST;
        public static final /* enum */ PhoneNumberType TOLL_FREE;
        public static final /* enum */ PhoneNumberType UAN;
        public static final /* enum */ PhoneNumberType UNKNOWN;
        public static final /* enum */ PhoneNumberType VOICEMAIL;
        public static final /* enum */ PhoneNumberType VOIP;

        static {
            PhoneNumberType phoneNumberType;
            FIXED_LINE = new PhoneNumberType();
            MOBILE = new PhoneNumberType();
            FIXED_LINE_OR_MOBILE = new PhoneNumberType();
            TOLL_FREE = new PhoneNumberType();
            PREMIUM_RATE = new PhoneNumberType();
            SHARED_COST = new PhoneNumberType();
            VOIP = new PhoneNumberType();
            PERSONAL_NUMBER = new PhoneNumberType();
            PAGER = new PhoneNumberType();
            UAN = new PhoneNumberType();
            VOICEMAIL = new PhoneNumberType();
            UNKNOWN = phoneNumberType = new PhoneNumberType();
            PhoneNumberType[] arrphoneNumberType = new PhoneNumberType[]{FIXED_LINE, MOBILE, FIXED_LINE_OR_MOBILE, TOLL_FREE, PREMIUM_RATE, SHARED_COST, VOIP, PERSONAL_NUMBER, PAGER, UAN, VOICEMAIL, phoneNumberType};
            $VALUES = arrphoneNumberType;
        }

        public static PhoneNumberType valueOf(String string2) {
            return (PhoneNumberType)Enum.valueOf(PhoneNumberType.class, (String)string2);
        }

        public static PhoneNumberType[] values() {
            return (PhoneNumberType[])$VALUES.clone();
        }
    }

    public static final class ValidationResult
    extends Enum<ValidationResult> {
        private static final /* synthetic */ ValidationResult[] $VALUES;
        public static final /* enum */ ValidationResult INVALID_COUNTRY_CODE;
        public static final /* enum */ ValidationResult IS_POSSIBLE;
        public static final /* enum */ ValidationResult TOO_LONG;
        public static final /* enum */ ValidationResult TOO_SHORT;

        static {
            ValidationResult validationResult;
            IS_POSSIBLE = new ValidationResult();
            INVALID_COUNTRY_CODE = new ValidationResult();
            TOO_SHORT = new ValidationResult();
            TOO_LONG = validationResult = new ValidationResult();
            ValidationResult[] arrvalidationResult = new ValidationResult[]{IS_POSSIBLE, INVALID_COUNTRY_CODE, TOO_SHORT, validationResult};
            $VALUES = arrvalidationResult;
        }

        public static ValidationResult valueOf(String string2) {
            return (ValidationResult)Enum.valueOf(ValidationResult.class, (String)string2);
        }

        public static ValidationResult[] values() {
            return (ValidationResult[])$VALUES.clone();
        }
    }

}

