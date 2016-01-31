package com.tonydiperna.pokedex3000;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tonydiperna.pokedex3000.models.SimplePokemon;

public class PokedexAdapter extends ArrayAdapter<SimplePokemon> {

    private LayoutInflater inflater;

    public PokedexAdapter(Context context, int resource) {
        super(context, resource);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        ViewHolder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.pokedex_item, parent, false);
            holder = new ViewHolder();
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.number = (TextView) view.findViewById(R.id.number);
        holder.name = (TextView) view.findViewById(R.id.name);

        holder.number.setText("" + getItem(position).getId());
        holder.name.setText(getItem(position).getName());

        return view;
    }

    private class ViewHolder {

        private TextView number;
        private TextView name;

    }
}
