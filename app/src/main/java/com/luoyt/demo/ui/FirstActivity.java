package com.luoyt.demo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.blankj.utilcode.util.ToastUtils;
import com.luoyt.demo.MainActivity;
import com.luoyt.demo.R;
import com.luoyt.demo.adapter.FruitAdapter;
import com.luoyt.demo.bean.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {

    public static final String TAG = "first";
    private Button button_close;
//    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Mango"};

    private List<Fruit> fruit_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Log.d(TAG, "onCreate: create");
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        Log.i(TAG, bundle.toString());

        //关闭页面
        button_close = (Button) findViewById(R.id.button_close);
        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", "luoyongtao");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        //简单列表
        ListView list_view = (ListView) findViewById(R.id.list_view);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(FirstActivity.this, android.R.layout.simple_list_item_1, data);
//        list_view.setAdapter(adapter);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(FirstActivity.this, R.layout.first_item, fruit_list);
        list_view.setAdapter(adapter);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruit_list.get(position);
                ToastUtils.showShort(fruit.getName());
            }
        });
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

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("name", "luoyongtao");
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onCreate: onstart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onCreate: onstop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onCreate: onrestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onCreate: ondestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onCreate: onpause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onCreate: onresume");
    }
}
