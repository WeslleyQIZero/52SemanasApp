package br.com.clubeapp.a52semanas.Activitys.Models;


import java.util.Date;

/**
 * Created by Denis Souza on 11/07/2017.
 */

public class Desafio {
    private String objetivo;
    private Double valorInicial;
    private Date dataInicio;
    private int visualizacao;

    public Desafio(){};

    public Desafio(String objetivo, Double valorInicial, Date dataInicio, int visualizacao) {
        this.objetivo = objetivo;
        this.valorInicial = valorInicial;
        this.dataInicio = dataInicio;
        this.visualizacao = visualizacao;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getVisualizacao() {
        return visualizacao;
    }

    public void setVisualizacao(int visualizacao) {
        this.visualizacao = visualizacao;
    }
}