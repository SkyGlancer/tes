/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.ClipData
 *  android.content.ClipboardManager
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnKeyListener
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.content.res.Resources
 *  android.graphics.Color
 *  android.graphics.Rect
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.ClipboardManager
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.BaseAdapter
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.TextView
 *  android.widget.Toast
 *  io.branch.referral.Branch
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 */
package app.dukhaan.src.java.io.branch.referral;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import io.branch.referral.AnimatedDialog;
import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import io.branch.referral.BranchShareSheetBuilder;
import io.branch.referral.BranchShortLinkBuilder;
import io.branch.referral.BranchUtil;
import io.branch.referral.PrefHelper;
import io.branch.referral.SharingHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class ShareLinkManager {
    private static int ICON_SIZER = 2;
    private static int viewItemMinHeight_ = 100;
    private final int BG_COLOR_DISABLED = Color.argb((int)20, (int)17, (int)4, (int)56);
    private final int BG_COLOR_ENABLED = Color.argb((int)60, (int)17, (int)4, (int)56);
    private BranchShareSheetBuilder builder_;
    Branch.BranchLinkShareListener callback_;
    Branch.IChannelProperties channelPropertiesCallback_;
    Context context_;
    private List<ResolveInfo> displayedAppList_;
    private List<String> excludeFromShareSheet = new ArrayList();
    private int iconSize_ = 50;
    private List<String> includeInShareSheet = new ArrayList();
    private boolean isShareInProgress_ = false;
    final int leftMargin = 100;
    final int padding = 5;
    private int shareDialogThemeID_ = -1;
    AnimatedDialog shareDlg_;
    private Intent shareLinkIntent_;

    ShareLinkManager() {
    }

    private void addLinkToClipBoard(String string2, String string3) {
        if (Build.VERSION.SDK_INT < 11) {
            ((android.text.ClipboardManager)this.context_.getSystemService("clipboard")).setText((CharSequence)string2);
        } else {
            ((ClipboardManager)this.context_.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText((CharSequence)string3, (CharSequence)string2));
        }
        Toast.makeText((Context)this.context_, (CharSequence)this.builder_.getUrlCopiedMessage(), (int)0).show();
    }

    private void createShareDialog(List<SharingHelper.SHARE_WITH> list) {
        List list2 = this.context_.getPackageManager().queryIntentActivities(this.shareLinkIntent_, 65536);
        ArrayList arrayList = new ArrayList(this.getExplicitlyIncludedMatchingApps((List<ResolveInfo>)list2));
        List<ResolveInfo> list3 = this.getPreferredMatchingApps((List<ResolveInfo>)list2, list);
        arrayList.removeAll(list3);
        arrayList.addAll(0, list3);
        arrayList.add((Object)new CopyLinkItem());
        list3.add((Object)new CopyLinkItem());
        this.filterOutExplicitlyExcludedApps((List<ResolveInfo>)arrayList);
        if (list3.size() > 1) {
            if (arrayList.size() > list3.size()) {
                list3.add((Object)new MoreShareItem());
            }
            this.displayedAppList_ = list3;
        } else {
            this.displayedAppList_ = arrayList;
        }
        final ChooserArrayAdapter chooserArrayAdapter = new ChooserArrayAdapter();
        final ListView listView = this.shareDialogThemeID_ > 1 && Build.VERSION.SDK_INT >= 21 ? new ListView(this.context_, null, 0, this.shareDialogThemeID_) : new ListView(this.context_);
        listView.setHorizontalFadingEdgeEnabled(false);
        listView.setBackgroundColor(-1);
        listView.setSelector((Drawable)new ColorDrawable(0));
        if (this.builder_.getSharingTitleView() != null) {
            listView.addHeaderView(this.builder_.getSharingTitleView(), null, false);
        } else if (!TextUtils.isEmpty((CharSequence)this.builder_.getSharingTitle())) {
            TextView textView = new TextView(this.context_);
            textView.setText((CharSequence)this.builder_.getSharingTitle());
            textView.setBackgroundColor(this.BG_COLOR_DISABLED);
            textView.setTextColor(this.BG_COLOR_DISABLED);
            textView.setTextAppearance(this.context_, 16973892);
            textView.setTextColor(this.context_.getResources().getColor(17170432));
            textView.setPadding(100, 5, 5, 5);
            listView.addHeaderView((View)textView, null, false);
        }
        listView.setAdapter((ListAdapter)chooserArrayAdapter);
        if (this.builder_.getDividerHeight() >= 0) {
            listView.setDividerHeight(this.builder_.getDividerHeight());
        } else if (this.builder_.getIsFullWidthStyle()) {
            listView.setDividerHeight(0);
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener((List)arrayList, chooserArrayAdapter, listView){
            final /* synthetic */ ChooserArrayAdapter val$adapter;
            final /* synthetic */ List val$completeAppList;
            final /* synthetic */ ListView val$shareOptionListView;
            {
                this.val$completeAppList = list;
                this.val$adapter = chooserArrayAdapter;
                this.val$shareOptionListView = listView;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int n, long l) {
                if (view == null) {
                    return;
                }
                if (view.getTag() instanceof MoreShareItem) {
                    ShareLinkManager.this.displayedAppList_ = this.val$completeAppList;
                    this.val$adapter.notifyDataSetChanged();
                    return;
                }
                if (view.getTag() instanceof ResolveInfo) {
                    ResolveInfo resolveInfo = (ResolveInfo)view.getTag();
                    if (ShareLinkManager.this.callback_ != null) {
                        PackageManager packageManager = ShareLinkManager.this.context_.getPackageManager();
                        String string2 = ShareLinkManager.this.context_ != null && resolveInfo.loadLabel(packageManager) != null ? resolveInfo.loadLabel(packageManager).toString() : "";
                        ShareLinkManager.this.builder_.getShortLinkBuilder().setChannel(resolveInfo.loadLabel(packageManager).toString());
                        ShareLinkManager.this.callback_.onChannelSelected(string2);
                    }
                    this.val$adapter.selectedPos = n - this.val$shareOptionListView.getHeaderViewsCount();
                    this.val$adapter.notifyDataSetChanged();
                    ShareLinkManager.this.invokeSharingClient(resolveInfo);
                    if (ShareLinkManager.this.shareDlg_ != null) {
                        ShareLinkManager.this.shareDlg_.cancel();
                    }
                }
            }
        });
        this.shareDlg_ = this.builder_.getDialogThemeResourceID() > 0 ? new AnimatedDialog(this.context_, this.builder_.getDialogThemeResourceID()) : new AnimatedDialog(this.context_, this.builder_.getIsFullWidthStyle());
        this.shareDlg_.setContentView((View)listView);
        this.shareDlg_.show();
        Branch.BranchLinkShareListener branchLinkShareListener = this.callback_;
        if (branchLinkShareListener != null) {
            branchLinkShareListener.onShareLinkDialogLaunched();
        }
        this.shareDlg_.setOnDismissListener(new DialogInterface.OnDismissListener(){

            public void onDismiss(DialogInterface dialogInterface) {
                if (ShareLinkManager.this.callback_ != null) {
                    ShareLinkManager.this.callback_.onShareLinkDialogDismissed();
                    ShareLinkManager.this.callback_ = null;
                }
                if (!ShareLinkManager.this.isShareInProgress_) {
                    ShareLinkManager.this.context_ = null;
                    ShareLinkManager.this.builder_ = null;
                }
                ShareLinkManager.this.shareDlg_ = null;
            }
        });
        this.shareDlg_.setOnKeyListener(new DialogInterface.OnKeyListener(){

            public boolean onKey(DialogInterface dialogInterface, int n, KeyEvent keyEvent) {
                boolean bl;
                block11 : {
                    block10 : {
                        block8 : {
                            block9 : {
                                if (keyEvent.getAction() != 1) {
                                    return false;
                                }
                                if (n == 4) break block8;
                                if (n == 23 || n == 66) break block9;
                                if (n != 19) {
                                    if (n != 20) {
                                        return false;
                                    }
                                    if (chooserArrayAdapter.selectedPos < chooserArrayAdapter.getCount() - 1) {
                                        ChooserArrayAdapter chooserArrayAdapter2 = chooserArrayAdapter;
                                        chooserArrayAdapter2.selectedPos = 1 + chooserArrayAdapter2.selectedPos;
                                        chooserArrayAdapter.notifyDataSetChanged();
                                    }
                                } else if (chooserArrayAdapter.selectedPos > 0) {
                                    ChooserArrayAdapter chooserArrayAdapter3 = chooserArrayAdapter;
                                    --chooserArrayAdapter3.selectedPos;
                                    chooserArrayAdapter.notifyDataSetChanged();
                                }
                                break block10;
                            }
                            int n2 = chooserArrayAdapter.selectedPos;
                            bl = false;
                            if (n2 >= 0) {
                                int n3 = chooserArrayAdapter.selectedPos;
                                int n4 = chooserArrayAdapter.getCount();
                                bl = false;
                                if (n3 < n4) {
                                    ListView listView2 = listView;
                                    ChooserArrayAdapter chooserArrayAdapter4 = chooserArrayAdapter;
                                    listView2.performItemClick(chooserArrayAdapter4.getView(chooserArrayAdapter4.selectedPos, null, null), chooserArrayAdapter.selectedPos, listView.getItemIdAtPosition(chooserArrayAdapter.selectedPos));
                                    return false;
                                }
                            }
                            break block11;
                        }
                        ShareLinkManager.this.shareDlg_.dismiss();
                    }
                    bl = true;
                }
                return bl;
            }
        });
    }

    private void filterOutExplicitlyExcludedApps(List<ResolveInfo> list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ResolveInfo resolveInfo = (ResolveInfo)iterator.next();
            if (resolveInfo == null || resolveInfo.activityInfo == null || !this.excludeFromShareSheet.contains((Object)resolveInfo.activityInfo.packageName)) continue;
            iterator.remove();
        }
    }

    private List<ResolveInfo> getExplicitlyIncludedMatchingApps(List<ResolveInfo> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (this.includeInShareSheet.size() > 0) {
            for (ResolveInfo resolveInfo : arrayList) {
                if (!this.includeInShareSheet.contains((Object)resolveInfo.activityInfo.packageName)) continue;
                arrayList2.add((Object)resolveInfo);
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    private List<ResolveInfo> getPreferredMatchingApps(List<ResolveInfo> list, List<SharingHelper.SHARE_WITH> list2) {
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : list) {
            SharingHelper.SHARE_WITH sHARE_WITH;
            block2 : {
                SharingHelper.SHARE_WITH sHARE_WITH2;
                if (resolveInfo == null || resolveInfo.activityInfo == null) continue;
                String string2 = resolveInfo.activityInfo.packageName;
                Iterator iterator = list2.iterator();
                do {
                    boolean bl = iterator.hasNext();
                    sHARE_WITH = null;
                    if (!bl) break block2;
                    sHARE_WITH2 = (SharingHelper.SHARE_WITH)((Object)iterator.next());
                } while (!string2.toLowerCase().contains((CharSequence)sHARE_WITH2.toString().toLowerCase()));
                sHARE_WITH = sHARE_WITH2;
            }
            if (sHARE_WITH == null) continue;
            arrayList.add((Object)resolveInfo);
        }
        return arrayList;
    }

    private void invokeSharingClient(final ResolveInfo resolveInfo) {
        this.isShareInProgress_ = true;
        final String string2 = resolveInfo.loadLabel(this.context_.getPackageManager()).toString();
        this.builder_.getShortLinkBuilder().generateShortUrlInternal(new Branch.BranchLinkCreateListener(){

            @Override
            public void onLinkCreate(String string22, BranchError branchError) {
                if (branchError == null) {
                    ShareLinkManager.this.shareWithClient(resolveInfo, string22, string2);
                    return;
                }
                String string3 = ShareLinkManager.this.builder_.getDefaultURL();
                if (string3 != null && string3.trim().length() > 0) {
                    ShareLinkManager.this.shareWithClient(resolveInfo, string3, string2);
                    return;
                }
                if (ShareLinkManager.this.callback_ != null) {
                    ShareLinkManager.this.callback_.onLinkShareResponse(string22, string2, branchError);
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unable to share link ");
                    stringBuilder.append(branchError.getMessage());
                    PrefHelper.Debug(stringBuilder.toString());
                }
                if (branchError.getErrorCode() != -113 && branchError.getErrorCode() != -117) {
                    ShareLinkManager.this.cancelShareLinkDialog(false);
                    ShareLinkManager.this.isShareInProgress_ = false;
                    return;
                }
                ShareLinkManager.this.shareWithClient(resolveInfo, string22, string2);
            }
        }, true);
    }

    private void shareWithClient(ResolveInfo resolveInfo, String string2, String string3) {
        Branch.BranchLinkShareListener branchLinkShareListener = this.callback_;
        if (branchLinkShareListener != null) {
            branchLinkShareListener.onLinkShareResponse(string2, string3, null);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Shared link with ");
            stringBuilder.append(string3);
            PrefHelper.Debug(stringBuilder.toString());
        }
        if (resolveInfo instanceof CopyLinkItem) {
            this.addLinkToClipBoard(string2, this.builder_.getShareMsg());
            return;
        }
        this.shareLinkIntent_.setPackage(resolveInfo.activityInfo.packageName);
        String string4 = this.builder_.getShareSub();
        String string5 = this.builder_.getShareMsg();
        Branch.IChannelProperties iChannelProperties = this.channelPropertiesCallback_;
        if (iChannelProperties != null) {
            String string6 = iChannelProperties.getSharingTitleForChannel(string3);
            String string7 = this.channelPropertiesCallback_.getSharingMessageForChannel(string3);
            if (!TextUtils.isEmpty((CharSequence)string6)) {
                string4 = string6;
            }
            if (!TextUtils.isEmpty((CharSequence)string7)) {
                string5 = string7;
            }
        }
        if (string4 != null && string4.trim().length() > 0) {
            this.shareLinkIntent_.putExtra("android.intent.extra.SUBJECT", string4);
        }
        Intent intent = this.shareLinkIntent_;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string5);
        stringBuilder.append("\n");
        stringBuilder.append(string2);
        intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
        this.context_.startActivity(this.shareLinkIntent_);
    }

    void cancelShareLinkDialog(boolean bl) {
        AnimatedDialog animatedDialog = this.shareDlg_;
        if (animatedDialog != null && animatedDialog.isShowing()) {
            if (bl) {
                this.shareDlg_.cancel();
                return;
            }
            this.shareDlg_.dismiss();
        }
    }

    Dialog shareLink(BranchShareSheetBuilder branchShareSheetBuilder) {
        Intent intent;
        this.builder_ = branchShareSheetBuilder;
        this.context_ = branchShareSheetBuilder.getActivity();
        this.callback_ = branchShareSheetBuilder.getCallback();
        this.channelPropertiesCallback_ = branchShareSheetBuilder.getChannelPropertiesCallback();
        this.shareLinkIntent_ = intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        this.shareDialogThemeID_ = branchShareSheetBuilder.getStyleResourceID();
        this.includeInShareSheet = branchShareSheetBuilder.getIncludedInShareSheet();
        this.excludeFromShareSheet = branchShareSheetBuilder.getExcludedFromShareSheet();
        this.iconSize_ = branchShareSheetBuilder.getIconSize();
        try {
            this.createShareDialog((List<SharingHelper.SHARE_WITH>)branchShareSheetBuilder.getPreferredOptions());
        }
        catch (Exception exception) {
            exception.printStackTrace();
            Branch.BranchLinkShareListener branchLinkShareListener = this.callback_;
            if (branchLinkShareListener != null) {
                branchLinkShareListener.onLinkShareResponse(null, null, new BranchError("Trouble sharing link", -110));
            }
            PrefHelper.Debug("Unable create share options. Couldn't find applications on device to share the link.");
        }
        return this.shareDlg_;
    }

    private class ChooserArrayAdapter
    extends BaseAdapter {
        public int selectedPos = -1;

        private ChooserArrayAdapter() {
        }

        public int getCount() {
            return ShareLinkManager.this.displayedAppList_.size();
        }

        public Object getItem(int n) {
            return ShareLinkManager.this.displayedAppList_.get(n);
        }

        public long getItemId(int n) {
            return n;
        }

        public View getView(int n, View view, ViewGroup viewGroup) {
            ShareItemView shareItemView;
            if (view == null) {
                ShareLinkManager shareLinkManager = ShareLinkManager.this;
                shareItemView = shareLinkManager.new ShareItemView(shareLinkManager.context_);
            } else {
                shareItemView = (ShareItemView)view;
            }
            ResolveInfo resolveInfo = (ResolveInfo)ShareLinkManager.this.displayedAppList_.get(n);
            boolean bl = n == this.selectedPos;
            shareItemView.setLabel(resolveInfo.loadLabel(ShareLinkManager.this.context_.getPackageManager()).toString(), resolveInfo.loadIcon(ShareLinkManager.this.context_.getPackageManager()), bl);
            shareItemView.setTag((Object)resolveInfo);
            return shareItemView;
        }

        public boolean isEnabled(int n) {
            return this.selectedPos < 0;
        }
    }

    private class CopyLinkItem
    extends ResolveInfo {
        private CopyLinkItem() {
        }

        public Drawable loadIcon(PackageManager packageManager) {
            return ShareLinkManager.this.builder_.getCopyUrlIcon();
        }

        public CharSequence loadLabel(PackageManager packageManager) {
            return ShareLinkManager.this.builder_.getCopyURlText();
        }
    }

    private class MoreShareItem
    extends ResolveInfo {
        private MoreShareItem() {
        }

        public Drawable loadIcon(PackageManager packageManager) {
            return ShareLinkManager.this.builder_.getMoreOptionIcon();
        }

        public CharSequence loadLabel(PackageManager packageManager) {
            return ShareLinkManager.this.builder_.getMoreOptionText();
        }
    }

    private class ShareItemView
    extends TextView {
        Context context_;
        int iconSizeDP_;

        public ShareItemView(Context context) {
            super(context);
            this.context_ = context;
            this.setPadding(100, 5, 5, 5);
            this.setGravity(8388627);
            this.setMinWidth(this.context_.getResources().getDisplayMetrics().widthPixels);
            int n = ShareLinkManager.this.iconSize_ != 0 ? BranchUtil.dpToPx(context, ShareLinkManager.this.iconSize_) : 0;
            this.iconSizeDP_ = n;
        }

        public void setLabel(String string2, Drawable drawable2, boolean bl) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\t");
            stringBuilder.append(string2);
            this.setText((CharSequence)stringBuilder.toString());
            this.setTag((Object)string2);
            if (drawable2 == null) {
                this.setTextAppearance(this.context_, 16973890);
                this.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            } else {
                int n = this.iconSizeDP_;
                if (n != 0) {
                    drawable2.setBounds(0, 0, n, n);
                    this.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.setCompoundDrawablesWithIntrinsicBounds(drawable2, null, null, null);
                }
                this.setTextAppearance(this.context_, 16973892);
                viewItemMinHeight_ = Math.max((int)viewItemMinHeight_, (int)(5 + drawable2.getCurrent().getBounds().centerY() * ICON_SIZER));
            }
            this.setMinHeight(viewItemMinHeight_);
            this.setTextColor(this.context_.getResources().getColor(17170444));
            if (bl) {
                this.setBackgroundColor(ShareLinkManager.this.BG_COLOR_ENABLED);
                return;
            }
            this.setBackgroundColor(ShareLinkManager.this.BG_COLOR_DISABLED);
        }
    }

}

