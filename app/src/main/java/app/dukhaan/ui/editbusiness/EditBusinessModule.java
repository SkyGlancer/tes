/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  app.dukhaan.data.DataRepository
 *  app.dukhaan.di.ViewModelProviderFactory
 *  app.dukhaan.ui.editbusiness.EditBusinessViewModel
 *  dagger.Module
 *  dagger.Provides
 *  java.lang.Object
 */
package app.dukhaan.ui.editbusiness;

import androidx.lifecycle.ViewModelProvider;
import app.dukhaan.data.DataRepository;
import app.dukhaan.di.ViewModelProviderFactory;
import app.dukhaan.network.ApiService;
import app.dukhaan.ui.editbusiness.EditBusinessViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class EditBusinessModule {
    @Provides
    ViewModelProvider.Factory businessEditDetailsViewModelProvider(EditBusinessViewModel editBusinessViewModel) {
        return new ViewModelProviderFactory((Object)editBusinessViewModel);
    }

    @Provides
    EditBusinessViewModel provideBusinessEditDetailsViewModel(DataRepository dataRepository, ApiService apiService) {
        return new EditBusinessViewModel(dataRepository, apiService);
    }
}

