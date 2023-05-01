package br.com.alura.escola.dominio.aluno.exceptions;

import br.com.alura.escola.dominio.Eventos;

public abstract class Ouvinte {

    public void processa(Eventos evento){
        if(this.deveProcessar(evento)){
            this.reageAo(evento);
        }
    }

    protected abstract void reageAo(Eventos evento);

    protected abstract boolean deveProcessar(Eventos evento);

}
