package org.feira.Model;

public class Legume {

    private String nome;
    private Integer quantidade;
    private Double valor;

    public Legume(String nome, Integer quantidade, Double valor){
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

    public String vendeu(){
        return (getNome()+" foi vendido e agora restam "+String.valueOf(getQuantidade()-1));
    }

    public String mostrarQuantidade(){
        return ("Ha "+String.valueOf(getQuantidade())+" do legume "+getNome()+" em estoque.");
    }

    public String mostrarValor(){
        return (getNome()+" custa "+String.valueOf(getValor())+" reais.");
    }

}
