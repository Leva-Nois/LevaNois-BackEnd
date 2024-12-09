package com.levanois.levanoisAPI.models.principais;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Trilha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trilha_id")
    private Long trilhaId;

    @Column(nullable = false, length = 100, name = "nome_trilha")
    private String nomeTrilha;

    @Column(nullable = false, length = 2000, name = "descricao_trilha")
    private String descricaoTrilha;

    public enum TipoTrilha {
        LINGUA, // 0
        CULTURA, // 1
        ESTUDO; // 2
    }

    @Enumerated(EnumType.ORDINAL) // Mapeia o enum como números no banco (TINYINT)
    @Column(nullable = false, name = "tipo_trilha")
    private TipoTrilha tipoTrilha;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(nullable = false, name = "total_atividades")
    private Integer totalAtividades;

    // Controle de versão
    @Column(nullable = false, name = "versao")
    private Integer versao;

    // Getters and Setters

    public Long getTrilhaId() {
        return trilhaId;
    }

    public void setTrilhaId(Long trilhaId) {
        this.trilhaId = trilhaId;
    }

    public String getNomeTrilha() {
        return nomeTrilha;
    }

    public void setNomeTrilha(String nomeTrilha) {
        this.nomeTrilha = nomeTrilha;
    }

    public String getDescricaoTrilha() {
        return descricaoTrilha;
    }

    public void setDescricaoTrilha(String descricaoTrilha) {
        this.descricaoTrilha = descricaoTrilha;
    }

    public TipoTrilha getTipoTrilha() {
        return tipoTrilha;
    }

    public void setTipoTrilha(TipoTrilha tipoTrilha) {
        this.tipoTrilha = tipoTrilha;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Integer getTotalAtividades() {
        return totalAtividades;
    }

    public void setTotalAtividades(Integer totalAtividades) {
        this.totalAtividades = totalAtividades;
    }

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }
}
