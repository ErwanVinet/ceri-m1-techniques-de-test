package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() throws Exception {
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void testGetPokemonMetadata() throws Exception {
        //Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        //Mockito.when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pokemon);
        Pokemon result = pokemonFactory.createPokemon(1, 613, 64, 4000, 4);

        assertNotNull(result);
        assertEquals(result.getIndex(), 1);
        assertEquals(result.getCp(), 613);
        assertEquals(result.getHp(), 64);
        assertEquals(result.getDust(), 4000);
        assertEquals(result.getCandy(), 4);
        assertTrue(result.getIv() >= 0 && result.getIv() <= 100);
    }

    @Test
    public void testGetPokemonMetadataException() throws Exception {
        Exception exception = assertThrows(Erreur.class, () -> {
            Pokemon p = pokemonFactory.createPokemon(-1, 613, 64, 4000, 4);
            assertNull(p);
        });
    }
}