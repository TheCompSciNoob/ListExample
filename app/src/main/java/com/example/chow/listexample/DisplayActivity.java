package com.example.chow.listexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    private TextView heroName, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        wireWidgets();
        setDisplayInfo();
    }

    private void setDisplayInfo() {
        Intent i = getIntent();
        SuperHero displayhero = i.getParcelableExtra(MainActivity.HERO_INFO);
        heroName.setText(displayhero.getName());
        description.setText(displayhero.getDescription());
    }

    private void wireWidgets() {
        heroName = (TextView) findViewById(R.id.name_hero);
        description = (TextView) findViewById(R.id.description);
    }
}
