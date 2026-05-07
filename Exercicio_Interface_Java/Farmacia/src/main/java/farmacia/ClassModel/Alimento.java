package farmacia.ClassModel;

public class Alimento {

    private String nome;
    private Integer peso;
    private Double valor;

    public Alimento(String nome, Integer peso, Double valor){
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

    public String mostrarVenceu(){return (getNome()+" passou da data de validade!");}

    public String mostrarValor(){
        return("Esse alimento custa "+String.valueOf(getValor())+" reais.");
    }

    public String mostrarPeso(){
        return(getNome()+" pesa "+String.valueOf(getPeso())+" gramas.");
    }
}
