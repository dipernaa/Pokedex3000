package com.tonydiperna.pokedex3000.activities;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.tonydiperna.pokedex3000.R;
import com.tonydiperna.pokedex3000.loaders.PokemonLoader;
import com.tonydiperna.pokedex3000.models.Pokemon;


public class PokemonActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Pokemon> {

    private int _pokemonId;
    private TextView textView;
    private ImageView imageView;
    private View progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        _pokemonId = getIntent().getIntExtra("pokemonId", 1);
        progress = findViewById(R.id.routes_progress_bar);
        imageView = (ImageView) findViewById(R.id.pokemon_sprite);
        textView = (TextView) findViewById(R.id.pokemon_name);

        getSupportLoaderManager().restartLoader(0, null, this);
    }

    @Override
    public Loader<Pokemon> onCreateLoader(int id, Bundle args) {
        Log.d("POOP", "onCreateLoader");
        return new PokemonLoader(this, _pokemonId);
    }

    @Override
    public void onLoadFinished(Loader<Pokemon> loader, Pokemon data) {
        hideProgressBar();
        if (data == null) {
            Toast.makeText(this, "Could not load pokemon. Check network connection", Toast.LENGTH_LONG).show();
        } else {
            Picasso.with(this).load("http://pokeapi.co" + data.getSprites()[0]).into(imageView);
            textView.setText(data.getName());
        }
    }

    private void hideProgressBar() {
        progress.setVisibility(View.GONE);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoaderReset(Loader<Pokemon> loader) {
        //Not used
    }
}
