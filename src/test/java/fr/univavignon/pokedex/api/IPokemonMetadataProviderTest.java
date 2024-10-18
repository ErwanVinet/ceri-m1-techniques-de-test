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
        PokemonMetadata pokemon = new PokemonMetadata(1, "Arcanin", 100, 90, 54);
        Mockito.when(provider.getPokemonMetadata(1)).thenReturn(pokemon);
        PokemonMetadata result = provider.getPokemonMetadata(1);
        assertNotNull(result);
        assertEquals(pokemon, result);
        assertEquals("Arcanin", result.getName());
        assertEquals(1, result.getIndex());
        assertEquals(100, result.getAttack());
        assertEquals(90, result.getDefense());
        assertEquals(54, result.getStamina());
    }

}
