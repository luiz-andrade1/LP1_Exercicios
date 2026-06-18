package org.example.farmacia.model;

public class Alimento {

    private int id;
    private String nome;
    private Integer peso;
    private Double valor;

    public Alimento(String nome, Integer peso, Double valor){
        this.nome = nome;
        this.peso = peso;
        this.valor = valor;
    }

    public Alimento(int id, String nome, Integer peso, Double valor){
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.valor = valor;
    }

    public Alimento(){}

    public String getNome() {return nome;}
    public void setNome() {this.nome = nome;}

    public Integer getPeso(){return peso;}
    public void setPeso(){this.peso = peso;}

    public Double getValor(){return valor;}
    public void setValor(){this.valor = valor;}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
}
