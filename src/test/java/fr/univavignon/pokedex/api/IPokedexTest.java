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
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Mockito.when(provider.addPokemon(pokemon)).thenReturn(0);
        int index = provider.addPokemon(pokemon);
        assertEquals(0, index);
        Mockito.verify(provider).addPokemon(pokemon);
    }

    @Test
    public void getPokemonTest() throws Exception {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Mockito.when(provider.getPokemon(0)).thenReturn(pokemon);
        Pokemon result = provider.getPokemon(0);
        assertNotNull(result);
        assertEquals(pokemon, result);
        Mockito.verify(provider).getPokemon(0);
    }
}
