import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PokemonExplorer {

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Pokemon Encyclopedia & Discovery!");
        System.out.print("Enter a Pokemon name: ");

        String pokemonName = input.nextLine();

        getPokemon(pokemonName);

    }

    public static void getPokemon(String pokemonName) throws Exception {

        String url = "https://pokeapi.co/api/v2/pokemon/"
                + pokemonName.toLowerCase().trim();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() == 200) {
            System.out.println(response.body());
        } else {
            System.out.println("Error: " + response.statusCode());
        }

    }
}
