//formula nota.
//(p1*0,5+e1*0,2+e2*0,3+x+sub*0,15).
//api representa 50% da nota, caso o aluno atinja a media 6 nas entregas de aula.
//ou seja, api soma com a nota das entregas e provas e tudo se divide por 2.
//caso o aluno nao atinja a media 6, ele fara exame.
//exame representa a substituição das notas, ou seja, 100% da nota total no final.


import java.util.Scanner;
public class NotaFinal {

    public void main(){

        CalcMedia notas = new CalcMedia();
        Scanner ler = new Scanner(System.in);

        IO.println("Digite a nota da Primeira Prova:");
        notas.setP1(ler.nextDouble());
        IO.println("Digite a nota da Entrega 1:");
        notas.setE1(ler.nextDouble());
        IO.println("Digite a nota da Entrega 2:");
        notas.setE2(ler.nextDouble());
        IO.println("Digite a nota de Participação:");
        notas.setX(ler.nextDouble());
        IO.println("Agora, caso o aluno tenha feito.");
        IO.println("Digite a nota da Prova de Substituição:");
        notas.setSub(ler.nextDouble());
        IO.println("Agora digite a nota da API:");
        notas.setApi(ler.nextDouble());

        if(notas.calcNota()>5.9){
            IO.println("Aprovado");}
        else
        {IO.println("Reprovado por nota regular.\nDigitar nota do exame:");
        notas.setExame(ler.nextDouble());
            if (notas.calcNota()<5.9){
            IO.println("Reprovado");}
            else {IO.println("Aprovado");
            IO.println("E a nota foi:");
            IO.println(notas.calcNota());
        }
        }



    }

}