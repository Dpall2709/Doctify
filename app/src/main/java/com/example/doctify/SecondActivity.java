package com.example.doctify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    LinearLayout dotsLayout;
    SliderAdapter adapter;
    List<Data> data;
    //Button getStarted;
    TextView skip;
    ViewPager2 viewPager2;
    ImageView[] dots;
    ImageView arrow1,arrow2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().hide();


        dotsLayout = findViewById(R.id.dots_layout);
        viewPager2 = findViewById(R.id.view_pager_2);
//        skip = (TextView)findViewById(R.id.skip);
        // getStarted = findViewById(R.id.start_btn);
//        arrow1 = findViewById(R.id.arrow_left);
        arrow2 = findViewById(R.id.arrow_right);

        data = new ArrayList<>();
        data.add(new Data("Where Employeess Meet \n     Employees in a Click","Doctify india is one of the biggest hospital recruitment services with an experience of 9 years. Our portal is authentic, reliable, and easy-to-use.We carry out all the formalities with utmost care and perfection.Thus it benefits both the employers as well as the employees.",R.drawable.one_info));
        data.add(new Data("       Get what you are\n             looking for","We make sure the right person gets the right job so that a magnificent blend of quality, integrity, and compassion can be provided. Also, we link small frims with big organisations. This led the right candidates to get hired into the right room, into the right deserving arena.",R.drawable.two_info));
        data.add(new Data("          Hire What you\n                    Desire","Want to hire healthcare professional of your desire, but aren't able to find the perfect candidate. Well, we have one stop solution for anything related to the healthcare and the medical industry. So, why wait just fill out the details and join us",R.drawable.three_info));


        adapter = new SliderAdapter(data);
        viewPager2.setAdapter(adapter);

        dots = new ImageView[3];
        createDots();

        setectedDots(0);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                setectedDots(position);
//                if (position == 0  & position == 2)
//                {
//                    skip.setVisibility(View.VISIBLE);
//                    arrow1.setVisibility(View.INVISIBLE);
//                    arrow2.setVisibility(View.VISIBLE);
//                }

                if (position == 1){
                    arrow2.setVisibility(View.INVISIBLE);
                }
                if (position == 0){
                    arrow2.setVisibility(View.INVISIBLE);
                }
                if (position == 2){
                    arrow2.setVisibility(View.VISIBLE);
                }
                if(position == 2)
                {
                    arrow2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                            startActivity(intent);


                        }
                    });


                }


//                if(position == 0)
//                {
//                    arrow1.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Intent intent = new Intent(SecondActivity.this,FirstPage.class);
//                            startActivity(intent);
//                        }
//                    });
//
//
//                }
                //else {
                // skip.setVisibility(View.INVISIBLE);
                //}
                //  if (position == 2)
//               {
//                   getStarted.setVisibility(View.VISIBLE);
//                   getStarted.setEnabled(true);
//               }
//               else
//               {
//                   getStarted.setVisibility(View.INVISIBLE);
//                   getStarted.setEnabled(false);
//               }

            }
        });


    }

    private void setectedDots(int postion) {
        for (int i=0;i<dots.length;i++)
        {
            if (i == postion)
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dots_select));
            }
            else
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dots_unselect));
            }

        }
    }


    private void createDots() {
        for(int i=0;i<dots.length;i++)
        {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(10,100,10,0);
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dots_unselect));
            dotsLayout.addView(dots[i]);


        }
    }}

