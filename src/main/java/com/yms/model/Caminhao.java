package com.yms.model;

public class Caminhao {
    private String placa;
    private String transportadora;
    private String tipoVeiculo;
    private String motorista;
    private double capacidadeCarga; // em toneladas

    Caminhao(String placa, String transportadora, String tipoVeiculo, String motorista, double capacidadeCarga){
        this.placa = placa;
        this.transportadora = transportadora;
        this.tipoVeiculo = tipoVeiculo;
        this.motorista = motorista;
        setCapacidadeCarga(capacidadeCarga); //valida no set
    }

    public String getPlaca() {return placa;}
    public String getTransportadora() {return transportadora;}
    public String getTipoVeiculo(){return tipoVeiculo;}
    public String getMotorista() {return motorista;}
    public double setCapacidadeCarga(){return capacidadeCarga;}

    public void setPlaca(String placa){
        this.placa = placa.toUpperCase().trim();
    }
    public void setTransportadora(String transportadora){
        this.transportadora = transportadora;
    }
    public void setTipoVeiculo(String tipoVeiculo){
        this.tipoVeiculo = tipoVeiculo;
    }
    public void seTipoVeiculo(String tipoVeiculo){
        this.tipoVeiculo = tipoVeiculo;
    }
    public void setMotorista(String motorista){
        this.motorista = motorista;
    }
    public void setCapacidadeCarga(double capacidadeCarga){
        if(capacidadeCarga <= 0){
            throw new IllegalArgumentException("Capacidade de carga deve ser maior que zero");
        }
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public String toString(){
        return String.format("Placa: %s | Transportadora: %s | Tipo: %s | Motorista: %s | Capacidade: %.1f ton",
                placa, transportadora, tipoVeiculo, motorista, capacidadeCarga);
    }
}
