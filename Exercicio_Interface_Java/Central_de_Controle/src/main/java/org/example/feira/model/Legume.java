package org.example.feira.model;

public class Legume {

    private int id;
    private String nome;
    private Integer quantidade;
    private Double valor;

    public Legume(String nome, Integer quantidade, Double valor){
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Legume(int id, String nome, Integer quantidade, Double valor){
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Legume(){}

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
    public void setValor(){
        this.valor = valor;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
}
