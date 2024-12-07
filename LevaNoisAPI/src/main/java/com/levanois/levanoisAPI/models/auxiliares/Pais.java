package com.levanois.levanoisAPI.models.auxiliares;

import jakarta.persistence.*;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "pais_id")
    private Long paisId;

    @Column(nullable = false, length = 50, name = "nome_pais")
    private String nomePais;

    @Column(nullable = false, unique = true, length = 3, name = "codigo_iso")
    private String codigoIso;

    // Getters e Setters

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    public String getCodigoIso() {
        return codigoIso;
    }

    public void setCodigoIso(String codigoIso) {
        this.codigoIso = codigoIso;
    }
}
