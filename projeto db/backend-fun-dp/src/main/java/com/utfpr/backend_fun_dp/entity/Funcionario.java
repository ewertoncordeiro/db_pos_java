package com.utfpr.backend_fun_dp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "funcionario")
@Data

//alteracao para usar @NamedQuery
@NamedQuery(
        name = "Funcionario.findByQtdDependentes",
        query = "SELECT f FROM Funcionario f WHERE f.qtd_dependentes = :qtdDependentes"
)
// alteracao para usar @NamedNativeQuery
@NamedNativeQuery(
        name = "Funcionario.findByNomeContaining",
        query = "SELECT * FROM Funcionario WHERE nome LIKE CONCAT('%', :nome, '%')",
        resultClass = Funcionario.class
)


public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_fun", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cod_dp", nullable = false)
    private Departamento departamento;

    private String nome;
    private Integer qtd_dependentes;

    @Column(length = 50)
    private String cargo;

    private Double salario;


}
