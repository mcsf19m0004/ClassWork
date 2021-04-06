package com.example.listviewpractic4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> friendArrayList;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.addedBtn);
        textView=findViewById(R.id.addedName);

        listView=findViewById(R.id.ListView);
        String [] friendList={"sana","hifza","haleema","rabia","nimra","munaza"};
        friendArrayList=new ArrayList<String>();
        friendArrayList.add("sana1");
        friendArrayList.add("hifza1");
        friendArrayList.add("haleema1");
        friendArrayList.add("Azra1");
        friendArrayList.add("bushra");
        friendArrayList.add("rubab");
        arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,friendArrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>  adapterView, View view, int i, long l) {
                Log.d("you clikked" , friendArrayList.get(i));
                Intent intent=new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("freind name",friendArrayList.get(i));
                startActivity(intent);
            }
        });

    }
    public void addFriends(View view) {
        friendArrayList.add(textView.getText().toString());
        listView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
        Collections.sort(friendArrayList);
    }
}