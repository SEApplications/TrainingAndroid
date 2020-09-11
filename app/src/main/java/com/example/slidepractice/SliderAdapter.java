package com.example.slidepractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int [] slideImages = {
            R.drawable.test,
            R.drawable.test2,
            R.drawable.test3
    };

    public String [] slideHeading = {
            "SLEEP",
            "EAT",
            "REPEAT"
    };

    public String [] slideDescription = {
            "hgefiugqwiufgqweiugfiqwegfieqwgfi",
            "EewfhoqweghfouwehgfouwhAT",
            "REw,fhl34hfo34hgf34hgilk3hlf3ll3PEAT"
    };


    @Override
    public int getCount() {
        return slideHeading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView imageView = view.findViewById(R.id.test);
        TextView heading = view.findViewById(R.id.tv_heading);
        TextView description = view.findViewById(R.id.tv_lorem);

        imageView.setImageResource(slideImages[position]);
        heading.setText(slideHeading[position]);
        description.setText(slideDescription[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
