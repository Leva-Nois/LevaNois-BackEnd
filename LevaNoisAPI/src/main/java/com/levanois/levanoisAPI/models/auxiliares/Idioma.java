package com.levanois.levanoisAPI.models.auxiliares;

import jakarta.persistence.*;

@Entity
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "idioma_id")
    private Long idiomaId;

    @Column(nullable = false, length = 50, name = "nome_idioma")
    private String nomeIdioma;

    // Getters e Setters

    public Long getIdiomaId() {
        return idiomaId;
    }

    public void setIdiomaId(Long idiomaId) {
        this.idiomaId = idiomaId;
    }

    public String getNomeIdioma() {
        return nomeIdioma;
    }

    public void setNomeIdioma(String nomeIdioma) {
        this.nomeIdioma = nomeIdioma;
    }
}
