package com.example.alien.pactodehonor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

import static com.example.alien.pactodehonor.CargaDatos.heroes;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {


        LinkedList<Heroe> listaNombres;


public static class MyViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case

    public TextView nombrer;
    public TextView razar;
    public TextView nivelr;

    public MyViewHolder(View view) {
        super(view);

        nombrer = view.findViewById(R.id.RNombre);
        razar = view.findViewById(R.id.RRaza);
        nivelr = view.findViewById(R.id.RNivel);
    }
}



    public MyAdapter( LinkedList<Heroe> listaNombres) {

        this.listaNombres = listaNombres;
        notifyDataSetChanged();

    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_heroe_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Heroe heroe = listaNombres.get(position);

        holder.nombrer.setText(heroe.getNombre());
        holder.razar.setText(heroe.getRaza());
        holder.nivelr.setText(heroe.getNivel());

    }

    @Override
    public int getItemCount() {
        return listaNombres.size();
    }

}
