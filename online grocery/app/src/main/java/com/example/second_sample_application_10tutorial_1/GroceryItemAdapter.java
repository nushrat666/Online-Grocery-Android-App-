package com.example.second_sample_application_10tutorial_1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class GroceryItemAdapter {
    private static final String TAG = "GroceryItemAdapter";

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        private TextView name;
        private TextView price;
        private CardView parent;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image=(ImageView)itemView.findViewById(R.id.itemImage);
            name=(TextView)itemView.findViewById(R.id.txtItemName);
            price=(TextView)itemView.findViewById(R.id.txtPrice);
            parent=(CardView)itemView.findViewById(R.id.parent);


        }
    }
    }

