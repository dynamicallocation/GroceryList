package com.example.ikavanagh.grocerylist;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
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
    private boolean isInput;
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

        if(myGrocery.length() != 0) {
                Grocery list = new Grocery(myGrocery);
                boolean insertData = helper.addData(list);
                if (insertData == true) {
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                }
        }
        else
        {
            Toast.makeText(MainActivity.this,"You Must Enter a Value",Toast.LENGTH_LONG).show();
        }
    }

    public void viewList(View view)
    {

        Intent i = new Intent(MainActivity.this,ListData.class);
        startActivity(i);


    }



    public void updateList(View view)
    {

        TextView input = (TextView) findViewById(R.id.idInput);
        TextView newItem = (TextView) findViewById(R.id.groceryInput);


        int temp = input.getText().toString().length();

        String idInput = input.getText().toString();
        String item = newItem.getText().toString();


        if(temp > 0) {
             isInput = helper.updateData(idInput,item);
             if(isInput == true)
             {
                 Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_LONG).show();
             }
             else
             {
                 Toast.makeText(MainActivity.this,"Failure",Toast.LENGTH_LONG).show();
             }
        }
        else
        {
            Toast.makeText(MainActivity.this,"You Must Enter an ID",Toast.LENGTH_LONG).show();
        }

    }


    public void removeRecord(View view)
    {

        TextView input = (TextView) findViewById(R.id.idInput);
        TextView newItem = (TextView) findViewById(R.id.groceryInput);


        int temp = input.getText().toString().length();
        String idInput = input.getText().toString();



        if(temp > 0) {

            Integer deleteRecord = helper.deleteData(idInput);
            if(deleteRecord > 0)
            {
                Toast.makeText(MainActivity.this,"Record Deleted Successfully",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(MainActivity.this,"Deletion Failed",Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(MainActivity.this,"You Must Enter an ID",Toast.LENGTH_LONG).show();
        }

    }







}
