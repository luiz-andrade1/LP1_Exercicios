/*
3. Na empresa em que trabalhamos, há tabelas com o gasto de cada
mês. Para fechar o balanço do primeiro trimestre, precisamos somar
o gasto total. Sabendo que, em janeiro, foram gastos 15 mil reais, em
fevereiro, 23 mil reais e, em março, 17 mil reais, faça um programa
que calcule e imprima a despesa total no trimestre e a média mensal
de gastos.
 */

public void main(){

    Balanco trimestre = new Balanco();

    trimestre.setJaneiro(15000);
    trimestre.setFevereiro(23000);
    trimestre.setMarco(17000);

    IO.println("A totalidade dos gastos no trimestre é:");
    IO.println(trimestre.somar());

    IO.println("A media dos gastos no trimestre é:");
    IO.println(trimestre.media());
}
