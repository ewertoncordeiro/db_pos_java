package com.utfpr.backend_fun_dp.service;

import com.utfpr.backend_fun_dp.entity.Departamento;
import com.utfpr.backend_fun_dp.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service

public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Departamento getFirstDepartamento() {
        return departamentoRepository.findFirstByOrderByIdAsc(PageRequest.of(0, 1));
    }

}
