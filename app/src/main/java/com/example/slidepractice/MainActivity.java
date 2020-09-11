package com.example.slidepractice;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {


    //test for animation
    ConstraintLayout cl;


    private ViewPager viewPager;
    private LinearLayout dotsLayout;

    private SliderAdapter sliderAdapter;
    private TextView [] dots;

    private Button nextBtn;
    private Button backBtn;

    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = findViewById(R.id.viewPager);
        int x = 5;

        int y = 12;



        dotsLayout = findViewById(R.id.dots_layout);
        nextBtn = findViewById(R.id.next_btn);
        backBtn = findViewById(R.id.prev_btn);

        sliderAdapter = new SliderAdapter(this);

        viewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        viewPager.addOnPageChangeListener(viewListener);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(currentPage + 1);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(currentPage - 1);
            }
        });
    }

    public void addDotsIndicator(int position){
        dots = new TextView[3];
        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0){
            dots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            currentPage = position;

            if (position == 0){
                nextBtn.setEnabled(true);
                backBtn.setEnabled(false);
                backBtn.setVisibility(View.INVISIBLE);

                nextBtn.setText("Next");
                backBtn.setText("");
            } else if (position == dots.length - 1){
                nextBtn.setEnabled(true);
                backBtn.setEnabled(true);
                backBtn.setVisibility(View.VISIBLE);

                nextBtn.setText("Finish");
                backBtn.setText("Back");
                nextBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    }
                });
            }else {
                nextBtn.setEnabled(true);
                backBtn.setEnabled(true);
                backBtn.setVisibility(View.VISIBLE);

                nextBtn.setText("Next");
                backBtn.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}