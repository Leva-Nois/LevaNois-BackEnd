package com.levanois.levanoisAPI.models.usuario;

import com.levanois.levanoisAPI.models.principais.Atividade;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ProgressoAtividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "progresso_atividade_id", nullable = false)
    private Long progressoAtividadeId;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuarioId;

    @ManyToOne
    @JoinColumn(name = "atividade_id", nullable = false)
    private Atividade atividadeId;

    @Column(name = "situacao_atividade", nullable = false)
    private Boolean situacaoAtividade;

    @Column(name = "data_conclusao")
    private LocalDate dataConclusao;

    // Getters e Setters

    public Long getProgressoAtividadeId() {
        return progressoAtividadeId;
    }

    public void setProgressoAtividadeId(Long progressoAtividadeId) {
        this.progressoAtividadeId = progressoAtividadeId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Atividade getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(Atividade atividadeId) {
        this.atividadeId = atividadeId;
    }

    public Boolean getSituacaoAtividade() {
        return situacaoAtividade;
    }

    public void setSituacaoAtividade(Boolean situacaoAtividade) {
        this.situacaoAtividade = situacaoAtividade;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
}
