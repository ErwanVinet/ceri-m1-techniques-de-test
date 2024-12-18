package fr.univavignon.pokedex.api;

import java.util.Random;

public class PokemonFactory implements IPokemonFactory {

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        try {
            PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
            PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);

            Random random = new Random();
            int ivAttack = random.nextInt(16);
            int ivDefense = random.nextInt(16);
            int ivVitesse = random.nextInt(16);
            double iv = (double) (ivAttack + ivDefense + ivVitesse) / 45;

            return new Pokemon(index, metadata.getName(), metadata.getAttack() + ivAttack, metadata.getDefense() + ivDefense, metadata.getStamina() + ivVitesse, cp, hp, dust, candy, iv);
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du pokemon");
        }

        return null;
    }
}
