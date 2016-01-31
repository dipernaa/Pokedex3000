package com.tonydiperna.pokedex3000.loaders;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.tonydiperna.pokedex3000.BaseService;
import com.tonydiperna.pokedex3000.models.SimplePokemon;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PokedexLoader extends AsyncTaskLoader<List<SimplePokemon>> {

    public static final int POKEDEX_ID = 1;

    public PokedexLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public List<SimplePokemon> loadInBackground() {
        Log.d("POOP", "loadInBackground");
        List<SimplePokemon> pokemon = new ArrayList<>();
        try {
            pokemon = BaseService.getPokedex(POKEDEX_ID);
            return pokemon;
        } catch (JSONException e) {
            return pokemon;
        } catch (IOException e) {
            return null;
        }
    }
}
