package edu.ktu.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdactivitydesign);
        ImageView Image1 = (ImageView) findViewById(R.id.image1);
        ImageView Image2 = (ImageView) findViewById(R.id.image2);
        ImageView Image3 = (ImageView) findViewById(R.id.image3);
        ImageView Image4 = (ImageView) findViewById(R.id.image4);
        ImageView Image5 = (ImageView) findViewById(R.id.image5);

        int imageResource1 = getResources().getIdentifier("@drawable/a11",null,this.getPackageName());
        int imageResource2 = getResources().getIdentifier("@drawable/b22",null,this.getPackageName());
        int imageResource3 = getResources().getIdentifier("@drawable/c33",null,this.getPackageName());
        int imageResource4 = getResources().getIdentifier("@drawable/sc1",null,this.getPackageName());
        int imageResource5 = getResources().getIdentifier("@drawable/sc2",null,this.getPackageName());

        Image1.setImageResource(imageResource1);
        Image2.setImageResource(imageResource2);
        Image3.setImageResource(imageResource3);
        Image4.setImageResource(imageResource4);
        Image5.setImageResource(imageResource5);
    }
}
