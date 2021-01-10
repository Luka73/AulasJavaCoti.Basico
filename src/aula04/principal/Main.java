package aula04.principal;

import aula04.contracts.IFuncionarioRepository;
import aula04.entities.Funcionario;
import aula04.factories.ConnectionFactory;
import aula04.repositories.FuncionarioRepository;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection connection = null;

        try {
            //pedindo para fábrica uma conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            IFuncionarioRepository repository = new FuncionarioRepository(connection);
            Funcionario funcionario = new Funcionario(null, "Luana Fernandes", "12009760700", "2021-001", 8000d);
            repository.create(funcionario);

            System.out.println("Funcionário cadastrado com sucesso!");

            for (Funcionario f : repository.findAll()) {
                System.out.println(f);
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
