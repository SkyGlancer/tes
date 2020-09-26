package app.dukhaan.ui.ui.editproduct;

import app.dukhaan.ui.editproduct.EditProductViewModel;
import app.dukhaan.ui.editproduct.EditProdutModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class EditProdutModule_EditProductViewModelProviderFactory implements Factory<androidx.lifecycle.ViewModelProvider.Factory> {
   private final app.dukhaan.ui.editproduct.EditProdutModule module;
   private final Provider<app.dukhaan.ui.editproduct.EditProductViewModel> viewModelProvider;

   public EditProdutModule_EditProductViewModelProviderFactory(app.dukhaan.ui.editproduct.EditProdutModule var1, Provider<app.dukhaan.ui.editproduct.EditProductViewModel> var2) {
      this.module = var1;
      this.viewModelProvider = var2;
   }

   public static EditProdutModule_EditProductViewModelProviderFactory create(app.dukhaan.ui.editproduct.EditProdutModule var0, Provider<app.dukhaan.ui.editproduct.EditProductViewModel> var1) {
      return new EditProdutModule_EditProductViewModelProviderFactory(var0, var1);
   }

   public static androidx.lifecycle.ViewModelProvider.Factory editProductViewModelProvider(EditProdutModule var0, app.dukhaan.ui.editproduct.EditProductViewModel var1) {
      return (androidx.lifecycle.ViewModelProvider.Factory)Preconditions.checkNotNull(var0.editProductViewModelProvider(var1), "Cannot return null from a non-@Nullable @Provides method");
   }

   public androidx.lifecycle.ViewModelProvider.Factory get() {
      return editProductViewModelProvider(this.module, (EditProductViewModel)this.viewModelProvider.get());
   }
}
