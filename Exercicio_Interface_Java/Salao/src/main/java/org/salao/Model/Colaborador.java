package org.salao.Model;

public class Colaborador {

    private String nome;
    private String funcao;
    private Double salario;

    public Colaborador(String nome, String funcao, Double salario){
        this.nome = nome;
        this.funcao = funcao;
        this.salario = salario;
    }
    public Colaborador(){}

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

    public String trabalhar(){
        return (getNome()+" esta trabalhando como: "+getFuncao());
    }
    public String promocao(){
        setSalario(salario + 200.00);
        return (getNome()+" foi promovido e agora ganha "+String.valueOf(getSalario()));
    }
    public String demitir(){
        return(getNome()+" foi demitido!");
    }
}
