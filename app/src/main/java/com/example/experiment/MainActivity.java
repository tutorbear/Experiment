package com.example.experiment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.Pivot;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this, AnimationTests.class));
        ArrayList<String> title = new ArrayList<>();
        title.add("hi");
        title.add("bye");
        title.add("bye");
        title.add("hi");
        title.add("bye");
        title.add("bye");
        title.add("bye");
        title.add("bye");


        DiscreteScrollView scrollView = findViewById(R.id.picker);
        scrollView.setAdapter(new Adapter(this,title));

        scrollView.setItemTransformer(new ScaleTransformer.Builder()
                .setMaxScale(1.05f)
                .setMinScale(0.8f)
                .setPivotX(Pivot.X.CENTER) // CENTER is a default one
                .setPivotY(Pivot.Y.BOTTOM) // CENTER is a default one
                .build());
    }

    public void apply(View view) {
    }
}
