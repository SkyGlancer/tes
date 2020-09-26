/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModel
 *  androidx.lifecycle.ViewModelProvider
 *  androidx.lifecycle.ViewModelProvider$Factory
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package app.dukhaan.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelProviderFactory<V>
implements ViewModelProvider.Factory {
    private V viewModel;

    public ViewModelProviderFactory(V v) {
        this.viewModel = v;
    }

    public <T extends ViewModel> T create(Class<T> class_) {
        if (class_.isAssignableFrom(this.viewModel.getClass())) {
            return (T)((ViewModel)this.viewModel);
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}

