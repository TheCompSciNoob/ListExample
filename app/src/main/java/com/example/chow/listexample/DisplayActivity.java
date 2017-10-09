package com.example.chow.listexample;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    private TextView heroName, description;
    private ImageView image;
    private SuperHero displayHero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        wireWidgets();
        setDisplayInfo();
    }

    private void setDisplayInfo() {
        Intent i = getIntent();
        displayHero = i.getParcelableExtra(MainActivity.HERO_INFO);
        heroName.setText(displayHero.getName());
        description.setText("Ranking: " + displayHero.getRanking() + "; " + displayHero.getDescription());
        image.setImageResource(displayHero.getImageResouceID());
        registerForContextMenu(image);
    }

    private void wireWidgets() {
        heroName = (TextView) findViewById(R.id.name_hero);
        description = (TextView) findViewById(R.id.description);
        image = (ImageView) findViewById(R.id.image);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.image_display_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.image_display:
                return true;
            case R.id.name_change:
                displayChangeNameDialog();
                return true;
            case R.id.description_change:
                displayChangeDescriptionDialog();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void displayChangeDescriptionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_change, null);
        builder.setView(dialogView);
        final EditText changeDescription = dialogView.findViewById(R.id.name_new);
        changeDescription.setHint("New description");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                displayHero.setDescription(changeDescription.getText().toString());
                description.setText(displayHero.getDescription());
            }
        });
        builder.setNegativeButton("CANCEL", null);
        builder.show();
    }

    private void displayChangeNameDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_change, null);
        builder.setView(dialogView);
        final EditText newName = dialogView.findViewById(R.id.name_new);
        newName.setHint("New name");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                displayHero.setName(newName.getText().toString());
                heroName.setText(displayHero.getName());
            }
        });
        builder.setNegativeButton("CANCEL", null);
        builder.show();
    }
}
