package aula03.projeto01.repositories;

import aula03.projeto01.abstracts.ClienteRepositoryAbstract;
import aula03.projeto01.entities.Cliente;
import aula03.projeto01.utils.FileUtil;

public class ClienteRepositoryCsv extends ClienteRepositoryAbstract {

    @Override
    public void exportarDados(Cliente cliente) throws Exception {
        String csv = cliente.getIdCliente()
                + ";" + cliente.getNome()
                + ";" + cliente.getEmail()
                + ";" + cliente.getCpf();

        FileUtil.write(csv, PATH + "cliente.csv");
    }
}
