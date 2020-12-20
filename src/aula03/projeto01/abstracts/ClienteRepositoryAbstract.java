package aula03.projeto01.abstracts;

import aula03.projeto01.entities.Cliente;

public abstract class ClienteRepositoryAbstract {

    protected static final String PATH = "C:\\Users\\luana\\IdeaProjects\\AulasJavaCoti\\src\\aula03\\files\\";

    public abstract void exportarDados(Cliente cliente) throws Exception;
}
