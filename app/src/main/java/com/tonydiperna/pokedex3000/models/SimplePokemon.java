package com.tonydiperna.pokedex3000.models;

public class SimplePokemon {
    public static final String NAME = "name";
    public static final String RESOURCE_URI = "resource_uri";

    private int _id;
    private String _name;
    private String _resourceUri;

    public SimplePokemon(int id, String name, String resourceUri) {
        _id = id;
        _name = name;
        _resourceUri = resourceUri;
    }

    public int getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public String getResourceUri() {
        return _resourceUri;
    }
}
