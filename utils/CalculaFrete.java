
import java.util.Scanner;

/**Classe que realiza o calcula do preço do frete a depender da distância e do tempo percorrido @author Gabriel (mat 2124706)*/

public class CalculaFrete {

	Scanner s = new Scanner(System.in);

	public double Calcularfrete() {

		System.out.print("Digite a distancia Percorrida em KM ");

		double distanciaFrete = s.nextDouble();

		System.out.println("Digite o tempo gasto para realizar o frete em minutos: ");

		double tempoFrete = s.nextDouble();

		Calculadora calc = new Calculadora();

		double custoDistancia = calc.multiplicacao(distanciaFrete, 2);
		double custoTempo = calc.multiplicacao(tempoFrete, 0.5);

		double custoTotal = calc.soma(custoDistancia, custoTempo);

		System.out.println("O preço total do frete é : " + custoTotal);
		return custoTotal;
	}

};