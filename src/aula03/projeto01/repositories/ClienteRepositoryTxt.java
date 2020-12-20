package aula03.projeto01.repositories;

import aula03.projeto01.abstracts.ClienteRepositoryAbstract;
import aula03.projeto01.entities.Cliente;
import aula03.projeto01.utils.FileUtil;

public class ClienteRepositoryTxt extends ClienteRepositoryAbstract {

    @Override
    public void exportarDados(Cliente cliente) throws Exception {
        StringBuilder builder = new StringBuilder();

        builder.append("DADOS DO CLIENTE: ");
        builder.append("\nID.................: " + cliente.getIdCliente());
        builder.append("\nNOME...............: " + cliente.getNome());
        builder.append("\nEMAIL..............: " + cliente.getEmail());
        builder.append("\nCPF................: " + cliente.getCpf());

        FileUtil.write(builder.toString(), PATH + "cliente.txt");

    }
}
