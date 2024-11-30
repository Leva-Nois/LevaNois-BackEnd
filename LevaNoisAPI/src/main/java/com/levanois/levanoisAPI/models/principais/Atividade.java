package com.levanois.levanoisAPI.models.principais;

import jakarta.persistence.*;

@Entity
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atividade_id")
    private Long atividadeId;

    @ManyToOne
    @JoinColumn(name = "trilha_id", nullable = false)
    private Trilha trilha;

    @Column(name = "nome_atividade", length = 100, nullable = false)
    private String nomeAtividade;

    @Column(name = "descricao_atividade", length = 2000, nullable = false)
    private String descricaoAtividade;

    @Column(name = "duracao_atividade", nullable = false)
    private Integer duracaoAtividade;

    public enum TipoAtividade {
        VIDEO, QUIZ, ARTIGO, PRATICA, OUTRO
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_atividade", nullable = false)
    private TipoAtividade tipoAtividade;

    @Column(name = "pontos_experiencia", nullable = false)
    private Double pontosExperiencia;

    // Getters e Setters

    public Long getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(Long atividadeId) {
        this.atividadeId = atividadeId;
    }

    public Trilha getTrilha() {
        return trilha;
    }

    public void setTrilha(Trilha trilha) {
        this.trilha = trilha;
    }

    public String getNomeAtividade() {
        return nomeAtividade;
    }

    public void setNomeAtividade(String nomeAtividade) {
        this.nomeAtividade = nomeAtividade;
    }

    public String getDescricaoAtividade() {
        return descricaoAtividade;
    }

    public void setDescricaoAtividade(String descricaoAtividade) {
        this.descricaoAtividade = descricaoAtividade;
    }

    public Integer getDuracaoAtividade() {
        return duracaoAtividade;
    }

    public void setDuracaoAtividade(Integer duracaoAtividade) {
        this.duracaoAtividade = duracaoAtividade;
    }

    public TipoAtividade getTipoAtividade() {
        return tipoAtividade;
    }

    public void setTipoAtividade(TipoAtividade tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
    }

    public Double getPontosExperiencia() {
        return pontosExperiencia;
    }

    public void setPontosExperiencia(Double pontosExperiencia) {
        this.pontosExperiencia = pontosExperiencia;
    }
}
