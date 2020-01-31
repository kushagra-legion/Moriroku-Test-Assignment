package com.example.firebase1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.firebase1.Adapter.RecyclerViewAdapter;
import com.example.firebase1.Adapter.example_item;

import java.util.ArrayList;

public class aboutus extends AppCompatActivity {
 private RecyclerView mrecyclerview;
 private RecyclerViewAdapter mrecycleadapter;
 private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        ArrayList<example_item> exampleList=new ArrayList<>();
        exampleList.add(new example_item(R.drawable.mti0,"1 image"));
        exampleList.add(new example_item(R.drawable.mti1,"2 image"));
        exampleList.add(new example_item(R.drawable.mti2,"3 image"));
        exampleList.add(new example_item(R.drawable.mti3,"4 image"));
        exampleList.add(new example_item(R.drawable.mti4,"5 image"));
        exampleList.add(new example_item(R.drawable.mti5,"6 image"));
        exampleList.add(new example_item(R.drawable.mti6,"7 image"));
        exampleList.add(new example_item(R.drawable.mti7,"8 image"));
        exampleList.add(new example_item(R.drawable.mti8,"9 image"));
        mrecyclerview=findViewById(R.id.recycler_view);
        mrecyclerview.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        mrecycleadapter=new RecyclerViewAdapter(exampleList);
        mrecyclerview.setLayoutManager(layoutManager);
        mrecyclerview.setAdapter(mrecycleadapter);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
