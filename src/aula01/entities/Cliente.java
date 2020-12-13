package aula01.entities;

public class Cliente extends Pessoa {
    private String email;
    private String cpf;
    private Endereco endereco;

    public Cliente() {
        endereco = new Endereco(); //--> EAGER LOADING
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
