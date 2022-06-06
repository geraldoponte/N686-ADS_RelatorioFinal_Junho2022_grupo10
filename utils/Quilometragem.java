import java.util.Scanner;

public class Quilometragem{
    
     /** classe para calcular a km final de carros alugados @author Victor Maciel Sousa Silva (mat. 2124704) */
     Scanner sc = new Scanner(System.in);

     public double mostrarDistancia(){
         double kmInicial,kmFinal, resultado;
         System.out.println("Entre com km inicial");
         kmInicial= sc.nextDouble();
         System.out.println("Entre com a km final");
         kmFinal= sc.nextDouble();
         Calculadora cal = new Calculadora(); 
         resultado = cal.subtracao(kmFinal, kmInicial);
         System.out.println("O carro teve " + resultado + "Km rodados");
         return resultado;
}
   }