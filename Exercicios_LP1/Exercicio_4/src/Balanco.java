public class Balanco {

    private int janeiro;
    private int fevereiro;
    private int marco;

    public void setJaneiro(int janeiro) {
        this.janeiro = janeiro;
    }
    public void setFevereiro(int fevereiro) {
        this.fevereiro = fevereiro;
    }
    public void setMarco(int marco) {
        this.marco = marco;
    }
    public int somar(){
        return(janeiro+fevereiro+marco);
    }
    public double media(){
        return(somar()/3);
    }
}
