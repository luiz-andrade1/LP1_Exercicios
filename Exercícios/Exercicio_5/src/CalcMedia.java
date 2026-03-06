//(p1*0,5+e1*0,2+e2*0,3+x+sub*0,15)*0,5.

public class CalcMedia {

    private double p1;
    private double e1;
    private double e2;
    private double x;
    private double sub;
    private double api;
    private double exame;

    public void setP1(double p1) {
        this.p1 = p1;
    }
    public void setE1(double e1) {
        this.e1 = e1;
    }
    public void setE2(double e2) {
        this.e2 = e2;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setSub(double sub) {
        this.sub = sub;
    }
    public void setApi(double api) {
        this.api = api;
    }

    public double calcNota (){
        double media = (p1*0.5+e1*0.2+e2*0.3+x+sub*0.15);
        if (media>5.9){return (media*0.5)+(api*0.5);}
        if (media<exame){return exame;}
        return media;
    }
}
