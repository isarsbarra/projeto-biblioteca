package org.example.servico;

import org.example.dominios.Aluno;
import org.example.dominios.Emprestimo;
import org.example.dominios.Livro;
import org.example.repository.EmprestimoRepository;

import java.util.ArrayList;

public class RealizarEmprestimo {

    public static void executar(Aluno aluno, Livro livrosEmprestados) {

        Emprestimo emprestimo = new Emprestimo(aluno,livrosEmprestados);
        EmprestimoRepository.getInstance().save(emprestimo);

    }
}
