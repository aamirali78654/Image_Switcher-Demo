package com.example.imageswitcher;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageSwitcher img_switcher;
    int []img = {R.drawable.flowers,R.drawable.fly,R.drawable.ubuntu};
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //---------------------ImageSwitcher on Declair  ----------------->
        img_switcher = findViewById(R.id.img_switcher);
        img_switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageV = new ImageView(getApplicationContext());
                imageV.setScaleType(ImageView.ScaleType.CENTER);
                return imageV;
            }
        });
        img_switcher.setImageResource(img[0]);

    }
    public void nextBtn(View view)
    {
        index = index+1;
        if(index == img.length)
        {
            index = 0;
        }
        img_switcher.setImageResource(img[index]);

    }
    public void previousBtn(View view)
    {
        index = index-1;
        if(index <0)
        {
            index = img.length-1;
        }
        img_switcher.setImageResource(img[index]);

    }
}