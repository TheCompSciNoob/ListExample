package com.example.chow.listexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<SuperHero> heroes;
    private ListView heroListView;
    public static final String HERO_INFO = "Display hero info";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        createSuperHeroes();
        ArrayAdapter<SuperHero> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, heroes);
        heroListView.setAdapter(adapter);
        heroListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra(HERO_INFO, heroes.get(i));
                startActivity(intent);
            }
        });
    }

    private void wireWidgets() {
        heroListView = (ListView) findViewById(R.id.listview_hero);
    }

    private void createSuperHeroes()
    {
        heroes = new ArrayList<>();
        heroes.add(new SuperHero("Batman", "half man, half bat", 0));
        heroes.add(new SuperHero("Datman", "half cat, half dog", 0));
        heroes.add(new SuperHero("Flatman", "slides under doors", 0));
        heroes.add(new SuperHero("MyOldMan", "Has 200000MP eyes", 0));
        heroes.add(new SuperHero("TheNextDoorMan", "Looks like he's going to kill you", 0));
    }
}
