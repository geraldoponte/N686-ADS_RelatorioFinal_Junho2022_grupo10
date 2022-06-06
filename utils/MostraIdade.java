import java.util.Scanner;

public class MostraIdade {

	Scanner sc = new Scanner(System.in);

	public void mostrarIdade() {
		double nascimento, anoAtual, resultado1;
		System.out.println("Digite o seu ano de nascimento");
		nascimento = sc.nextDouble();
		System.out.println("Digite o ano atual");
		anoAtual = sc.nextDouble();
		Calculadora calc = new Calculadora();
		resultado1 = (calc.subtracao(anoAtual, nascimento));
		System.out.println("Sua idade é " + resultado1 + " anos");
	}

};
