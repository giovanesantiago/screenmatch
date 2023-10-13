package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.exception.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.model.Titulo;
import br.com.alura.screenmatch.model.TituloDTO;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leia = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting().create();

        while (true){

            System.out.println("Digite um filme para buscar : ");
            busca = leia.nextLine().replaceAll(" ", "-");

            if (busca.equalsIgnoreCase("sair")){
                break;
            }

            String url = "https://www.omdbapi.com/?t=" + busca + "&apikey=1461add3";
            try{
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                System.out.println(response.body());
                String json = response.body();



                TituloDTO tituloDTO = gson.fromJson(json, TituloDTO.class);
                System.out.println(tituloDTO);
                Titulo meuTitulo = null;

                meuTitulo = new Titulo(tituloDTO);
                System.out.println(meuTitulo);

               titulos.add(meuTitulo);
            }catch (NumberFormatException e){
                System.out.println("Deu merda ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e){
                System.out.println("Error no argumento ");
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(titulos);

        FileWriter escrita =  new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();

        try {
            FileWriter writer = new FileWriter("arquivo");

            writer.write("Hello");
            writer.close();
            writer.write(" World!");
            writer.close();
        } catch (Exception e) {
            System.out.println("Erro no codigo da atividade");
        }

    }
}
