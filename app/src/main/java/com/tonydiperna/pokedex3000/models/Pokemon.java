package com.tonydiperna.pokedex3000.models;


import java.util.Arrays;

public class Pokemon {

    public static final String NAME = "name";
    public static final String RESOURCE_URI = "resource_uri";
    public static final String ABILITIES = "abilities";
    public static final String EGG_GROUPS = "egg_groups";
    public static final String EVOLUTIONS = "evolutions";
    public static final String MOVES = "moves";
    public static final String TYPES = "types";
    public static final String CATCH_RATE = "catch_rate";
    public static final String SPECIES = "species";
    public static final String HP = "hp";
    public static final String ATTACK = "attack";
    public static final String DEFENSE = "defense";
    public static final String SPECIAL_ATTACK = "sp_atk";
    public static final String SPECIAL_DEFENSE = "sp_def";
    public static final String SPEED = "speed";
    public static final String TOTAL = "total";
    public static final String EGG_CYCLES = "egg_cycles";
    public static final String EV_YIELD = "ev_yield";
    public static final String EXPERIENCE = "exp";
    public static final String GROWTH_RATE = "growth_rate";
    public static final String HEIGHT = "height";
    public static final String WEIGHT = "weight";
    public static final String HAPPINESS = "happiness";
    public static final String MF_RATIO = "male_femal_ratio";

    private int _id;
    private String _name;
    private String _resourceUri;
    private String[] _abilities;
    private String[] _eggGroups;
    private Evolution _evolution;
    private String[] _moves;
    private String[] _types;
    private int _catchRate;
    private String _species;
    private int _hp;
    private int _attack;
    private int _defense;
    private int _spAtk;
    private int _spDef;
    private int _speed;
    private int _total;
    private int _eggCycles;
    private String _evYield;
    private int _exp;
    private String _growthRate;
    private String _height;
    private int _weight;
    private int _happiness;
    private String _maleFemaleRatio;

    public Pokemon() {
        this(0, "", "", new String[0], new String[0], new Evolution(), new String[0], new String[0], 0, "", 0, 0, 0, 0, 0, 0, 0, 0, "", 0, "", "", 0, 0, "");
    }

    public Pokemon(int id, String name, String resourceUri, String[] abilities, String[] eggGroups, Evolution evolution, String[] moves, String[] types, int catchRate, String species, int hp, int attack, int defense, int spAtk, int spDef, int speed, int total, int eggCycles, String evYield, int exp, String growthRate, String height, int weight, int happiness, String maleFemaleRatio) {
        _id = id;
        _name = name;
        _resourceUri = resourceUri;
        _abilities = abilities;
        _eggGroups = eggGroups;
        _evolution = evolution;
        _moves = moves;
        _types = types;
        _catchRate = catchRate;
        _species = species;
        _hp = hp;
        _attack = attack;
        _defense = defense;
        _spAtk = spAtk;
        _spDef = spDef;
        _speed = speed;
        _total = total;
        _eggCycles = eggCycles;
        _evYield = evYield;
        _exp = exp;
        _growthRate = growthRate;
        _height = height;
        _weight = weight;
        _happiness = happiness;
        _maleFemaleRatio = maleFemaleRatio;
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

    public String[] getAbilities() {
        return _abilities;
    }

    public String[] getEggGroups() {
        return _eggGroups;
    }

    public Evolution getEvolution() {
        return _evolution;
    }

    public String[] getMoves() {
        return _moves;
    }

    public String[] getTypes() {
        return _types;
    }

    public int getCatchRate() {
        return _catchRate;
    }

    public String getSpecies() {
        return _species;
    }

    public int getHp() {
        return _hp;
    }

    public int getAttack() {
        return _attack;
    }

    public int getDefense() {
        return _defense;
    }

    public int getSpAtk() {
        return _spAtk;
    }

    public int getSpDef() {
        return _spDef;
    }

    public int getSpeed() {
        return _speed;
    }

    public int getTotal() {
        return _total;
    }

    public int getEggCycles() {
        return _eggCycles;
    }

    public String getEvYield() {
        return _evYield;
    }

    public int getExp() {
        return _exp;
    }

    public String getGrowthRate() {
        return _growthRate;
    }

    public String getHeight() {
        return _height;
    }

    public int getWeight() {
        return _weight;
    }

    public int getHappiness() {
        return _happiness;
    }

    public String getMaleFemaleRatio() {
        return _maleFemaleRatio;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "_id=" + _id +
                ", _name='" + _name + '\'' +
                ", _resourceUri='" + _resourceUri + '\'' +
                ", _abilities=" + Arrays.toString(_abilities) +
                ", _eggGroups=" + Arrays.toString(_eggGroups) +
                ", _evolution=" + _evolution +
                ", _moves=" + Arrays.toString(_moves) +
                ", _types=" + Arrays.toString(_types) +
                ", _catchRate=" + _catchRate +
                ", _species='" + _species + '\'' +
                ", _hp=" + _hp +
                ", _attack=" + _attack +
                ", _defense=" + _defense +
                ", _spAtk=" + _spAtk +
                ", _spDef=" + _spDef +
                ", _speed=" + _speed +
                ", _total=" + _total +
                ", _eggCycles=" + _eggCycles +
                ", _evYield='" + _evYield + '\'' +
                ", _exp=" + _exp +
                ", _growthRate='" + _growthRate + '\'' +
                ", _height='" + _height + '\'' +
                ", _weight=" + _weight +
                ", _happiness=" + _happiness +
                ", _maleFemaleRatio='" + _maleFemaleRatio + '\'' +
                '}';
    }
}
