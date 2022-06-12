package org.example.servico;

import org.example.dominios.Aluno;
import org.example.dominios.Emprestimo;
import org.example.repository.EmprestimoRepository;

import java.util.*;

public class ImprimirRelatorio {

    public static void executar() {

        List<Emprestimo> relatorio = EmprestimoRepository.getInstance().getEmprestimosCadastrados();
        Collections.sort(relatorio);

        for (Emprestimo emprestimo:relatorio) {
            System.out.println(emprestimo);

            }
        }


}
