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

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    private String nome;
    private Integer qtd_dependentes;

    @Column(length = 50)
    private String cargo;

    private Double salario;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQtd_dependentes(Integer qtd_dependentes) {
        this.qtd_dependentes = qtd_dependentes;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQtd_dependentes() {
        return qtd_dependentes;
    }

    public String getCargo() {
        return cargo;
    }

    public Double getSalario() {
        return salario;
    }
}
