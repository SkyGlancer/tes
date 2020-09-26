/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.databinding.DataBindingUtil
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package app.dukhaan.ui.addresspicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.databinding.ItemSearchBinding;
import app.dukhaan.network.model.placesResponseData.Prediction;
import app.dukhaan.ui.addresspicker.PlacesSearchAdapter;
import java.util.List;

public class PlacesSearchAdapter
extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private PlacesAdapterItemClick adapterBtnClickListener;
    private List<Prediction> googlePlacesList;

    public PlacesSearchAdapter(List<Prediction> list, PlacesAdapterItemClick placesAdapterItemClick) {
        this.googlePlacesList = list;
        this.adapterBtnClickListener = placesAdapterItemClick;
    }

    static /* synthetic */ PlacesAdapterItemClick access$000(PlacesSearchAdapter placesSearchAdapter) {
        return placesSearchAdapter.adapterBtnClickListener;
    }

    public int getItemCount() {
        return this.googlePlacesList.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n) {
        Prediction prediction = (Prediction)this.googlePlacesList.get(n);
        ((PlacesViewHolder)viewHolder).bind(prediction);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        return new PlacesViewHolder((ItemSearchBinding)DataBindingUtil.inflate((LayoutInflater)LayoutInflater.from((Context)viewGroup.getContext()), (int)2131558529, (ViewGroup)viewGroup, (boolean)false));
    }

    public class PlacesViewHolder
    extends RecyclerView.ViewHolder {
        private ItemSearchBinding binding;
        private int position;
        private Prediction prediction;

        public PlacesViewHolder(ItemSearchBinding itemSearchBinding) {
            super(itemSearchBinding.getRoot());
            this.binding = itemSearchBinding;
        }

        void bind(Prediction prediction) {
            this.binding.setVariable(1, (Object)prediction);
            this.binding.executePendingBindings();
            this.prediction = prediction;
            try {
                this.binding.tvName.setText((CharSequence)prediction.getSearchKey());
                this.binding.tvOthersDesc.setText((CharSequence)prediction.getDescription());
            }
            catch (Exception exception) {
                this.binding.tvName.setText((CharSequence)prediction.getDescription());
                exception.printStackTrace();
            }
            this.binding.constItemSearchPlaces.setOnClickListener(new View.OnClickListener(this, prediction){
                final /* synthetic */ PlacesViewHolder this$1;
                final /* synthetic */ Prediction val$prediction;
                {
                    this.this$1 = placesViewHolder;
                    this.val$prediction = prediction;
                }

                public void onClick(View view) {
                    PlacesSearchAdapter.access$000(this.this$1.PlacesSearchAdapter.this).onPlacesAdapterItemClick(this.val$prediction);
                }
            });
        }
    }

}

