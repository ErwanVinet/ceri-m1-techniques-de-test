package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest {

    private IPokedexFactory provider;

    @Before
    public void setUp() throws Exception {
        provider = Mockito.mock(IPokedexFactory.class);
    }

    @Test
    public void testCreate() throws Exception {
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        IPokemonMetadataProvider metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
        Mockito.when(provider.createPokedex(metadataProvider, pokedex)).thenReturn(pokedex);
        IPokedex result = provider.createPokedex(metadataProvider, pokedex);
        assertEquals(pokedex, result);
        Mockito.verify(provider).createPokedex(metadataProvider, pokedex);
    }
}
