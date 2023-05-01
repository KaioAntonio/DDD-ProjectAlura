package br.com.alura.escola.dominio;

import br.com.alura.escola.dominio.aluno.exceptions.Ouvinte;

import java.util.ArrayList;
import java.util.List;

public class PublicadorDeEventos {

    private List<Ouvinte> ouvintes = new ArrayList<>();

    public void adicionar(Ouvinte ouvinte){
        this.ouvintes.add(ouvinte);
    }

    public void publicar(Eventos evento){
        this.ouvintes.forEach(o -> {
            o.processa(evento);
        });
    }
}
