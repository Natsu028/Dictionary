package com.example.kodakanatsumi.dictionary;

import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;

    EditText wordEditText;
    EditText meanEditText;
    EditText searchWordText;

    HashMap<String, String> hashMap;
    TreeSet<String> wordSet;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        wordEditText = (EditText) findViewById(R.id.word);
        meanEditText = (EditText) findViewById(R.id.mean);
        searchWordText = (EditText) findViewById(R.id.searchword);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        this.hashMap = new HashMap<>();
        wordSet = new TreeSet<String>();
        pref = getSharedPreferences("dictionary", MODE_PRIVATE);
        editor = pref.edit();
    }
}
