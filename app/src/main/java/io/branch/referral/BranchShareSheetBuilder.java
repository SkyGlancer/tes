/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  io.branch.referral.Branch
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.List
 *  org.json.JSONObject
 */
package app.dukhaan.src.java.io.branch.referral;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import io.branch.referral.Branch;
import io.branch.referral.BranchShortLinkBuilder;
import io.branch.referral.BranchUtil;
import io.branch.referral.SharingHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

public class BranchShareSheetBuilder {
    private final Activity activity_;
    private Branch.BranchLinkShareListener callback_;
    private Branch.IChannelProperties channelPropertiesCallback_;
    private String copyURlText_;
    private Drawable copyUrlIcon_;
    private String defaultURL_;
    private int dialogThemeResourceID_;
    private int dividerHeight_;
    private List<String> excludeFromShareSheet;
    private int iconSize_;
    private List<String> includeInShareSheet;
    private Drawable moreOptionIcon_;
    private String moreOptionText_;
    private ArrayList<SharingHelper.SHARE_WITH> preferredOptions_;
    private boolean setFullWidthStyle_;
    private String shareMsg_;
    private String shareSub_;
    private View sharingTitleView_;
    private String sharingTitle_;
    private BranchShortLinkBuilder shortLinkBuilder_;
    private int styleResourceID_;
    private String urlCopiedMessage_;

    public BranchShareSheetBuilder(Activity activity, BranchShortLinkBuilder branchShortLinkBuilder) {
        this(activity, new JSONObject());
        this.shortLinkBuilder_ = branchShortLinkBuilder;
    }

    /*
     * Exception decompiling
     */
    public BranchShareSheetBuilder(Activity var1, JSONObject var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl53.1 : ALOAD_0 : trying to set 1 previously set to 0
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

    public BranchShareSheetBuilder addParam(String string2, String string3) {
        try {
            this.shortLinkBuilder_.addParameters(string2, string3);
        }
        catch (Exception exception) {}
        return this;
    }

    public BranchShareSheetBuilder addPreferredSharingOption(SharingHelper.SHARE_WITH sHARE_WITH) {
        this.preferredOptions_.add((Object)sHARE_WITH);
        return this;
    }

    public BranchShareSheetBuilder addPreferredSharingOptions(ArrayList<SharingHelper.SHARE_WITH> arrayList) {
        this.preferredOptions_.addAll(arrayList);
        return this;
    }

    public BranchShareSheetBuilder addTag(String string2) {
        this.shortLinkBuilder_.addTag(string2);
        return this;
    }

    public BranchShareSheetBuilder addTags(ArrayList<String> arrayList) {
        this.shortLinkBuilder_.addTags((List<String>)arrayList);
        return this;
    }

    public BranchShareSheetBuilder excludeFromShareSheet(String string2) {
        this.excludeFromShareSheet.add((Object)string2);
        return this;
    }

    public BranchShareSheetBuilder excludeFromShareSheet(List<String> list) {
        this.excludeFromShareSheet.addAll(list);
        return this;
    }

    public BranchShareSheetBuilder excludeFromShareSheet(String[] arrstring) {
        this.excludeFromShareSheet.addAll((Collection)Arrays.asList((Object[])arrstring));
        return this;
    }

    public Activity getActivity() {
        return this.activity_;
    }

    @Deprecated
    public Branch getBranch() {
        return Branch.getInstance();
    }

    public Branch.BranchLinkShareListener getCallback() {
        return this.callback_;
    }

    public Branch.IChannelProperties getChannelPropertiesCallback() {
        return this.channelPropertiesCallback_;
    }

    public String getCopyURlText() {
        return this.copyURlText_;
    }

    public Drawable getCopyUrlIcon() {
        return this.copyUrlIcon_;
    }

    public String getDefaultURL() {
        return this.defaultURL_;
    }

    public int getDialogThemeResourceID() {
        return this.dialogThemeResourceID_;
    }

    public int getDividerHeight() {
        return this.dividerHeight_;
    }

    List<String> getExcludedFromShareSheet() {
        return this.excludeFromShareSheet;
    }

    public int getIconSize() {
        return this.iconSize_;
    }

    List<String> getIncludedInShareSheet() {
        return this.includeInShareSheet;
    }

    public boolean getIsFullWidthStyle() {
        return this.setFullWidthStyle_;
    }

    public Drawable getMoreOptionIcon() {
        return this.moreOptionIcon_;
    }

    public String getMoreOptionText() {
        return this.moreOptionText_;
    }

    public ArrayList<SharingHelper.SHARE_WITH> getPreferredOptions() {
        return this.preferredOptions_;
    }

    public String getShareMsg() {
        return this.shareMsg_;
    }

    public String getShareSub() {
        return this.shareSub_;
    }

    public String getSharingTitle() {
        return this.sharingTitle_;
    }

    public View getSharingTitleView() {
        return this.sharingTitleView_;
    }

    public BranchShortLinkBuilder getShortLinkBuilder() {
        return this.shortLinkBuilder_;
    }

    public int getStyleResourceID() {
        return this.styleResourceID_;
    }

    public String getUrlCopiedMessage() {
        return this.urlCopiedMessage_;
    }

    public BranchShareSheetBuilder includeInShareSheet(String string2) {
        this.includeInShareSheet.add((Object)string2);
        return this;
    }

    public BranchShareSheetBuilder includeInShareSheet(List<String> list) {
        this.includeInShareSheet.addAll(list);
        return this;
    }

    public BranchShareSheetBuilder includeInShareSheet(String[] arrstring) {
        this.includeInShareSheet.addAll((Collection)Arrays.asList((Object[])arrstring));
        return this;
    }

    public BranchShareSheetBuilder setAlias(String string2) {
        this.shortLinkBuilder_.setAlias(string2);
        return this;
    }

    public BranchShareSheetBuilder setAsFullWidthStyle(boolean bl) {
        this.setFullWidthStyle_ = bl;
        return this;
    }

    public BranchShareSheetBuilder setCallback(Branch.BranchLinkShareListener branchLinkShareListener) {
        this.callback_ = branchLinkShareListener;
        return this;
    }

    public BranchShareSheetBuilder setChannelProperties(Branch.IChannelProperties iChannelProperties) {
        this.channelPropertiesCallback_ = iChannelProperties;
        return this;
    }

    public BranchShareSheetBuilder setCopyUrlStyle(int n, int n2, int n3) {
        this.copyUrlIcon_ = BranchUtil.getDrawable(this.activity_.getApplicationContext(), n);
        this.copyURlText_ = this.activity_.getResources().getString(n2);
        this.urlCopiedMessage_ = this.activity_.getResources().getString(n3);
        return this;
    }

    public BranchShareSheetBuilder setCopyUrlStyle(Drawable drawable2, String string2, String string3) {
        this.copyUrlIcon_ = drawable2;
        this.copyURlText_ = string2;
        this.urlCopiedMessage_ = string3;
        return this;
    }

    public BranchShareSheetBuilder setDefaultURL(String string2) {
        this.defaultURL_ = string2;
        return this;
    }

    public BranchShareSheetBuilder setDialogThemeResourceID(int n) {
        this.dialogThemeResourceID_ = n;
        return this;
    }

    public BranchShareSheetBuilder setDividerHeight(int n) {
        this.dividerHeight_ = n;
        return this;
    }

    public BranchShareSheetBuilder setFeature(String string2) {
        this.shortLinkBuilder_.setFeature(string2);
        return this;
    }

    public BranchShareSheetBuilder setIconSize(int n) {
        this.iconSize_ = n;
        return this;
    }

    public BranchShareSheetBuilder setMatchDuration(int n) {
        this.shortLinkBuilder_.setDuration(n);
        return this;
    }

    public BranchShareSheetBuilder setMessage(String string2) {
        this.shareMsg_ = string2;
        return this;
    }

    public BranchShareSheetBuilder setMoreOptionStyle(int n, int n2) {
        this.moreOptionIcon_ = BranchUtil.getDrawable(this.activity_.getApplicationContext(), n);
        this.moreOptionText_ = this.activity_.getResources().getString(n2);
        return this;
    }

    public BranchShareSheetBuilder setMoreOptionStyle(Drawable drawable2, String string2) {
        this.moreOptionIcon_ = drawable2;
        this.moreOptionText_ = string2;
        return this;
    }

    public BranchShareSheetBuilder setSharingTitle(View view) {
        this.sharingTitleView_ = view;
        return this;
    }

    public BranchShareSheetBuilder setSharingTitle(String string2) {
        this.sharingTitle_ = string2;
        return this;
    }

    public void setShortLinkBuilderInternal(BranchShortLinkBuilder branchShortLinkBuilder) {
        this.shortLinkBuilder_ = branchShortLinkBuilder;
    }

    public BranchShareSheetBuilder setStage(String string2) {
        this.shortLinkBuilder_.setStage(string2);
        return this;
    }

    public void setStyleResourceID(int n) {
        this.styleResourceID_ = n;
    }

    public BranchShareSheetBuilder setSubject(String string2) {
        this.shareSub_ = string2;
        return this;
    }

    public void shareLink() {
        Branch.getInstance().shareLink(this);
    }
}

