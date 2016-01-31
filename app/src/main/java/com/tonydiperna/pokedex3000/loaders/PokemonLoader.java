package com.tonydiperna.pokedex3000.loaders;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.tonydiperna.pokedex3000.BaseService;
import com.tonydiperna.pokedex3000.models.Evolution;
import com.tonydiperna.pokedex3000.models.Pokemon;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class PokemonLoader extends AsyncTaskLoader<Pokemon> {

    private final int _pokemonId;

    public PokemonLoader(Context context, int pokemonId) {
        super(context);
        _pokemonId = pokemonId;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public Pokemon loadInBackground() {
        Log.d("POOP", "loadInBackground");

        Pokemon pokemon = new Pokemon();
        try {
            pokemon = BaseService.getPokemon(_pokemonId);
            return pokemon;
        } catch (JSONException e) {
            e.printStackTrace();
            return pokemon;
        } catch (IOException e) {
            return null;
        }
    }
}
