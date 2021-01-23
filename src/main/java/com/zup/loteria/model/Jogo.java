package com.zup.loteria.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Min(1)
    @Max(60)
    @Column(name = "numero_1", nullable = false)
    private Integer numero1;

    @NotNull
    @Min(1)
    @Max(60)
    @Column(name = "numero_2", nullable = false)
    private Integer numero2;

    @NotNull
    @Min(1)
    @Max(60)
    @Column(name = "numero_3", nullable = false)
    private Integer numero3;

    @NotNull
    @Min(1)
    @Max(60)
    @Column(name = "numero_4", nullable = false)
    private Integer numero4;

    @NotNull
    @Min(1)
    @Max(60)
    @Column(name = "numero_5", nullable = false)
    private Integer numero5;

    @NotNull
    @Min(1)
    @Max(60)
    @Column(name = "numero_6", nullable = false)
    private Integer numero6;

    @Column(name = "data_criacao", nullable = false)
    private LocalDate dataCriacao;

    public Jogo() {
    }

    public Jogo(Integer id, Integer numero1, Integer numero2, Integer numero3, Integer numero4, Integer numero5, Integer numero6, LocalDate dataCriacao) {
        this.id = id;
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.numero3 = numero3;
        this.numero4 = numero4;
        this.numero5 = numero5;
        this.numero6 = numero6;
        this.dataCriacao = dataCriacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero1() {
        return numero1;
    }

    public void setNumero1(Integer numero1) {
        this.numero1 = numero1;
    }

    public Integer getNumero2() {
        return numero2;
    }

    public void setNumero2(Integer numero2) {
        this.numero2 = numero2;
    }

    public Integer getNumero3() {
        return numero3;
    }

    public void setNumero3(Integer numero3) {
        this.numero3 = numero3;
    }

    public Integer getNumero4() {
        return numero4;
    }

    public void setNumero4(Integer numero4) {
        this.numero4 = numero4;
    }

    public Integer getNumero5() {
        return numero5;
    }

    public void setNumero5(Integer numero5) {
        this.numero5 = numero5;
    }

    public Integer getNumero6() {
        return numero6;
    }

    public void setNumero6(Integer numero6) {
        this.numero6 = numero6;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
