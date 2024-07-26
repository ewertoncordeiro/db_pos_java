package com.utfpr.backend_fun_dp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.Set;

@Entity
@Table(name = "departamento")
@Data

public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_Dp", nullable = false)
    private Long codDp;

    @Getter
    @Column(name = "nome_Dp", nullable = false)
    private String nomeDp;

    @OneToMany(mappedBy = "departamento")
    private Set<Funcionario> funcionarios;

    @Override
    public String toString() {
        return "Departamento{" +
                "codDp=" + codDp +
                ", nomeDp='" + nomeDp + '\'' +
                '}';
    }
}
