package com.example.experiment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import com.ncorti.slidetoact.SlideToActView;

public class AnimationTests extends AppCompatActivity {

    AnimatedVectorDrawable animatedVectorDrawable;
    AnimatedVectorDrawableCompat animatedVectorDrawableCompat;

    ObjectAnimator alpha;
    ObjectAnimator alpha2;

    AnimatorSet animatorSet;
    SlideToActView slideToActView;
    SlideToActView slideToActView2;
    ImageView tick;
    Drawable animDrawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_test_layout);
        tick = findViewById(R.id.tick);

        animatorSet = new AnimatorSet();

        alpha = ObjectAnimator.ofFloat(slideToActView , View.ALPHA, 1.0f, 0f);
        alpha.setDuration(200);

        alpha2 = ObjectAnimator.ofFloat(slideToActView , View.ALPHA, 0f, 1f);

        alpha2.setDuration(200);


        animatorSet.play(alpha);

        animDrawable = tick.getDrawable();

        slideToActView = findViewById(R.id.slider_button_new);
        slideToActView2 = findViewById(R.id.slider_button_second);

        slideToActView.setCompleteIcon(R.drawable.rotate);

        slideToActView2.setCompleteIcon(R.drawable.spinner_new);


    }


    public void stopAnimation(View view) {
        tick.setVisibility(View.VISIBLE);

        AnimatedVectorDrawable avd = (AnimatedVectorDrawable) animDrawable;

        animatorSet.start();
        avd.start();



    }

    public void reset(View view) {
        slideToActView.resetSlider();
        animatorSet.play(alpha2);
        tick.setVisibility(View.GONE);
        animatorSet.start();
    }
}
