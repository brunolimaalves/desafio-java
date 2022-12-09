package br.com.biblioteca.enums;


public enum Classificacao {

    BAIXO_RISCO("Baixo Risco"),
    MEDIO_RISCO("Medio Risco"),
    ALTO_RISCO("Alto Risco");

    private final String descricao;

    public String getDescricao() {
        return descricao;
    }

    Classificacao(String descricao) {
        this.descricao = descricao;
    }
}
