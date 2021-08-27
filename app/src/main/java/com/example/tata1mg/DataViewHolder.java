package com.example.tata1mg;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class DataViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView product1,quantity1,price1 ;
    private Button cart1;

    public DataViewHolder(@NonNull View itemView) {
        super(itemView);
        intit(itemView);

    }

    private void intit(View itemView) {
        imageView=itemView.findViewById(R.id.image);
        product1=itemView.findViewById(R.id.product);
        quantity1=itemView.findViewById(R.id.quantity);
        price1=itemView.findViewById(R.id.price);
        cart1=itemView.findViewById(R.id.cart);

    }

    public void setData(ModelClass modelClass) {
     imageView.setImageResource(modelClass.getImage());
     product1.setText(modelClass.getProduct());
     quantity1.setText(modelClass.getQuantity());
     price1.setText(modelClass.getPrice());
     cart1.setText(modelClass.getCart());

    }
}
