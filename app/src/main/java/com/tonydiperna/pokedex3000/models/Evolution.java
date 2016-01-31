package com.tonydiperna.pokedex3000.models;

public class Evolution {

    public static final String LEVEL = "level";
    public static final String NAME = "to";
    public static final String METHOD = "method";
    public static final String RESOURCE_URI = "resource_uri";

    private int _level;
    private String _name;
    private String _method;
    private String _resourceUri;

    public Evolution() {
        this(0, "", "", "");
    }

    public Evolution(int level, String name, String method, String resourceUri) {
        _level = level;
        _name = name;
        _method = method;
        _resourceUri = resourceUri;
    }

    public int getLevel() {
        return _level;
    }

    public String getName() {
        return _name;
    }

    public String getMethod() {
        return _method;
    }

    public String getResourceUri() {
        return _resourceUri;
    }

    @Override
    public String toString() {
        return "Evolution{" +
                "_level=" + _level +
                ", _name='" + _name + '\'' +
                ", _method='" + _method + '\'' +
                ", _resourceUri='" + _resourceUri + '\'' +
                '}';
    }
}
