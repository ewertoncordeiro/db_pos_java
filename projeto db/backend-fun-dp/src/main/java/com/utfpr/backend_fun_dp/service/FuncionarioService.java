package com.utfpr.backend_fun_dp.service;

import com.utfpr.backend_fun_dp.entity.Funcionario;
import com.utfpr.backend_fun_dp.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    public Funcionario getFuncionariosByNomeAndQtdDependentes(String nome, Integer qtdDependentes) {
        return funcionarioRepository.findFuncionariosByNomeAndQtdDependentes(nome, qtdDependentes);
    }

    public List<Funcionario> getFuncionariosByDepartamentoNome(String nomeDp) {
        return funcionarioRepository.findFuncionariosByDepartamentoNome(nomeDp);
    }

    public Funcionario getTopFuncionariosBySalario() {
        return funcionarioRepository.findTopByOrderBySalarioDesc(PageRequest.of(0, 1));

    }

    public List<Funcionario> getTop3FuncionariosBySalario() {
        return funcionarioRepository.findTop3ByOrderBySalarioDesc(PageRequest.of(0, 3));
    }

    public List<Funcionario> getFuncionariosWithoutDependentesOrderByNameAsc() {
        return funcionarioRepository.findFuncionariosWithoutDependentesOrderByNameAsc();
    }

    public List<Funcionario> getFuncionariosBySalarioGreaterThan(Double salario) {
        return funcionarioRepository.findFuncionariosBySalarioGreaterThan(salario);
    }

    public List<Funcionario> getFuncionariosBySalarioGreaterThanNative(Double salario) {
        return funcionarioRepository.findFuncionariosBySalarioGreaterThanNative(salario);
    }

    public List<Funcionario> getFuncionariosByQtdDependentes(Integer qtdDependentes) {
        return funcionarioRepository.findByQtdDependentes(qtdDependentes);
    }

    public List<Funcionario> getFuncionariosByNomeContaining(String nome) {
        return funcionarioRepository.findFuncionariosByNomeContaining(nome);
    }


    public void atualizarSalarios(int percentual) {
        funcionarioRepository.atualizaSalario(percentual);
    }

    public List<Funcionario> getFuncionariosByDepartamentoWithoutDependentes(String departamentoNome) {
        return funcionarioRepository.findFuncionariosByDepartamentoWithoutDependentes(departamentoNome);
    }

    public int trocarDepartamento(Long departamentoAtualId, Long novoDepartamentoId) {
        return funcionarioRepository.updateDepartamento(departamentoAtualId, novoDepartamentoId);
    }

    public int excluirFuncionariosPorDepartamento(Long departamentoId) {
        return funcionarioRepository.deleteByDepartamentoId(departamentoId);
    }
//salvar apenas o funcionario
    @Transactional
    public Funcionario save(Funcionario funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário não pode ser nulo");
        }
        return funcionarioRepository.save(funcionario);
    }
}
