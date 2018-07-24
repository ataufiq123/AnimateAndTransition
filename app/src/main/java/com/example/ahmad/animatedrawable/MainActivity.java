package com.example.ahmad.animatedrawable;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable imageAnimation;
    ImageView imageView;
    ImageView image;
    boolean draw=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView= findViewById(R.id.img);
        image=findViewById(R.id.imageView);
        final Animation zoomAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.startAnimation(zoomAnimation);
            }
        });





        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.menu_to_back));
                Drawable drawable=imageView.getDrawable();
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                Intent intent= new Intent(MainActivity.this,Main2Activity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(MainActivity.this,
                                imageView,
                                ViewCompat.getTransitionName(imageView));
                startActivity(intent, options.toBundle());
                draw=!draw;

            }
        });
    }
}
