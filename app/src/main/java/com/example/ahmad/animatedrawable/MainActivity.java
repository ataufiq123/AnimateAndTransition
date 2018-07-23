package com.example.ahmad.animatedrawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable imageAnimation;
    ImageView imageView;
    boolean draw=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView= findViewById(R.id.img);



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (draw){
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.menu_to_back));
                }else {
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.back_to_menu));
                }
                Drawable drawable=imageView.getDrawable();
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                draw=!draw;

            }
        });
    }
}
