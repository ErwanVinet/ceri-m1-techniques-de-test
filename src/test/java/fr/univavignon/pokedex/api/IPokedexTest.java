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

    private IPokedex provider;

    @Before
    public void setUp() throws Exception {
        //provider = Mockito.mock(IPokedex.class);
        provider = new Pokedex();
    }

    @Test
    public void addPokemonTest() throws Exception {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        //Mockito.when(provider.addPokemon(pokemon)).thenReturn(0);
        int index = provider.addPokemon(pokemon);
        assertEquals(0, index);
        //Mockito.verify(provider).addPokemon(pokemon);
    }

    @Test
    public void getPokemonTest() throws Exception {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        //Mockito.when(provider.getPokemon(0)).thenReturn(pokemon);
        Pokemon result = provider.getPokemon(0);
        assertNotNull(result);
        assertEquals(pokemon, result);
        assertEquals(pokemon.getIndex(), result.getIndex());
        assertEquals(pokemon.getCp(), result.getCp());
        assertEquals(pokemon.getHp(), result.getHp());
        assertEquals(pokemon.getDust(), result.getDust());
        assertEquals(pokemon.getCandy(), result.getCandy());
        //Mockito.verify(provider).getPokemon(0);
    }

    @Test
    public void testGetPokemonListTest() throws Exception {
        Pokemon bulbi = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Pokemon aqua = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1.00);
        List<Pokemon> list = Arrays.asList(aqua, bulbi);
        //Mockito.when(provider.getPokemons()).thenReturn(list);
        List<Pokemon> result = provider.getPokemons();
        assertEquals(2, list.size());
        assertEquals(aqua, list.get(0));
        assertEquals(bulbi, list.get(1));
        //Mockito.verify(provider).getPokemons();
        assertThrows(UnsupportedOperationException.class, () -> {
            result.add(new Pokemon(150, "Mewtwo", 126, 126, 90, 613, 64, 4000, 4, 0.56));
        });
    }


    @Test
    public void getPokemonsOrderTest() throws Exception {
        Pokemon bulbi = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Pokemon aqua = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1.00);
        List<Pokemon> list = Arrays.asList(bulbi, aqua);
        list.sort(Comparator.comparing(Pokemon::getName));
        Comparator<Pokemon> comparatorByName = Comparator.comparing(Pokemon::getName);
        //Mockito.when(provider.getPokemons(comparatorByName)).thenReturn(list);
        List<Pokemon> sortedPokemons = provider.getPokemons(comparatorByName);

        assertEquals("Bulbizarre", sortedPokemons.get(1).getName());
        assertEquals("Aquali", sortedPokemons.get(0).getName());

        // Vérifier l'appel du mock avec le Comparator
        //Mockito.verify(provider).getPokemons(comparatorByName);
    }

    @Test
    public void sizeTest() throws Exception {
        Pokemon bulbi = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Pokemon aqua = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1.00);
        List<Pokemon> list = Arrays.asList(bulbi, aqua);
        //Mockito.when(provider.size()).thenReturn(list.size());
        int tailleList = provider.size();
        assertEquals(tailleList, list.size());
        //Mockito.verify(provider).size();
    }
}
