package com.yms.model;

import com.yms.model.enums.StatusOperacao;
import com.yms.model.enums.TipoOperacao;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Operacao {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private int codigoOperacao;
    private String placaCaminhao; // referencia ao caminhao
    private int numeroDoca; // referencia a doca
    private LocalDateTime dataHoraChegada;
    private LocalDateTime horaInicio; // preenchido quando operacao comeca
    private LocalDateTime horaTermino; // preenchida quando operacao termina
    private TipoOperacao tipoOperacao;
    private String produto;
    private double pesoCarga; // em toneladas
    private StatusOperacao statusOperacao;

    //constructor
    public Operacao(int codigoOperacao, String placaCaminhao, int numeroDoca, LocalDateTime dataHoraChegada,
                    TipoOperacao tipoOperacao, String produto, double pesoCarga){
        this.codigoOperacao = codigoOperacao;
        this.placaCaminhao = placaCaminhao.toUpperCase().trim();
        this.numeroDoca = numeroDoca;
        this.dataHoraChegada = dataHoraChegada;
        this.tipoOperacao = tipoOperacao;
        this.produto = produto;
        this.pesoCarga = pesoCarga;
        this.statusOperacao = StatusOperacao.AGENDADA; // comeca sempre agendada
        this.horaInicio = null; // nao iniciou
        this.horaTermino = null; // nao terminou
    }

    // getters
    public int getCodigoOperacao() {return codigoOperacao;}
    public String getPlacaCaminhao() {return placaCaminhao;}
    public int getNumeroDoca() {return numeroDoca;}
    public LocalDateTime getDataHoraChegada() {return dataHoraChegada;}
    public LocalDateTime getHoraInicio() {return horaInicio;}
    public LocalDateTime getHoraTermino() {return horaTermino;}
    public TipoOperacao getTipoOperacao() {return tipoOperacao;}
    public String getProduto() {return produto;}
    public double getPesoCarga() {return pesoCarga;}
    public StatusOperacao getStatusOperacao() {return statusOperacao;}

    //setters
    public void setPlacaCaminhao(String placaCaminhao){
        this.placaCaminhao = placaCaminhao.toUpperCase().trim();
    }
    public void setNumeroDoca(int numeroDoca){
        this.numeroDoca = numeroDoca;
    }
    public void setDataHoraChegada(LocalDateTime dataHoraChegada){
        this.dataHoraChegada = dataHoraChegada;
    }
    public void setHoraInicio(LocalDateTime horaInicio){
        this.horaInicio = horaInicio;
    }
    public void setHoraTermino(LocalDateTime horaTermino){
        this.horaTermino = horaTermino;
    }
    public void setTipoOperacao(TipoOperacao tipoOperacao){
        this.tipoOperacao = tipoOperacao;
    }
    public void setProduto(String produto){
        this.produto = produto;
    }
    public void setPesoCarga(double pesoCarga){
        this.pesoCarga = pesoCarga;
    }
    public void setStatusOperacao(StatusOperacao statusOperacao){
        this.statusOperacao = statusOperacao;
    }

    //Formata data e hora para exibição
    private String formatar(LocalDateTime dt){
        return dt != null ? dt.format(FORMATTER) : "-";
    }

    @Override
    public String toString(){
        return String.format("Operação: %d | Placa: %s | Doca: %d | Tipo: %s | Produto: %s | " +
                        "Peso: %.1f ton | Status: %s | Chegada: %s | Início: %s | Término: %s",
                codigoOperacao, placaCaminhao, numeroDoca, tipoOperacao, produto,
                pesoCarga, statusOperacao, formatar(dataHoraChegada), formatar(horaInicio), formatar(horaTermino));

    }

}
