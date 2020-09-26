/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.List
 */
package app.dukhaan.ui.account;

import app.dukhaan.base.BaseNavigator;
import app.dukhaan.network.model.AwardStatsResponse;
import java.util.List;

public interface AccountViewNavigator
extends BaseNavigator {
    public void onWhatsAppChatSupportError(boolean var1);

    public void onWhatsAppChatSupportUpdated(boolean var1);

    public void openReferDialog(List<AwardStatsResponse.AwardData> var1);
}

