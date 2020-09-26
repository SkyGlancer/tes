/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.core.content.ContextCompat
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package app.dukhaan.ui.chagnelanguage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import app.dukhaan.ui.chagnelanguage.ChangeLanguageAdapter;
import java.util.ArrayList;

public class ChangeLanguageAdapter
extends RecyclerView.Adapter<SingleViewHolder> {
    public int checkedPosition = 0;
    private Context context;
    private OnLanguageChangeListener languageChangeListener;
    private ArrayList<String> languagesList;

    public ChangeLanguageAdapter(Context context, ArrayList<String> arrayList, OnLanguageChangeListener onLanguageChangeListener) {
        this.context = context;
        this.languagesList = arrayList;
        this.languageChangeListener = onLanguageChangeListener;
    }

    static /* synthetic */ OnLanguageChangeListener access$100(ChangeLanguageAdapter changeLanguageAdapter) {
        return changeLanguageAdapter.languageChangeListener;
    }

    public int getItemCount() {
        return this.languagesList.size();
    }

    public void onBindViewHolder(SingleViewHolder singleViewHolder, int n) {
        singleViewHolder.bind((String)this.languagesList.get(n));
    }

    public SingleViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        return new SingleViewHolder(LayoutInflater.from((Context)this.context).inflate(2131558524, viewGroup, false));
    }

    class SingleViewHolder
    extends RecyclerView.ViewHolder {
        private ImageView imgCheckIcon;
        private ConstraintLayout itemLayout;
        private TextView textView;

        SingleViewHolder(View view) {
            super(view);
            this.textView = (TextView)view.findViewById(2131362198);
            this.imgCheckIcon = (ImageView)view.findViewById(2131362182);
            this.itemLayout = (ConstraintLayout)view.findViewById(2131362192);
        }

        void bind(String string2) {
            if (ChangeLanguageAdapter.this.checkedPosition == -1) {
                this.textView.setTextColor(ContextCompat.getColor((Context)ChangeLanguageAdapter.this.context, (int)2131099711));
                this.imgCheckIcon.setVisibility(4);
            } else if (ChangeLanguageAdapter.this.checkedPosition == this.getAdapterPosition()) {
                this.textView.setTextColor(ContextCompat.getColor((Context)ChangeLanguageAdapter.this.context, (int)2131099693));
                this.imgCheckIcon.setVisibility(0);
            } else {
                this.textView.setTextColor(ContextCompat.getColor((Context)ChangeLanguageAdapter.this.context, (int)2131099711));
                this.imgCheckIcon.setVisibility(4);
            }
            this.textView.setText((CharSequence)string2);
            this.itemLayout.setOnClickListener(new View.OnClickListener(this, string2){
                final /* synthetic */ SingleViewHolder this$1;
                final /* synthetic */ String val$language;
                {
                    this.this$1 = singleViewHolder;
                    this.val$language = string2;
                }

                public void onClick(View view) {
                    if (this.this$1.ChangeLanguageAdapter.this.checkedPosition != this.this$1.getAdapterPosition()) {
                        this.this$1.ChangeLanguageAdapter.this.checkedPosition = this.this$1.getAdapterPosition();
                        this.this$1.ChangeLanguageAdapter.this.notifyDataSetChanged();
                        ChangeLanguageAdapter.access$100(this.this$1.ChangeLanguageAdapter.this).onLanguageChanged(this.val$language);
                    }
                }
            });
        }
    }

}

