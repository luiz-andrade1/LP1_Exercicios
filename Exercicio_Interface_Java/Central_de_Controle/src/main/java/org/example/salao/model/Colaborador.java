package org.example.salao.model;

public class Colaborador {

    private int id;
    private String nome;
    private String funcao;
    private Double salario;

    public Colaborador(String nome, String funcao, Double salario){
        this.nome = nome;
        this.funcao = funcao;
        this.salario = salario;
    }

    public Colaborador(int id, String nome, String funcao, Double salario){
        this.id = id;
        this.nome = nome;
        this.funcao = funcao;
        this.salario = salario;
    }

    public Colaborador(){}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getFuncao(){
        return funcao;
    }
    public void setFuncao(String funcao){
        this.funcao = funcao;
    }
    public Double getSalario(){
        return salario;
    }
    public void setSalario(Double salario){
        this.salario = salario;
    }
}
