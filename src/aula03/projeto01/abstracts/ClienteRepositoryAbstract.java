package aula03.projeto01.abstracts;

import aula03.projeto01.entities.Cliente;

public abstract class ClienteRepositoryAbstract {

    protected static final String PATH = "C:\\Projects\\AulasJavaCoti.Basico\\src\\aula03\\projeto01\\files\\";

    public abstract void exportarDados(Cliente cliente) throws Exception;
}
