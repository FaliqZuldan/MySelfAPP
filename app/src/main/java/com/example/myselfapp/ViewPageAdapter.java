package com.example.myselfapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;




public class ViewPageAdapter extends PagerAdapter {

    Context context;

    int[] images = {
            R.drawable.hallo,
            R.drawable.slide2,
            R.drawable.slide3
    };

    int[] header = {
            R.string.header1,
            R.string.header2,
            R.string.header3
    };

    int[] isi = {
            R.string.isi1,
            R.string.isi2,
            R.string.isi3
    };

    public ViewPageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return header.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout, container, false);

        ImageView slidetitleimage = view.findViewById(R.id.title_image);
        TextView slideHeading = view.findViewById(R.id.tittle_header);
        TextView sldieisi = view.findViewById(R.id.tittle_isi);

        slidetitleimage.setImageResource(images[position]);
        slideHeading.setText(header[position]);
        sldieisi.setText(isi[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
