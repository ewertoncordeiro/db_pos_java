package com.utfpr.backend_fun_dp.controller;

import com.utfpr.backend_fun_dp.entity.Funcionario;
import com.utfpr.backend_fun_dp.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    // http://localhost:8080/funcionarios?nome=Fabricio Godoi&qtdDependentes=4
    @GetMapping("/funcionarios")
    public Funcionario getFuncionariosByNomeAndQtdDependentes(
            @RequestParam String nome,
            @RequestParam Integer qtdDependentes
    ) {
        return funcionarioService.getFuncionariosByNomeAndQtdDependentes(nome, qtdDependentes);
    }

    //http://localhost:8080/funcionarios-dp?nomeDp=Produção
    @GetMapping("/funcionarios-dp")
    public List<Funcionario> getFuncionariosByDepartamentoNome(@RequestParam String nomeDp) {
        return funcionarioService.getFuncionariosByDepartamentoNome(nomeDp);
    }

    @GetMapping("/top-salary-funcionarios")
    public Funcionario getTopFuncionariosBySalario() {
        return funcionarioService.getTopFuncionariosBySalario();
    }

    @GetMapping("/top3-highest-salary-funcionarios")
    public List<Funcionario> getTop3FuncionariosBySalario() {
        return funcionarioService.getTop3FuncionariosBySalario();
    }

    //http://localhost:8080/funcionarios-salario-maior?salario=1000
    @GetMapping("/funcionarios-salario-maior")
    public List<Funcionario> getFuncionariosBySalarioGreaterThan(@RequestParam Double salario) {
        return funcionarioService.getFuncionariosBySalarioGreaterThan(salario);
    }

    //funcionarios-salario-maior-native?salario=5000
    @GetMapping("/funcionarios-salario-maior-native")
    public List<Funcionario> getFuncionariosBySalarioGreaterThanNative(@RequestParam Double salario) {
        return funcionarioService.getFuncionariosBySalarioGreaterThanNative(salario);
    }

    @GetMapping("/funcionarios-sem-dependentes")
    public List<Funcionario> getFuncionariosNotDep() {
        return funcionarioService.getFuncionariosWithoutDependentesOrderByNameAsc();
    }

    //funcionarios-dependentes?qtdDependentes=2
    @GetMapping("/funcionarios-dependentes")
    public List<Funcionario> getFuncionariosByQtdDependentes(@RequestParam Integer qtdDependentes) {
        return funcionarioService.getFuncionariosByQtdDependentes(qtdDependentes);
    }

    @GetMapping("/funcionarios-por-nome")
    public List<Funcionario> getFuncionariosByNomeContaining(@RequestParam String nome) {
        return funcionarioService.getFuncionariosByNomeContaining(nome);
    }

    @PostMapping("/atualizarSalarios")
    public void atualizarSalarios(@RequestParam int percentual) {
        funcionarioService.atualizarSalarios(percentual);
    }

    @GetMapping("/funcionarios-sem-dependentes-param")
    public List<Funcionario> getFuncionariosSemDependentes(@RequestParam String departamentoNome) {
        return funcionarioService.getFuncionariosByDepartamentoWithoutDependentes(departamentoNome);
    }

    //POST /trocar-departamento?departamentoAtualId=1&novoDepartamentoId=2
    @PostMapping("/trocar-departamento")
    public String trocarDepartamento(
            @RequestParam Long departamentoAtualId,
            @RequestParam Long novoDepartamentoId) {
        int updatedCount = funcionarioService.trocarDepartamento(departamentoAtualId, novoDepartamentoId);
        return "Número de funcionários atualizados: " + updatedCount;
    }
     //DELETE /excluir-funcionarios?departamentoId=1
    @DeleteMapping("/excluir-funcionarios")
    public String excluirFuncionarios(
            @RequestParam Long departamentoId) {
        int deletedCount = funcionarioService.excluirFuncionariosPorDepartamento(departamentoId);
        return "Número de funcionários excluídos: " + deletedCount;
    }
/*
    @PostMapping("/salvarFun")
    public ResponseEntity<Funcionario> salvarFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario funcionarioSalvo = funcionarioService.save(funcionario);
        return ResponseEntity.ok(funcionarioSalvo);
    }*/
}