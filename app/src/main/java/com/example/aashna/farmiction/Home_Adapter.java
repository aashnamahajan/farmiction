package com.example.aashna.farmiction;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Home_Adapter extends RecyclerView.Adapter<Home_Adapter.ContactViewHolder> {
    ArrayList<Home> grids = new ArrayList<Home>();

    public Home_Adapter(ArrayList<Home> grids){
        this.grids=grids;
    }
    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_card_layout_view,parent,false);
        ContactViewHolder contactViewHolder = new ContactViewHolder(view);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Home con = grids.get(position);
        holder.name.setText(con.getName());
    }

    @Override
    public int getItemCount() {
        return grids.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        TextView name;

        public ContactViewHolder(View view) {

            super(view);
            name = (TextView) view.findViewById(R.id.name);
        }
    }
}