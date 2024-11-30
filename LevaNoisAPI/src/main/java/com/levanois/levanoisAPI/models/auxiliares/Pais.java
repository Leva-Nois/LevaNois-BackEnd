package com.levanois.levanoisAPI.models.auxiliares;

import jakarta.persistence.*;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paisId;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, unique = true)
    private Character codigoIso;

    // Getters e Setters

    public Integer getPaisId() {
        return paisId;
    }

    public void setPaisId(Integer paisId) {
        this.paisId = paisId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Character getCodigoIso() {
        return codigoIso;
    }

    public void setCodigoIso(Character codigoIso) {
        this.codigoIso = codigoIso;
    }
}
