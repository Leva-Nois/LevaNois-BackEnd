package com.levanois.levanoisAPI.models.usuario;

import com.levanois.levanoisAPI.models.auxiliares.Pais;
import com.levanois.levanoisAPI.models.principais.ParentesConvivio;
import com.levanois.levanoisAPI.models.principais.Trabalho;
import com.levanois.levanoisAPI.models.principais.Trilha;
import jakarta.persistence.*;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(name = "nome_usuario", length = 100, nullable = false)
    private String nomeUsuario;

    @Column(name = "email_usuario", length = 100, nullable = false)
    private String emailUsuario;

    @Column(name = "senha_usuario", length = 100, nullable = false)
    private String senhaUsuario;

    @Column(name = "data_nascimento", nullable = false, updatable = false)
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "trilha_id", nullable = false)
    private Trilha trilhaId;

    @ManyToOne
    @JoinColumn(name = "trabalho_id", nullable = false)
    private Trabalho trabalhoId;

    @ManyToOne
    @JoinColumn(name = "parentes_convivio_id", nullable = false)
    private ParentesConvivio parentesConvivioId;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais paisInteresseId;

    public enum StatusUsuario {
        ATIVO, INATIVO, EM_TRILHA
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "status_usuario", nullable = false)
    private StatusUsuario statusUsuario;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    @CurrentTimestamp
    private LocalDateTime dataCriacao;

    @Column(name = "pontos_experiencia_usuario")
    private Double pontosExperienciaUsuario;

    // Getters e Setters

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Trilha getTrilhaId() {
        return trilhaId;
    }

    public void setTrilhaId(Trilha trilhaId) {
        this.trilhaId = trilhaId;
    }

    public Trabalho getTrabalhoId() {
        return trabalhoId;
    }

    public void setTrabalhoId(Trabalho trabalhoId) {
        this.trabalhoId = trabalhoId;
    }

    public ParentesConvivio getParentesConvivioId() {
        return parentesConvivioId;
    }

    public void setParentesConvivioId(ParentesConvivio parentesConvivioId) {
        this.parentesConvivioId = parentesConvivioId;
    }

    public Pais getPaisInteresseId() {
        return paisInteresseId;
    }

    public void setPaisInteresseId(Pais paisInteresseId) {
        this.paisInteresseId = paisInteresseId;
    }

    public StatusUsuario getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(StatusUsuario statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Double getPontosExperienciaUsuario() {
        return pontosExperienciaUsuario;
    }

    public void setPontosExperienciaUsuario(Double pontosExperienciaUsuario) {
        this.pontosExperienciaUsuario = pontosExperienciaUsuario;
    }
}
