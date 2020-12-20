package aula03.projeto02.entities;

import java.io.Serializable;

public class Pessoa implements Serializable, Comparable<Pessoa> {

    private static final long serialVersionUID = 7105481210762720473L;

    private Integer id;
    private String nome;

    public Pessoa() {
    }

    public Pessoa(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pessoa) {
            Pessoa pessoa = (Pessoa) obj;
            return this.id.equals(pessoa.getId());
        }

        return false;
    }

    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + "]";
    }

    @Override
    public int compareTo(Pessoa obj) {
        return nome.compareTo(obj.getNome());
    }
}
