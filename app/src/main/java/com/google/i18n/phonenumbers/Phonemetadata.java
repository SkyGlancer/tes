/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.i18n.phonenumbers.Phonemetadata$NumberFormat$Builder
 *  com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata$Builder
 *  com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadataCollection$Builder
 *  com.google.i18n.phonenumbers.Phonemetadata$PhoneNumberDesc$Builder
 *  java.io.Externalizable
 *  java.io.IOException
 *  java.io.ObjectInput
 *  java.io.ObjectOutput
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package app.dukhaan.src.java.com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.Phonemetadata;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public final class Phonemetadata {
    private Phonemetadata() {
    }

    /*
     * Exception performing whole class analysis.
     */
    public static class NumberFormat
    implements Externalizable {
        private static final long serialVersionUID = 1L;
        private String domesticCarrierCodeFormattingRule_;
        private String format_;
        private boolean hasDomesticCarrierCodeFormattingRule;
        private boolean hasFormat;
        private boolean hasNationalPrefixFormattingRule;
        private boolean hasNationalPrefixOptionalWhenFormatting;
        private boolean hasPattern;
        private List<String> leadingDigitsPattern_;
        private String nationalPrefixFormattingRule_;
        private boolean nationalPrefixOptionalWhenFormatting_;
        private String pattern_;

        public NumberFormat() {
            this.pattern_ = "";
            this.format_ = "";
            this.leadingDigitsPattern_ = new ArrayList();
            this.nationalPrefixFormattingRule_ = "";
            this.nationalPrefixOptionalWhenFormatting_ = false;
            this.domesticCarrierCodeFormattingRule_ = "";
        }

        public static Builder newBuilder() {
            return new /* Unavailable Anonymous Inner Class!! */;
        }

        public NumberFormat addLeadingDigitsPattern(String string2) {
            if (string2 != null) {
                this.leadingDigitsPattern_.add((Object)string2);
                return this;
            }
            throw null;
        }

        public NumberFormat clearNationalPrefixFormattingRule() {
            this.hasNationalPrefixFormattingRule = false;
            this.nationalPrefixFormattingRule_ = "";
            return this;
        }

        public String getDomesticCarrierCodeFormattingRule() {
            return this.domesticCarrierCodeFormattingRule_;
        }

        public String getFormat() {
            return this.format_;
        }

        public String getLeadingDigitsPattern(int n) {
            return (String)this.leadingDigitsPattern_.get(n);
        }

        public String getNationalPrefixFormattingRule() {
            return this.nationalPrefixFormattingRule_;
        }

        public String getPattern() {
            return this.pattern_;
        }

        public boolean hasDomesticCarrierCodeFormattingRule() {
            return this.hasDomesticCarrierCodeFormattingRule;
        }

        public boolean hasFormat() {
            return this.hasFormat;
        }

        public boolean hasNationalPrefixFormattingRule() {
            return this.hasNationalPrefixFormattingRule;
        }

        public boolean hasNationalPrefixOptionalWhenFormatting() {
            return this.hasNationalPrefixOptionalWhenFormatting;
        }

        public boolean hasPattern() {
            return this.hasPattern;
        }

        public boolean isNationalPrefixOptionalWhenFormatting() {
            return this.nationalPrefixOptionalWhenFormatting_;
        }

        public List<String> leadingDigitPatterns() {
            return this.leadingDigitsPattern_;
        }

        public int leadingDigitsPatternSize() {
            return this.leadingDigitsPattern_.size();
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            this.setPattern(objectInput.readUTF());
            this.setFormat(objectInput.readUTF());
            int n = objectInput.readInt();
            for (int i = 0; i < n; ++i) {
                this.leadingDigitsPattern_.add((Object)objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                this.setNationalPrefixFormattingRule(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                this.setDomesticCarrierCodeFormattingRule(objectInput.readUTF());
            }
            this.setNationalPrefixOptionalWhenFormatting(objectInput.readBoolean());
        }

        public NumberFormat setDomesticCarrierCodeFormattingRule(String string2) {
            this.hasDomesticCarrierCodeFormattingRule = true;
            this.domesticCarrierCodeFormattingRule_ = string2;
            return this;
        }

        public NumberFormat setFormat(String string2) {
            this.hasFormat = true;
            this.format_ = string2;
            return this;
        }

        public NumberFormat setNationalPrefixFormattingRule(String string2) {
            this.hasNationalPrefixFormattingRule = true;
            this.nationalPrefixFormattingRule_ = string2;
            return this;
        }

        public NumberFormat setNationalPrefixOptionalWhenFormatting(boolean bl) {
            this.hasNationalPrefixOptionalWhenFormatting = true;
            this.nationalPrefixOptionalWhenFormatting_ = bl;
            return this;
        }

        public NumberFormat setPattern(String string2) {
            this.hasPattern = true;
            this.pattern_ = string2;
            return this;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeUTF(this.pattern_);
            objectOutput.writeUTF(this.format_);
            int n = this.leadingDigitsPatternSize();
            objectOutput.writeInt(n);
            for (int i = 0; i < n; ++i) {
                objectOutput.writeUTF((String)this.leadingDigitsPattern_.get(i));
            }
            objectOutput.writeBoolean(this.hasNationalPrefixFormattingRule);
            if (this.hasNationalPrefixFormattingRule) {
                objectOutput.writeUTF(this.nationalPrefixFormattingRule_);
            }
            objectOutput.writeBoolean(this.hasDomesticCarrierCodeFormattingRule);
            if (this.hasDomesticCarrierCodeFormattingRule) {
                objectOutput.writeUTF(this.domesticCarrierCodeFormattingRule_);
            }
            objectOutput.writeBoolean(this.nationalPrefixOptionalWhenFormatting_);
        }
    }

    /*
     * Exception performing whole class analysis.
     */
    public static class PhoneMetadata
    implements Externalizable {
        private static final long serialVersionUID = 1L;
        private PhoneNumberDesc carrierSpecific_;
        private int countryCode_;
        private PhoneNumberDesc emergency_;
        private PhoneNumberDesc fixedLine_;
        private PhoneNumberDesc generalDesc_;
        private boolean hasCarrierSpecific;
        private boolean hasCountryCode;
        private boolean hasEmergency;
        private boolean hasFixedLine;
        private boolean hasGeneralDesc;
        private boolean hasId;
        private boolean hasInternationalPrefix;
        private boolean hasLeadingDigits;
        private boolean hasLeadingZeroPossible;
        private boolean hasMainCountryForCode;
        private boolean hasMobile;
        private boolean hasMobileNumberPortableRegion;
        private boolean hasNationalPrefix;
        private boolean hasNationalPrefixForParsing;
        private boolean hasNationalPrefixTransformRule;
        private boolean hasNoInternationalDialling;
        private boolean hasPager;
        private boolean hasPersonalNumber;
        private boolean hasPreferredExtnPrefix;
        private boolean hasPreferredInternationalPrefix;
        private boolean hasPremiumRate;
        private boolean hasSameMobileAndFixedLinePattern;
        private boolean hasSharedCost;
        private boolean hasShortCode;
        private boolean hasStandardRate;
        private boolean hasTollFree;
        private boolean hasUan;
        private boolean hasVoicemail;
        private boolean hasVoip;
        private String id_;
        private String internationalPrefix_;
        private List<NumberFormat> intlNumberFormat_;
        private String leadingDigits_;
        private boolean leadingZeroPossible_;
        private boolean mainCountryForCode_;
        private boolean mobileNumberPortableRegion_;
        private PhoneNumberDesc mobile_;
        private String nationalPrefixForParsing_;
        private String nationalPrefixTransformRule_;
        private String nationalPrefix_;
        private PhoneNumberDesc noInternationalDialling_;
        private List<NumberFormat> numberFormat_;
        private PhoneNumberDesc pager_;
        private PhoneNumberDesc personalNumber_;
        private String preferredExtnPrefix_;
        private String preferredInternationalPrefix_;
        private PhoneNumberDesc premiumRate_;
        private boolean sameMobileAndFixedLinePattern_;
        private PhoneNumberDesc sharedCost_;
        private PhoneNumberDesc shortCode_;
        private PhoneNumberDesc standardRate_;
        private PhoneNumberDesc tollFree_;
        private PhoneNumberDesc uan_;
        private PhoneNumberDesc voicemail_;
        private PhoneNumberDesc voip_;

        public PhoneMetadata() {
            this.generalDesc_ = null;
            this.fixedLine_ = null;
            this.mobile_ = null;
            this.tollFree_ = null;
            this.premiumRate_ = null;
            this.sharedCost_ = null;
            this.personalNumber_ = null;
            this.voip_ = null;
            this.pager_ = null;
            this.uan_ = null;
            this.emergency_ = null;
            this.voicemail_ = null;
            this.shortCode_ = null;
            this.standardRate_ = null;
            this.carrierSpecific_ = null;
            this.noInternationalDialling_ = null;
            this.id_ = "";
            this.countryCode_ = 0;
            this.internationalPrefix_ = "";
            this.preferredInternationalPrefix_ = "";
            this.nationalPrefix_ = "";
            this.preferredExtnPrefix_ = "";
            this.nationalPrefixForParsing_ = "";
            this.nationalPrefixTransformRule_ = "";
            this.sameMobileAndFixedLinePattern_ = false;
            this.numberFormat_ = new ArrayList();
            this.intlNumberFormat_ = new ArrayList();
            this.mainCountryForCode_ = false;
            this.leadingDigits_ = "";
            this.leadingZeroPossible_ = false;
            this.mobileNumberPortableRegion_ = false;
        }

        public static Builder newBuilder() {
            return new /* Unavailable Anonymous Inner Class!! */;
        }

        public PhoneMetadata addIntlNumberFormat(NumberFormat numberFormat) {
            if (numberFormat != null) {
                this.intlNumberFormat_.add((Object)numberFormat);
                return this;
            }
            throw null;
        }

        public PhoneMetadata addNumberFormat(NumberFormat numberFormat) {
            if (numberFormat != null) {
                this.numberFormat_.add((Object)numberFormat);
                return this;
            }
            throw null;
        }

        public PhoneMetadata clearIntlNumberFormat() {
            this.intlNumberFormat_.clear();
            return this;
        }

        public PhoneMetadata clearLeadingZeroPossible() {
            this.hasLeadingZeroPossible = false;
            this.leadingZeroPossible_ = false;
            return this;
        }

        public PhoneMetadata clearMainCountryForCode() {
            this.hasMainCountryForCode = false;
            this.mainCountryForCode_ = false;
            return this;
        }

        public PhoneMetadata clearMobileNumberPortableRegion() {
            this.hasMobileNumberPortableRegion = false;
            this.mobileNumberPortableRegion_ = false;
            return this;
        }

        public PhoneMetadata clearNationalPrefix() {
            this.hasNationalPrefix = false;
            this.nationalPrefix_ = "";
            return this;
        }

        public PhoneMetadata clearNationalPrefixTransformRule() {
            this.hasNationalPrefixTransformRule = false;
            this.nationalPrefixTransformRule_ = "";
            return this;
        }

        public PhoneMetadata clearPreferredExtnPrefix() {
            this.hasPreferredExtnPrefix = false;
            this.preferredExtnPrefix_ = "";
            return this;
        }

        public PhoneMetadata clearPreferredInternationalPrefix() {
            this.hasPreferredInternationalPrefix = false;
            this.preferredInternationalPrefix_ = "";
            return this;
        }

        public PhoneMetadata clearSameMobileAndFixedLinePattern() {
            this.hasSameMobileAndFixedLinePattern = false;
            this.sameMobileAndFixedLinePattern_ = false;
            return this;
        }

        public PhoneNumberDesc getCarrierSpecific() {
            return this.carrierSpecific_;
        }

        public int getCountryCode() {
            return this.countryCode_;
        }

        public PhoneNumberDesc getEmergency() {
            return this.emergency_;
        }

        public PhoneNumberDesc getFixedLine() {
            return this.fixedLine_;
        }

        public PhoneNumberDesc getGeneralDesc() {
            return this.generalDesc_;
        }

        public String getId() {
            return this.id_;
        }

        public String getInternationalPrefix() {
            return this.internationalPrefix_;
        }

        public NumberFormat getIntlNumberFormat(int n) {
            return (NumberFormat)this.intlNumberFormat_.get(n);
        }

        public String getLeadingDigits() {
            return this.leadingDigits_;
        }

        public boolean getMainCountryForCode() {
            return this.mainCountryForCode_;
        }

        public PhoneNumberDesc getMobile() {
            return this.mobile_;
        }

        public String getNationalPrefix() {
            return this.nationalPrefix_;
        }

        public String getNationalPrefixForParsing() {
            return this.nationalPrefixForParsing_;
        }

        public String getNationalPrefixTransformRule() {
            return this.nationalPrefixTransformRule_;
        }

        public PhoneNumberDesc getNoInternationalDialling() {
            return this.noInternationalDialling_;
        }

        public NumberFormat getNumberFormat(int n) {
            return (NumberFormat)this.numberFormat_.get(n);
        }

        public PhoneNumberDesc getPager() {
            return this.pager_;
        }

        public PhoneNumberDesc getPersonalNumber() {
            return this.personalNumber_;
        }

        public String getPreferredExtnPrefix() {
            return this.preferredExtnPrefix_;
        }

        public String getPreferredInternationalPrefix() {
            return this.preferredInternationalPrefix_;
        }

        public PhoneNumberDesc getPremiumRate() {
            return this.premiumRate_;
        }

        public PhoneNumberDesc getSharedCost() {
            return this.sharedCost_;
        }

        public PhoneNumberDesc getShortCode() {
            return this.shortCode_;
        }

        public PhoneNumberDesc getStandardRate() {
            return this.standardRate_;
        }

        public PhoneNumberDesc getTollFree() {
            return this.tollFree_;
        }

        public PhoneNumberDesc getUan() {
            return this.uan_;
        }

        public PhoneNumberDesc getVoicemail() {
            return this.voicemail_;
        }

        public PhoneNumberDesc getVoip() {
            return this.voip_;
        }

        public boolean hasCarrierSpecific() {
            return this.hasCarrierSpecific;
        }

        public boolean hasCountryCode() {
            return this.hasCountryCode;
        }

        public boolean hasEmergency() {
            return this.hasEmergency;
        }

        public boolean hasFixedLine() {
            return this.hasFixedLine;
        }

        public boolean hasGeneralDesc() {
            return this.hasGeneralDesc;
        }

        public boolean hasId() {
            return this.hasId;
        }

        public boolean hasInternationalPrefix() {
            return this.hasInternationalPrefix;
        }

        public boolean hasLeadingDigits() {
            return this.hasLeadingDigits;
        }

        public boolean hasLeadingZeroPossible() {
            return this.hasLeadingZeroPossible;
        }

        public boolean hasMainCountryForCode() {
            return this.hasMainCountryForCode;
        }

        public boolean hasMobile() {
            return this.hasMobile;
        }

        public boolean hasMobileNumberPortableRegion() {
            return this.hasMobileNumberPortableRegion;
        }

        public boolean hasNationalPrefix() {
            return this.hasNationalPrefix;
        }

        public boolean hasNationalPrefixForParsing() {
            return this.hasNationalPrefixForParsing;
        }

        public boolean hasNationalPrefixTransformRule() {
            return this.hasNationalPrefixTransformRule;
        }

        public boolean hasNoInternationalDialling() {
            return this.hasNoInternationalDialling;
        }

        public boolean hasPager() {
            return this.hasPager;
        }

        public boolean hasPersonalNumber() {
            return this.hasPersonalNumber;
        }

        public boolean hasPreferredExtnPrefix() {
            return this.hasPreferredExtnPrefix;
        }

        public boolean hasPreferredInternationalPrefix() {
            return this.hasPreferredInternationalPrefix;
        }

        public boolean hasPremiumRate() {
            return this.hasPremiumRate;
        }

        public boolean hasSameMobileAndFixedLinePattern() {
            return this.hasSameMobileAndFixedLinePattern;
        }

        public boolean hasSharedCost() {
            return this.hasSharedCost;
        }

        public boolean hasShortCode() {
            return this.hasShortCode;
        }

        public boolean hasStandardRate() {
            return this.hasStandardRate;
        }

        public boolean hasTollFree() {
            return this.hasTollFree;
        }

        public boolean hasUan() {
            return this.hasUan;
        }

        public boolean hasVoicemail() {
            return this.hasVoicemail;
        }

        public boolean hasVoip() {
            return this.hasVoip;
        }

        public int intlNumberFormatSize() {
            return this.intlNumberFormat_.size();
        }

        public List<NumberFormat> intlNumberFormats() {
            return this.intlNumberFormat_;
        }

        public boolean isLeadingZeroPossible() {
            return this.leadingZeroPossible_;
        }

        public boolean isMainCountryForCode() {
            return this.mainCountryForCode_;
        }

        public boolean isMobileNumberPortableRegion() {
            return this.mobileNumberPortableRegion_;
        }

        public boolean isSameMobileAndFixedLinePattern() {
            return this.sameMobileAndFixedLinePattern_;
        }

        public int numberFormatSize() {
            return this.numberFormat_.size();
        }

        public List<NumberFormat> numberFormats() {
            return this.numberFormat_;
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                this.setGeneralDesc(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                this.setFixedLine(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                this.setMobile(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                this.setTollFree(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                this.setPremiumRate(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                this.setSharedCost(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                this.setPersonalNumber(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                this.setVoip(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                this.setPager(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                this.setUan(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                this.setEmergency(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                this.setVoicemail(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                this.setShortCode(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                this.setStandardRate(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                this.setCarrierSpecific(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                this.setNoInternationalDialling(phoneNumberDesc);
            }
            this.setId(objectInput.readUTF());
            this.setCountryCode(objectInput.readInt());
            this.setInternationalPrefix(objectInput.readUTF());
            if (objectInput.readBoolean()) {
                this.setPreferredInternationalPrefix(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                this.setNationalPrefix(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                this.setPreferredExtnPrefix(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                this.setNationalPrefixForParsing(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                this.setNationalPrefixTransformRule(objectInput.readUTF());
            }
            this.setSameMobileAndFixedLinePattern(objectInput.readBoolean());
            int n = objectInput.readInt();
            int n2 = 0;
            for (int i = 0; i < n; ++i) {
                NumberFormat numberFormat = new NumberFormat();
                numberFormat.readExternal(objectInput);
                this.numberFormat_.add((Object)numberFormat);
            }
            int n3 = objectInput.readInt();
            while (n2 < n3) {
                NumberFormat numberFormat = new NumberFormat();
                numberFormat.readExternal(objectInput);
                this.intlNumberFormat_.add((Object)numberFormat);
                ++n2;
            }
            this.setMainCountryForCode(objectInput.readBoolean());
            if (objectInput.readBoolean()) {
                this.setLeadingDigits(objectInput.readUTF());
            }
            this.setLeadingZeroPossible(objectInput.readBoolean());
            this.setMobileNumberPortableRegion(objectInput.readBoolean());
        }

        public PhoneMetadata setCarrierSpecific(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc != null) {
                this.hasCarrierSpecific = true;
                this.carrierSpecific_ = phoneNumberDesc;
                return this;
            }
            throw null;
        }

        public PhoneMetadata setCountryCode(int n) {
            this.hasCountryCode = true;
            this.countryCode_ = n;
            return this;
        }

        public PhoneMetadata setEmergency(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc != null) {
                this.hasEmergency = true;
                this.emergency_ = phoneNumberDesc;
                return this;
            }
            throw null;
        }

        public PhoneMetadata setFixedLine(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc != null) {
                this.hasFixedLine = true;
                this.fixedLine_ = phoneNumberDesc;
                return this;
            }
            throw null;
        }

        public PhoneMetadata setGeneralDesc(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc != null) {
                this.hasGeneralDesc = true;
                this.generalDesc_ = phoneNumberDesc;
                return this;
            }
            throw null;
        }

        public PhoneMetadata setId(String string2) {
            this.hasId = true;
            this.id_ = string2;
            return this;
        }

        public PhoneMetadata setInternationalPrefix(String string2) {
            this.hasInternationalPrefix = true;
            this.internationalPrefix_ = string2;
            return this;
        }

        public PhoneMetadata setLeadingDigits(String string2) {
            this.hasLeadingDigits = true;
            this.leadingDigits_ = string2;
            return this;
        }

        public PhoneMetadata setLeadingZeroPossible(boolean bl) {
            this.hasLeadingZeroPossible = true;
            this.leadingZeroPossible_ = bl;
            return this;
        }

        public PhoneMetadata setMainCountryForCode(boolean bl) {
            this.hasMainCountryForCode = true;
            this.mainCountryForCode_ = bl;
            return this;
        }

        public PhoneMetadata setMobile(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc != null) {
                this.hasMobile = true;
                this.mobile_ = phoneNumberDesc;
                return this;
            }
            throw null;
        }

        public PhoneMetadata setMobileNumberPortableRegion(boolean bl) {
            this.hasMobileNumberPortableRegion = true;
            this.mobileNumberPortableRegion_ = bl;
            return this;
        }

        public PhoneMetadata setNationalPrefix(String string2) {
            this.hasNationalPrefix = true;
            this.nationalPrefix_ = string2;
            return this;
        }

        public PhoneMetadata setNationalPrefixForParsing(String string2) {
            this.hasNationalPrefixForParsing = true;
            this.nationalPrefixForParsing_ = string2;
            return this;
        }

        public PhoneMetadata setNationalPrefixTransformRule(String string2) {
            this.hasNationalPrefixTransformRule = true;
            this.nationalPrefixTransformRule_ = string2;
            return this;
        }

        public PhoneMetadata setNoInternationalDialling(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc != null) {
                this.hasNoInternationalDialling = true;
                this.noInternationalDialling_ = phoneNumberDesc;
                return this;
            }
            throw null;
        }

        public PhoneMetadata setPager(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc != null) {
                this.hasPager = true;
                this.pager_ = phoneNumberDesc;
                return this;
            }
            throw null;
        }

        public PhoneMetadata setPersonalNumber(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc != null) {
                this.hasPersonalNumber = true;
                this.personalNumber_ = phoneNumberDesc;
                return this;
            }
            throw null;
        }

        public PhoneMetadata setPreferredExtnPrefix(String string2) {
            this.hasPreferredExtnPrefix = true;
            this.preferredExtnPrefix_ = string2;
            return this;
        }

        public PhoneMetadata setPreferredInternationalPrefix(String string2) {
            this.hasPreferredInternationalPrefix = true;
            this.preferredInternationalPrefix_ = string2;
            return this;
        }

        public PhoneMetadata setPremiumRate(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc != null) {
                this.hasPremiumRate = true;
                this.premiumRate_ = phoneNumberDesc;
                return this;
            }
            throw null;
        }

        public PhoneMetadata setSameMobileAndFixedLinePattern(boolean bl) {
            this.hasSameMobileAndFixedLinePattern = true;
            this.sameMobileAndFixedLinePattern_ = bl;
            return this;
        }

        public PhoneMetadata setSharedCost(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc != null) {
                this.hasSharedCost = true;
                this.sharedCost_ = phoneNumberDesc;
                return this;
            }
            throw null;
        }

        public PhoneMetadata setShortCode(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc != null) {
                this.hasShortCode = true;
                this.shortCode_ = phoneNumberDesc;
                return this;
            }
            throw null;
        }

        public PhoneMetadata setStandardRate(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc != null) {
                this.hasStandardRate = true;
                this.standardRate_ = phoneNumberDesc;
                return this;
            }
            throw null;
        }

        public PhoneMetadata setTollFree(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc != null) {
                this.hasTollFree = true;
                this.tollFree_ = phoneNumberDesc;
                return this;
            }
            throw null;
        }

        public PhoneMetadata setUan(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc != null) {
                this.hasUan = true;
                this.uan_ = phoneNumberDesc;
                return this;
            }
            throw null;
        }

        public PhoneMetadata setVoicemail(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc != null) {
                this.hasVoicemail = true;
                this.voicemail_ = phoneNumberDesc;
                return this;
            }
            throw null;
        }

        public PhoneMetadata setVoip(PhoneNumberDesc phoneNumberDesc) {
            if (phoneNumberDesc != null) {
                this.hasVoip = true;
                this.voip_ = phoneNumberDesc;
                return this;
            }
            throw null;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeBoolean(this.hasGeneralDesc);
            if (this.hasGeneralDesc) {
                this.generalDesc_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasFixedLine);
            if (this.hasFixedLine) {
                this.fixedLine_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasMobile);
            if (this.hasMobile) {
                this.mobile_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasTollFree);
            if (this.hasTollFree) {
                this.tollFree_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasPremiumRate);
            if (this.hasPremiumRate) {
                this.premiumRate_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasSharedCost);
            if (this.hasSharedCost) {
                this.sharedCost_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasPersonalNumber);
            if (this.hasPersonalNumber) {
                this.personalNumber_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasVoip);
            if (this.hasVoip) {
                this.voip_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasPager);
            if (this.hasPager) {
                this.pager_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasUan);
            if (this.hasUan) {
                this.uan_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasEmergency);
            if (this.hasEmergency) {
                this.emergency_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasVoicemail);
            if (this.hasVoicemail) {
                this.voicemail_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasShortCode);
            if (this.hasShortCode) {
                this.shortCode_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasStandardRate);
            if (this.hasStandardRate) {
                this.standardRate_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasCarrierSpecific);
            if (this.hasCarrierSpecific) {
                this.carrierSpecific_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasNoInternationalDialling);
            if (this.hasNoInternationalDialling) {
                this.noInternationalDialling_.writeExternal(objectOutput);
            }
            objectOutput.writeUTF(this.id_);
            objectOutput.writeInt(this.countryCode_);
            objectOutput.writeUTF(this.internationalPrefix_);
            objectOutput.writeBoolean(this.hasPreferredInternationalPrefix);
            if (this.hasPreferredInternationalPrefix) {
                objectOutput.writeUTF(this.preferredInternationalPrefix_);
            }
            objectOutput.writeBoolean(this.hasNationalPrefix);
            if (this.hasNationalPrefix) {
                objectOutput.writeUTF(this.nationalPrefix_);
            }
            objectOutput.writeBoolean(this.hasPreferredExtnPrefix);
            if (this.hasPreferredExtnPrefix) {
                objectOutput.writeUTF(this.preferredExtnPrefix_);
            }
            objectOutput.writeBoolean(this.hasNationalPrefixForParsing);
            if (this.hasNationalPrefixForParsing) {
                objectOutput.writeUTF(this.nationalPrefixForParsing_);
            }
            objectOutput.writeBoolean(this.hasNationalPrefixTransformRule);
            if (this.hasNationalPrefixTransformRule) {
                objectOutput.writeUTF(this.nationalPrefixTransformRule_);
            }
            objectOutput.writeBoolean(this.sameMobileAndFixedLinePattern_);
            int n = this.numberFormatSize();
            objectOutput.writeInt(n);
            int n2 = 0;
            for (int i = 0; i < n; ++i) {
                ((NumberFormat)this.numberFormat_.get(i)).writeExternal(objectOutput);
            }
            int n3 = this.intlNumberFormatSize();
            objectOutput.writeInt(n3);
            while (n2 < n3) {
                ((NumberFormat)this.intlNumberFormat_.get(n2)).writeExternal(objectOutput);
                ++n2;
            }
            objectOutput.writeBoolean(this.mainCountryForCode_);
            objectOutput.writeBoolean(this.hasLeadingDigits);
            if (this.hasLeadingDigits) {
                objectOutput.writeUTF(this.leadingDigits_);
            }
            objectOutput.writeBoolean(this.leadingZeroPossible_);
            objectOutput.writeBoolean(this.mobileNumberPortableRegion_);
        }
    }

    /*
     * Exception performing whole class analysis.
     */
    public static class PhoneMetadataCollection
    implements Externalizable {
        private static final long serialVersionUID = 1L;
        private List<PhoneMetadata> metadata_;

        public PhoneMetadataCollection() {
            this.metadata_ = new ArrayList();
        }

        public static Builder newBuilder() {
            return new /* Unavailable Anonymous Inner Class!! */;
        }

        public PhoneMetadataCollection addMetadata(PhoneMetadata phoneMetadata) {
            if (phoneMetadata != null) {
                this.metadata_.add((Object)phoneMetadata);
                return this;
            }
            throw null;
        }

        public PhoneMetadataCollection clear() {
            this.metadata_.clear();
            return this;
        }

        public int getMetadataCount() {
            return this.metadata_.size();
        }

        public List<PhoneMetadata> getMetadataList() {
            return this.metadata_;
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            int n = objectInput.readInt();
            for (int i = 0; i < n; ++i) {
                PhoneMetadata phoneMetadata = new PhoneMetadata();
                phoneMetadata.readExternal(objectInput);
                this.metadata_.add((Object)phoneMetadata);
            }
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            int n = this.getMetadataCount();
            objectOutput.writeInt(n);
            for (int i = 0; i < n; ++i) {
                ((PhoneMetadata)this.metadata_.get(i)).writeExternal(objectOutput);
            }
        }
    }

    /*
     * Exception performing whole class analysis.
     */
    public static class PhoneNumberDesc
    implements Externalizable {
        private static final long serialVersionUID = 1L;
        private String exampleNumber_;
        private boolean hasExampleNumber;
        private boolean hasNationalNumberPattern;
        private boolean hasPossibleNumberPattern;
        private String nationalNumberPattern_;
        private List<Integer> possibleLengthLocalOnly_;
        private List<Integer> possibleLength_;
        private String possibleNumberPattern_;

        public PhoneNumberDesc() {
            this.nationalNumberPattern_ = "";
            this.possibleNumberPattern_ = "";
            this.possibleLength_ = new ArrayList();
            this.possibleLengthLocalOnly_ = new ArrayList();
            this.exampleNumber_ = "";
        }

        public static Builder newBuilder() {
            return new /* Unavailable Anonymous Inner Class!! */;
        }

        public PhoneNumberDesc addPossibleLength(int n) {
            this.possibleLength_.add((Object)n);
            return this;
        }

        public PhoneNumberDesc addPossibleLengthLocalOnly(int n) {
            this.possibleLengthLocalOnly_.add((Object)n);
            return this;
        }

        public PhoneNumberDesc clearExampleNumber() {
            this.hasExampleNumber = false;
            this.exampleNumber_ = "";
            return this;
        }

        public PhoneNumberDesc clearNationalNumberPattern() {
            this.hasNationalNumberPattern = false;
            this.nationalNumberPattern_ = "";
            return this;
        }

        public PhoneNumberDesc clearPossibleLength() {
            this.possibleLength_.clear();
            return this;
        }

        public PhoneNumberDesc clearPossibleLengthLocalOnly() {
            this.possibleLengthLocalOnly_.clear();
            return this;
        }

        public PhoneNumberDesc clearPossibleNumberPattern() {
            this.hasPossibleNumberPattern = false;
            this.possibleNumberPattern_ = "";
            return this;
        }

        public boolean exactlySameAs(PhoneNumberDesc phoneNumberDesc) {
            return this.nationalNumberPattern_.equals((Object)phoneNumberDesc.nationalNumberPattern_) && this.possibleNumberPattern_.equals((Object)phoneNumberDesc.possibleNumberPattern_) && this.possibleLength_.equals(phoneNumberDesc.possibleLength_) && this.possibleLengthLocalOnly_.equals(phoneNumberDesc.possibleLengthLocalOnly_) && this.exampleNumber_.equals((Object)phoneNumberDesc.exampleNumber_);
        }

        public String getExampleNumber() {
            return this.exampleNumber_;
        }

        public String getNationalNumberPattern() {
            return this.nationalNumberPattern_;
        }

        public int getPossibleLength(int n) {
            return (Integer)this.possibleLength_.get(n);
        }

        public int getPossibleLengthCount() {
            return this.possibleLength_.size();
        }

        public List<Integer> getPossibleLengthList() {
            return this.possibleLength_;
        }

        public int getPossibleLengthLocalOnly(int n) {
            return (Integer)this.possibleLengthLocalOnly_.get(n);
        }

        public int getPossibleLengthLocalOnlyCount() {
            return this.possibleLengthLocalOnly_.size();
        }

        public List<Integer> getPossibleLengthLocalOnlyList() {
            return this.possibleLengthLocalOnly_;
        }

        public String getPossibleNumberPattern() {
            return this.possibleNumberPattern_;
        }

        public boolean hasExampleNumber() {
            return this.hasExampleNumber;
        }

        public boolean hasNationalNumberPattern() {
            return this.hasNationalNumberPattern;
        }

        public boolean hasPossibleNumberPattern() {
            return this.hasPossibleNumberPattern;
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readBoolean()) {
                this.setNationalNumberPattern(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                this.setPossibleNumberPattern(objectInput.readUTF());
            }
            int n = objectInput.readInt();
            int n2 = 0;
            for (int i = 0; i < n; ++i) {
                this.possibleLength_.add((Object)objectInput.readInt());
            }
            int n3 = objectInput.readInt();
            while (n2 < n3) {
                this.possibleLengthLocalOnly_.add((Object)objectInput.readInt());
                ++n2;
            }
            if (objectInput.readBoolean()) {
                this.setExampleNumber(objectInput.readUTF());
            }
        }

        public PhoneNumberDesc setExampleNumber(String string2) {
            this.hasExampleNumber = true;
            this.exampleNumber_ = string2;
            return this;
        }

        public PhoneNumberDesc setNationalNumberPattern(String string2) {
            this.hasNationalNumberPattern = true;
            this.nationalNumberPattern_ = string2;
            return this;
        }

        public PhoneNumberDesc setPossibleNumberPattern(String string2) {
            this.hasPossibleNumberPattern = true;
            this.possibleNumberPattern_ = string2;
            return this;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeBoolean(this.hasNationalNumberPattern);
            if (this.hasNationalNumberPattern) {
                objectOutput.writeUTF(this.nationalNumberPattern_);
            }
            objectOutput.writeBoolean(this.hasPossibleNumberPattern);
            if (this.hasPossibleNumberPattern) {
                objectOutput.writeUTF(this.possibleNumberPattern_);
            }
            int n = this.getPossibleLengthCount();
            objectOutput.writeInt(n);
            int n2 = 0;
            for (int i = 0; i < n; ++i) {
                objectOutput.writeInt(((Integer)this.possibleLength_.get(i)).intValue());
            }
            int n3 = this.getPossibleLengthLocalOnlyCount();
            objectOutput.writeInt(n3);
            while (n2 < n3) {
                objectOutput.writeInt(((Integer)this.possibleLengthLocalOnly_.get(n2)).intValue());
                ++n2;
            }
            objectOutput.writeBoolean(this.hasExampleNumber);
            if (this.hasExampleNumber) {
                objectOutput.writeUTF(this.exampleNumber_);
            }
        }
    }

}

