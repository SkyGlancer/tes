/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.i18n.phonenumbers.internal.RegexBasedMatcher
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package app.dukhaan.src.java.com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.CountryCodeToRegionCodeMap;
import com.google.i18n.phonenumbers.MetadataManager;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.internal.MatcherApi;
import com.google.i18n.phonenumbers.internal.RegexBasedMatcher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShortNumberInfo {
    private static final ShortNumberInfo INSTANCE;
    private static final Set<String> REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT;
    private static final Logger logger;
    private final Map<Integer, List<String>> countryCallingCodeToRegionCodeMap;
    private final MatcherApi matcherApi;

    static {
        HashSet hashSet;
        logger = Logger.getLogger((String)ShortNumberInfo.class.getName());
        INSTANCE = new ShortNumberInfo(RegexBasedMatcher.create());
        REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT = hashSet = new HashSet();
        hashSet.add((Object)"BR");
        REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT.add((Object)"CL");
        REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT.add((Object)"NI");
    }

    ShortNumberInfo(MatcherApi matcherApi) {
        this.matcherApi = matcherApi;
        this.countryCallingCodeToRegionCodeMap = CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap();
    }

    public static ShortNumberInfo getInstance() {
        return INSTANCE;
    }

    private static String getNationalSignificantNumber(Phonenumber.PhoneNumber phoneNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        if (phoneNumber.isItalianLeadingZero()) {
            char[] arrc = new char[phoneNumber.getNumberOfLeadingZeros()];
            Arrays.fill((char[])arrc, (char)'0');
            stringBuilder.append(new String(arrc));
        }
        stringBuilder.append(phoneNumber.getNationalNumber());
        return stringBuilder.toString();
    }

    private String getRegionCodeForShortNumberFromRegionList(Phonenumber.PhoneNumber phoneNumber, List<String> list) {
        if (list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return (String)list.get(0);
        }
        String string2 = ShortNumberInfo.getNationalSignificantNumber(phoneNumber);
        for (String string3 : list) {
            Phonemetadata.PhoneMetadata phoneMetadata = MetadataManager.getShortNumberMetadataForRegion(string3);
            if (phoneMetadata == null || !this.matchesPossibleNumberAndNationalNumber(string2, phoneMetadata.getShortCode())) continue;
            return string3;
        }
        return null;
    }

    private List<String> getRegionCodesForCountryCode(int n) {
        List list = (List)this.countryCallingCodeToRegionCodeMap.get((Object)n);
        if (list == null) {
            list = new ArrayList(0);
        }
        return Collections.unmodifiableList((List)list);
    }

    private boolean matchesEmergencyNumberHelper(String string2, String string3, boolean bl) {
        String string4 = PhoneNumberUtil.extractPossibleNumber(string2);
        if (PhoneNumberUtil.PLUS_CHARS_PATTERN.matcher((CharSequence)string4).lookingAt()) {
            return false;
        }
        Phonemetadata.PhoneMetadata phoneMetadata = MetadataManager.getShortNumberMetadataForRegion(string3);
        if (phoneMetadata != null) {
            if (!phoneMetadata.hasEmergency()) {
                return false;
            }
            String string5 = PhoneNumberUtil.normalizeDigitsOnly(string4);
            Phonemetadata.PhoneNumberDesc phoneNumberDesc = phoneMetadata.getEmergency();
            boolean bl2 = false;
            if (bl) {
                boolean bl3 = REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT.contains((Object)string3);
                bl2 = false;
                if (!bl3) {
                    bl2 = true;
                }
            }
            return this.matcherApi.matchesNationalNumber(string5, phoneNumberDesc, bl2);
        }
        return false;
    }

    private boolean matchesPossibleNumberAndNationalNumber(String string2, Phonemetadata.PhoneNumberDesc phoneNumberDesc) {
        if (phoneNumberDesc.getPossibleLengthCount() > 0 && !phoneNumberDesc.getPossibleLengthList().contains((Object)string2.length())) {
            return false;
        }
        return this.matcherApi.matchesNationalNumber(string2, phoneNumberDesc, false);
    }

    private boolean regionDialingFromMatchesNumber(Phonenumber.PhoneNumber phoneNumber, String string2) {
        return this.getRegionCodesForCountryCode(phoneNumber.getCountryCode()).contains((Object)string2);
    }

    public boolean connectsToEmergencyNumber(String string2, String string3) {
        return this.matchesEmergencyNumberHelper(string2, string3, true);
    }

    String getExampleShortNumber(String string2) {
        Phonemetadata.PhoneMetadata phoneMetadata = MetadataManager.getShortNumberMetadataForRegion(string2);
        if (phoneMetadata == null) {
            return "";
        }
        Phonemetadata.PhoneNumberDesc phoneNumberDesc = phoneMetadata.getShortCode();
        if (phoneNumberDesc.hasExampleNumber()) {
            return phoneNumberDesc.getExampleNumber();
        }
        return "";
    }

    String getExampleShortNumberForCost(String string2, ShortNumberCost shortNumberCost) {
        Phonemetadata.PhoneMetadata phoneMetadata = MetadataManager.getShortNumberMetadataForRegion(string2);
        if (phoneMetadata == null) {
            return "";
        }
        int n = 1.$SwitchMap$com$google$i18n$phonenumbers$ShortNumberInfo$ShortNumberCost[shortNumberCost.ordinal()];
        Object object = n != 1 ? (n != 3 ? (n != 4 ? null : phoneMetadata.getTollFree()) : phoneMetadata.getStandardRate()) : phoneMetadata.getPremiumRate();
        if (object != null && ((Phonemetadata.PhoneNumberDesc)object).hasExampleNumber()) {
            return ((Phonemetadata.PhoneNumberDesc)object).getExampleNumber();
        }
        return "";
    }

    public ShortNumberCost getExpectedCost(Phonenumber.PhoneNumber phoneNumber) {
        List<String> list = this.getRegionCodesForCountryCode(phoneNumber.getCountryCode());
        if (list.size() == 0) {
            return ShortNumberCost.UNKNOWN_COST;
        }
        if (list.size() == 1) {
            return this.getExpectedCostForRegion(phoneNumber, (String)list.get(0));
        }
        ShortNumberCost shortNumberCost = ShortNumberCost.TOLL_FREE;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ShortNumberCost shortNumberCost2 = this.getExpectedCostForRegion(phoneNumber, (String)iterator.next());
            int n = 1.$SwitchMap$com$google$i18n$phonenumbers$ShortNumberInfo$ShortNumberCost[shortNumberCost2.ordinal()];
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        if (n == 4) continue;
                        Logger logger = ShortNumberInfo.logger;
                        Level level = Level.SEVERE;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unrecognised cost for region: ");
                        stringBuilder.append((Object)shortNumberCost2);
                        logger.log(level, stringBuilder.toString());
                        continue;
                    }
                    if (shortNumberCost == ShortNumberCost.UNKNOWN_COST) continue;
                    shortNumberCost = ShortNumberCost.STANDARD_RATE;
                    continue;
                }
                shortNumberCost = ShortNumberCost.UNKNOWN_COST;
                continue;
            }
            return ShortNumberCost.PREMIUM_RATE;
        }
        return shortNumberCost;
    }

    public ShortNumberCost getExpectedCostForRegion(Phonenumber.PhoneNumber phoneNumber, String string2) {
        if (!this.regionDialingFromMatchesNumber(phoneNumber, string2)) {
            return ShortNumberCost.UNKNOWN_COST;
        }
        Phonemetadata.PhoneMetadata phoneMetadata = MetadataManager.getShortNumberMetadataForRegion(string2);
        if (phoneMetadata == null) {
            return ShortNumberCost.UNKNOWN_COST;
        }
        String string3 = ShortNumberInfo.getNationalSignificantNumber(phoneNumber);
        if (!phoneMetadata.getGeneralDesc().getPossibleLengthList().contains((Object)string3.length())) {
            return ShortNumberCost.UNKNOWN_COST;
        }
        if (this.matchesPossibleNumberAndNationalNumber(string3, phoneMetadata.getPremiumRate())) {
            return ShortNumberCost.PREMIUM_RATE;
        }
        if (this.matchesPossibleNumberAndNationalNumber(string3, phoneMetadata.getStandardRate())) {
            return ShortNumberCost.STANDARD_RATE;
        }
        if (this.matchesPossibleNumberAndNationalNumber(string3, phoneMetadata.getTollFree())) {
            return ShortNumberCost.TOLL_FREE;
        }
        if (this.isEmergencyNumber(string3, string2)) {
            return ShortNumberCost.TOLL_FREE;
        }
        return ShortNumberCost.UNKNOWN_COST;
    }

    Set<String> getSupportedRegions() {
        return MetadataManager.getSupportedShortNumberRegions();
    }

    public boolean isCarrierSpecific(Phonenumber.PhoneNumber phoneNumber) {
        String string2 = this.getRegionCodeForShortNumberFromRegionList(phoneNumber, this.getRegionCodesForCountryCode(phoneNumber.getCountryCode()));
        String string3 = ShortNumberInfo.getNationalSignificantNumber(phoneNumber);
        Phonemetadata.PhoneMetadata phoneMetadata = MetadataManager.getShortNumberMetadataForRegion(string2);
        return phoneMetadata != null && this.matchesPossibleNumberAndNationalNumber(string3, phoneMetadata.getCarrierSpecific());
    }

    public boolean isCarrierSpecificForRegion(Phonenumber.PhoneNumber phoneNumber, String string2) {
        if (!this.regionDialingFromMatchesNumber(phoneNumber, string2)) {
            return false;
        }
        String string3 = ShortNumberInfo.getNationalSignificantNumber(phoneNumber);
        Phonemetadata.PhoneMetadata phoneMetadata = MetadataManager.getShortNumberMetadataForRegion(string2);
        boolean bl = false;
        if (phoneMetadata != null) {
            boolean bl2 = this.matchesPossibleNumberAndNationalNumber(string3, phoneMetadata.getCarrierSpecific());
            bl = false;
            if (bl2) {
                bl = true;
            }
        }
        return bl;
    }

    public boolean isEmergencyNumber(String string2, String string3) {
        return this.matchesEmergencyNumberHelper(string2, string3, false);
    }

    public boolean isPossibleShortNumber(Phonenumber.PhoneNumber phoneNumber) {
        List<String> list = this.getRegionCodesForCountryCode(phoneNumber.getCountryCode());
        int n = ShortNumberInfo.getNationalSignificantNumber(phoneNumber).length();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Phonemetadata.PhoneMetadata phoneMetadata = MetadataManager.getShortNumberMetadataForRegion((String)iterator.next());
            if (phoneMetadata == null || !phoneMetadata.getGeneralDesc().getPossibleLengthList().contains((Object)n)) continue;
            return true;
        }
        return false;
    }

    public boolean isPossibleShortNumberForRegion(Phonenumber.PhoneNumber phoneNumber, String string2) {
        if (!this.regionDialingFromMatchesNumber(phoneNumber, string2)) {
            return false;
        }
        Phonemetadata.PhoneMetadata phoneMetadata = MetadataManager.getShortNumberMetadataForRegion(string2);
        if (phoneMetadata == null) {
            return false;
        }
        int n = ShortNumberInfo.getNationalSignificantNumber(phoneNumber).length();
        return phoneMetadata.getGeneralDesc().getPossibleLengthList().contains((Object)n);
    }

    public boolean isValidShortNumber(Phonenumber.PhoneNumber phoneNumber) {
        List<String> list = this.getRegionCodesForCountryCode(phoneNumber.getCountryCode());
        String string2 = this.getRegionCodeForShortNumberFromRegionList(phoneNumber, list);
        if (list.size() > 1 && string2 != null) {
            return true;
        }
        return this.isValidShortNumberForRegion(phoneNumber, string2);
    }

    public boolean isValidShortNumberForRegion(Phonenumber.PhoneNumber phoneNumber, String string2) {
        if (!this.regionDialingFromMatchesNumber(phoneNumber, string2)) {
            return false;
        }
        Phonemetadata.PhoneMetadata phoneMetadata = MetadataManager.getShortNumberMetadataForRegion(string2);
        if (phoneMetadata == null) {
            return false;
        }
        String string3 = ShortNumberInfo.getNationalSignificantNumber(phoneNumber);
        if (!this.matchesPossibleNumberAndNationalNumber(string3, phoneMetadata.getGeneralDesc())) {
            return false;
        }
        return this.matchesPossibleNumberAndNationalNumber(string3, phoneMetadata.getShortCode());
    }

    public static final class ShortNumberCost
    extends Enum<ShortNumberCost> {
        private static final /* synthetic */ ShortNumberCost[] $VALUES;
        public static final /* enum */ ShortNumberCost PREMIUM_RATE;
        public static final /* enum */ ShortNumberCost STANDARD_RATE;
        public static final /* enum */ ShortNumberCost TOLL_FREE;
        public static final /* enum */ ShortNumberCost UNKNOWN_COST;

        static {
            ShortNumberCost shortNumberCost;
            TOLL_FREE = new ShortNumberCost();
            STANDARD_RATE = new ShortNumberCost();
            PREMIUM_RATE = new ShortNumberCost();
            UNKNOWN_COST = shortNumberCost = new ShortNumberCost();
            ShortNumberCost[] arrshortNumberCost = new ShortNumberCost[]{TOLL_FREE, STANDARD_RATE, PREMIUM_RATE, shortNumberCost};
            $VALUES = arrshortNumberCost;
        }

        public static ShortNumberCost valueOf(String string2) {
            return (ShortNumberCost)Enum.valueOf(ShortNumberCost.class, (String)string2);
        }

        public static ShortNumberCost[] values() {
            return (ShortNumberCost[])$VALUES.clone();
        }
    }

}

