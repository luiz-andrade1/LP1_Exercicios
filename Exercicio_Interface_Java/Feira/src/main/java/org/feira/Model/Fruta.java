package org.feira.Model;

public class Fruta {

    private String nome;
    private Integer quantidade;
    private Double valor;

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

    public String vendeu(){
        return (getNome()+" foi vendido em sua totalidade");
    }

    public String quantidadeSobrando(){
        return ("Restam "+String.valueOf(getQuantidade())+" da fruta "+getNome())+".";
    }

    public String mostrarValor(){
        return (getNome()+" custa "+String.valueOf(getValor())+" reais.");
    }

}
