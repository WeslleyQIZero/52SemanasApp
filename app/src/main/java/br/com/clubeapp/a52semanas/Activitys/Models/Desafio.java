package br.com.clubeapp.a52semanas.Activitys.Models;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Denis Souza on 11/07/2017.
 */

public class Desafio {

    private Long id;
    private String objetivo;
    private Double valorInicial;
    private Date dataInicio;
    private int visualizacao;
    private Date dataFim;
    private int porcentagem;
    private  int semana;

    public Desafio(){};

    public Desafio(Long id,String pNome, Date pDatainicio,int pTipoViasualização,Double pValor){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String datetext = df.format(pDatainicio);

        this.id = id;
        this.objetivo = pNome;
        this.dataInicio = pDatainicio;
        this.visualizacao = pTipoViasualização;
        this.valorInicial= pValor;
    }
    public static Date stringToDate(String data1) {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        // f.setLenient(false);
        Date d1 = null;
        try {
            d1 = f.parse(data1);
        } catch (ParseException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return d1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public int getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(int porcentagem) {
        this.porcentagem = porcentagem;
    }

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }
}