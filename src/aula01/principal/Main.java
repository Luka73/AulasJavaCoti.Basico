package aula01.principal;

import aula01.entities.Cliente;
import aula01.utils.ScannerUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("****CONTROLE DE CLIENTES****");
        Cliente cliente = new Cliente();

        cliente.setId(1);
        cliente.setNome("Luana Fernandes");
        cliente.setEmail("luana@gmail.com");
        cliente.setCpf("123.456.789-00");

        System.out.println("**Primeiro Cliente**");
        System.out.println("Id................: " + cliente.getId());
        System.out.println("Nome..............: " + cliente.getNome());
        System.out.println("Email.............: " + cliente.getEmail());
        System.out.println("Cpf...............: " + cliente.getCpf());

        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o id: ");
        cliente.setId(sc.nextInt());

        System.out.println("Informe o nome: ");
        cliente.setNome(sc.next());

        System.out.println("Informe o email: ");
        cliente.setEmail(sc.next());

        System.out.println("Informe o cpf: ");
        cliente.setCpf(sc.next());

        //cliente.setEndereco(new Endereco());  --> LAZY LOADING
        ScannerUtil scUtil = new ScannerUtil();
        try {
            cliente.getEndereco().setId(Integer.parseInt(scUtil.read("Informe o id do endereço: ")));
            cliente.getEndereco().setLogradouro(scUtil.read("Logradouro: "));
            cliente.getEndereco().setBairro(scUtil.read("Bairro: "));
            cliente.getEndereco().setCidade(scUtil.read("Cidade: "));
            cliente.getEndereco().setEstado(scUtil.read("Estado: "));
            cliente.getEndereco().setCep(scUtil.read("Cep: "));
        } catch (Exception e) {
            System.out.println("\nErro: " + e.getMessage());
        }

        System.out.println("**Segundo Cliente**");
        System.out.println("Id................: " + cliente.getId());
        System.out.println("Nome..............: " + cliente.getNome());
        System.out.println("Email.............: " + cliente.getEmail());
        System.out.println("Cpf...............: " + cliente.getCpf());

        System.out.println("\nDADOS DO ENDEREÇO:");
        System.out.println("ID.............: " + cliente.getEndereco().getId());
        System.out.println("Logradouro.....: " + cliente.getEndereco().getLogradouro());
        System.out.println("Bairro.........: " + cliente.getEndereco().getBairro());
        System.out.println("Cidade.........: " + cliente.getEndereco().getCidade());
        System.out.println("Estado.........: " + cliente.getEndereco().getEstado());
        System.out.println("CEP............: " + cliente.getEndereco().getCep());
    }
}
