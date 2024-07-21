package com.utfpr.backend_fun_dp.controller;


import com.utfpr.backend_fun_dp.entity.Departamento;
import com.utfpr.backend_fun_dp.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class DepartamentoController {

        @Autowired
        private DepartamentoService departamentoService;

        @GetMapping("/primeiro-departamento")
        public Departamento getFirstDepartamento() {
            return departamentoService.getFirstDepartamento();
        }
}
