package com.utfpr.backend_fun_dp.service;

import com.utfpr.backend_fun_dp.entity.Departamento;
import com.utfpr.backend_fun_dp.entity.Funcionario;
import com.utfpr.backend_fun_dp.repository.DepartamentoRepository;
import com.utfpr.backend_fun_dp.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Departamento getFirstDepartamento() {
        return departamentoRepository.findFirstByOrderByIdAsc(PageRequest.of(0, 1));
    }

    //5- salvar dp e associar um funcionario
    public Departamento salvarDepartamentoComFuncionario(Departamento departamento, Funcionario funcionario) {
        if (departamento == null) {
            throw new IllegalArgumentException("Departamento não pode ser nulo");
        }
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionario não pode ser nulo");
        }
        Departamento departamentoSalvo = departamentoRepository.save(departamento);
        funcionario.setDepartamento(departamentoSalvo);
        funcionarioRepository.save(funcionario);
        return departamentoSalvo;
    }
}
