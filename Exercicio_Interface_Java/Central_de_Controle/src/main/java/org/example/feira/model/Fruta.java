package org.example.feira.model;

public class Fruta {

    private int id;
    private String nome;
    private Integer quantidade;
    private Double valor;

    public Fruta(int id, String nome, Integer quantidade, Double valor) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Fruta(String nome, Integer quantidade, Double valor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Fruta(){}

    public String getNome(){
        return nome;
    }
    public void setNome(){
        this.nome = nome;
    }

    public Integer getQuantidade(){
        return quantidade;
    }
    public void setQuantidade(){
        this.quantidade = quantidade;
    }

    public Double getValor(){
        return valor;
    }
    public void setValor(){this.valor = valor;}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
}
