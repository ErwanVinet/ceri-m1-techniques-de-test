package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

    private List<Pokemon> pokedex;

    public Pokedex() {
        this.pokedex = new ArrayList<Pokemon>();
    }

    @Override
    public int size() {
        return pokedex.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokedex.add(pokemon);
        return pokemon.getIndex();
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        return pokedex.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokedex;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        if (order != null) {
            pokedex.sort(order);
        }
        return pokedex;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        PokemonFactory pokemonFactory = new PokemonFactory();
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }
}
