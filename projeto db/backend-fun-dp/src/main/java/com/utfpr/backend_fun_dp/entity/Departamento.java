package com.utfpr.backend_fun_dp.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Table(name = "departamento")
@Data

public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_Dp", nullable = false)
    private Long codDp;

    @Column(name = "nome_Dp", nullable = false)
    private String nomeDp;

    @OneToMany(mappedBy = "departamento")
    private Set<Funcionario> funcionarios;

    public Long getCodDp() {
        return codDp;
    }

    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public String getNomeDp() {
        return nomeDp;
    }

    public void setCodDp(Long codDp) {
        this.codDp = codDp;
    }

    public void setNomeDp(String nomeDp) {
        this.nomeDp = nomeDp;
    }

    public void setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
