package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
        * @author Roy Tendler
        * @version 1
        * @since 10/12/2019
        */
public class MainActivity extends AppCompatActivity {

    final String [] colors={"Red","Green","Blue"};
    int[] color;
    AlertDialog.Builder adb;
    LinearLayout ll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = findViewById(R.id.ll);
    }

    /**
     *This method creates an alert that changes the background color when button preesed
     */
    public void single(View view) {
        color = new int[]{0,0,0};

        adb = new AlertDialog.Builder(this);

        adb.setTitle("Choose one for background");
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color[which]=255;
                ll.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }


        });
        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        adb.setCancelable(false);
        AlertDialog ad = adb.create();
        ad.show();
    }
    /**
     *This method creates an alert that changes the background color when button preesed
     */
    public void mul(View view) {
        color = new int[]{0,0,0};

        adb = new AlertDialog.Builder(this);

        adb.setTitle("Combine Colors to change background");
        adb.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                color[which]=255;
            }
        });

        adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });
        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        adb.setCancelable(false);
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     *This Method resets the background back to white
     */
    public void reset(View view) {
        ll.setBackgroundColor(Color.WHITE);
    }

    /**
     *This method creats an alert that receives an input and prints it out as a toast
     */
    public void text(View view) {

        adb = new AlertDialog.Builder(this);

        adb.setTitle("Enter text to Toast");
        final EditText et = new EditText(this);
        et.setHint("Enter here");
        adb.setView(et);

        adb.setPositiveButton("To Toast", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = et.getText().toString();
                Toast.makeText(MainActivity.this,str, Toast.LENGTH_SHORT).show();
         }
        });
        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        adb.setCancelable(false);
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     *The method creates an option menu with credits
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,0,250,"Credits");
        return true;
    }

    /**
     *The method checks what option was picked in the option menu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String st=item.getTitle().toString();
        if(st.equals("Credits")){
            Intent si = new Intent(this,Credits.class);
            startActivity(si);
        }

        return true;
    }
}
