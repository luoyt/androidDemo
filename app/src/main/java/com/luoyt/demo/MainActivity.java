package com.luoyt.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.luoyt.demo.ui.FirstActivity;
import com.luoyt.demo.ui.RecyclerActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "tag";
    private Button button_1;
    private Button btn_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.init(MainActivity.this);
        button_1 = (Button) findViewById(R.id.button_1);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", "luoyongtao");
                bundle.putInt("age", 32);
                bundle.putString("telephone", "13512123434");
                intent.putExtra("data", bundle);
                startActivityForResult(intent, 1);
            }
        });

        btn_recycler = (Button) findViewById(R.id.button_recycler);
        btn_recycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String res = data.getStringExtra("name");
                    Log.i(TAG, "onActivityResult: " + res);
                }
        }
    }

    /**
     * 菜单相关
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                ToastUtils.showShort("click menu1");
                break;
            case R.id.menu2:
                ToastUtils.showShort("click menu2");
                break;
        }
        return true;
    }
}
