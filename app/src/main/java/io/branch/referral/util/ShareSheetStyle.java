/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.List
 */
package app.dukhaan.src.java.io.branch.referral.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import io.branch.referral.SharingHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ShareSheetStyle {
    final Context context_;
    private String copyURlText_;
    private Drawable copyUrlIcon_;
    private String defaultURL_;
    private int dialogThemeResourceID_ = -1;
    private int dividerHeight_ = -1;
    private List<String> excludeFromShareSheet = new ArrayList();
    private int iconSize_ = 50;
    private List<String> includeInShareSheet = new ArrayList();
    private final String messageBody_;
    private final String messageTitle_;
    private Drawable moreOptionIcon_;
    private String moreOptionText_;
    private final ArrayList<SharingHelper.SHARE_WITH> preferredOptions_;
    private boolean setFullWidthStyle_;
    private View sharingTitleView_ = null;
    private String sharingTitle_ = null;
    private int styleResourceID_ = -1;
    private String urlCopiedMessage_;

    public ShareSheetStyle(Context context, String string2, String string3) {
        this.context_ = context;
        this.moreOptionIcon_ = null;
        this.moreOptionText_ = null;
        this.copyUrlIcon_ = null;
        this.copyURlText_ = null;
        this.urlCopiedMessage_ = null;
        this.preferredOptions_ = new ArrayList();
        this.defaultURL_ = null;
        this.messageTitle_ = string2;
        this.messageBody_ = string3;
    }

    private Drawable getDrawable(Context context, int n) {
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getResources().getDrawable(n, context.getTheme());
        }
        return context.getResources().getDrawable(n);
    }

    public ShareSheetStyle addPreferredSharingOption(SharingHelper.SHARE_WITH sHARE_WITH) {
        this.preferredOptions_.add((Object)sHARE_WITH);
        return this;
    }

    public ShareSheetStyle excludeFromShareSheet(String string2) {
        this.excludeFromShareSheet.add((Object)string2);
        return this;
    }

    public ShareSheetStyle excludeFromShareSheet(List<String> list) {
        this.excludeFromShareSheet.addAll(list);
        return this;
    }

    public ShareSheetStyle excludeFromShareSheet(String[] arrstring) {
        this.excludeFromShareSheet.addAll((Collection)Arrays.asList((Object[])arrstring));
        return this;
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

    public List<String> getExcludedFromShareSheet() {
        return this.excludeFromShareSheet;
    }

    public int getIconSize() {
        return this.iconSize_;
    }

    public List<String> getIncludedInShareSheet() {
        return this.includeInShareSheet;
    }

    public boolean getIsFullWidthStyle() {
        return this.setFullWidthStyle_;
    }

    public String getMessageBody() {
        return this.messageBody_;
    }

    public String getMessageTitle() {
        return this.messageTitle_;
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

    public String getSharingTitle() {
        return this.sharingTitle_;
    }

    public View getSharingTitleView() {
        return this.sharingTitleView_;
    }

    public int getStyleResourceID() {
        return this.styleResourceID_;
    }

    public String getUrlCopiedMessage() {
        return this.urlCopiedMessage_;
    }

    public ShareSheetStyle includeInShareSheet(String string2) {
        this.includeInShareSheet.add((Object)string2);
        return this;
    }

    public ShareSheetStyle includeInShareSheet(List<String> list) {
        this.includeInShareSheet.addAll(list);
        return this;
    }

    public ShareSheetStyle includeInShareSheet(String[] arrstring) {
        this.includeInShareSheet.addAll((Collection)Arrays.asList((Object[])arrstring));
        return this;
    }

    public ShareSheetStyle setAsFullWidthStyle(boolean bl) {
        this.setFullWidthStyle_ = bl;
        return this;
    }

    public ShareSheetStyle setCopyUrlStyle(int n, int n2, int n3) {
        this.copyUrlIcon_ = this.getDrawable(this.context_, n);
        this.copyURlText_ = this.context_.getResources().getString(n2);
        this.urlCopiedMessage_ = this.context_.getResources().getString(n3);
        return this;
    }

    public ShareSheetStyle setCopyUrlStyle(Drawable drawable2, String string2, String string3) {
        this.copyUrlIcon_ = drawable2;
        this.copyURlText_ = string2;
        this.urlCopiedMessage_ = string3;
        return this;
    }

    public ShareSheetStyle setDefaultURL(String string2) {
        this.defaultURL_ = string2;
        return this;
    }

    public ShareSheetStyle setDialogThemeResourceID(int n) {
        this.dialogThemeResourceID_ = n;
        return this;
    }

    public ShareSheetStyle setDividerHeight(int n) {
        this.dividerHeight_ = n;
        return this;
    }

    public ShareSheetStyle setIconSize(int n) {
        this.iconSize_ = n;
        return this;
    }

    public ShareSheetStyle setMoreOptionStyle(int n, int n2) {
        this.moreOptionIcon_ = this.getDrawable(this.context_, n);
        this.moreOptionText_ = this.context_.getResources().getString(n2);
        return this;
    }

    public ShareSheetStyle setMoreOptionStyle(Drawable drawable2, String string2) {
        this.moreOptionIcon_ = drawable2;
        this.moreOptionText_ = string2;
        return this;
    }

    public ShareSheetStyle setSharingTitle(View view) {
        this.sharingTitleView_ = view;
        return this;
    }

    public ShareSheetStyle setSharingTitle(String string2) {
        this.sharingTitle_ = string2;
        return this;
    }

    public ShareSheetStyle setStyleResourceID(int n) {
        this.styleResourceID_ = n;
        return this;
    }
}

