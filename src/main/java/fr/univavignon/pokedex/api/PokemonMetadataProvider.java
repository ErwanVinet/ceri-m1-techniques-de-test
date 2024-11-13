package fr.univavignon.pokedex.api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        String nom = "";
        int attaque = 0;
        int defense = 0;
        int vitesse = 0;
        boolean trouve = false; // Indicateur pour vérifier si le Pokémon a été trouvé

        // Lecture du fichier CSV et récupération des statistiques
        try (BufferedReader br = new BufferedReader(new FileReader("pokemon.csv"))) {
            String ligne;
            br.readLine(); // Ignorer l'en-tête

            while ((ligne = br.readLine()) != null) {
                String[] valeurs = ligne.split(",");
                if (Objects.equals(valeurs[0], Integer.toString(index))) { // Comparer le numéro
                    // Stocker les valeurs dans les variables locales
                    nom = valeurs[1];
                    attaque = Integer.parseInt(valeurs[3]);
                    defense = Integer.parseInt(valeurs[4]);
                    vitesse = Integer.parseInt(valeurs[5]);
                    trouve = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier CSV : " + e.getMessage());
        }
        return new PokemonMetadata(index, nom, attaque, defense, vitesse);
    }
}
