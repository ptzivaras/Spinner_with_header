package com.example.spinnerheader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.items)){

            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if(position==0){
                    TextView textView = new TextView(MainActivity.this);
                    textView.setHeight(0);
                    textView.setVisibility(View.GONE);
                    convertView=textView;
                    return  convertView;
                }else{
                    return super.getDropDownView(position, null, parent);
                }
            }
        };
        spinner.setAdapter(arrayAdapter);
spinner.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
//         if (i==1){
//             Toast.makeText(this, "Yo locks", Toast.LENGTH_SHORT).show();
//         }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
