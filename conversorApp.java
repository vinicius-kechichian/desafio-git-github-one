import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class conversorApp {

    public static void main(String[] args) {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.exchangerate-api.com/v4/latest/USD"))
                .GET()
                .build();

        try {

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            int status = response.statusCode();
            System.out.println("Status da resposta: " + status);

            if (status == 200) {

                String json = response.body();

                JsonElement elemento = JsonParser.parseString(json);
                JsonObject objectRoot = elemento.getAsJsonObject();
                JsonObject rates = objectRoot.getAsJsonObject("rates");

                String[] moedas = {"ARS", "BOB", "BRL", "CLP", "COP", "USD"};

                System.out.println("Moedas disponíveis:");
                for (String moeda : moedas) {
                    if (rates.has(moeda)) {
                        double taxa = rates.get(moeda).getAsDouble();
                        System.out.println(moeda + " = " + taxa);
                    }
                }

                Scanner scanner = new Scanner(System.in);
                int opcao = -1;

                while (opcao != 0) {

                    System.out.println("\n=== CONVERSOR DE MOEDAS ===");
                    System.out.println("1 - USD → BRL");
                    System.out.println("2 - BRL → USD");
                    System.out.println("3 - USD → ARS");
                    System.out.println("4 - ARS → USD");
                    System.out.println("5 - USD → COP");
                    System.out.println("6 - COP → USD");
                    System.out.println("0 - Sair");
                    System.out.print("Escolha uma opção: ");

                    opcao = scanner.nextInt();

                    if (opcao == 0) {
                        System.out.println("Encerrando programa...");
                        break;
                    }

                    System.out.print("Digite o valor: ");
                    double valor = scanner.nextDouble();

                    String moedaOrigem = "";
                    String moedaDestino = "";

                    switch (opcao) {
                        case 1:
                            moedaOrigem = "USD";
                            moedaDestino = "BRL";
                            break;
                        case 2:
                            moedaOrigem = "BRL";
                            moedaDestino = "USD";
                            break;
                        case 3:
                            moedaOrigem = "USD";
                            moedaDestino = "ARS";
                            break;
                        case 4:
                            moedaOrigem = "ARS";
                            moedaDestino = "USD";
                            break;
                        case 5:
                            moedaOrigem = "USD";
                            moedaDestino = "COP";
                            break;
                        case 6:
                            moedaOrigem = "COP";
                            moedaDestino = "USD";
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            continue;
                    }

                    double taxaOrigem = rates.get(moedaOrigem).getAsDouble();
                    double taxaDestino = rates.get(moedaDestino).getAsDouble();

                    double resultado = converter(valor, taxaOrigem, taxaDestino);

                    System.out.println("Resultado: " + resultado + " " + moedaDestino);
                }

            } else {
                System.out.println("Erro na requisição. Código: " + status);
            }

        } catch (Exception e) {
            System.out.println("Erro ao conectar com a API.");
            System.out.println(e.getMessage());
        }
    }

    // ✅ MÉTODO PRECISA FICAR DENTRO DA CLASSE
    public static double converter(double valor, double taxaOrigem, double taxaDestino) {
        return valor * (taxaDestino / taxaOrigem);
    }
}
