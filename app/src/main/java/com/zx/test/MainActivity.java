package com.zx.test;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private int[] ids = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        final CarouselView carouselView = (CarouselView) findViewById(R.id.carendarview);
//        Button button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                carouselView.addPic(5, R.drawable.f, true);
//            }
//        });
        List<Integer> resIds = new ArrayList<>();
        for(int i : ids){
            resIds.add(i);
        }
        final HorizontalListView hList = (HorizontalListView) findViewById(R.id.hList);
        ImageAdapter adapter = new ImageAdapter(this, resIds);
        hList.setAdapter(adapter);
        hList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                hList.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
