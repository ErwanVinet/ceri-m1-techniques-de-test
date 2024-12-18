package fr.univavignon.pokedex.api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private Map<Integer, PokemonMetadata> map;

    public PokemonMetadataProvider() {
        map = new HashMap<>();
        dataCsv();
    }


    private void dataCsv(){
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/fr/univavignon/pokedex/api/pokemon.csv"))) {
            String ligne;
            br.readLine(); // Ignorer l'en-tête

            while ((ligne = br.readLine()) != null) {
                String[] valeurs = ligne.split(",");
                int index = Integer.parseInt(valeurs[0]);
                String nom = valeurs[1];
                int attaque = Integer.parseInt(valeurs[3]);
                int defense = Integer.parseInt(valeurs[4]);
                int vitesse = Integer.parseInt(valeurs[5]);
                PokemonMetadata metadata = new PokemonMetadata(index, nom, attaque, defense, vitesse);
                map.put(index, metadata);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier CSV : " + e.getMessage());
        }
    }
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (map.containsKey(index)){
            return map.get(index);
        }
        else{
            throw new PokedexException("Pokemon introvable");
        }
    }
}
