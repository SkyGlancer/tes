/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  android.view.View
 *  io.branch.referral.Branch
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.ClassLoader
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.indexing;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import io.branch.indexing.AppIndexingHelper;
import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import io.branch.referral.BranchShareSheetBuilder;
import io.branch.referral.BranchShortLinkBuilder;
import io.branch.referral.Defines;
import io.branch.referral.PrefHelper;
import io.branch.referral.SharingHelper;
import io.branch.referral.util.BRANCH_STANDARD_EVENT;
import io.branch.referral.util.ContentMetadata;
import io.branch.referral.util.CurrencyType;
import io.branch.referral.util.LinkProperties;
import io.branch.referral.util.ShareSheetStyle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BranchUniversalObject
implements Parcelable {
    public static final Creator CREATOR = new Creator(){

        public BranchUniversalObject createFromParcel(Parcel parcel) {
            return new BranchUniversalObject(parcel);
        }

        public BranchUniversalObject[] newArray(int n) {
            return new BranchUniversalObject[n];
        }
    };
    private String canonicalIdentifier_ = "";
    private String canonicalUrl_ = "";
    private long creationTimeStamp_ = System.currentTimeMillis();
    private String description_ = "";
    private long expirationInMilliSec_ = 0L;
    private String imageUrl_;
    private CONTENT_INDEX_MODE indexMode_ = CONTENT_INDEX_MODE.PUBLIC;
    private final ArrayList<String> keywords_ = new ArrayList();
    private CONTENT_INDEX_MODE localIndexMode_ = CONTENT_INDEX_MODE.PUBLIC;
    private ContentMetadata metadata_ = new ContentMetadata();
    private String title_ = "";

    public BranchUniversalObject() {
    }

    private BranchUniversalObject(Parcel parcel) {
        this();
        this.creationTimeStamp_ = parcel.readLong();
        this.canonicalIdentifier_ = parcel.readString();
        this.canonicalUrl_ = parcel.readString();
        this.title_ = parcel.readString();
        this.description_ = parcel.readString();
        this.imageUrl_ = parcel.readString();
        this.expirationInMilliSec_ = parcel.readLong();
        this.indexMode_ = CONTENT_INDEX_MODE.values()[parcel.readInt()];
        ArrayList arrayList = (ArrayList)parcel.readSerializable();
        if (arrayList != null) {
            this.keywords_.addAll((Collection)arrayList);
        }
        this.metadata_ = (ContentMetadata)parcel.readParcelable(ContentMetadata.class.getClassLoader());
        this.localIndexMode_ = CONTENT_INDEX_MODE.values()[parcel.readInt()];
    }

    /*
     * Exception decompiling
     */
    public static BranchUniversalObject createInstance(JSONObject var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl176 : ALOAD_2 : trying to set 1 previously set to 0
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

    private BranchShortLinkBuilder getLinkBuilder(Context context, LinkProperties linkProperties) {
        return this.getLinkBuilder(new BranchShortLinkBuilder(context), linkProperties);
    }

    private BranchShortLinkBuilder getLinkBuilder(BranchShortLinkBuilder branchShortLinkBuilder, LinkProperties linkProperties) {
        JSONArray jSONArray;
        if (linkProperties.getTags() != null) {
            branchShortLinkBuilder.addTags((List<String>)linkProperties.getTags());
        }
        if (linkProperties.getFeature() != null) {
            branchShortLinkBuilder.setFeature(linkProperties.getFeature());
        }
        if (linkProperties.getAlias() != null) {
            branchShortLinkBuilder.setAlias(linkProperties.getAlias());
        }
        if (linkProperties.getChannel() != null) {
            branchShortLinkBuilder.setChannel(linkProperties.getChannel());
        }
        if (linkProperties.getStage() != null) {
            branchShortLinkBuilder.setStage(linkProperties.getStage());
        }
        if (linkProperties.getCampaign() != null) {
            branchShortLinkBuilder.setCampaign(linkProperties.getCampaign());
        }
        if (linkProperties.getMatchDuration() > 0) {
            branchShortLinkBuilder.setDuration(linkProperties.getMatchDuration());
        }
        if (!TextUtils.isEmpty((CharSequence)this.title_)) {
            branchShortLinkBuilder.addParameters(Defines.Jsonkey.ContentTitle.getKey(), this.title_);
        }
        if (!TextUtils.isEmpty((CharSequence)this.canonicalIdentifier_)) {
            branchShortLinkBuilder.addParameters(Defines.Jsonkey.CanonicalIdentifier.getKey(), this.canonicalIdentifier_);
        }
        if (!TextUtils.isEmpty((CharSequence)this.canonicalUrl_)) {
            branchShortLinkBuilder.addParameters(Defines.Jsonkey.CanonicalUrl.getKey(), this.canonicalUrl_);
        }
        if ((jSONArray = this.getKeywordsJsonArray()).length() > 0) {
            branchShortLinkBuilder.addParameters(Defines.Jsonkey.ContentKeyWords.getKey(), (Object)jSONArray);
        }
        if (!TextUtils.isEmpty((CharSequence)this.description_)) {
            branchShortLinkBuilder.addParameters(Defines.Jsonkey.ContentDesc.getKey(), this.description_);
        }
        if (!TextUtils.isEmpty((CharSequence)this.imageUrl_)) {
            branchShortLinkBuilder.addParameters(Defines.Jsonkey.ContentImgUrl.getKey(), this.imageUrl_);
        }
        if (this.expirationInMilliSec_ > 0L) {
            String string2 = Defines.Jsonkey.ContentExpiryTime.getKey();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(this.expirationInMilliSec_);
            branchShortLinkBuilder.addParameters(string2, stringBuilder.toString());
        }
        String string3 = Defines.Jsonkey.PublicallyIndexable.getKey();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(this.isPublicallyIndexable());
        branchShortLinkBuilder.addParameters(string3, stringBuilder.toString());
        JSONObject jSONObject = this.metadata_.convertToJson();
        try {
            Iterator iterator = jSONObject.keys();
            while (iterator.hasNext()) {
                String string4 = (String)iterator.next();
                branchShortLinkBuilder.addParameters(string4, jSONObject.get(string4));
            }
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        HashMap<String, String> hashMap = linkProperties.getControlParams();
        for (String string5 : hashMap.keySet()) {
            branchShortLinkBuilder.addParameters(string5, hashMap.get((Object)string5));
        }
        return branchShortLinkBuilder;
    }

    /*
     * Exception decompiling
     */
    public static BranchUniversalObject getReferredBranchUniversalObject() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl35.1 : ACONST_NULL : trying to set 1 previously set to 0
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

    public BranchUniversalObject addContentMetadata(String string2, String string3) {
        this.metadata_.addCustomMetadata(string2, string3);
        return this;
    }

    public BranchUniversalObject addContentMetadata(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            for (String string2 : hashMap.keySet()) {
                this.metadata_.addCustomMetadata(string2, (String)hashMap.get((Object)string2));
            }
        }
        return this;
    }

    public BranchUniversalObject addKeyWord(String string2) {
        this.keywords_.add((Object)string2);
        return this;
    }

    public BranchUniversalObject addKeyWords(ArrayList<String> arrayList) {
        this.keywords_.addAll(arrayList);
        return this;
    }

    public JSONObject convertToJson() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = this.metadata_.convertToJson();
            Iterator iterator = jSONObject2.keys();
            while (iterator.hasNext()) {
                String string2 = (String)iterator.next();
                jSONObject.put(string2, jSONObject2.get(string2));
            }
            if (!TextUtils.isEmpty((CharSequence)this.title_)) {
                jSONObject.put(Defines.Jsonkey.ContentTitle.getKey(), (Object)this.title_);
            }
            if (!TextUtils.isEmpty((CharSequence)this.canonicalIdentifier_)) {
                jSONObject.put(Defines.Jsonkey.CanonicalIdentifier.getKey(), (Object)this.canonicalIdentifier_);
            }
            if (!TextUtils.isEmpty((CharSequence)this.canonicalUrl_)) {
                jSONObject.put(Defines.Jsonkey.CanonicalUrl.getKey(), (Object)this.canonicalUrl_);
            }
            if (this.keywords_.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator iterator2 = this.keywords_.iterator();
                while (iterator2.hasNext()) {
                    jSONArray.put((Object)((String)iterator2.next()));
                }
                jSONObject.put(Defines.Jsonkey.ContentKeyWords.getKey(), (Object)jSONArray);
            }
            if (!TextUtils.isEmpty((CharSequence)this.description_)) {
                jSONObject.put(Defines.Jsonkey.ContentDesc.getKey(), (Object)this.description_);
            }
            if (!TextUtils.isEmpty((CharSequence)this.imageUrl_)) {
                jSONObject.put(Defines.Jsonkey.ContentImgUrl.getKey(), (Object)this.imageUrl_);
            }
            if (this.expirationInMilliSec_ > 0L) {
                jSONObject.put(Defines.Jsonkey.ContentExpiryTime.getKey(), this.expirationInMilliSec_);
            }
            jSONObject.put(Defines.Jsonkey.PublicallyIndexable.getKey(), this.isPublicallyIndexable());
            jSONObject.put(Defines.Jsonkey.LocallyIndexable.getKey(), this.isLocallyIndexable());
            jSONObject.put(Defines.Jsonkey.CreationTimestamp.getKey(), this.creationTimeStamp_);
        }
        catch (JSONException jSONException) {}
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public void generateShortUrl(Context context, LinkProperties linkProperties, Branch.BranchLinkCreateListener branchLinkCreateListener) {
        this.getLinkBuilder(context, linkProperties).generateShortUrl(branchLinkCreateListener);
    }

    public void generateShortUrl(Context context, LinkProperties linkProperties, Branch.BranchLinkCreateListener branchLinkCreateListener, boolean bl) {
        ((BranchShortLinkBuilder)this.getLinkBuilder(context, linkProperties).setDefaultToLongUrl(bl)).generateShortUrl(branchLinkCreateListener);
    }

    public String getCanonicalIdentifier() {
        return this.canonicalIdentifier_;
    }

    public String getCanonicalUrl() {
        return this.canonicalUrl_;
    }

    public ContentMetadata getContentMetadata() {
        return this.metadata_;
    }

    public String getCurrencyType() {
        return null;
    }

    public String getDescription() {
        return this.description_;
    }

    public long getExpirationTime() {
        return this.expirationInMilliSec_;
    }

    public String getImageUrl() {
        return this.imageUrl_;
    }

    public ArrayList<String> getKeywords() {
        return this.keywords_;
    }

    public JSONArray getKeywordsJsonArray() {
        JSONArray jSONArray = new JSONArray();
        Iterator iterator = this.keywords_.iterator();
        while (iterator.hasNext()) {
            jSONArray.put((Object)((String)iterator.next()));
        }
        return jSONArray;
    }

    public HashMap<String, String> getMetadata() {
        return this.metadata_.getCustomMetadata();
    }

    public double getPrice() {
        return 0.0;
    }

    public String getShortUrl(Context context, LinkProperties linkProperties) {
        return this.getLinkBuilder(context, linkProperties).getShortUrl();
    }

    public String getShortUrl(Context context, LinkProperties linkProperties, boolean bl) {
        return ((BranchShortLinkBuilder)this.getLinkBuilder(context, linkProperties).setDefaultToLongUrl(bl)).getShortUrl();
    }

    public String getTitle() {
        return this.title_;
    }

    public String getType() {
        return null;
    }

    public boolean isLocallyIndexable() {
        return this.localIndexMode_ == CONTENT_INDEX_MODE.PUBLIC;
    }

    public boolean isPublicallyIndexable() {
        return this.indexMode_ == CONTENT_INDEX_MODE.PUBLIC;
    }

    public void listOnGoogleSearch(Context context) {
        AppIndexingHelper.addToAppIndex(context, this, null);
    }

    public void listOnGoogleSearch(Context context, LinkProperties linkProperties) {
        AppIndexingHelper.addToAppIndex(context, this, linkProperties);
    }

    public void registerView() {
        this.registerView(null);
    }

    public void registerView(RegisterViewStatusListener registerViewStatusListener) {
        if (Branch.getInstance() != null) {
            Branch.getInstance().registerView(this, registerViewStatusListener);
            return;
        }
        if (registerViewStatusListener != null) {
            registerViewStatusListener.onRegisterViewFinished(false, new BranchError("Register view error", -109));
        }
    }

    public void removeFromLocalIndexing(Context context) {
        AppIndexingHelper.removeFromFirebaseLocalIndex(context, this, null);
    }

    public void removeFromLocalIndexing(Context context, LinkProperties linkProperties) {
        AppIndexingHelper.removeFromFirebaseLocalIndex(context, this, linkProperties);
    }

    public BranchUniversalObject setCanonicalIdentifier(String string2) {
        this.canonicalIdentifier_ = string2;
        return this;
    }

    public BranchUniversalObject setCanonicalUrl(String string2) {
        this.canonicalUrl_ = string2;
        return this;
    }

    public BranchUniversalObject setContentDescription(String string2) {
        this.description_ = string2;
        return this;
    }

    public BranchUniversalObject setContentExpiration(Date date) {
        this.expirationInMilliSec_ = date.getTime();
        return this;
    }

    public BranchUniversalObject setContentImageUrl(String string2) {
        this.imageUrl_ = string2;
        return this;
    }

    public BranchUniversalObject setContentIndexingMode(CONTENT_INDEX_MODE cONTENT_INDEX_MODE) {
        this.indexMode_ = cONTENT_INDEX_MODE;
        return this;
    }

    public BranchUniversalObject setContentMetadata(ContentMetadata contentMetadata) {
        this.metadata_ = contentMetadata;
        return this;
    }

    public BranchUniversalObject setContentType(String string2) {
        return this;
    }

    public BranchUniversalObject setLocalIndexMode(CONTENT_INDEX_MODE cONTENT_INDEX_MODE) {
        this.localIndexMode_ = cONTENT_INDEX_MODE;
        return this;
    }

    public BranchUniversalObject setPrice(double d, CurrencyType currencyType) {
        return this;
    }

    public BranchUniversalObject setTitle(String string2) {
        this.title_ = string2;
        return this;
    }

    public void showShareSheet(Activity activity, LinkProperties linkProperties, ShareSheetStyle shareSheetStyle, Branch.BranchLinkShareListener branchLinkShareListener) {
        this.showShareSheet(activity, linkProperties, shareSheetStyle, branchLinkShareListener, null);
    }

    public void showShareSheet(Activity activity, LinkProperties linkProperties, ShareSheetStyle shareSheetStyle, Branch.BranchLinkShareListener branchLinkShareListener, Branch.IChannelProperties iChannelProperties) {
        if (Branch.getInstance() == null) {
            if (branchLinkShareListener != null) {
                branchLinkShareListener.onLinkShareResponse(null, null, new BranchError("Trouble sharing link. ", -109));
                return;
            }
            PrefHelper.Debug("Sharing error. Branch instance is not created yet. Make sure you have initialised Branch.");
            return;
        }
        BranchShareSheetBuilder branchShareSheetBuilder = new BranchShareSheetBuilder(activity, this.getLinkBuilder((Context)activity, linkProperties));
        branchShareSheetBuilder.setCallback(new LinkShareListenerWrapper(branchLinkShareListener, branchShareSheetBuilder, linkProperties)).setChannelProperties(iChannelProperties).setSubject(shareSheetStyle.getMessageTitle()).setMessage(shareSheetStyle.getMessageBody());
        if (shareSheetStyle.getCopyUrlIcon() != null) {
            branchShareSheetBuilder.setCopyUrlStyle(shareSheetStyle.getCopyUrlIcon(), shareSheetStyle.getCopyURlText(), shareSheetStyle.getUrlCopiedMessage());
        }
        if (shareSheetStyle.getMoreOptionIcon() != null) {
            branchShareSheetBuilder.setMoreOptionStyle(shareSheetStyle.getMoreOptionIcon(), shareSheetStyle.getMoreOptionText());
        }
        if (shareSheetStyle.getDefaultURL() != null) {
            branchShareSheetBuilder.setDefaultURL(shareSheetStyle.getDefaultURL());
        }
        if (shareSheetStyle.getPreferredOptions().size() > 0) {
            branchShareSheetBuilder.addPreferredSharingOptions(shareSheetStyle.getPreferredOptions());
        }
        if (shareSheetStyle.getStyleResourceID() > 0) {
            branchShareSheetBuilder.setStyleResourceID(shareSheetStyle.getStyleResourceID());
        }
        branchShareSheetBuilder.setDividerHeight(shareSheetStyle.getDividerHeight());
        branchShareSheetBuilder.setAsFullWidthStyle(shareSheetStyle.getIsFullWidthStyle());
        branchShareSheetBuilder.setDialogThemeResourceID(shareSheetStyle.getDialogThemeResourceID());
        branchShareSheetBuilder.setSharingTitle(shareSheetStyle.getSharingTitle());
        branchShareSheetBuilder.setSharingTitle(shareSheetStyle.getSharingTitleView());
        branchShareSheetBuilder.setIconSize(shareSheetStyle.getIconSize());
        if (shareSheetStyle.getIncludedInShareSheet() != null && shareSheetStyle.getIncludedInShareSheet().size() > 0) {
            branchShareSheetBuilder.includeInShareSheet(shareSheetStyle.getIncludedInShareSheet());
        }
        if (shareSheetStyle.getExcludedFromShareSheet() != null && shareSheetStyle.getExcludedFromShareSheet().size() > 0) {
            branchShareSheetBuilder.excludeFromShareSheet(shareSheetStyle.getExcludedFromShareSheet());
        }
        branchShareSheetBuilder.shareLink();
    }

    public void userCompletedAction(BRANCH_STANDARD_EVENT bRANCH_STANDARD_EVENT) {
        this.userCompletedAction(bRANCH_STANDARD_EVENT.getName(), null);
    }

    public void userCompletedAction(BRANCH_STANDARD_EVENT bRANCH_STANDARD_EVENT, HashMap<String, String> hashMap) {
        this.userCompletedAction(bRANCH_STANDARD_EVENT.getName(), hashMap);
    }

    public void userCompletedAction(String string2) {
        this.userCompletedAction(string2, null);
    }

    /*
     * Exception decompiling
     */
    public void userCompletedAction(String var1, HashMap<String, String> var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeLong(this.creationTimeStamp_);
        parcel.writeString(this.canonicalIdentifier_);
        parcel.writeString(this.canonicalUrl_);
        parcel.writeString(this.title_);
        parcel.writeString(this.description_);
        parcel.writeString(this.imageUrl_);
        parcel.writeLong(this.expirationInMilliSec_);
        parcel.writeInt(this.indexMode_.ordinal());
        parcel.writeSerializable(this.keywords_);
        parcel.writeParcelable((Parcelable)this.metadata_, n);
        parcel.writeInt(this.localIndexMode_.ordinal());
    }

    public static final class CONTENT_INDEX_MODE
    extends Enum<CONTENT_INDEX_MODE> {
        private static final /* synthetic */ CONTENT_INDEX_MODE[] $VALUES;
        public static final /* enum */ CONTENT_INDEX_MODE PRIVATE;
        public static final /* enum */ CONTENT_INDEX_MODE PUBLIC;

        static {
            CONTENT_INDEX_MODE cONTENT_INDEX_MODE;
            PUBLIC = new CONTENT_INDEX_MODE();
            PRIVATE = cONTENT_INDEX_MODE = new CONTENT_INDEX_MODE();
            CONTENT_INDEX_MODE[] arrcONTENT_INDEX_MODE = new CONTENT_INDEX_MODE[]{PUBLIC, cONTENT_INDEX_MODE};
            $VALUES = arrcONTENT_INDEX_MODE;
        }

        public static CONTENT_INDEX_MODE valueOf(String string2) {
            return (CONTENT_INDEX_MODE)Enum.valueOf(CONTENT_INDEX_MODE.class, (String)string2);
        }

        public static CONTENT_INDEX_MODE[] values() {
            return (CONTENT_INDEX_MODE[])$VALUES.clone();
        }
    }

    private class LinkShareListenerWrapper
    implements Branch.BranchLinkShareListener {
        private final LinkProperties linkProperties_;
        private final Branch.BranchLinkShareListener originalCallback_;
        private final BranchShareSheetBuilder shareSheetBuilder_;

        LinkShareListenerWrapper(Branch.BranchLinkShareListener branchLinkShareListener, BranchShareSheetBuilder branchShareSheetBuilder, LinkProperties linkProperties) {
            this.originalCallback_ = branchLinkShareListener;
            this.shareSheetBuilder_ = branchShareSheetBuilder;
            this.linkProperties_ = linkProperties;
        }

        @Override
        public void onChannelSelected(String string2) {
            Branch.BranchLinkShareListener branchLinkShareListener;
            Branch.BranchLinkShareListener branchLinkShareListener2 = this.originalCallback_;
            if (branchLinkShareListener2 != null) {
                branchLinkShareListener2.onChannelSelected(string2);
            }
            if ((branchLinkShareListener = this.originalCallback_) instanceof Branch.ExtendedBranchLinkShareListener && ((Branch.ExtendedBranchLinkShareListener)branchLinkShareListener).onChannelSelected(string2, BranchUniversalObject.this, this.linkProperties_)) {
                BranchShareSheetBuilder branchShareSheetBuilder = this.shareSheetBuilder_;
                branchShareSheetBuilder.setShortLinkBuilderInternal(BranchUniversalObject.this.getLinkBuilder(branchShareSheetBuilder.getShortLinkBuilder(), this.linkProperties_));
            }
        }

        @Override
        public void onLinkShareResponse(String string2, String string3, BranchError branchError) {
            HashMap hashMap = new HashMap();
            if (branchError == null) {
                hashMap.put((Object)Defines.Jsonkey.SharedLink.getKey(), (Object)string2);
            } else {
                hashMap.put((Object)Defines.Jsonkey.ShareError.getKey(), (Object)branchError.getMessage());
            }
            BranchUniversalObject.this.userCompletedAction(BRANCH_STANDARD_EVENT.SHARE.getName(), (HashMap<String, String>)hashMap);
            Branch.BranchLinkShareListener branchLinkShareListener = this.originalCallback_;
            if (branchLinkShareListener != null) {
                branchLinkShareListener.onLinkShareResponse(string2, string3, branchError);
            }
        }

        @Override
        public void onShareLinkDialogDismissed() {
            Branch.BranchLinkShareListener branchLinkShareListener = this.originalCallback_;
            if (branchLinkShareListener != null) {
                branchLinkShareListener.onShareLinkDialogDismissed();
            }
        }

        @Override
        public void onShareLinkDialogLaunched() {
            Branch.BranchLinkShareListener branchLinkShareListener = this.originalCallback_;
            if (branchLinkShareListener != null) {
                branchLinkShareListener.onShareLinkDialogLaunched();
            }
        }
    }

    public static interface RegisterViewStatusListener {
        public void onRegisterViewFinished(boolean var1, BranchError var2);
    }

}

