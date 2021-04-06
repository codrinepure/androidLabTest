package com.example.test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public  String operatie;
    public int option;
    public int number1;
    public int number2;
    public int result;
    ArrayList<String> operations = new ArrayList<>(Arrays.asList("plus","minus","inmultire"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.operatie_entries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(this);

//        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if(position == 0) {
//                    operatie = operations.get(position);
//                    Log.d("success",operatie);
//
//                    parent.getItemAtPosition(position);
//                }
//            }
//        });
    }




    public void calculeaza(View btn) {

        String number1 = ((EditText)findViewById(R.id.number1)).getText().toString();
        int number11 = Integer.parseInt(number1);
        String number2 = ((EditText)findViewById(R.id.number2)).getText().toString();
        int number22 =  Integer.parseInt(number2);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Rezultat");


        if(option == 0) {
            result = number11+number22;
        } else if(option == 1) {
            result = number11-number22;
        }else if(option == 2) {
            result = number11*number22;
        }
        else if(option == 3) {
            result = number11/number22;
        }

        builder.setMessage(number1 + "+" + number2 + "=" + String.valueOf(result));

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        AlertDialog myDialog = builder.create();
        myDialog.show();
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d("success",String.valueOf(position));
        option=position;

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}