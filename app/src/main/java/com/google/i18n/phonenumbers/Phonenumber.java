/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Enum
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package app.dukhaan.src.java.com.google.i18n.phonenumbers;

import java.io.Serializable;

public final class Phonenumber {
    private Phonenumber() {
    }

    public static class PhoneNumber
    implements Serializable {
        private static final long serialVersionUID = 1L;
        private CountryCodeSource countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        private int countryCode_ = 0;
        private String extension_ = "";
        private boolean hasCountryCode;
        private boolean hasCountryCodeSource;
        private boolean hasExtension;
        private boolean hasItalianLeadingZero;
        private boolean hasNationalNumber;
        private boolean hasNumberOfLeadingZeros;
        private boolean hasPreferredDomesticCarrierCode;
        private boolean hasRawInput;
        private boolean italianLeadingZero_ = false;
        private long nationalNumber_ = 0L;
        private int numberOfLeadingZeros_ = 1;
        private String preferredDomesticCarrierCode_ = "";
        private String rawInput_ = "";

        public final PhoneNumber clear() {
            this.clearCountryCode();
            this.clearNationalNumber();
            this.clearExtension();
            this.clearItalianLeadingZero();
            this.clearNumberOfLeadingZeros();
            this.clearRawInput();
            this.clearCountryCodeSource();
            this.clearPreferredDomesticCarrierCode();
            return this;
        }

        public PhoneNumber clearCountryCode() {
            this.hasCountryCode = false;
            this.countryCode_ = 0;
            return this;
        }

        public PhoneNumber clearCountryCodeSource() {
            this.hasCountryCodeSource = false;
            this.countryCodeSource_ = CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
            return this;
        }

        public PhoneNumber clearExtension() {
            this.hasExtension = false;
            this.extension_ = "";
            return this;
        }

        public PhoneNumber clearItalianLeadingZero() {
            this.hasItalianLeadingZero = false;
            this.italianLeadingZero_ = false;
            return this;
        }

        public PhoneNumber clearNationalNumber() {
            this.hasNationalNumber = false;
            this.nationalNumber_ = 0L;
            return this;
        }

        public PhoneNumber clearNumberOfLeadingZeros() {
            this.hasNumberOfLeadingZeros = false;
            this.numberOfLeadingZeros_ = 1;
            return this;
        }

        public PhoneNumber clearPreferredDomesticCarrierCode() {
            this.hasPreferredDomesticCarrierCode = false;
            this.preferredDomesticCarrierCode_ = "";
            return this;
        }

        public PhoneNumber clearRawInput() {
            this.hasRawInput = false;
            this.rawInput_ = "";
            return this;
        }

        public boolean equals(Object object) {
            return object instanceof PhoneNumber && this.exactlySameAs((PhoneNumber)object);
        }

        public boolean exactlySameAs(PhoneNumber phoneNumber) {
            if (phoneNumber == null) {
                return false;
            }
            if (this == phoneNumber) {
                return true;
            }
            int n = this.countryCode_;
            int n2 = phoneNumber.countryCode_;
            boolean bl = false;
            if (n == n2) {
                long l = this.nationalNumber_ LCMP phoneNumber.nationalNumber_;
                bl = false;
                if (l == false) {
                    boolean bl2 = this.extension_.equals((Object)phoneNumber.extension_);
                    bl = false;
                    if (bl2) {
                        boolean bl3 = this.italianLeadingZero_;
                        boolean bl4 = phoneNumber.italianLeadingZero_;
                        bl = false;
                        if (bl3 == bl4) {
                            int n3 = this.numberOfLeadingZeros_;
                            int n4 = phoneNumber.numberOfLeadingZeros_;
                            bl = false;
                            if (n3 == n4) {
                                boolean bl5 = this.rawInput_.equals((Object)phoneNumber.rawInput_);
                                bl = false;
                                if (bl5) {
                                    CountryCodeSource countryCodeSource = this.countryCodeSource_;
                                    CountryCodeSource countryCodeSource2 = phoneNumber.countryCodeSource_;
                                    bl = false;
                                    if (countryCodeSource == countryCodeSource2) {
                                        boolean bl6 = this.preferredDomesticCarrierCode_.equals((Object)phoneNumber.preferredDomesticCarrierCode_);
                                        bl = false;
                                        if (bl6) {
                                            boolean bl7 = this.hasPreferredDomesticCarrierCode();
                                            boolean bl8 = phoneNumber.hasPreferredDomesticCarrierCode();
                                            bl = false;
                                            if (bl7 == bl8) {
                                                bl = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return bl;
        }

        public int getCountryCode() {
            return this.countryCode_;
        }

        public CountryCodeSource getCountryCodeSource() {
            return this.countryCodeSource_;
        }

        public String getExtension() {
            return this.extension_;
        }

        public long getNationalNumber() {
            return this.nationalNumber_;
        }

        public int getNumberOfLeadingZeros() {
            return this.numberOfLeadingZeros_;
        }

        public String getPreferredDomesticCarrierCode() {
            return this.preferredDomesticCarrierCode_;
        }

        public String getRawInput() {
            return this.rawInput_;
        }

        public boolean hasCountryCode() {
            return this.hasCountryCode;
        }

        public boolean hasCountryCodeSource() {
            return this.hasCountryCodeSource;
        }

        public boolean hasExtension() {
            return this.hasExtension;
        }

        public boolean hasItalianLeadingZero() {
            return this.hasItalianLeadingZero;
        }

        public boolean hasNationalNumber() {
            return this.hasNationalNumber;
        }

        public boolean hasNumberOfLeadingZeros() {
            return this.hasNumberOfLeadingZeros;
        }

        public boolean hasPreferredDomesticCarrierCode() {
            return this.hasPreferredDomesticCarrierCode;
        }

        public boolean hasRawInput() {
            return this.hasRawInput;
        }

        public int hashCode() {
            int n = 53 * (53 * (53 * (2173 + this.getCountryCode()) + Long.valueOf((long)this.getNationalNumber()).hashCode()) + this.getExtension().hashCode());
            boolean bl = this.isItalianLeadingZero();
            int n2 = 1231;
            int n3 = bl ? 1231 : 1237;
            int n4 = 53 * (53 * (53 * (53 * (53 * (n + n3) + this.getNumberOfLeadingZeros()) + this.getRawInput().hashCode()) + this.getCountryCodeSource().hashCode()) + this.getPreferredDomesticCarrierCode().hashCode());
            if (!this.hasPreferredDomesticCarrierCode()) {
                n2 = 1237;
            }
            return n4 + n2;
        }

        public boolean isItalianLeadingZero() {
            return this.italianLeadingZero_;
        }

        public PhoneNumber mergeFrom(PhoneNumber phoneNumber) {
            if (phoneNumber.hasCountryCode()) {
                this.setCountryCode(phoneNumber.getCountryCode());
            }
            if (phoneNumber.hasNationalNumber()) {
                this.setNationalNumber(phoneNumber.getNationalNumber());
            }
            if (phoneNumber.hasExtension()) {
                this.setExtension(phoneNumber.getExtension());
            }
            if (phoneNumber.hasItalianLeadingZero()) {
                this.setItalianLeadingZero(phoneNumber.isItalianLeadingZero());
            }
            if (phoneNumber.hasNumberOfLeadingZeros()) {
                this.setNumberOfLeadingZeros(phoneNumber.getNumberOfLeadingZeros());
            }
            if (phoneNumber.hasRawInput()) {
                this.setRawInput(phoneNumber.getRawInput());
            }
            if (phoneNumber.hasCountryCodeSource()) {
                this.setCountryCodeSource(phoneNumber.getCountryCodeSource());
            }
            if (phoneNumber.hasPreferredDomesticCarrierCode()) {
                this.setPreferredDomesticCarrierCode(phoneNumber.getPreferredDomesticCarrierCode());
            }
            return this;
        }

        public PhoneNumber setCountryCode(int n) {
            this.hasCountryCode = true;
            this.countryCode_ = n;
            return this;
        }

        public PhoneNumber setCountryCodeSource(CountryCodeSource countryCodeSource) {
            if (countryCodeSource != null) {
                this.hasCountryCodeSource = true;
                this.countryCodeSource_ = countryCodeSource;
                return this;
            }
            throw null;
        }

        public PhoneNumber setExtension(String string2) {
            if (string2 != null) {
                this.hasExtension = true;
                this.extension_ = string2;
                return this;
            }
            throw null;
        }

        public PhoneNumber setItalianLeadingZero(boolean bl) {
            this.hasItalianLeadingZero = true;
            this.italianLeadingZero_ = bl;
            return this;
        }

        public PhoneNumber setNationalNumber(long l) {
            this.hasNationalNumber = true;
            this.nationalNumber_ = l;
            return this;
        }

        public PhoneNumber setNumberOfLeadingZeros(int n) {
            this.hasNumberOfLeadingZeros = true;
            this.numberOfLeadingZeros_ = n;
            return this;
        }

        public PhoneNumber setPreferredDomesticCarrierCode(String string2) {
            if (string2 != null) {
                this.hasPreferredDomesticCarrierCode = true;
                this.preferredDomesticCarrierCode_ = string2;
                return this;
            }
            throw null;
        }

        public PhoneNumber setRawInput(String string2) {
            if (string2 != null) {
                this.hasRawInput = true;
                this.rawInput_ = string2;
                return this;
            }
            throw null;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Country Code: ");
            stringBuilder.append(this.countryCode_);
            stringBuilder.append(" National Number: ");
            stringBuilder.append(this.nationalNumber_);
            if (this.hasItalianLeadingZero() && this.isItalianLeadingZero()) {
                stringBuilder.append(" Leading Zero(s): true");
            }
            if (this.hasNumberOfLeadingZeros()) {
                stringBuilder.append(" Number of leading zeros: ");
                stringBuilder.append(this.numberOfLeadingZeros_);
            }
            if (this.hasExtension()) {
                stringBuilder.append(" Extension: ");
                stringBuilder.append(this.extension_);
            }
            if (this.hasCountryCodeSource()) {
                stringBuilder.append(" Country Code Source: ");
                stringBuilder.append((Object)this.countryCodeSource_);
            }
            if (this.hasPreferredDomesticCarrierCode()) {
                stringBuilder.append(" Preferred Domestic Carrier Code: ");
                stringBuilder.append(this.preferredDomesticCarrierCode_);
            }
            return stringBuilder.toString();
        }

        public static final class CountryCodeSource
        extends Enum<CountryCodeSource> {
            private static final /* synthetic */ CountryCodeSource[] $VALUES;
            public static final /* enum */ CountryCodeSource FROM_DEFAULT_COUNTRY;
            public static final /* enum */ CountryCodeSource FROM_NUMBER_WITHOUT_PLUS_SIGN;
            public static final /* enum */ CountryCodeSource FROM_NUMBER_WITH_IDD;
            public static final /* enum */ CountryCodeSource FROM_NUMBER_WITH_PLUS_SIGN;

            static {
                CountryCodeSource countryCodeSource;
                FROM_NUMBER_WITH_PLUS_SIGN = new CountryCodeSource();
                FROM_NUMBER_WITH_IDD = new CountryCodeSource();
                FROM_NUMBER_WITHOUT_PLUS_SIGN = new CountryCodeSource();
                FROM_DEFAULT_COUNTRY = countryCodeSource = new CountryCodeSource();
                CountryCodeSource[] arrcountryCodeSource = new CountryCodeSource[]{FROM_NUMBER_WITH_PLUS_SIGN, FROM_NUMBER_WITH_IDD, FROM_NUMBER_WITHOUT_PLUS_SIGN, countryCodeSource};
                $VALUES = arrcountryCodeSource;
            }

            public static CountryCodeSource valueOf(String string2) {
                return (CountryCodeSource)Enum.valueOf(CountryCodeSource.class, (String)string2);
            }

            public static CountryCodeSource[] values() {
                return (CountryCodeSource[])$VALUES.clone();
            }
        }

    }

}

