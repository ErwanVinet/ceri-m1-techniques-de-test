package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory provider;

    @Before
    public void setUp() throws Exception {
        provider = Mockito.mock(IPokemonTrainerFactory.class);
    }

    @Test
    public void testCreate() throws Exception{
        IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        PokemonTrainer pokemonTrainer = new PokemonTrainer("Dylan", Team.INSTINCT, pokedex);
        Mockito.when(provider.createTrainer("Dylan", Team.INSTINCT, pokedexFactory)).thenReturn(pokemonTrainer);
        PokemonTrainer result = provider.createTrainer("Dylan", Team.INSTINCT, pokedexFactory);
        assertEquals(pokemonTrainer, result);
        Mockito.verify(provider).createTrainer("Dylan", Team.INSTINCT, pokedexFactory);
    }
}
