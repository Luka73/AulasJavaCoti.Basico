package aula03.projeto01.entities;

import java.io.Serializable;

public class Cliente implements Serializable {

    private static final long serialVersionUID = -1520441410265288790L;

    private Integer idCliente;
    private String nome;
    private String email;
    private String cpf;

    public Cliente() {
    }

    public Cliente(Integer idCliente, String nome, String email, String cpf) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int hashCode() {
        return this.idCliente.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Cliente) {
            return ((Cliente) obj).idCliente.equals(idCliente);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Id: " + idCliente + ", nome: " + nome + ", email: " + email;
    }
}
