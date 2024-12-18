package fr.univavignon.pokedex.api;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class IPokemonMetadataProviderTest {
    private IPokemonMetadataProvider provider;

    @Before
    public void setUp() throws Exception {
        provider = new PokemonMetadataProvider();
    }

    @Test
    public void testGetPokemonMetadata() throws Exception {
        PokemonMetadata pokemon = provider.getPokemonMetadata(1);
        //Mockito.when(provider.getPokemonMetadata(0)).thenReturn(pokemon);
        //PokemonMetadata result = provider.getPokemonMetadata(0);
        assertNotNull(pokemon);
        //assertEquals(pokemon, result);
        assertEquals("Bulbizarre", pokemon.getName());
        assertEquals(1, pokemon.getIndex());
        assertEquals(126, pokemon.getAttack());
        assertEquals(126, pokemon.getDefense());
        assertEquals(90, pokemon.getStamina());
    }

}
