/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package app.dukhaan.ui.editbusiness;

import app.dukhaan.base.BaseNavigator;
import app.dukhaan.data.model.UploadImage;

public interface EditBusinessNavigator
extends BaseNavigator {
    public void updatedBusinessDetails(boolean var1);

    public void uploadedImage(UploadImage var1);
}

