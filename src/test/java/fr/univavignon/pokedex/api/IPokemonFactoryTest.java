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
        Pokemon pokemon = new Pokemon(1, "Arcanin", 1, 2, 3, 4, 5, 6, 7, 8.5);
        Mockito.when(provider.createPokemon(1, 4, 5, 6, 7)).thenReturn(pokemon);
        Pokemon result = provider.createPokemon(1, 4, 5, 6, 7);
        assertEquals(pokemon, result);
        assertEquals(result.getCp(), 4);
        assertEquals(result.getHp(), 5);
        assertEquals(result.getDust(), 6);
        assertEquals(result.getCandy(), 7);
    }
}