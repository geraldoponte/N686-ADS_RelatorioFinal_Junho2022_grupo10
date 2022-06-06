import java.util.Scanner;

public class MediaFinal {

 /** classe para calcular a média de alunos @author Victor Maciel Sousa Silva (mat. 2124704) */
 Scanner sc = new Scanner(System.in);

 public void calcularMedia(){
     double nota1,nota2, media;
     System.out.println("Entre com a primeira nota");
     nota1= sc.nextDouble();
     System.out.println("Com a segunda nota");
     nota2= sc.nextDouble();
     Calculadora calc = new Calculadora();
     media=(calc.soma(nota1,nota2)/2);
     System.out.println("A nota final é " + media);
 }
    
}
