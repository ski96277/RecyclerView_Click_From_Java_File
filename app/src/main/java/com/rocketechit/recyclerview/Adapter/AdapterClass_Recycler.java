package com.rocketechit.recyclerview.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rocketechit.recyclerview.MainActivity;
import com.rocketechit.recyclerview.R;

import java.util.List;

public class AdapterClass_Recycler extends RecyclerView.Adapter<AdapterClass_Recycler.ViewClass> {
    Context context;
    int[] images;
    String[] name;
    //for onlick from java class (Second ....)
    private static ClickListener clickListener;

    public AdapterClass_Recycler(MainActivity mainActivity, int[] images, String[] name) {
        this.images = images;
        this.name = name;
        this.context = mainActivity;
    }


    @NonNull
    @Override
    public ViewClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_view, null);

        return new ViewClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewClass viewClass, int i) {
        viewClass.imageView.setImageResource(images[i]);
        viewClass.nameTV.setText(name[i]);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    //implement interface for onlick from java class (third ....)
    public class ViewClass extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {

        ImageView imageView;
        TextView nameTV;

        public ViewClass(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            imageView = itemView.findViewById(R.id.imageView);
            nameTV = itemView.findViewById(R.id.name_TV);
        }
        //Override this method for onlick from java class (fourth ....)
        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(), v);
            return false;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull ViewClass holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        holder.setIsRecyclable(true);
    }

    //for onlick from java class
    public void setOnItemClickListener(ClickListener clickListener) {
        AdapterClass_Recycler.clickListener = clickListener;
    }
//for onlick from java class (First ....)
    public interface ClickListener {
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }
}
