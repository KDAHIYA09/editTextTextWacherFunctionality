package com.example.edittexttextwatcherdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listViewPerson;
    EditText editTxtSearch;
    ArrayAdapter<String> adapter;

    private String personName[] = {"Aman","bravo","child","demo","elephant","fish","harsh","icecream","juggie","khushi","lemon","mango","nope","oops","person","query","rest","statue","time","uvwxyz","venu","waranda","xmax","yipeee","zabra"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewPerson = findViewById(R.id.listViewPerson);
        editTxtSearch = findViewById(R.id.editTextSearch);
        adapter = new ArrayAdapter<String>(this,R.layout.listview_item,R.id.txtPersonName, personName);
        listViewPerson.setAdapter(adapter);

        editTxtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Toast.makeText(MainActivity.this, "Before user changed the text", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Toast.makeText(MainActivity.this, "After user changed the text", Toast.LENGTH_SHORT).show();
            }
        });

    }
}