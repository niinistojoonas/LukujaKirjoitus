package com.example.joonas.ekaviikko;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class LOLXDLOL extends AppCompatActivity {

    Context context = null;

    EditText text;

    EditText tiedosto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lolxdlol);
        context = LOLXDLOL.this;



        text = findViewById(R.id.editText2);
        tiedosto = findViewById(R.id.editText);
    }

    public void tallenna(View lol){

        String s;

        try{
            InputStream ins = context.openFileInput(tiedosto.getText().toString().trim());


            BufferedReader lukija = new BufferedReader(new InputStreamReader(ins));



            while ((s = lukija.readLine()) != null){
                text.setText(s);



            }
            ins.close();



        }
        catch (IOException e){
            Log.e("IOException", "virhe syötteessä");
            Toast.makeText(getBaseContext(),"Virhe syötteessä", Toast.LENGTH_SHORT).show();


        }






    }

    public void kirjoita(View lol){

        try{
            FileOutputStream ins = context.openFileOutput(tiedosto.getText().toString().trim(), Context.MODE_PRIVATE);
            OutputStreamWriter kirjoita = new OutputStreamWriter(ins);

            kirjoita.write(text.getText().toString().trim());

            kirjoita.close();



        }
        catch (IOException e){
            Log.e("IOException", "virhe syötteessä");
            Toast.makeText(getBaseContext(),"Virhe syötteessä", Toast.LENGTH_SHORT).show();


        }


    }
}
