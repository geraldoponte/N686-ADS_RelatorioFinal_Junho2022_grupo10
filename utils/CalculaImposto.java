import java.util.Scanner;

/** @author Carlos Diego Moreira Rufino 2124707 */

public class CalculaImposto {
    Scanner scanner = new Scanner(System.in);


    public double calculaImposto (){
        double salarioBruto;
        System.out.println("Qual o seu salário?");
        salarioBruto= scanner.nextDouble();

        Calculadora cal = new Calculadora();
        double resultado = cal.multiplicacao(salarioBruto, 0.4082);

        System.out.println("Aproximadamente " + resultado + " reais do seu salário são para pagar impostos.");
        return resultado;
    }

}