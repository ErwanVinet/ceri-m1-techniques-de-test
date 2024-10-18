package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexTest {

    private IPokedex provider;

    @Before
    public void setUp() throws Exception {
        provider = Mockito.mock(IPokedex.class);
    }

    @Test
    public void addPokemonTest() throws Exception {
        Pokemon pokemon = new Pokemon(1, "Arcanin", 1, 2, 3, 4, 5, 6, 7, 8.5);
        Mockito.when(provider.addPokemon(pokemon)).thenReturn(1);
        int index = provider.addPokemon(pokemon);
        assertEquals(1, index);
        Mockito.verify(provider).addPokemon(pokemon);
    }

    @Test
    public void getPokemonTest() throws Exception {
        Pokemon pokemon = new Pokemon(1, "Arcanin", 1, 2, 3, 4, 5, 6, 7, 8.5);
        Mockito.when(provider.getPokemon(1)).thenReturn(pokemon);
        Pokemon result = provider.getPokemon(1);
        assertEquals(pokemon, result);
        Mockito.verify(provider).getPokemon(1);
    }
}
