package aula03.projeto01.controllers;

import aula03.projeto01.abstracts.ClienteRepositoryAbstract;
import aula03.projeto01.entities.Cliente;
import aula03.projeto01.utils.ScannerUtil;

public class ClienteController {

    private ClienteRepositoryAbstract clienteRepositoryAbstract;

    public ClienteController(ClienteRepositoryAbstract clienteRepositoryAbstract) {
        this.clienteRepositoryAbstract = clienteRepositoryAbstract;
    }

    public void exportarDados() throws Exception {
        Cliente cliente = new Cliente();

        cliente.setIdCliente(Integer.parseInt(ScannerUtil.read("Id do Cliente: ")));
        cliente.setNome(ScannerUtil.read("Nome: "));
        cliente.setEmail(ScannerUtil.read("Email: "));
        cliente.setCpf(ScannerUtil.read("CPF: "));

        clienteRepositoryAbstract.exportarDados(cliente);
    }
}
