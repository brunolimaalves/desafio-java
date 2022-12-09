package br.com.biblioteca.enums;

public enum Status {

    EM_ANALISE("Em analise"),
    ANALISE_REALIZADA("Analise Realizada"),
    ANALISE_APROVADA("Analise Aprovada"),
    INICIADO("Iniciado"),
    PLANEJADO("Planejado"),
    EM_ANDAMENTO("Em andamento"),
    ENCERRADO("Encerrado"),
    CANCELADO("Cancelado");

    private final String descricao;

    public String getDescricao() {
        return descricao;
    }

    Status(String descricao) {
        this.descricao = descricao;
    }
}
