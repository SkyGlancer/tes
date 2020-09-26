package app.dukhaan.ui.ui.editcategory;

import app.dukhaan.ui.editcategory.EditCategoriesViewModel;
import app.dukhaan.ui.editcategory.EditCategoryModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class EditCategoryModule_EditCategoriesViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.editcategory.EditCategoryModule module;
   private final Provider<app.dukhaan.ui.editcategory.EditCategoriesViewModel> viewModelProvider;

   public EditCategoryModule_EditCategoriesViewModelProviderFactory(app.dukhaan.ui.editcategory.EditCategoryModule var1, Provider<app.dukhaan.ui.editcategory.EditCategoriesViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static EditCategoryModule_EditCategoriesViewModelProviderFactory create(app.dukhaan.ui.editcategory.EditCategoryModule var0, Provider<app.dukhaan.ui.editcategory.EditCategoriesViewModel> var1) {
      return new EditCategoryModule_EditCategoriesViewModelProviderFactory(var0, var1);
   }

   public static androidx.lifecycle.ViewModelProvider.Factory editCategoriesViewModelProvider(EditCategoryModule var0, app.dukhaan.ui.editcategory.EditCategoriesViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.editCategoriesViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return editCategoriesViewModelProvider(this.module, (EditCategoriesViewModel)this.viewModelProvider.get());
   }
}
