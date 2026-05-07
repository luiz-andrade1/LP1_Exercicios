package farmacia.ClassModel;

public class Remedio {

    private String nome;
    private Integer peso;
    private Double valor;

    public Remedio (String nome, Integer peso, Double valor){
        this.nome = nome;
        this.peso = peso;
        this.valor = valor;
    }

    public Remedio (){}

    public String getNome() {return nome;}
    public void setNome() {this.nome = nome;}

    public Integer getPeso() {return peso;}
    public void setPeso() {this.peso = peso;}

    public Double getValor() {return valor;}
    public void setValor() {this.valor = valor;}

    public String mostrarVenceu(){
        return (getNome()+" passou da data de validade");
    }

    public String mostrarPeso(){ return (getNome()+" pesa "+String.valueOf(getPeso())+"g");}

    public String mostrarValor(){return  (getNome()+" custa "+String.valueOf(getValor())+" reais");}
}
