package aula04.repositories;

import aula04.contracts.IFuncionarioRepository;
import aula04.entities.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository implements IFuncionarioRepository {

    private Connection connection;

    public FuncionarioRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Funcionario obj) throws Exception {
        String query = "insert into funcionario(nome, cpf, matricula, salario) "
                        + "values(?, ? , ? , ?)";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, obj.getNome());
        statement.setString(2, obj.getCpf());
        statement.setString(3, obj.getMatricula());
        statement.setDouble(4, obj.getSalario());

        statement.execute();
        statement.close(); //IPC: fecha o statement e não a conexão com o banco.
    }

    @Override
    public void update(Funcionario obj) throws Exception {
        String query = "update funcionario set nome=?, cpf=?, matricula=?, salario=? where id=?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, obj.getNome());
        statement.setString(2, obj.getCpf());
        statement.setString(3, obj.getMatricula());
        statement.setDouble(4, obj.getSalario());
        statement.setInt(5, obj.getId());

        statement.execute();
        statement.close();
    }

    @Override
    public void delete(Integer id) throws Exception {
        String query = "delete from funcionario where id=?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        statement.execute();
        statement.close();
    }

    @Override
    public List<Funcionario> findAll() throws Exception {
        String query = "select * from funcionario";

        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet result = statement.executeQuery();

        List<Funcionario> list = new ArrayList<>();

        while (result.next()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setId(result.getInt("id"));
            funcionario.setNome(result.getString("nome"));
            funcionario.setCpf(result.getString("cpf"));
            funcionario.setMatricula(result.getString("matricula"));
            funcionario.setSalario(result.getDouble("salario"));

            list.add(funcionario);
        }

        statement.close();
        return list;
    }

    @Override
    public Funcionario findById(Integer id) throws Exception {
        String query = "select * from funcionario where id=?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();

        Funcionario funcionario = null;

        if(result.next()) {
            funcionario = new Funcionario();
            funcionario.setId(result.getInt("id"));
            funcionario.setNome(result.getString("nome"));
            funcionario.setCpf(result.getString("cpf"));
            funcionario.setMatricula(result.getString("matricula"));
            funcionario.setSalario(result.getDouble("salario"));
        }

        statement.close();
        return funcionario;
    }

    @Override
    public Funcionario findByCpf(String cpf) throws Exception {
        String query = "select * from funcionario where cpf=?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, cpf);
        ResultSet result = statement.executeQuery();

        Funcionario funcionario = null;

        if(result.next()) {
            funcionario = new Funcionario();
            funcionario.setId(result.getInt("id"));
            funcionario.setNome(result.getString("nome"));
            funcionario.setCpf(result.getString("cpf"));
            funcionario.setMatricula(result.getString("matricula"));
            funcionario.setSalario(result.getDouble("salario"));
        }

        statement.close();
        return funcionario;
    }
}
