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

<<<<<<< HEAD
    //5- salvar dp e associar um funcionario
    public Departamento salvarDepartamentoComFuncionario(Departamento departamento, Funcionario funcionario) {
        if (departamento == null) {
            throw new IllegalArgumentException("Departamento não pode ser nulo");
        }
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionario não pode ser nulo");
        }
=======
    public Departamento save(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    //5- salvar dp e associar um funcionario
    @Transactional
    public Departamento salvarDepartamentoComFuncionario2(Departamento departamento, Funcionario funcionario) {
>>>>>>> hotfix/teste_30_07
        Departamento departamentoSalvo = departamentoRepository.save(departamento);
        funcionario.setDepartamento(departamentoSalvo);
        funcionarioRepository.save(funcionario);
        return departamentoSalvo;
    }


    // Método para salvar um departamento
    public Departamento salvarDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    //salvar fun e dp funcionando ok
    @Transactional(readOnly = false)
    public void salvarDepartamentoEFuncionario(Departamento departamento, Funcionario funcionario) {
        departamentoRepository.save(departamento);
        funcionario.setDepartamento(departamento);
        funcionarioRepository.save(funcionario);
    }

}
