package app.dukhaan.ui.ui.editbusiness;

import app.dukhaan.data.DataRepository;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.editbusiness.EditBusinessModule;
import app.dukhaan.ui.editbusiness.EditBusinessViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class EditBusinessModule_ProvideBusinessEditDetailsViewModelFactory implements Factory<app.dukhaan.ui.editbusiness.EditBusinessViewModel> {
   private final Provider<ApiService> apiServiceProvider;
   private final Provider<DataRepository> dataRepositoryProvider;
   private final app.dukhaan.ui.editbusiness.EditBusinessModule module;

   public EditBusinessModule_ProvideBusinessEditDetailsViewModelFactory(app.dukhaan.ui.editbusiness.EditBusinessModule var1, Provider<DataRepository> var2, Provider<ApiService> var3) {
      this.module = var1;
      this.dataRepositoryProvider = var2;
      this.apiServiceProvider = var3;
   }

   public static EditBusinessModule_ProvideBusinessEditDetailsViewModelFactory create(app.dukhaan.ui.editbusiness.EditBusinessModule var0, Provider<DataRepository> var1, Provider<ApiService> var2) {
      return new EditBusinessModule_ProvideBusinessEditDetailsViewModelFactory(var0, var1, var2);
   }

   public static app.dukhaan.ui.editbusiness.EditBusinessViewModel provideBusinessEditDetailsViewModel(EditBusinessModule var0, DataRepository var1, ApiService var2) {
      return (app.dukhaan.ui.editbusiness.EditBusinessViewModel)Preconditions.checkNotNull(var0.provideBusinessEditDetailsViewModel(var1, var2), "Cannot return null from a non-@Nullable @Provides method");
   }

   public EditBusinessViewModel get() {
      return provideBusinessEditDetailsViewModel(this.module, (DataRepository)this.dataRepositoryProvider.get(), (ApiService)this.apiServiceProvider.get());
   }
}
