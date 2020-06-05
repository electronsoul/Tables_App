package com.example.mynotes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    protected int table_number = 1;
    ArrayAdapter<String >arrayAdapter;
    public void input(View view){

        //Instantiation
        ListView listView = (ListView)findViewById(R.id.list_layout);
        TextView textView = (TextView)findViewById(R.id.input_number);
        Button button = (Button)findViewById(R.id.input_button);

        //Get Number From User
        table_number = Integer.parseInt(textView.getText().toString());

        // Declare The Array
        ArrayList<String> myTable = new ArrayList<String >();

        //Adding Value To Table
        for(int i = 1; i <= 10; i++ ){
            myTable.add("          "+String.valueOf(table_number)+" x "+String.valueOf(i)+" = "+String.valueOf(i*table_number));
        }

        //create Array Adapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myTable);

        //Attach ArrayAdapter To List Layout
        listView.setAdapter(arrayAdapter);

    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = MainActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION|WindowManager.LayoutParams.FLAG_FULLSCREEN); //For Full Screen And Navigation Bar Translucent
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.Background_Color));

    }
}