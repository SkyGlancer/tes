/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Color
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  android.widget.ImageView
 *  androidx.core.graphics.ColorUtils
 *  java.lang.Object
 */
package app.dukhaan.src.java.com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;
import com.jaredrummler.android.colorpicker.ColorPanelView;
import com.jaredrummler.android.colorpicker.R;

class ColorPaletteAdapter
extends BaseAdapter {
    int colorShape;
    final int[] colors;
    final OnColorSelectedListener listener;
    int selectedPosition;

    ColorPaletteAdapter(OnColorSelectedListener onColorSelectedListener, int[] arrn, int n, int n2) {
        this.listener = onColorSelectedListener;
        this.colors = arrn;
        this.selectedPosition = n;
        this.colorShape = n2;
    }

    public int getCount() {
        return this.colors.length;
    }

    public Object getItem(int n) {
        return this.colors[n];
    }

    public long getItemId(int n) {
        return n;
    }

    public View getView(int n, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        View view2;
        if (view == null) {
            viewHolder = new ViewHolder(viewGroup.getContext());
            view2 = viewHolder.view;
        } else {
            ViewHolder viewHolder2 = (ViewHolder)view.getTag();
            view2 = view;
            viewHolder = viewHolder2;
        }
        viewHolder.setup(n);
        return view2;
    }

    void selectNone() {
        this.selectedPosition = -1;
        this.notifyDataSetChanged();
    }

    static interface OnColorSelectedListener {
        public void onColorSelected(int var1);
    }

    private final class ViewHolder {
        ColorPanelView colorPanelView;
        ImageView imageView;
        int originalBorderColor;
        View view;

        ViewHolder(Context context) {
            View view;
            int n = ColorPaletteAdapter.this.colorShape == 0 ? R.layout.cpv_color_item_square : R.layout.cpv_color_item_circle;
            this.view = view = View.inflate((Context)context, (int)n, null);
            this.colorPanelView = (ColorPanelView)view.findViewById(R.id.cpv_color_panel_view);
            this.imageView = (ImageView)this.view.findViewById(R.id.cpv_color_image_view);
            this.originalBorderColor = this.colorPanelView.getBorderColor();
            this.view.setTag((Object)this);
        }

        private void setColorFilter(int n) {
            if (n == ColorPaletteAdapter.this.selectedPosition && ColorUtils.calculateLuminance((int)ColorPaletteAdapter.this.colors[n]) >= 0.65) {
                this.imageView.setColorFilter(-16777216, PorterDuff.Mode.SRC_IN);
                return;
            }
            this.imageView.setColorFilter(null);
        }

        private void setOnClickListener(final int n) {
            this.colorPanelView.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view) {
                    if (ColorPaletteAdapter.this.selectedPosition != n) {
                        ColorPaletteAdapter.this.selectedPosition = n;
                        ColorPaletteAdapter.this.notifyDataSetChanged();
                    }
                    ColorPaletteAdapter.this.listener.onColorSelected(ColorPaletteAdapter.this.colors[n]);
                }
            });
            this.colorPanelView.setOnLongClickListener(new View.OnLongClickListener(){

                public boolean onLongClick(View view) {
                    ViewHolder.this.colorPanelView.showHint();
                    return true;
                }
            });
        }

        void setup(int n) {
            int n2 = ColorPaletteAdapter.this.colors[n];
            int n3 = Color.alpha((int)n2);
            this.colorPanelView.setColor(n2);
            ImageView imageView = this.imageView;
            int n4 = ColorPaletteAdapter.this.selectedPosition == n ? R.drawable.cpv_preset_checked : 0;
            imageView.setImageResource(n4);
            if (n3 != 255) {
                if (n3 <= 165) {
                    this.colorPanelView.setBorderColor(n2 | -16777216);
                    this.imageView.setColorFilter(-16777216, PorterDuff.Mode.SRC_IN);
                } else {
                    this.colorPanelView.setBorderColor(this.originalBorderColor);
                    this.imageView.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
                }
            } else {
                this.setColorFilter(n);
            }
            this.setOnClickListener(n);
        }

    }

}

