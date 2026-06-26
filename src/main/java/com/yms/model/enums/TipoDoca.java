package com.yms.model.enums;

public enum TipoDoca {
    CARGA("Carga"),
    DESCARGA("Descarga");

    private final String descricao;

    TipoDoca(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString(){
        return descricao;
    }
}
