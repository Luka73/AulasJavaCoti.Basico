package aula03.projeto01.principal;

import aula03.projeto01.controllers.ClienteController;
import aula03.projeto01.repositories.ClienteRepositoryCsv;
import aula03.projeto01.repositories.ClienteRepositoryTxt;
import aula03.projeto01.utils.ScannerUtil;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("EXPORTADOR DE DADOS DE CLIENTE: ");
            String opcao = ScannerUtil.read("Informe [CSV] ou [TXT]");

            ClienteController clienteController = switch (opcao.toUpperCase()) {
                case "CSV" -> new ClienteController(new ClienteRepositoryCsv());
                case "TXT" -> new ClienteController(new ClienteRepositoryTxt());
                default -> throw new Exception("Opção inválida");
            };

            clienteController.exportarDados();
            System.out.println("\n DADOS GRAVADOS COM SUCESSO!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
