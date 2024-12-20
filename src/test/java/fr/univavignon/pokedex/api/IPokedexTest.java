package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IPokedexTest {

    private IPokedex pokedex;
    private IPokemonFactory pokemonFactory;
    private IPokemonMetadataProvider provider;

    @Before
    public void setUp() throws Exception {
        //pokedex = Mockito.mock(IPokedex.class);
        pokedex = new Pokedex();
        pokemonFactory  = new PokemonFactory();
        provider = new PokemonMetadataProvider();
    }

    @Test
    public void addPokemonTest() throws Exception {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        //Mockito.when(pokedex.addPokemon(pokemon)).thenReturn(0);
        int index = pokedex.addPokemon(pokemon);
        assertEquals(0, index);
        //Mockito.verify(pokedex).addPokemon(pokemon);
    }

    @Test
    public void getPokemonTest() throws Exception {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        //Mockito.when(pokedex.getPokemon(0)).thenReturn(pokemon);
        pokedex.addPokemon(pokemon);
        Pokemon result = pokedex.getPokemon(0);
        assertNotNull(result);
        assertEquals(pokemon, result);
        assertEquals(pokemon.getIndex(), result.getIndex());
        assertEquals(pokemon.getCp(), result.getCp());
        assertEquals(pokemon.getHp(), result.getHp());
        assertEquals(pokemon.getDust(), result.getDust());
        assertEquals(pokemon.getCandy(), result.getCandy());
        //Mockito.verify(pokedex).getPokemon(0);
    }

    @Test
    public void getPokemonListTest() throws Exception {
        Pokemon bulbi = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Pokemon aqua = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1.00);
        List<Pokemon> list = Arrays.asList(aqua, bulbi);
        pokedex.addPokemon(aqua);
        pokedex.addPokemon(bulbi);
        //Mockito.when(pokedex.getPokemons()).thenReturn(list);
        List<Pokemon> result = pokedex.getPokemons();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(aqua, result.get(0));
        assertEquals(list, result);
        //Mockito.verify(pokedex).getPokemons();
        
    }


    @Test
    public void getPokemonsOrderTest() throws Exception {
        Pokemon bulbi = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Pokemon aqua = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1.00);
        List<Pokemon> list = Arrays.asList(bulbi, aqua);
        list.sort(Comparator.comparing(Pokemon::getName));

        pokedex.addPokemon(bulbi);
        pokedex.addPokemon(aqua);
        Comparator<Pokemon> comparatorByName = Comparator.comparing(Pokemon::getName);
        //Mockito.when(pokedex.getPokemons(comparatorByName)).thenReturn(list);
        assertNotNull(comparatorByName);
        List<Pokemon> sortedPokemons = pokedex.getPokemons(comparatorByName);
        assertNotNull(sortedPokemons);
        assertEquals(2, sortedPokemons.size());
        assertEquals("Bulbizarre", sortedPokemons.get(1).getName());
        assertEquals("Aquali", sortedPokemons.get(0).getName());

        // Vérifier l'appel du mock avec le Comparator
        //Mockito.verify(pokedex).getPokemons(comparatorByName);
    }

    @Test
    public void sizeTest() throws Exception {
        assertEquals(0, pokedex.size());
        Pokemon bulbi = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Pokemon aqua = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1.00);
        //List<Pokemon> list = Arrays.asList(bulbi, aqua);
        //Mockito.when(pokedex.size()).thenReturn(list.size());
        pokedex.addPokemon(bulbi);
        pokedex.addPokemon(aqua);
        assertEquals(pokedex.size(), 2);
        //Mockito.verify(pokedex).size();
    }


    @Test
    public void createPokemonTest() throws Exception {
        Pokemon pokemon = pokemonFactory.createPokemon(1, 613, 64, 4000, 4);
        Pokemon result = pokedex.createPokemon(1, 613, 64, 4000, 4);
        assertNotNull(result);
        assertEquals(pokemon.getIndex(), result.getIndex());
        assertEquals(pokemon.getCp(), result.getCp());
        assertEquals(pokemon.getHp(), result.getHp());
        assertEquals(pokemon.getDust(), result.getDust());
        assertEquals(pokemon.getCandy(), result.getCandy());
    }


    @Test
    public void getPokemonMetaDataTest() throws Exception {
        PokemonMetadata meta = provider.getPokemonMetadata(1);
        PokemonMetadata data = pokedex.getPokemonMetadata(1);
        assertNotNull(data);
        assertEquals(meta.getName(), data.getName());
        assertEquals(meta.getIndex(), data.getIndex());
        assertEquals(meta.getAttack(), data.getAttack());
        assertEquals(meta.getDefense(), data.getDefense());
        assertEquals(meta.getStamina(), data.getStamina());
    }
}
