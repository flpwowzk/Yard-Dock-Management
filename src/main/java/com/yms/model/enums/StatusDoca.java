package com.yms.model.enums;

public enum StatusDoca {
    LIVRE("Livre"),
    OCUPADA("Ocupada");

    private final String descricao;

    StatusDoca(String descricao){
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
