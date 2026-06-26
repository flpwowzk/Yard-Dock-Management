package com.yms.model.enums;

public enum TipoOperacao {
    CARGA("Carga"),
    DESCARGA("Descarga");

    private final String descricao;

    TipoOperacao(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

    @Override
    public String toString(){
        return descricao;
    }
}
