package org.salao.Model;

public class Cliente {

    private String nome;
    private String tipoCliente;
    private Integer idade;

    public Cliente(String nome, String tipoCliente, Integer idade){
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        this.idade = idade;
    }

    public Cliente(){}

    public String getNome(){
        return nome;
    }
    public void setNome(){
        this.nome = nome;
    }
    public String getTipoCliente(){
        return tipoCliente;
    }
    public void setTipoCliente(){
        this.tipoCliente = tipoCliente;
    }
    public Integer getIdade(){
        return idade;
    }
    public void setIdade(){
        this.idade = idade;
    }

    public String clienteChegou(){
        return (getNome()+" chegou na loja. Por favor, atenda-o.");
    }
    public String fazerAniversario(){
        return (getNome()+" fez "+String.valueOf(getIdade()+1)+" anos, hoje!");
    }
    public String mostrarTipoCliente(){
        return (getNome()+" eh cliente "+getTipoCliente()+".");
    }

}
