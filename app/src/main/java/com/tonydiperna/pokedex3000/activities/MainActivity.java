package com.tonydiperna.pokedex3000.activities;

import android.content.Intent;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.tonydiperna.pokedex3000.PokedexAdapter;
import com.tonydiperna.pokedex3000.R;
import com.tonydiperna.pokedex3000.loaders.PokedexLoader;
import com.tonydiperna.pokedex3000.models.SimplePokemon;

import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<SimplePokemon>> {

    private PokedexAdapter adapter;
    private ListView listView;
    private View progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = findViewById(R.id.routes_progress_bar);
        listView = (ListView)findViewById(R.id.PokedexListView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            SimplePokemon item = adapter.getItem(position);
            Intent intent = new Intent(MainActivity.this, PokemonActivity.class);
            intent.putExtra("pokemonId", item.getId());
            startActivity(intent);
            }
        });

        if (adapter == null) {
            adapter = new PokedexAdapter(this, R.layout.pokedex_item);
        }
        listView.setAdapter(adapter);

        getSupportLoaderManager().restartLoader(0, null, this);
    }

    @Override
    public Loader<List<SimplePokemon>> onCreateLoader(int id, Bundle args) {
        Log.d("POOP", "onCreateLoader");
        return new PokedexLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<SimplePokemon>> loader, List<SimplePokemon> data) {
        adapter.clear();
        hideProgressBar();
        if (data == null) {
            Toast.makeText(this, "Could not load pokemon. Check network connection", Toast.LENGTH_LONG).show();
        } else {
            adapter.addAll(data);
            adapter.sort(new Comparator<SimplePokemon>() {
                @Override
                public int compare(SimplePokemon lhs, SimplePokemon rhs) {
                    if(lhs.getId() > rhs.getId()) {
                        return 1;
                    }else if(lhs.getId() < rhs.getId()) {
                        return -1;
                    }

                    return 0;
                }
            });
            adapter.notifyDataSetChanged();
        }
    }

    private void hideProgressBar() {
        progress.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoaderReset(Loader<List<SimplePokemon>> loader) {
        //Not used
    }
}
