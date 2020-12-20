package aula03.projeto02.principal;

import aula03.projeto02.entities.Pessoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Pessoa> lista = new ArrayList<>();

        lista.add(new Pessoa(1, "Leo"));
        lista.add(new Pessoa(2, "Rui"));
        lista.add(new Pessoa(3, "Ana"));
        lista.add(new Pessoa(4, "Bia"));
        lista.add(new Pessoa(5, "Max"));

        System.out.println("Quantidade de pessoas: " + lista.size());

        Collections.sort(lista);

        for (Pessoa p : lista) {
            System.out.println(p);
        }

        lista.forEach(x -> System.out.println(x.toString()));

    }
}
