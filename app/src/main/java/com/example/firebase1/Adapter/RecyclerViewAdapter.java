package com.example.firebase1.Adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.firebase1.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ExampleViewHolder> {
   private ArrayList<example_item> mlist;
    public  static class ExampleViewHolder extends RecyclerView.ViewHolder
    {   public ImageView mimage;
        public TextView mtext;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mimage=itemView.findViewById(R.id.imageView3);
            mtext=itemView.findViewById(R.id.textView4);
        }
    }

    public RecyclerViewAdapter(ArrayList<example_item> list)
    {
        mlist=list;
    }
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return (evh);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
       example_item current=mlist.get(position);
       holder.mimage.setImageResource(current.getMimageResource());
       holder.mtext.setText(current.getMtitle());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }



}
