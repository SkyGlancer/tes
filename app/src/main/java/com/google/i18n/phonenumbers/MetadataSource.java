/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.src.java.com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.Phonemetadata;

interface MetadataSource {
    public Phonemetadata.PhoneMetadata getMetadataForNonGeographicalRegion(int var1);

    public Phonemetadata.PhoneMetadata getMetadataForRegion(String var1);
}

