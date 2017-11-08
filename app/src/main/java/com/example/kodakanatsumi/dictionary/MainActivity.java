package com.example.kodakanatsumi.dictionary;

import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;
    //リストに表示する時にはadapterを通さないと表示されない

    EditText wordEditText;
    EditText meanEditText;
    EditText searchWordText;

    HashMap<String, String> hashMap;
    TreeSet<String> wordSet;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    //SharedPreferencesは倉庫

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

        editor.putString("technology", "科学技術");
        editor.putString("develop", "開発する");
        editor.commit();
        //commit()は必ず入れる

        wordSet.add("technology");
        wordSet.add("develop");
        //keyのみwordSetに保存する

        //Mapに追加
        for (String word : wordSet) {
            //ShardPreferences内の日本語を取得
            //検索機能のためMapに追加
            this.hashMap.put(word, pref.getString(word, null));

            //adapterに追加
            adapter.add("[" + word + "]" + pref.getString(word, null));

            //listに表示
            listView.setAdapter(adapter);

        }
        public void add


    }


}
