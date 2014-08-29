package com.example.xmlmenu;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tv = (TextView)findViewById(R.id.tv_test);
        registerForContextMenu(tv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.isCheckable()) {
            item.setChecked(true);
        }
        
        switch (item.getItemId()) {
        case R.id.font_size_10:
            tv.setTextSize(10);
            break;
        case R.id.font_size_12:
            tv.setTextSize(12);
            break;
        case R.id.font_size_14:
            tv.setTextSize(14);
            break;
        case R.id.font_size_16:
            tv.setTextSize(16);
            break;
        case R.id.color_red:
            tv.setTextColor(Color.RED);
            item.setChecked(true);
            break;
        case R.id.color_green:
            tv.setTextColor(Color.GREEN);
            item.setChecked(true);
            break;
        case R.id.color_blue:
            tv.setTextColor(Color.BLUE);
            item.setChecked(true);
            break;
        case R.id.plain_item:
            Toast.makeText(this, "You clicked plain item", Toast.LENGTH_SHORT).show();
        default:
            break;
        }

        return true;
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context, menu);
        menu.setHeaderIcon(R.drawable.ic_launcher);
        menu.setHeaderTitle("Set background color");
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
        case R.id.red:
            tv.setBackgroundColor(Color.RED);
            item.setChecked(true);
            break;
        case R.id.green:
            tv.setBackgroundColor(Color.GREEN);
            item.setChecked(true);
            break;
        case R.id.blue:
            tv.setBackgroundColor(Color.BLUE);
            item.setChecked(true);
            break;

        default:
            break;
        }
        return true;
    }

}
