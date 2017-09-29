package com.example.chow.listexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    private TextView heroName, description;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        wireWidgets();
        setDisplayInfo();
    }

    private void setDisplayInfo() {
        Intent i = getIntent();
        SuperHero displayHero = i.getParcelableExtra(MainActivity.HERO_INFO);
        heroName.setText(displayHero.getName());
        description.setText(displayHero.getDescription());
        image.setImageResource(displayHero.getImageResouceID());
    }

    private void wireWidgets() {
        heroName = (TextView) findViewById(R.id.name_hero);
        description = (TextView) findViewById(R.id.description);
        image = (ImageView) findViewById(R.id.image);
    }
}
