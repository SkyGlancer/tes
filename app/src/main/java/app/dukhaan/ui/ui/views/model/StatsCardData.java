package app.dukhaan.ui.ui.views.model;

public class StatsCardData {
   public String label;
   public String value;

   public StatsCardData(String var1, String var2) {
      this.label = var1;
      this.value = var2;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("StatsCardData{label='");
      var1.append(this.label);
      var1.append('\'');
      var1.append(", value='");
      var1.append(this.value);
      var1.append('\'');
      var1.append('}');
      return var1.toString();
   }
}
