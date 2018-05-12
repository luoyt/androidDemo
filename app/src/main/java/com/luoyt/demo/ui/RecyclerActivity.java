package com.luoyt.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.luoyt.demo.R;
import com.luoyt.demo.adapter.FruitListAdapter;
import com.luoyt.demo.bean.Fruit;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    private List<Fruit> fruit_list = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        FruitListAdapter adapter = new FruitListAdapter(fruit_list);
        recyclerView.setAdapter(adapter);
    }


    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("apple", R.drawable.apple);
            fruit_list.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.banana);
            fruit_list.add(banana);
            Fruit grape = new Fruit("Grape", R.drawable.grape);
            fruit_list.add(grape);
            Fruit mangos = new Fruit("Mango", R.drawable.mango);
            fruit_list.add(mangos);
            Fruit orange = new Fruit("orange", R.drawable.orange);
            fruit_list.add(orange);
            Fruit pear = new Fruit("Pear", R.drawable.pear);
            fruit_list.add(pear);
            Fruit water = new Fruit("waterMelon", R.drawable.watermelon);
            fruit_list.add(water);
        }
    }
}
