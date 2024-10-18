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
        provider = Mockito.mock(IPokemonMetadataProvider.class);
    }

    @Test
    public void testGetPokemonMetadata() throws Exception {
        PokemonMetadata pokemon = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        Mockito.when(provider.getPokemonMetadata(0)).thenReturn(pokemon);
        PokemonMetadata result = provider.getPokemonMetadata(0);
        assertNotNull(result);
        assertEquals(pokemon, result);
        assertEquals("Bulbizarre", result.getName());
        assertEquals(0, result.getIndex());
        assertEquals(126, result.getAttack());
        assertEquals(126, result.getDefense());
        assertEquals(90, result.getStamina());
    }

}
