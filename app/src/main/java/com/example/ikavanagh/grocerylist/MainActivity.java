package com.example.ikavanagh.grocerylist;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private String myGrocery;
    private String myQuantity;
    DatabaseHelper helper = new DatabaseHelper(this);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    public void submitGrocery(View view)
    {

        TextView groceryText = (TextView) findViewById(R.id.groceryInput);
        myGrocery = groceryText.getText().toString();
        Grocery list = new Grocery(myGrocery);
        boolean insertData = helper.addData(list);
        if(insertData == true)
        {
            Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(MainActivity.this,"Failure",Toast.LENGTH_SHORT).show();
        }
    }



}
