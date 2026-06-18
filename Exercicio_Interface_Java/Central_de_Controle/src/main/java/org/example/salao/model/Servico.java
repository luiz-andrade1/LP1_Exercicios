package org.example.salao.model;

public class Servico {

    private int id;
    private String nome;
    private Double valor;
    private String responsavel;

    public Servico(String nome, Double valor, String responsavel){
        this.nome = nome;
        this.valor = valor;
        this.responsavel = responsavel;
    }

    public Servico(int id, String nome, Double valor, String responsavel){
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.responsavel = responsavel;
    }

   public Servico(){}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getResponsavel(){
        return responsavel;
    }
    public void setResponsavel(String responsavel){
        this.responsavel = responsavel;
    }
    public Double getValor(){
        return valor;
    }
    public void setValor(Double valor){
        this.valor = valor;
    }
}
