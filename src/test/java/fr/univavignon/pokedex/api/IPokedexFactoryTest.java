package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest {

    private IPokedexFactory provider;
    private IPokedex pokedex;
    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() throws Exception {
        //provider = Mockito.mock(IPokedexFactory.class);
        provider = new PokedexFactory();
        //pokedex = Mockito.mock(IPokedex.class);
        pokedex = new Pokedex();
        //metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        metadataProvider = PokemonMetadataProvider();
        //Mockito.when(provider.createPokedex(metadataProvider, pokedex)).thenReturn(pokedex);
    }

    @Test
    public void testCreate() throws Exception {
        IPokedex result = provider.createPokedex(metadataProvider, pokedex);
        assertNotNull(result);
    }
}
