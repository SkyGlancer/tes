package app.dukhaan.ui.ui.editbusiness;

import androidx.lifecycle.ViewModelProvider.Factory;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.editbusiness.EditBusinessViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class EditBusinessModule {
   public EditBusinessModule() {
   }

   @Provides
   Factory businessEditDetailsViewModelProvider(EditBusinessViewModel var1) {
      return new ViewModelProviderFactory(var1);
   }

   @Provides
   EditBusinessViewModel provideBusinessEditDetailsViewModel(DataRepository var1, ApiService var2) {
      return new EditBusinessViewModel(var1, var2);
   }
}
