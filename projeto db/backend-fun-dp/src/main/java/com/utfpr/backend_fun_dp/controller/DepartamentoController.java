package com.utfpr.backend_fun_dp.controller;


import com.utfpr.backend_fun_dp.entity.Departamento;
import com.utfpr.backend_fun_dp.entity.Funcionario;
import com.utfpr.backend_fun_dp.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/primeiro-departamento")
    public Departamento getFirstDepartamento() {
        return departamentoService.getFirstDepartamento();
    }


//fubcionando ok salvar um do apenas
    @PostMapping("/salvarDP")
    public ResponseEntity<Departamento> salvarDepartamento(@RequestBody Departamento departamento) {
        Departamento departamentoSalvo = departamentoService.salvarDepartamento(departamento);
        return ResponseEntity.ok(departamentoSalvo);
    }

//neste formato funcionou a inclusáo
    @PostMapping("/salvarDeptEFuncionario")
    public ResponseEntity<String> salvarDeptEFuncionario(@RequestBody DepartamentoFuncionarioRequest request) {
        Departamento departamento = request.getDepartamento();
        Funcionario funcionario = request.getFuncionario();

        if (departamento == null || funcionario == null) {
            return ResponseEntity.badRequest().body("Departamento ou Funcionario não podem ser nulos");
        }

        departamentoService.salvarDepartamentoEFuncionario(departamento, funcionario);
        return ResponseEntity.ok("Departamento e Funcionario salvos com sucesso!");
    }

}
