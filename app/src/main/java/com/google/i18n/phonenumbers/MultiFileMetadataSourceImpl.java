/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.concurrent.ConcurrentHashMap
 */
package app.dukhaan.src.java.com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.CountryCodeToRegionCodeMap;
import com.google.i18n.phonenumbers.MetadataLoader;
import com.google.i18n.phonenumbers.MetadataManager;
import com.google.i18n.phonenumbers.MetadataSource;
import com.google.i18n.phonenumbers.Phonemetadata;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

final class MultiFileMetadataSourceImpl
implements MetadataSource {
    private final ConcurrentHashMap<String, Phonemetadata.PhoneMetadata> geographicalRegions = new ConcurrentHashMap();
    private final MetadataLoader metadataLoader;
    private final ConcurrentHashMap<Integer, Phonemetadata.PhoneMetadata> nonGeographicalRegions = new ConcurrentHashMap();
    private final String phoneNumberMetadataFilePrefix;

    MultiFileMetadataSourceImpl(MetadataLoader metadataLoader) {
        this("/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto", metadataLoader);
    }

    MultiFileMetadataSourceImpl(String string2, MetadataLoader metadataLoader) {
        this.phoneNumberMetadataFilePrefix = string2;
        this.metadataLoader = metadataLoader;
    }

    private boolean isNonGeographical(int n) {
        List list = (List)CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap().get((Object)n);
        int n2 = list.size();
        boolean bl = false;
        if (n2 == 1) {
            boolean bl2 = "001".equals(list.get(0));
            bl = false;
            if (bl2) {
                bl = true;
            }
        }
        return bl;
    }

    @Override
    public Phonemetadata.PhoneMetadata getMetadataForNonGeographicalRegion(int n) {
        if (!this.isNonGeographical(n)) {
            return null;
        }
        return MetadataManager.getMetadataFromMultiFilePrefix(n, this.nonGeographicalRegions, this.phoneNumberMetadataFilePrefix, this.metadataLoader);
    }

    @Override
    public Phonemetadata.PhoneMetadata getMetadataForRegion(String string2) {
        return MetadataManager.getMetadataFromMultiFilePrefix(string2, this.geographicalRegions, this.phoneNumberMetadataFilePrefix, this.metadataLoader);
    }
}

