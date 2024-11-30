package com.levanois.levanoisAPI.models.principais;

import jakarta.persistence.*;

@Entity
public class Trabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trabalho_id")
    private Long trabalhoId;

    @Column(nullable = false, length = 100, name = "cargo")
    private String cargo;

    @Column(length = 30, name = "nome_empresa")
    private String nomeEmpresa;

    @Column(nullable = false, name = "salario")
    private Double salario;

    // Getters and Setters

    public Long getTrabalhoId() {
        return trabalhoId;
    }

    public void setTrabalhoId(Long trabalhoId) {
        this.trabalhoId = trabalhoId;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
