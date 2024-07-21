package com.utfpr.backend_fun_dp.repository;

import com.utfpr.backend_fun_dp.entity.Funcionario;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    // 1. Listar um funcionário pelo seu nome e quantidade de dependentes utilizando consulta
    @Query("SELECT f FROM Funcionario f WHERE f.nome = :nome AND f.qtd_dependentes = :qtdDependentes")
    Funcionario findFuncionariosByNomeAndQtdDependentes(
            @Param("nome") String nome,
            @Param("qtdDependentes") Integer qtdDependentes);

    //2. Listar todos os funcionários de um determinado departamento por JPQL via @Query
    @Query("SELECT f FROM Funcionario f JOIN f.departamento d WHERE d.nomeDp = :nomeDp")
    List<Funcionario> findFuncionariosByDepartamentoNome(@Param("nomeDp") String nomeDp);

    //4. Listar o primeiro funcionário que tem o maior salário.
    @Query("SELECT f FROM Funcionario f ORDER BY f.salario DESC")
    Funcionario findTopByOrderBySalarioDesc(PageRequest pageRequest);

    //5. Listar os 3 (três) primeiros funcionários que tem os maiores salários.
    @Query("SELECT f FROM Funcionario f ORDER BY f.salario DESC")
    List<Funcionario> findTop3ByOrderBySalarioDesc(PageRequest pageRequest);

    //6. Listar os funcionários que não tem dependentes em ordem crescente de nome por JPQL
    //via @Query.
    @Query("SELECT f FROM Funcionario f WHERE f.qtd_dependentes = 0 ORDER BY f.nome ASC")
    List<Funcionario> findFuncionariosWithoutDependentesOrderByNameAsc();

    //7. Listar os funcionários que tem salário maior que um determinado valor por JPQL
    //sobrescrevendo palavras-chaves @Query
    @Query("SELECT f FROM Funcionario f WHERE f.salario > :salario")
    List<Funcionario> findFuncionariosBySalarioGreaterThan(@Param("salario") Double salario);

    //8. Listar os funcionários que tem salário maior que um determinado valor por @Query
    //com native query
    @Query(value = "SELECT * FROM Funcionario f WHERE f.salario > :salario", nativeQuery = true)
    List<Funcionario> findFuncionariosBySalarioGreaterThanNative(@Param("salario") Double salario);

    //9. Alterar a classe Funcionario e criar uma consulta para listar os funcionários com uma
    //determinada quantidade de dependentes por @NamedQuery
    List<Funcionario> findByQtdDependentes(@Param("qtdDependentes") Integer qtdDependentes);

    //10. criar uma consulta para listar os funcionários que
    //contenham em qualquer parte do seu nome um determinado nome por
    //@NamedNativeQuery
    @org.springframework.data.jpa.repository.Query(name = "Funcionario.findByNomeContaining", nativeQuery = true)
    List<Funcionario> findFuncionariosByNomeContaining(@Param("nome") String nome);

}

