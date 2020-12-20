package aula02.interfaces;

import aula02.entities.Empresa;

public interface IEmpresaRepository {
    void exportarDados(Empresa empresa) throws Exception;
}
