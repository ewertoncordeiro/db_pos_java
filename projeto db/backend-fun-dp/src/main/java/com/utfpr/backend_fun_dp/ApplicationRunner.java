package com.utfpr.backend_fun_dp;

import com.utfpr.backend_fun_dp.entity.Funcionario;
import com.utfpr.backend_fun_dp.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {

    @Autowired
    private FuncionarioService funcionarioService;

    @Override
    public void run(String... args) throws Exception {
        // Testando os métodos do FuncionarioService

//        // Questão 2
//        List<Funcionario> funcionariosByDept = funcionarioService.getFuncionariosByCodDepartamento(1);
//        System.out.println("Funcionarios do Departamento 1:");
//        funcionariosByDept.forEach(System.out::println);

        // Questão 4
        Funcionario topFuncionarioBySalario = funcionarioService.getTopFuncionariosBySalario();
        System.out.println("Funcionario com maior salário:");
        System.out.println(topFuncionarioBySalario);
//
//        // Questão 5
//        List<Funcionario> top3FuncionariosBySalario = funcionarioService.findFirst3ByOrderBySalarioDesc();
//        System.out.println("Top 3 Funcionarios com maior salário:");
//        top3FuncionariosBySalario.forEach(System.out::println);
//
//        // Questão 6
//        List<Funcionario> funcionariosByNomeAsc = funcionarioService.findByOrderByNomeAsc();
//        System.out.println("Funcionarios ordenados por nome:");
//        funcionariosByNomeAsc.forEach(System.out::println);
    }
}