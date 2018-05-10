package com.example.alien.pactodehonor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {

        //Lista de objetos a mostrar
        ArrayList<Heroe> listaNombres;


public static class MyViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case

    public TextView nombrer;
    public TextView razar;
    public EditText nivelr;

    public MyViewHolder(View view) {
        super(view);

        nombrer = view.findViewById(R.id.RNombre);
        razar = view.findViewById(R.id.RRaza);
        nivelr = view.findViewById(R.id.RNivel);
    }
}



    public MyAdapter( ArrayList<Heroe> listaNombres) {
        this.listaNombres = listaNombres;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_heroe_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Heroe user = listaNombres.get(position);

        holder.nombrer.setText(user.getNombre());
        holder.razar.setText(user.getRaza());
        holder.nivelr.setText(user.getNivel());

    }

    @Override
    public int getItemCount() {
        return listaNombres.size();
    }

}
