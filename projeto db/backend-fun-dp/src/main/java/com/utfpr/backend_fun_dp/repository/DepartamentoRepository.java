package com.utfpr.backend_fun_dp.repository;

import com.utfpr.backend_fun_dp.entity.Departamento;
import com.utfpr.backend_fun_dp.entity.Funcionario;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

    //3. Listar o primeiro departamento cadastrado
    @Query("SELECT d FROM Departamento d ORDER BY d.codDp ASC")
    Departamento findFirstByOrderByIdAsc(PageRequest pageRequest);
}



