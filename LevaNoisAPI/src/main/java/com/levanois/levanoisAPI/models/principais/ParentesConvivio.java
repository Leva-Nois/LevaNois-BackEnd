package com.levanois.levanoisAPI.models.principais;

import jakarta.persistence.*;

@Entity
public class ParentesConvivio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parentes_convivio_id")
    private Long parentesConvivioId;

    @Column(nullable = false, length = 100, name = "nome_parente")
    private String nomeParente;

    @Column(nullable = false, length = 50, name = "grau_parentesco")
    private String grauParentesco;

    @ManyToOne
    @JoinColumn(name = "trabalho_id", nullable = false)
    private Trabalho trabalho;

    // Getters and Setters

    public Long getParentesConvivioId() {
        return parentesConvivioId;
    }

    public void setParentesConvivioId(Long parentesConvivioId) {
        this.parentesConvivioId = parentesConvivioId;
    }

    public String getNomeParente() {
        return nomeParente;
    }

    public void setNomeParente(String nomeParente) {
        this.nomeParente = nomeParente;
    }

    public String getGrauParentesco() {
        return grauParentesco;
    }

    public void setGrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }
}
