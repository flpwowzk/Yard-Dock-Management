package com.yms.model;

import com.yms.model.enums.StatusDoca;
import com.yms.model.enums.TipoDoca;

public class Doca {
    private int numeroDoca;
    private TipoDoca tipoDoca;
    private StatusDoca statusDoca;
    private double capacidadeMaxima; //em tons

    public Doca(int numeroDoca, TipoDoca tipoDoca, StatusDoca statusDoca, double capacidadeMaxima){
        this.numeroDoca = numeroDoca;
        this.tipoDoca = tipoDoca;
        this.statusDoca = StatusDoca.LIVRE;
        setCapacidadeMaxima(capacidadeMaxima);
    }

    public int getNumeroDoca() {return numeroDoca;}
    public TipoDoca getTipoDoca() {return tipoDoca;}
    public StatusDoca getStatusDoca() {return statusDoca;}
    public double getCapacidadeMaxima() {return capacidadeMaxima;}

    public void setNumeroDoca(int numeroDoca){
        this.numeroDoca = numeroDoca;
    }
    public void setTipoDoca(TipoDoca tipoDoca){
        this.tipoDoca = tipoDoca;
    }
    public void setStatusDoca(StatusDoca statusDoca) {
        this.statusDoca = statusDoca;
    }
    public void setCapacidadeMaxima(double capacidadeMaxima){
        if(capacidadeMaxima <= 0){
            throw new IllegalArgumentException("Capacidade maxima deve ser maior que zero.");
        }
        this.capacidadeMaxima = capacidadeMaxima;
    }

    @Override
    public String toString(){
        return String.format("Doca: %d | Tipo: %s | Status: %s | Capacidade máx: %.1f ton",
                numeroDoca, tipoDoca, statusDoca, capacidadeMaxima);
    }
}
