package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {
    private IPokemonFactory provider;

    @Before
    public void setUp() throws Exception {
        provider = Mockito.mock(IPokemonFactory.class);
    }

    @Test
    public void testGetPokemonMetadata() throws Exception {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Mockito.when(provider.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pokemon);
        Pokemon result = provider.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(result);
        assertEquals(pokemon, result);
        assertEquals(result.getIndex(), 0);
        assertEquals(result.getCp(), 613);
        assertEquals(result.getHp(), 64);
        assertEquals(result.getDust(), 4000);
        assertEquals(result.getCandy(), 4);
        assertEquals(result.getIv(), 0.56,0);
    }
}