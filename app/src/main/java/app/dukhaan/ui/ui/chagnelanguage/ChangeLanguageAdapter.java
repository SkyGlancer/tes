package app.dukhaan.ui.ui.chagnelanguage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;

public class ChangeLanguageAdapter extends Adapter<app.dukhaan.ui.chagnelanguage.ChangeLanguageAdapter.SingleViewHolder> {
   public int checkedPosition = 0;
   private Context context;
   private app.dukhaan.ui.chagnelanguage.ChangeLanguageAdapter.OnLanguageChangeListener languageChangeListener;
   private ArrayList<String> languagesList;

   public ChangeLanguageAdapter(Context var1, ArrayList<String> var2, app.dukhaan.ui.chagnelanguage.ChangeLanguageAdapter.OnLanguageChangeListener var3) {
      this.context = var1;
      this.languagesList = var2;
      this.languageChangeListener = var3;
   }

   public int getItemCount() {
      return this.languagesList.size();
   }

   public void onBindViewHolder(app.dukhaan.ui.chagnelanguage.ChangeLanguageAdapter.SingleViewHolder var1, int var2) {
      var1.bind((String)this.languagesList.get(var2));
   }

   public app.dukhaan.ui.chagnelanguage.ChangeLanguageAdapter.SingleViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return new app.dukhaan.ui.chagnelanguage.ChangeLanguageAdapter.SingleViewHolder(this, LayoutInflater.from(this.context).inflate(item_language_item, var1, false));
   }
}
