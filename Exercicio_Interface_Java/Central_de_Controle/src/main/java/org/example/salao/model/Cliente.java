package org.example.salao.model;

public class Cliente {

    private int id;
    private String nome;
    private String tipoCliente;
    private Integer idade;

    public Cliente(String nome, String tipoCliente, Integer idade){
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        this.idade = idade;
    }

    public Cliente(int id, String nome, String tipoCliente, Integer idade){
        this.id = id;
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        this.idade = idade;
    }

    public Cliente(){}

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getTipoCliente(){
        return tipoCliente;
    }
    public void setTipoCliente(String tipoCliente){this.tipoCliente = tipoCliente;}
    public Integer getIdade(){return idade;}
    public void setIdade(Integer idade){
        this.idade = idade;
    }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
}
