package com.example.ahmad.animatedrawable;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    AnimationDrawable imageAnimation;
    ImageView imageView;
    boolean draw=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView= findViewById(R.id.img);



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.back_to_menu));
                Drawable drawable=imageView.getDrawable();
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                Intent intent= new Intent(Main2Activity.this,MainActivity.class);
                Pair<View, String> pair1= Pair.create(findViewById(R.id.img),"simple_activity_transition");
                Pair<View, String> pair2= Pair.create(findViewById(R.id.btn),"button");
                Pair<View, String> pair3= Pair.create(findViewById(R.id.img_zoom),"zoom");
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(Main2Activity.this,pair1,pair2,pair3);
                startActivity(intent, options.toBundle());
                draw=!draw;

            }
        });
    }
}
