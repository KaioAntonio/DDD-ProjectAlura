package br.com.alura.escola.dominio.aluno;

import br.com.alura.escola.dominio.Eventos;
import br.com.alura.escola.dominio.aluno.exceptions.Ouvinte;

import java.time.format.DateTimeFormatter;

public class LogDeAlunoMatriculado extends Ouvinte {

    public void reageAo(Eventos evento){
        String momentoFormatado = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        System.out.println(
                String.format(
                        "Aluno com CPF: %s matriculado em: %s",
                        ((AlunoMatriculado) evento).getCpfDoAluno(), momentoFormatado));
    }

    @Override
    protected boolean deveProcessar(Eventos evento) {
        return evento instanceof AlunoMatriculado;
    }
}
