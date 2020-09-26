package app.dukhaan.ui.ui.account;

import app.dukhaan.base.BaseNavigator;
import app.dukhaan.network.model.AwardStatsResponse.AwardData;
import java.util.List;

public interface AccountViewNavigator extends BaseNavigator {
   void onWhatsAppChatSupportError(boolean var1);

   void onWhatsAppChatSupportUpdated(boolean var1);

   void openReferDialog(List<AwardData> var1);
}
