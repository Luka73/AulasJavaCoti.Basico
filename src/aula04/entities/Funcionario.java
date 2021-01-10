package aula04.entities;

import java.io.Serial;
import java.io.Serializable;

public class Funcionario implements Serializable, Comparable<Funcionario> {

    @Serial
    private static final long serialVersionUID = 1938286003323812164L;

    private Integer id;
    private String nome;
    private String cpf;
    private String matricula;
    private Double salario;

    public Funcionario() {
    }

    public Funcionario(Integer id, String nome, String cpf, String matricula, Double salario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.salario = salario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", matricula='" + matricula + '\'' +
                ", salario=" + salario +
                '}';
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Funcionario) {
            Funcionario funcionario = (Funcionario) obj;
            return this.id.equals(funcionario.id);
        }
        return false;
    }

    @Override
    public int compareTo(Funcionario funcionario) {
        return this.nome.compareTo(funcionario.getNome());
    }
}
