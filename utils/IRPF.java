/** @author Alexandre Teixeira de Oliveira 2124755 */
public class IRPF {
    private double valorIRPF;
    private double aliquota1 = 0.075;
    private double aliquota2 = 0.15;
    private double aliquota3 = 0.225;
    private double aliquota4 = 0.275;
    private double baseCalculo1 = 1903.98;
    private double baseCalculo2 = 2826.65;
    private double baseCalculo3 = 3751.05;  
    private double baseCalculo4 = 4664.68;
    private double auxiliar1;
    private double imposto1 = baseCalculo2 * aliquota1;
    private double imposto2 = baseCalculo3 * aliquota2;
    private double imposto3 = baseCalculo4 * aliquota3;

    public double calculoIRPF (double salario){
        Calculadora calc = new Calculadora();
        if (salario <= baseCalculo1){
            valorIRPF = 0;
        }
        if ((salario > baseCalculo1)&&(salario <= baseCalculo2) ){
            auxiliar1 = calc.subtracao(salario, baseCalculo1);
            valorIRPF = calc.multiplicacao(auxiliar1, aliquota1);
        }
        if ((salario > baseCalculo2)&&(salario <= baseCalculo3) ){
            auxiliar1 = calc.subtracao(salario,baseCalculo2);
            valorIRPF = calc.multiplicacao(auxiliar1,aliquota2) + imposto1;
        }
        if ((salario > baseCalculo3)&&(salario <= baseCalculo4) ){
            auxiliar1 = calc.subtracao(salario,baseCalculo3);
            valorIRPF = calc.multiplicacao(auxiliar1,aliquota3) + imposto1 + imposto2;
        }
        if (salario > baseCalculo4){
            auxiliar1 = calc.subtracao(salario,baseCalculo4);
            valorIRPF = calc.multiplicacao(auxiliar1,aliquota4) + imposto1 + imposto2 + imposto3;
        }

    return valorIRPF;    
    }  
}
