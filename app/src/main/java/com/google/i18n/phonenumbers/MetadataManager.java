/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.i18n.phonenumbers.MetadataManager$1
 *  java.io.InputStream
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.atomic.AtomicReference
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package app.dukhaan.src.java.com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.AlternateFormatsCountryCodeSet;
import com.google.i18n.phonenumbers.MetadataLoader;
import com.google.i18n.phonenumbers.MetadataManager;
import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.ShortNumbersRegionCodeSet;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

final class MetadataManager {
    private static final String ALTERNATE_FORMATS_FILE_PREFIX = "/com/google/i18n/phonenumbers/data/PhoneNumberAlternateFormatsProto";
    static final MetadataLoader DEFAULT_METADATA_LOADER = new 1();
    static final String MULTI_FILE_PHONE_NUMBER_METADATA_FILE_PREFIX = "/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto";
    private static final String SHORT_NUMBER_METADATA_FILE_PREFIX = "/com/google/i18n/phonenumbers/data/ShortNumberMetadataProto";
    static final String SINGLE_FILE_PHONE_NUMBER_METADATA_FILE_NAME = "/com/google/i18n/phonenumbers/data/SingleFilePhoneNumberMetadataProto";
    private static final Set<Integer> alternateFormatsCountryCodes;
    private static final ConcurrentHashMap<Integer, Phonemetadata.PhoneMetadata> alternateFormatsMap;
    private static final Logger logger;
    private static final ConcurrentHashMap<String, Phonemetadata.PhoneMetadata> shortNumberMetadataMap;
    private static final Set<String> shortNumberMetadataRegionCodes;

    static {
        logger = Logger.getLogger((String)MetadataManager.class.getName());
        alternateFormatsMap = new ConcurrentHashMap();
        shortNumberMetadataMap = new ConcurrentHashMap();
        alternateFormatsCountryCodes = AlternateFormatsCountryCodeSet.getCountryCodeSet();
        shortNumberMetadataRegionCodes = ShortNumbersRegionCodeSet.getRegionCodeSet();
    }

    private MetadataManager() {
    }

    static Phonemetadata.PhoneMetadata getAlternateFormatsForCountry(int n) {
        if (!alternateFormatsCountryCodes.contains((Object)n)) {
            return null;
        }
        return MetadataManager.getMetadataFromMultiFilePrefix(n, alternateFormatsMap, ALTERNATE_FORMATS_FILE_PREFIX, DEFAULT_METADATA_LOADER);
    }

    static <T> Phonemetadata.PhoneMetadata getMetadataFromMultiFilePrefix(T t, ConcurrentHashMap<T, Phonemetadata.PhoneMetadata> concurrentHashMap, String string2, MetadataLoader metadataLoader) {
        Phonemetadata.PhoneMetadata phoneMetadata;
        Phonemetadata.PhoneMetadata phoneMetadata2;
        Phonemetadata.PhoneMetadata phoneMetadata3 = (Phonemetadata.PhoneMetadata)concurrentHashMap.get(t);
        if (phoneMetadata3 != null) {
            return phoneMetadata3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("_");
        stringBuilder.append(t);
        String string3 = stringBuilder.toString();
        List<Phonemetadata.PhoneMetadata> list = MetadataManager.getMetadataFromSingleFileName(string3, metadataLoader);
        if (list.size() > 1) {
            Logger logger = MetadataManager.logger;
            Level level = Level.WARNING;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("more than one metadata in file ");
            stringBuilder2.append(string3);
            logger.log(level, stringBuilder2.toString());
        }
        if ((phoneMetadata2 = (Phonemetadata.PhoneMetadata)concurrentHashMap.putIfAbsent(t, (Object)(phoneMetadata = (Phonemetadata.PhoneMetadata)list.get(0)))) != null) {
            phoneMetadata = phoneMetadata2;
        }
        return phoneMetadata;
    }

    private static List<Phonemetadata.PhoneMetadata> getMetadataFromSingleFileName(String string2, MetadataLoader metadataLoader) {
        InputStream inputStream = metadataLoader.loadMetadata(string2);
        if (inputStream != null) {
            List<Phonemetadata.PhoneMetadata> list = MetadataManager.loadMetadataAndCloseInput(inputStream).getMetadataList();
            if (list.size() != 0) {
                return list;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("empty metadata: ");
            stringBuilder.append(string2);
            throw new IllegalStateException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("missing metadata: ");
        stringBuilder.append(string2);
        throw new IllegalStateException(stringBuilder.toString());
    }

    static Phonemetadata.PhoneMetadata getShortNumberMetadataForRegion(String string2) {
        if (!shortNumberMetadataRegionCodes.contains((Object)string2)) {
            return null;
        }
        return MetadataManager.getMetadataFromMultiFilePrefix(string2, shortNumberMetadataMap, SHORT_NUMBER_METADATA_FILE_PREFIX, DEFAULT_METADATA_LOADER);
    }

    static SingleFileMetadataMaps getSingleFileMetadataMaps(AtomicReference<SingleFileMetadataMaps> atomicReference, String string2, MetadataLoader metadataLoader) {
        SingleFileMetadataMaps singleFileMetadataMaps = (SingleFileMetadataMaps)atomicReference.get();
        if (singleFileMetadataMaps != null) {
            return singleFileMetadataMaps;
        }
        atomicReference.compareAndSet(null, (Object)SingleFileMetadataMaps.load(string2, metadataLoader));
        return (SingleFileMetadataMaps)atomicReference.get();
    }

    static Set<String> getSupportedShortNumberRegions() {
        return Collections.unmodifiableSet(shortNumberMetadataRegionCodes);
    }

    /*
     * Exception decompiling
     */
    private static Phonemetadata.PhoneMetadataCollection loadMetadataAndCloseInput(InputStream var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 8[CATCHBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

    static class SingleFileMetadataMaps {
        private final Map<Integer, Phonemetadata.PhoneMetadata> countryCallingCodeToMetadata;
        private final Map<String, Phonemetadata.PhoneMetadata> regionCodeToMetadata;

        private SingleFileMetadataMaps(Map<String, Phonemetadata.PhoneMetadata> map, Map<Integer, Phonemetadata.PhoneMetadata> map2) {
            this.regionCodeToMetadata = Collections.unmodifiableMap(map);
            this.countryCallingCodeToMetadata = Collections.unmodifiableMap(map2);
        }

        static SingleFileMetadataMaps load(String string2, MetadataLoader metadataLoader) {
            List list = MetadataManager.getMetadataFromSingleFileName(string2, metadataLoader);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            for (Phonemetadata.PhoneMetadata phoneMetadata : list) {
                String string3 = phoneMetadata.getId();
                if ("001".equals((Object)string3)) {
                    hashMap2.put((Object)phoneMetadata.getCountryCode(), (Object)phoneMetadata);
                    continue;
                }
                hashMap.put((Object)string3, (Object)phoneMetadata);
            }
            return new SingleFileMetadataMaps((Map<String, Phonemetadata.PhoneMetadata>)hashMap, (Map<Integer, Phonemetadata.PhoneMetadata>)hashMap2);
        }

        Phonemetadata.PhoneMetadata get(int n) {
            return (Phonemetadata.PhoneMetadata)this.countryCallingCodeToMetadata.get((Object)n);
        }

        Phonemetadata.PhoneMetadata get(String string2) {
            return (Phonemetadata.PhoneMetadata)this.regionCodeToMetadata.get((Object)string2);
        }
    }

}

