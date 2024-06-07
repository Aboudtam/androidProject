package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class data extends RecyclerView.Adapter<data.ViewHolder>{
    private Context context;
    private List<car> items;


    public data(Context context, List<car> items){
        this.context = context;
        this.items = items;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_viwe,
                parent,
                false);

        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final car car = items.get(position);
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.image);
        Glide.with(context).load(car.getPhoto()).into(imageView);
        TextView txt = (TextView)cardView.findViewById(R.id.txtName);
        txt.setText("name : "+car.getName());
        Button Bookbu = (Button)cardView.findViewById(R.id.Bookbu);
        ImageButton canselBu = (ImageButton)cardView.findViewById(R.id.canselBu);
        TextView txt1 = (TextView)cardView.findViewById(R.id.textPrice);
        txt1.setText("\n id :"+ car.getId()+ "\n seatnum : "+ car.getSeat_num()+
                "\n type :"+car.getType()+"\n availability : "+car.getAvailability() +"\n year : " + car.getYear() );
        txt1.setVisibility(View.INVISIBLE);
        cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                txt1.setVisibility(View.VISIBLE);
                Bookbu.setVisibility(View.VISIBLE);
                canselBu.setVisibility(View.VISIBLE);
            }
        });
        canselBu.setOnClickListener(view -> {
            txt1.setVisibility(View.INVISIBLE);
            Bookbu.setVisibility(View.INVISIBLE);
            canselBu.setVisibility(View.INVISIBLE);
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
        }

    }

}
