package aula04.contracts;

import aula04.entities.Funcionario;

public interface IFuncionarioRepository extends IBaseRepository<Funcionario, Integer> {
    Funcionario findByCpf(String cpf) throws Exception;
}
