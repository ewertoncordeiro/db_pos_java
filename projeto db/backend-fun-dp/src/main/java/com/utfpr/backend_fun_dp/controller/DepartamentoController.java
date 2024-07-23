package com.utfpr.backend_fun_dp.controller;


import com.utfpr.backend_fun_dp.entity.Departamento;
import com.utfpr.backend_fun_dp.entity.Funcionario;
import com.utfpr.backend_fun_dp.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class DepartamentoController {

        @Autowired
        private DepartamentoService departamentoService;

        // testando
        @GetMapping("/primeiro-departamento")
        public Departamento getFirstDepartamento() {
            return departamentoService.getFirstDepartamento();
        }

    @PostMapping("/salvar-departamento-com-funcionario")
    public Departamento salvarDepartamentoComFuncionario(
            @RequestBody Departamento departamento,
            @RequestBody Funcionario funcionario) {
        return departamentoService.salvarDepartamentoComFuncionario(departamento, funcionario);
    }
}
