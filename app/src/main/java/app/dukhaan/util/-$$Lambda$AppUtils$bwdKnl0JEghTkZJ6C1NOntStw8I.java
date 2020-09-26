/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  androidx.appcompat.widget.PopupMenu
 *  androidx.appcompat.widget.PopupMenu$OnMenuItemClickListener
 *  java.lang.Object
 */
package app.dukhaan.util;

import android.view.MenuItem;
import androidx.appcompat.widget.PopupMenu;
import app.dukhaan.util.AppUtils;
import app.dukhaan.util.IpopUpMenuItem;

public final class -$$Lambda$AppUtils$bwdKnl0JEghTkZJ6C1NOntStw8I
implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ IpopUpMenuItem f$0;

    public /* synthetic */ -$$Lambda$AppUtils$bwdKnl0JEghTkZJ6C1NOntStw8I(IpopUpMenuItem ipopUpMenuItem) {
        this.f$0 = ipopUpMenuItem;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return AppUtils.lambda$popUpMenu$2(this.f$0, menuItem);
    }
}

