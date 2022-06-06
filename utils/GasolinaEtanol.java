import java.util.Scanner;

/** @author Carlos Diego Moreira Rufino 2124707 */

public class GasolinaEtanol {
    Scanner scanner = new Scanner(System.in);


    public void gasolinaEtanol (){
        double precoGasolina,precoEtanol;
        System.out.println("Quanto está custando a gasolina?");
        precoGasolina= scanner.nextDouble();

        System.out.println("Quanto está custando o etanol?");
        precoEtanol= scanner.nextDouble();

        Calculadora cal = new Calculadora();
        double resultado = cal.multiplicacao(precoGasolina,0.7);

        if (resultado > precoEtanol) {

            System.out.println("Vale mais a pena colocar Etanol");

        } else {

            System.out.println("Vale mais a pena colocar Gasolina");

        }

    }

}