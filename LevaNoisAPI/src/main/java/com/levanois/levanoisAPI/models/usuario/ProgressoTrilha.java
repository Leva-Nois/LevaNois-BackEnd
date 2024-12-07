package com.levanois.levanoisAPI.models.usuario;

import com.levanois.levanoisAPI.models.principais.Trilha;
import jakarta.persistence.*;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDate;

@Entity
public class ProgressoTrilha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "progresso_trilha_id")
    private Long progressoTrilhaId;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuarioId;

    @ManyToOne
    @JoinColumn(name = "trilha_id", nullable = false)
    private Trilha trilhaId;

    @Column(name = "etapa_atual", nullable = false)
    private Integer etapaAtual;

    @Column(name = "total_etapas", nullable = false)
    private Integer totalEtapas;

    public enum SituacaoTrilha {
        CONCLUIDA, EM_ANDAMENTO
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao_trilha", nullable = false)
    private SituacaoTrilha situacaoTrilha;

    @Column(updatable = false,name = "data_inicio", nullable = false)
    @CurrentTimestamp
    private LocalDate dataInicio;

    @Column(name = "data_conclusao")
    private LocalDate dataConclusao;

    // Getters e Setters

    public Long getProgressoTrilhaId() {
        return progressoTrilhaId;
    }

    public void setProgressoTrilhaId(Long progressoTrilhaId) {
        this.progressoTrilhaId = progressoTrilhaId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Trilha getTrilhaId() {
        return trilhaId;
    }

    public void setTrilhaId(Trilha trilhaId) {
        this.trilhaId = trilhaId;
    }

    public Integer getEtapaAtual() {
        return etapaAtual;
    }

    public void setEtapaAtual(Integer etapaAtual) {
        this.etapaAtual = etapaAtual;
    }

    public Integer getTotalEtapas() {
        return totalEtapas;
    }

    public void setTotalEtapas(Integer totalEtapas) {
        this.totalEtapas = totalEtapas;
    }

    public SituacaoTrilha getSituacaoTrilha() {
        return situacaoTrilha;
    }

    public void setSituacaoTrilha(SituacaoTrilha situacaoTrilha) {
        this.situacaoTrilha = situacaoTrilha;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
}

