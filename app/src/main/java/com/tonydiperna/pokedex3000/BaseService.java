package com.tonydiperna.pokedex3000;

import android.util.Log;

import com.google.gson.Gson;
import com.tonydiperna.pokedex3000.models.Evolution;
import com.tonydiperna.pokedex3000.models.Pokemon;
import com.tonydiperna.pokedex3000.models.SimplePokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BaseService {

    private static final OkHttpClient client = new OkHttpClient();

    public static final String API = "http://pokeapi.co/api/v1/";

    public static final String POKEDEX_ENDPOINT = "pokedex/";
    public static final String POKEMON = "pokemon";
    public static final int MAX_POKEMON_ID = 649;

    public static final String POKEMON_ENDPOINT = "pokemon/";

    public static Response request(Request request) throws IOException {
        Log.d("Endpoint", request.url().toString());
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            Log.d("Error", "Response Code: " + response.code());
            throw new IOException("Unexpected code " + response.body());
        }
        return response;
    }

    public static Response request(String endpoint, int id) throws IOException {
        Request request = new Request.Builder()
            .get()
            .url(API + endpoint + id)
            .build();
        return request(request);
    }

    public static List<SimplePokemon> getPokedex(int id) throws IOException, JSONException {
        Log.d("POOP", "getPokedex");
        Response response = request(POKEDEX_ENDPOINT, id);
        JSONObject object = new JSONObject(response.body().string());
        JSONArray pokemans = object.getJSONArray(POKEMON);
        List<SimplePokemon> result = new ArrayList<>();
        String name;
        for(int i = 0; i < pokemans.length(); i++) {
            JSONObject pokemon = pokemans.getJSONObject(i);
            int pokemonId = getIdFromUri(pokemon.getString(SimplePokemon.RESOURCE_URI));
            if(pokemonId <= MAX_POKEMON_ID) {
                name = pokemon.getString(SimplePokemon.NAME);
                name = name.substring(0,1).toUpperCase() + name.substring(1);
                result.add(new SimplePokemon(pokemonId, name, pokemon.getString(SimplePokemon.RESOURCE_URI)));
            }
        }
        return result;
    }

    public static Pokemon getPokemon(int id) throws IOException, JSONException {
        Log.d("POOP", "getPokemon");
        Response response = request(POKEMON_ENDPOINT, id);
        JSONObject pokemon = new JSONObject(response.body().string());

        JSONArray jsonArray = pokemon.getJSONArray(Pokemon.ABILITIES);
        String[] abilities = new String[jsonArray.length()];
        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            abilities[i] = obj.getString(Pokemon.NAME);
        }

        jsonArray = pokemon.getJSONArray(Pokemon.EGG_GROUPS);
        String[] eggGroups = new String[jsonArray.length()];
        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            eggGroups[i] = obj.getString(Pokemon.NAME);
        }

        JSONObject evolutionObject = pokemon.getJSONArray(Pokemon.EVOLUTIONS).getJSONObject(0);
        Evolution evolution = new Evolution(evolutionObject.getInt(Evolution.LEVEL), evolutionObject.getString(Evolution.NAME), evolutionObject.getString(Evolution.METHOD), evolutionObject.getString(Evolution.RESOURCE_URI));

        jsonArray = pokemon.getJSONArray(Pokemon.MOVES);
        String[] moves = new String[jsonArray.length()];
        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            moves[i] = obj.getString(Pokemon.NAME);
        }

        jsonArray = pokemon.getJSONArray(Pokemon.TYPES);
        String[] types = new String[jsonArray.length()];
        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            types[i] = obj.getString(Pokemon.NAME);
        }

        String name = pokemon.getString(Pokemon.NAME);
        String resourceUri = pokemon.getString(Pokemon.RESOURCE_URI);
        int catchRate = pokemon.getInt(Pokemon.CATCH_RATE);
        String species = pokemon.getString(Pokemon.SPECIES);
        int hp = pokemon.getInt(Pokemon.HP);
        int attack = pokemon.getInt(Pokemon.ATTACK);
        int defense = pokemon.getInt(Pokemon.DEFENSE);
        int spAtk = pokemon.getInt(Pokemon.SPECIAL_ATTACK);
        int spDef = pokemon.getInt(Pokemon.SPECIAL_DEFENSE);
        int speed = pokemon.getInt(Pokemon.SPEED);
        int total = pokemon.getInt(Pokemon.TOTAL);
        int eggCycles = pokemon.getInt(Pokemon.EGG_CYCLES);
        String evYield = pokemon.getString(Pokemon.EV_YIELD);
        int exp = pokemon.getInt(Pokemon.EXPERIENCE);
        String growthRate = pokemon.getString(Pokemon.GROWTH_RATE);
        String height = pokemon.getString(Pokemon.HEIGHT);
        int weight = pokemon.getInt(Pokemon.WEIGHT);
        int happiness = pokemon.getInt(Pokemon.HAPPINESS);
//        String maleFemaleRatio = pokemon.getString(Pokemon.MF_RATIO);

        Pokemon result = new Pokemon(id, name, resourceUri, abilities, eggGroups, evolution, moves, types, catchRate, species, hp, attack, defense, spAtk, spDef, speed, total, eggCycles, evYield, exp, growthRate, height, weight, happiness, "");

        return result;
    }

    private static int getIdFromUri(String resourceUri) {
        String[] uriComponents =  resourceUri.split("/");
        return Integer.parseInt(uriComponents[uriComponents.length - 1]);
    }
}
