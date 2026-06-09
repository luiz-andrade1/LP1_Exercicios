package org.salao.Model;

public class Servico {

    private String nome;
    private Double valor;
    private String responsavel;

    public Servico(String nome, Double valor, String responsavel){
        this.nome = nome;
        this.valor = valor;
        this.responsavel = responsavel;
    }
    public Servico(){}

    public String getNome(){
        return nome;
    }
    public void setNome(){
        this.nome = nome;
    }
    public String getResponsavel(){
        return responsavel;
    }
    public void setResponsavel(){
        this.responsavel = responsavel;
    }
    public Double getValor(){
        return valor;
    }
    public void setValor(){
        this.valor = valor;
    }

    public String servicoExecutando(){
        return (getNome()+" esta sendo executado pelo(a): "+getResponsavel());
    }
    public String aumentarValorServico(){
        return (getNome()+" teve uma alteracao de valor e agora custa "+String.valueOf(getValor()+50));
    }
    public String cobrarServico(){
        return(getResponsavel()+" esta cobrando "+String.valueOf(getValor())+" do servico "+getNome()+" que executou.");
    }

}
