package com.example.ordreraapp.Card;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ordreraapp.R;

import java.util.ArrayList;

public class ListCardAdaptor extends RecyclerView.Adapter<ListCardAdaptor.viewHolder> {
    ArrayList<FoodModel> model;

    public ListCardAdaptor(ArrayList<FoodModel> arrayList) {
        model = arrayList;
    }


    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_model, parent, false);
        return new viewHolder(inflate);
    }

    public void onBindViewHolder(ListCardAdaptor.viewHolder holder, int position) {
        holder.name.setText(model.get(position).getName());
        holder.price.setText(model.get(position).getPrice());
        holder.num.setText(model.get(position).getNum());
        holder.image.setImageResource(model.get(position).getPhoto());
        Float f = Float.valueOf(model.get(position).getNum()) * Float.valueOf(model.get(position).getPrice());
        holder.totPrice.setText(String.valueOf(f));
        ////////
        holder.imgplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(model.get(position).getNum());
                i++;
                model.get(position).setNum(String.valueOf(i));
                holder.num.setText(model.get(position).getNum());
                float f = Float.valueOf(model.get(position).getNum()) * Float.valueOf(model.get(position).getPrice());
                holder.totPrice.setText(String.valueOf(f));

            }
        });

        holder.imgminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(model.get(position).getNum());
                if (i == 0) {
                    model.get(position).setNum("0");
                } else {
                    i--;
                    model.get(position).setNum(String.valueOf(i));
                    holder.num.setText(model.get(position).getNum());
                }
                Float f = Float.valueOf(model.get(position).getNum()) * Float.valueOf(model.get(position).getPrice());
                holder.totPrice.setText(String.valueOf(f));

            }
        });
        //////

    }

    @Override
    public int getItemCount() {
        return model.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {
        TextView name, price, totPrice, num;
        ImageView image, imgplus, imgminus;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_mName);
            price = itemView.findViewById(R.id.txt_mprice);
            totPrice = itemView.findViewById(R.id.txt_mtotalPrice);
            num = itemView.findViewById(R.id.Txt_mNum2);
            image = itemView.findViewById(R.id.mpic);
            imgplus = itemView.findViewById(R.id.mimg_Plus);
            imgminus = itemView.findViewById(R.id.mimg_minus);
        }
    }
}