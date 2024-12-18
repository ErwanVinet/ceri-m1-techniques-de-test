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
        assertEquals(49, pokemon.getAttack());
        assertEquals(49, pokemon.getDefense());
        assertEquals(45, pokemon.getStamina());
    }

    @Test
    pubic void testException() throws Exception {
        PokemonMetaData pokemon = provider.getPokemonMetadata(-1);
        Exception exception = assertThrows(PokedexException.class, () -> {
            PokemonMetaData pokemon = provider.getPokemonMetadata(-1);
        });

        assertEquals("Pokemon introuvable", exception.getMessage());
    }

}
