package br.com.alura.escola.dominio.aluno;

import br.com.alura.escola.dominio.Eventos;

import java.time.LocalDateTime;

public class AlunoMatriculado implements Eventos {

    private final CPF cpfDoAluno;
    private final LocalDateTime momento;

    public AlunoMatriculado(CPF cpfDoAluno) {
        this.cpfDoAluno = cpfDoAluno;
        this.momento = LocalDateTime.now();
    }

    @Override
    public LocalDateTime momento() {
        return this.momento;
    }

    public CPF getCpfDoAluno() {
        return cpfDoAluno;
    }

    public LocalDateTime getMomento() {
        return momento;
    }
}
