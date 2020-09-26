package app.dukhaan.ui.ui.editbusiness;

import app.dukhaan.base.BaseNavigator;
import app.dukhaan.data.model.UploadImage;

public interface EditBusinessNavigator extends BaseNavigator {
   void updatedBusinessDetails(boolean var1);

   void uploadedImage(UploadImage var1);
}
