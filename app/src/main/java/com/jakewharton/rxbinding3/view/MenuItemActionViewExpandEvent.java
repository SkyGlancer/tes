/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package app.dukhaan.src.java.com.jakewharton.rxbinding3.view;

import android.view.MenuItem;
import com.jakewharton.rxbinding3.view.MenuItemActionViewEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2={"Lcom/jakewharton/rxbinding3/view/MenuItemActionViewExpandEvent;", "Lcom/jakewharton/rxbinding3/view/MenuItemActionViewEvent;", "menuItem", "Landroid/view/MenuItem;", "(Landroid/view/MenuItem;)V", "getMenuItem", "()Landroid/view/MenuItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "rxbinding_release"}, k=1, mv={1, 1, 15})
public final class MenuItemActionViewExpandEvent
extends MenuItemActionViewEvent {
    private final MenuItem menuItem;

    public MenuItemActionViewExpandEvent(MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull((Object)menuItem, (String)"menuItem");
        super(null);
        this.menuItem = menuItem;
    }

    public static /* synthetic */ MenuItemActionViewExpandEvent copy$default(MenuItemActionViewExpandEvent menuItemActionViewExpandEvent, MenuItem menuItem, int n, Object object) {
        if ((n & 1) != 0) {
            menuItem = menuItemActionViewExpandEvent.getMenuItem();
        }
        return menuItemActionViewExpandEvent.copy(menuItem);
    }

    public final MenuItem component1() {
        return this.getMenuItem();
    }

    public final MenuItemActionViewExpandEvent copy(MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull((Object)menuItem, (String)"menuItem");
        return new MenuItemActionViewExpandEvent(menuItem);
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof MenuItemActionViewExpandEvent)) break block3;
                MenuItemActionViewExpandEvent menuItemActionViewExpandEvent = (MenuItemActionViewExpandEvent)object;
                if (Intrinsics.areEqual((Object)this.getMenuItem(), (Object)menuItemActionViewExpandEvent.getMenuItem())) break block2;
            }
            return false;
        }
        return true;
    }

    @Override
    public MenuItem getMenuItem() {
        return this.menuItem;
    }

    public int hashCode() {
        MenuItem menuItem = this.getMenuItem();
        if (menuItem != null) {
            return menuItem.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MenuItemActionViewExpandEvent(menuItem=");
        stringBuilder.append((Object)this.getMenuItem());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

