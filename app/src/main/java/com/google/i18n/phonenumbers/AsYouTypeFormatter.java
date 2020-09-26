/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package app.dukhaan.src.java.com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.RegexCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AsYouTypeFormatter {
    private static final Pattern CHARACTER_CLASS_PATTERN;
    private static final Pattern DIGIT_PATTERN;
    private static final String DIGIT_PLACEHOLDER = "\u2008";
    private static final Pattern ELIGIBLE_FORMAT_PATTERN;
    private static final Phonemetadata.PhoneMetadata EMPTY_METADATA;
    private static final int MIN_LEADING_DIGITS_LENGTH = 3;
    private static final Pattern NATIONAL_PREFIX_SEPARATORS_PATTERN;
    private static final char SEPARATOR_BEFORE_NATIONAL_NUMBER = ' ';
    private static final Pattern STANDALONE_DIGIT_PATTERN;
    private boolean ableToFormat = true;
    private StringBuilder accruedInput = new StringBuilder();
    private StringBuilder accruedInputWithoutFormatting = new StringBuilder();
    private String currentFormattingPattern = "";
    private Phonemetadata.PhoneMetadata currentMetadata;
    private String currentOutput = "";
    private String defaultCountry;
    private Phonemetadata.PhoneMetadata defaultMetadata;
    private String extractedNationalPrefix = "";
    private StringBuilder formattingTemplate = new StringBuilder();
    private boolean inputHasFormatting = false;
    private boolean isCompleteNumber = false;
    private boolean isExpectingCountryCallingCode = false;
    private int lastMatchPosition = 0;
    private StringBuilder nationalNumber = new StringBuilder();
    private int originalPosition = 0;
    private final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
    private int positionToRemember = 0;
    private List<Phonemetadata.NumberFormat> possibleFormats = new ArrayList();
    private StringBuilder prefixBeforeNationalNumber = new StringBuilder();
    private RegexCache regexCache = new RegexCache(64);
    private boolean shouldAddSpaceAfterNationalPrefix = false;

    static {
        EMPTY_METADATA = new Phonemetadata.PhoneMetadata().setInternationalPrefix("NA");
        CHARACTER_CLASS_PATTERN = Pattern.compile((String)"\\[([^\\[\\]])*\\]");
        STANDALONE_DIGIT_PATTERN = Pattern.compile((String)"\\d(?=[^,}][^,}])");
        ELIGIBLE_FORMAT_PATTERN = Pattern.compile((String)"[-x\u2010-\u2015\u2212\u30fc\uff0d-\uff0f \u00a0\u00ad\u200b\u2060\u3000()\uff08\uff09\uff3b\uff3d.\\[\\]/~\u2053\u223c\uff5e]*(\\$\\d[-x\u2010-\u2015\u2212\u30fc\uff0d-\uff0f \u00a0\u00ad\u200b\u2060\u3000()\uff08\uff09\uff3b\uff3d.\\[\\]/~\u2053\u223c\uff5e]*)+");
        NATIONAL_PREFIX_SEPARATORS_PATTERN = Pattern.compile((String)"[- ]");
        DIGIT_PATTERN = Pattern.compile((String)DIGIT_PLACEHOLDER);
    }

    AsYouTypeFormatter(String string2) {
        Phonemetadata.PhoneMetadata phoneMetadata;
        this.defaultCountry = string2;
        this.currentMetadata = phoneMetadata = this.getMetadataForRegion(string2);
        this.defaultMetadata = phoneMetadata;
    }

    private boolean ableToExtractLongerNdd() {
        if (this.extractedNationalPrefix.length() > 0) {
            this.nationalNumber.insert(0, this.extractedNationalPrefix);
            int n = this.prefixBeforeNationalNumber.lastIndexOf(this.extractedNationalPrefix);
            this.prefixBeforeNationalNumber.setLength(n);
        }
        return true ^ this.extractedNationalPrefix.equals((Object)this.removeNationalPrefixFromNationalNumber());
    }

    private String appendNationalNumber(String string2) {
        int n = this.prefixBeforeNationalNumber.length();
        if (this.shouldAddSpaceAfterNationalPrefix && n > 0 && this.prefixBeforeNationalNumber.charAt(n - 1) != ' ') {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(new String(this.prefixBeforeNationalNumber));
            stringBuilder.append(' ');
            stringBuilder.append(string2);
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Object)this.prefixBeforeNationalNumber);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    private String attemptToChooseFormattingPattern() {
        if (this.nationalNumber.length() >= 3) {
            this.getAvailableFormats(this.nationalNumber.toString());
            String string2 = this.attemptToFormatAccruedDigits();
            if (string2.length() > 0) {
                return string2;
            }
            if (this.maybeCreateNewTemplate()) {
                return this.inputAccruedNationalNumber();
            }
            return this.accruedInput.toString();
        }
        return this.appendNationalNumber(this.nationalNumber.toString());
    }

    private String attemptToChoosePatternWithPrefixExtracted() {
        this.ableToFormat = true;
        this.isExpectingCountryCallingCode = false;
        this.possibleFormats.clear();
        this.lastMatchPosition = 0;
        this.formattingTemplate.setLength(0);
        this.currentFormattingPattern = "";
        return this.attemptToChooseFormattingPattern();
    }

    private boolean attemptToExtractCountryCallingCode() {
        if (this.nationalNumber.length() == 0) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n = this.phoneUtil.extractCountryCode(this.nationalNumber, stringBuilder);
        if (n == 0) {
            return false;
        }
        this.nationalNumber.setLength(0);
        this.nationalNumber.append((CharSequence)stringBuilder);
        String string2 = this.phoneUtil.getRegionCodeForCountryCode(n);
        if ("001".equals((Object)string2)) {
            this.currentMetadata = this.phoneUtil.getMetadataForNonGeographicalRegion(n);
        } else if (!string2.equals((Object)this.defaultCountry)) {
            this.currentMetadata = this.getMetadataForRegion(string2);
        }
        String string3 = Integer.toString((int)n);
        StringBuilder stringBuilder2 = this.prefixBeforeNationalNumber;
        stringBuilder2.append(string3);
        stringBuilder2.append(' ');
        this.extractedNationalPrefix = "";
        return true;
    }

    private boolean attemptToExtractIdd() {
        RegexCache regexCache = this.regexCache;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\\+|");
        stringBuilder.append(this.currentMetadata.getInternationalPrefix());
        Matcher matcher = regexCache.getPatternForRegex(stringBuilder.toString()).matcher((CharSequence)this.accruedInputWithoutFormatting);
        if (matcher.lookingAt()) {
            this.isCompleteNumber = true;
            int n = matcher.end();
            this.nationalNumber.setLength(0);
            this.nationalNumber.append(this.accruedInputWithoutFormatting.substring(n));
            this.prefixBeforeNationalNumber.setLength(0);
            this.prefixBeforeNationalNumber.append(this.accruedInputWithoutFormatting.substring(0, n));
            if (this.accruedInputWithoutFormatting.charAt(0) != '+') {
                this.prefixBeforeNationalNumber.append(' ');
            }
            return true;
        }
        return false;
    }

    private boolean createFormattingTemplate(Phonemetadata.NumberFormat numberFormat) {
        String string2 = numberFormat.getPattern();
        if (string2.indexOf(124) != -1) {
            return false;
        }
        String string3 = CHARACTER_CLASS_PATTERN.matcher((CharSequence)string2).replaceAll("\\\\d");
        String string4 = STANDALONE_DIGIT_PATTERN.matcher((CharSequence)string3).replaceAll("\\\\d");
        this.formattingTemplate.setLength(0);
        String string5 = this.getFormattingTemplate(string4, numberFormat.getFormat());
        if (string5.length() > 0) {
            this.formattingTemplate.append(string5);
            return true;
        }
        return false;
    }

    private void getAvailableFormats(String string2) {
        List<Phonemetadata.NumberFormat> list = this.isCompleteNumber && this.currentMetadata.intlNumberFormatSize() > 0 ? this.currentMetadata.intlNumberFormats() : this.currentMetadata.numberFormats();
        boolean bl = this.currentMetadata.hasNationalPrefix();
        for (Phonemetadata.NumberFormat numberFormat : list) {
            if (bl && !this.isCompleteNumber && !numberFormat.isNationalPrefixOptionalWhenFormatting() && !PhoneNumberUtil.formattingRuleHasFirstGroupOnly(numberFormat.getNationalPrefixFormattingRule()) || !this.isFormatEligible(numberFormat.getFormat())) continue;
            this.possibleFormats.add((Object)numberFormat);
        }
        this.narrowDownPossibleFormats(string2);
    }

    private String getFormattingTemplate(String string2, String string3) {
        Matcher matcher = this.regexCache.getPatternForRegex(string2).matcher((CharSequence)"999999999999999");
        matcher.find();
        String string4 = matcher.group();
        if (string4.length() < this.nationalNumber.length()) {
            return "";
        }
        return string4.replaceAll(string2, string3).replaceAll("9", DIGIT_PLACEHOLDER);
    }

    private Phonemetadata.PhoneMetadata getMetadataForRegion(String string2) {
        int n = this.phoneUtil.getCountryCodeForRegion(string2);
        String string3 = this.phoneUtil.getRegionCodeForCountryCode(n);
        Phonemetadata.PhoneMetadata phoneMetadata = this.phoneUtil.getMetadataForRegion(string3);
        if (phoneMetadata != null) {
            return phoneMetadata;
        }
        return EMPTY_METADATA;
    }

    private String inputAccruedNationalNumber() {
        int n = this.nationalNumber.length();
        if (n > 0) {
            String string2 = "";
            for (int i = 0; i < n; ++i) {
                string2 = this.inputDigitHelper(this.nationalNumber.charAt(i));
            }
            if (this.ableToFormat) {
                return this.appendNationalNumber(string2);
            }
            return this.accruedInput.toString();
        }
        return this.prefixBeforeNationalNumber.toString();
    }

    private String inputDigitHelper(char c) {
        Matcher matcher = DIGIT_PATTERN.matcher((CharSequence)this.formattingTemplate);
        if (matcher.find(this.lastMatchPosition)) {
            int n;
            String string2 = matcher.replaceFirst(Character.toString((char)c));
            this.formattingTemplate.replace(0, string2.length(), string2);
            this.lastMatchPosition = n = matcher.start();
            return this.formattingTemplate.substring(0, n + 1);
        }
        if (this.possibleFormats.size() == 1) {
            this.ableToFormat = false;
        }
        this.currentFormattingPattern = "";
        return this.accruedInput.toString();
    }

    private String inputDigitWithOptionToRememberPosition(char c, boolean bl) {
        block19 : {
            block21 : {
                block20 : {
                    this.accruedInput.append(c);
                    if (bl) {
                        this.originalPosition = this.accruedInput.length();
                    }
                    if (!this.isDigitOrLeadingPlusSign(c)) {
                        this.ableToFormat = false;
                        this.inputHasFormatting = true;
                    } else {
                        c = this.normalizeAndAccrueDigitsAndPlusSign(c, bl);
                    }
                    if (!this.ableToFormat) {
                        if (this.inputHasFormatting) {
                            return this.accruedInput.toString();
                        }
                        if (this.attemptToExtractIdd()) {
                            if (this.attemptToExtractCountryCallingCode()) {
                                return this.attemptToChoosePatternWithPrefixExtracted();
                            }
                        } else if (this.ableToExtractLongerNdd()) {
                            this.prefixBeforeNationalNumber.append(' ');
                            return this.attemptToChoosePatternWithPrefixExtracted();
                        }
                        return this.accruedInput.toString();
                    }
                    int n = this.accruedInputWithoutFormatting.length();
                    if (n == 0 || n == 1 || n == 2) break block19;
                    if (n != 3) break block20;
                    if (!this.attemptToExtractIdd()) break block21;
                    this.isExpectingCountryCallingCode = true;
                }
                if (this.isExpectingCountryCallingCode) {
                    if (this.attemptToExtractCountryCallingCode()) {
                        this.isExpectingCountryCallingCode = false;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((Object)this.prefixBeforeNationalNumber);
                    stringBuilder.append(this.nationalNumber.toString());
                    return stringBuilder.toString();
                }
                if (this.possibleFormats.size() > 0) {
                    String string2 = this.inputDigitHelper(c);
                    String string3 = this.attemptToFormatAccruedDigits();
                    if (string3.length() > 0) {
                        return string3;
                    }
                    this.narrowDownPossibleFormats(this.nationalNumber.toString());
                    if (this.maybeCreateNewTemplate()) {
                        return this.inputAccruedNationalNumber();
                    }
                    if (this.ableToFormat) {
                        return this.appendNationalNumber(string2);
                    }
                    return this.accruedInput.toString();
                }
                return this.attemptToChooseFormattingPattern();
            }
            this.extractedNationalPrefix = this.removeNationalPrefixFromNationalNumber();
            return this.attemptToChooseFormattingPattern();
        }
        return this.accruedInput.toString();
    }

    private boolean isDigitOrLeadingPlusSign(char c) {
        boolean bl = Character.isDigit((char)c);
        int n = 1;
        if (!bl) {
            if (this.accruedInput.length() == n && PhoneNumberUtil.PLUS_CHARS_PATTERN.matcher((CharSequence)Character.toString((char)c)).matches()) {
                return n;
            }
            n = 0;
        }
        return n;
    }

    private boolean isFormatEligible(String string2) {
        return ELIGIBLE_FORMAT_PATTERN.matcher((CharSequence)string2).matches();
    }

    private boolean isNanpaNumberWithNationalPrefix() {
        int n = this.currentMetadata.getCountryCode();
        boolean bl = false;
        if (n == 1) {
            char c = this.nationalNumber.charAt(0);
            bl = false;
            if (c == '1') {
                char c2 = this.nationalNumber.charAt(1);
                bl = false;
                if (c2 != '0') {
                    char c3 = this.nationalNumber.charAt(1);
                    bl = false;
                    if (c3 != '1') {
                        bl = true;
                    }
                }
            }
        }
        return bl;
    }

    private boolean maybeCreateNewTemplate() {
        Iterator iterator = this.possibleFormats.iterator();
        while (iterator.hasNext()) {
            Phonemetadata.NumberFormat numberFormat = (Phonemetadata.NumberFormat)iterator.next();
            String string2 = numberFormat.getPattern();
            if (this.currentFormattingPattern.equals((Object)string2)) {
                return false;
            }
            if (this.createFormattingTemplate(numberFormat)) {
                this.currentFormattingPattern = string2;
                this.shouldAddSpaceAfterNationalPrefix = NATIONAL_PREFIX_SEPARATORS_PATTERN.matcher((CharSequence)numberFormat.getNationalPrefixFormattingRule()).find();
                this.lastMatchPosition = 0;
                return true;
            }
            iterator.remove();
        }
        this.ableToFormat = false;
        return false;
    }

    private void narrowDownPossibleFormats(String string2) {
        int n = -3 + string2.length();
        Iterator iterator = this.possibleFormats.iterator();
        while (iterator.hasNext()) {
            int n2;
            Phonemetadata.NumberFormat numberFormat = (Phonemetadata.NumberFormat)iterator.next();
            if (numberFormat.leadingDigitsPatternSize() == 0 || this.regexCache.getPatternForRegex(numberFormat.getLeadingDigitsPattern(n2 = Math.min((int)n, (int)(-1 + numberFormat.leadingDigitsPatternSize())))).matcher((CharSequence)string2).lookingAt()) continue;
            iterator.remove();
        }
    }

    private char normalizeAndAccrueDigitsAndPlusSign(char c, boolean bl) {
        if (c == '+') {
            this.accruedInputWithoutFormatting.append(c);
        } else {
            c = Character.forDigit((int)Character.digit((char)c, (int)10), (int)10);
            this.accruedInputWithoutFormatting.append(c);
            this.nationalNumber.append(c);
        }
        if (bl) {
            this.positionToRemember = this.accruedInputWithoutFormatting.length();
        }
        return c;
    }

    private String removeNationalPrefixFromNationalNumber() {
        Matcher matcher;
        boolean bl = this.isNanpaNumberWithNationalPrefix();
        int n = 1;
        if (bl) {
            StringBuilder stringBuilder = this.prefixBeforeNationalNumber;
            stringBuilder.append('1');
            stringBuilder.append(' ');
            this.isCompleteNumber = n;
        } else if (this.currentMetadata.hasNationalPrefixForParsing() && (matcher = this.regexCache.getPatternForRegex(this.currentMetadata.getNationalPrefixForParsing()).matcher((CharSequence)this.nationalNumber)).lookingAt() && matcher.end() > 0) {
            this.isCompleteNumber = n;
            n = matcher.end();
            this.prefixBeforeNationalNumber.append(this.nationalNumber.substring(0, n));
        } else {
            n = 0;
        }
        String string2 = this.nationalNumber.substring(0, n);
        this.nationalNumber.delete(0, n);
        return string2;
    }

    String attemptToFormatAccruedDigits() {
        for (Phonemetadata.NumberFormat numberFormat : this.possibleFormats) {
            Matcher matcher = this.regexCache.getPatternForRegex(numberFormat.getPattern()).matcher((CharSequence)this.nationalNumber);
            if (!matcher.matches()) continue;
            this.shouldAddSpaceAfterNationalPrefix = NATIONAL_PREFIX_SEPARATORS_PATTERN.matcher((CharSequence)numberFormat.getNationalPrefixFormattingRule()).find();
            return this.appendNationalNumber(matcher.replaceAll(numberFormat.getFormat()));
        }
        return "";
    }

    public void clear() {
        this.currentOutput = "";
        this.accruedInput.setLength(0);
        this.accruedInputWithoutFormatting.setLength(0);
        this.formattingTemplate.setLength(0);
        this.lastMatchPosition = 0;
        this.currentFormattingPattern = "";
        this.prefixBeforeNationalNumber.setLength(0);
        this.extractedNationalPrefix = "";
        this.nationalNumber.setLength(0);
        this.ableToFormat = true;
        this.inputHasFormatting = false;
        this.positionToRemember = 0;
        this.originalPosition = 0;
        this.isCompleteNumber = false;
        this.isExpectingCountryCallingCode = false;
        this.possibleFormats.clear();
        this.shouldAddSpaceAfterNationalPrefix = false;
        if (!this.currentMetadata.equals((Object)this.defaultMetadata)) {
            this.currentMetadata = this.getMetadataForRegion(this.defaultCountry);
        }
    }

    String getExtractedNationalPrefix() {
        return this.extractedNationalPrefix;
    }

    public int getRememberedPosition() {
        int n;
        if (!this.ableToFormat) {
            return this.originalPosition;
        }
        int n2 = 0;
        for (n = 0; n2 < this.positionToRemember && n < this.currentOutput.length(); ++n) {
            if (this.accruedInputWithoutFormatting.charAt(n2) != this.currentOutput.charAt(n)) continue;
            ++n2;
        }
        return n;
    }

    public String inputDigit(char c) {
        String string2;
        this.currentOutput = string2 = this.inputDigitWithOptionToRememberPosition(c, false);
        return string2;
    }

    public String inputDigitAndRememberPosition(char c) {
        String string2;
        this.currentOutput = string2 = this.inputDigitWithOptionToRememberPosition(c, true);
        return string2;
    }
}

