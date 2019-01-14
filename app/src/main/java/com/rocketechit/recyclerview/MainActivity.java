package com.rocketechit.recyclerview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.rocketechit.recyclerview.Adapter.AdapterClass_Recycler;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    int[] images = {R.drawable.num_one, R.drawable.num_two, R.drawable.num_three, R.drawable.num_four,
            R.drawable.num_five, R.drawable.num_six, R.drawable.num_seven, R.drawable.num_eight,
            R.drawable.num_nine, R.drawable.num_ten};

    String[] name = {"Giant", "GT Bikes", "Santa Cruz", "Trek", "Specialized", "Cannondale", "Marin Cycles",
            "Yeti Cycles", "Kona Bicycles", "Merida Bikes",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_ID);

      LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        recyclerView.setLayoutManager(linearLayout);

        AdapterClass_Recycler adapterClass_recycler = new AdapterClass_Recycler(this, images, name);
        recyclerView.setAdapter(adapterClass_recycler);

        //recyclerview onclick
        adapterClass_recycler.setOnItemClickListener(new AdapterClass_Recycler.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Toast.makeText(MainActivity.this, "Click"+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(int position, View v) {
                Toast.makeText(MainActivity.this, "Long"+position, Toast.LENGTH_SHORT).show();
            }
        });

    }

}
