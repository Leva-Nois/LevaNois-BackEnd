package com.levanois.levanoisAPI.models.principais;

import com.levanois.levanoisAPI.models.auxiliares.Idioma;
import com.levanois.levanoisAPI.models.auxiliares.Pais;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Instituicao {

    public enum TipoInstituicao {
        Escola_de_Idiomas, Centro_Cultural, Faculdade, Outro;
    }

    public enum SituacaoInstituicao {
        ACEITANDO_MATRICULAS, ANALISE, NAO_ACEITANDO_MATRICULAS;
    }

    public enum TipoFormacao {
        Graduacao, Pos_Graduacao, Mestrado, Doutorado, Outro;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instituicao_id")
    private Long instituicaoId;

    @Column(nullable = false, name = "tipo_instituicao")
    @Enumerated(EnumType.STRING)
    private TipoInstituicao tipoInstituicao;

    @Column(nullable = false, length = 60, name = "nome_instituicao")
    private String nomeInstituicao;

    @Column(nullable = false, updatable = false, name = "data_cadastro")
    private LocalDate dataCadastro;

    @Column(nullable = false, length = 65, name = "localizacao_instituicao")
    private String localizacaoInstituicao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idioma_id", nullable = false)
    private Idioma idioma;

    @Column(nullable = false, name = "situacao_instituicao")
    @Enumerated(EnumType.STRING)
    private SituacaoInstituicao situacao;

    @Column(nullable = false, length = 140, name = "cursos_oferecidos")
    private String cursosOferecidos;

    @Column(nullable = false, name = "tipo_formacao")
    @Enumerated(EnumType.STRING)
    private TipoFormacao tipoFormacao;

    @Column(nullable = false, name = "requisitos")
    private String requisitos;

    @Column(nullable = false, name = "custos")
    private Double custos;

    // Getters e Setters

    public Long getInstituicaoId() {
        return instituicaoId;
    }

    public void setInstituicaoId(Long instituicaoId) {
        this.instituicaoId = instituicaoId;
    }

    public TipoInstituicao getTipoInstituicao() {
        return tipoInstituicao;
    }

    public void setTipoInstituicao(TipoInstituicao tipoInstituicao) {
        this.tipoInstituicao = tipoInstituicao;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getLocalizacaoInstituicao() {
        return localizacaoInstituicao;
    }

    public void setLocalizacaoInstituicao(String localizacaoInstituicao) {
        this.localizacaoInstituicao = localizacaoInstituicao;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public SituacaoInstituicao getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoInstituicao situacao) {
        this.situacao = situacao;
    }

    public String getCursosOferecidos() { return cursosOferecidos;
    }

    public void setCursosOferecidos(String cursosOferecidos) {
        this.cursosOferecidos = cursosOferecidos;
    }

    public TipoFormacao getTipoFormacao() {
        return tipoFormacao;
    }

    public void setTipoFormacao(TipoFormacao tipoFormacao) {
        this.tipoFormacao = tipoFormacao;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public Double getCustos() {
        return custos;
    }

    public void setCustos(Double custos) {
        this.custos = custos;
    }
}
