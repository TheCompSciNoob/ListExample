package com.example.chow.listexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private List<SuperHero> heroes;
    private ListView heroListView;
    public static final String HERO_INFO = "Display hero info";
    private ArrayAdapter<SuperHero> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        createSuperHeroes();
    }

    private void wireWidgets() {
        heroListView = (ListView) findViewById(R.id.listview_hero);
    }

    private void createSuperHeroes()
    {
        heroes = new ArrayList<>();
        heroes.add(new SuperHero("Batman", "half man, half bat", 55, R.drawable.batman));
        heroes.add(new SuperHero("Datman", "half cat, half dog", 99, R.drawable.datman));
        heroes.add(new SuperHero("Flatman", "slides under doors", 72, R.drawable.flatman));
        heroes.add(new SuperHero("OldMan", "Has 200000MP eyes", 4, R.drawable.oldman));
        heroes.add(new SuperHero("TheNextDoorMan", "Looks like he's going to kill you", 100, R.drawable.thenextdoorman));
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, heroes);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_sort_name:
                sortByName();
                break;
            case R.id.menu_sort_rank:
                sortByRank();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void sortByName() {
        Collections.sort(heroes);
        adapter.notifyDataSetChanged();
    }

    private void sortByRank()
    {
        Collections.sort(heroes, new Comparator<SuperHero>() {
            @Override
            public int compare(SuperHero superHero, SuperHero t1) {
                return superHero.getName().toLowerCase().compareTo(t1.getName().toLowerCase());
            }
        });
        adapter.notifyDataSetChanged();
    }
}
