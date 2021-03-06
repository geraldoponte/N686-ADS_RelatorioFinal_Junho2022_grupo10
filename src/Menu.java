import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {
    private String menuPrincipal() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n\nDigite 1 para IRPF\n");
        sb.append("Digite 2 para Ração do Cavalo\n");
        sb.append("Digite 3 para calcular as raízes de uma Equação do Segundo Grau\n");
        sb.append("Digite 4 para calcular o IMC\n");
        sb.append("Digite 5 para Km percorrido\n");
        sb.append("Digite 6 para calcular média da disciplina\n");
        sb.append("Digite 7 para Função Mostrar Idade\n");
        sb.append("Digite 8 para Função Calcular Frete\n");
        sb.append("Digite 9 para Função 'Gasolina ou Álcool?'\n");
        sb.append("Digite 10 para Função Calculadora de Imposto\n");
        sb.append("Digite 11 para sair\n");
        sb.append("Informe a operação desejada: ");
        return sb.toString();
    }

    public void apresentarOpcoes() {
        int opcao = 0;
        double numeroA = 0.0;
        double numeroB = 0.0;

        Scanner teclasDigitadas = new Scanner(System.in);
        try {
            ConsoleReader in = new ConsoleReader(teclasDigitadas);

            while (opcao != 9) {
                opcao = in.readInteger(menuPrincipal());

                switch (opcao) {

                    case 1: {
                        /*Alexandre Teixeira de Oliveira 2124755 */
                        System.out.println("Você escolheu IRPF:");
                        IRPF imposto = new IRPF();
                        try {
                           
                            System.out.println("Digite o salário");
                            numeroA = teclasDigitadas.nextDouble();
                            System.out.println(" Você pagará R$ " + imposto.calculoIRPF(numeroA) + " de imposto de renda");
                        }catch (InputMismatchException exception) {
                            System.out.println("Digite apenas números.Tente novamente");
                            teclasDigitadas = new Scanner(System.in);
                            numeroA = 1;
                        } 
                        break;
                    }
                    case 2: {
                        /*Alexandre Teixeira de Oliveira 2124755 */
                        System.out.println("Você escolheu Ração do Cavalo:");
                        RacaoCavalo qtdRacao = new RacaoCavalo();
                        try {
                            System.out.println("Digite o peso do cavalo");
                            numeroA = teclasDigitadas.nextDouble();
                            System.out.println("Esse cavalo necessita de " + qtdRacao.calculaRacao(numeroA) + " kg de ração por dia");
                        }catch (InputMismatchException exception) {
                            System.out.println("Digite apenas números.Tente novamente");
                            teclasDigitadas = new Scanner(System.in);
                            numeroA = 1;
                        }   
                        break;
                    }
                    case 3: {
                        /* Geraldo Giovani Pinho da Ponte (2124713) */
                        System.out.println("Você escolheu calcular as raízes de uma equação do 2o grau:");
                        String leiaute = EquacaoSegundoGrau.LEIAUTE_DA_EQUACAO;
                        double a = in.readDouble(
                                "Informe o valor de 'a' para a equação " + leiaute + ": ");
                        double b = in.readDouble(
                                "Informe o valor de 'b' para a equação " + leiaute + ": ");
                        double c = in.readDouble(
                                "Informe o valor de 'c' para a equação " + leiaute + ": ");
                        EquacaoSegundoGrau eq = new EquacaoSegundoGrau(a, b, c);
                        System.out.println(eq.getRelatorioDoResultado(""));
                        if (in.respondeuSim("Deseja exibir uma amostra dos cenários possíveis? (S/N)")) {
                            System.out.println(eq.getExemplos());
                        }
                        break;
                    }
                    case 4: {
                        /* Geraldo Giovani Pinho da Ponte (2124713) */
                        System.out.println("Você escolheu calcular o IMC:");
                        double peso = in.readDouble("Informe seu peso (em Kg): ");
                        int altura = in.readInteger("Informe sua altura (valor inteiro em cm): ");
                        Imc imc = new Imc(peso, altura);
                        System.out.println(imc.getTabelaIMC());
                        System.out.println(imc.toString());
                        break;
                    }
                    case 5: {
                        System.out.println("Você escolheu calcular quilometragem do carro alugado:");
                        Quilometragem km = new Quilometragem();
                        km.mostrarDistancia();
                        break;
                    }
                    case 6: {
                        System.out.println("Você escolheu calcular a média do aluno(a):");
                        MediaFinal mf = new MediaFinal();
                        mf.calcularMedia();
                        break;
                    }
                    case 7: {
                        System.out.println("Você escolheu a função mostrar idade:");
                        MostraIdade mostraIdade = new MostraIdade();
                        mostraIdade.mostrarIdade();
                        break;
                    }
                    case 8: {
                        System.out.println("Você escolheu a opção, calcular frete:");
                        CalculaFrete calculoFrete = new CalculaFrete();
                        calculoFrete.Calcularfrete();
                        break;

                    }
                    case 9: {
                        /* Carlos Diego Moreira Rufino (2124707) */
                        System.out.println("Você escolheu a opção 'Gasolina ou Etanol?':");
                        GasolinaEtanol gasolinaEtanol = new GasolinaEtanol();
                        gasolinaEtanol.gasolinaEtanol();
                        break;
                    }
                    case 10: {
                        /* Carlos Diego Moreira Rufino (2124707) */
                        System.out.println("Você escolheu a opção 'Calculadora de Imposto':");
                        CalculaImposto calculoImposto = new CalculaImposto();
                        calculoImposto.calculaImposto();
                        break;
                    }
                    case 11: {
                        System.out.println("Você escolheu sair");
                        break;
                    }
                    default: {
                        System.out.println("Opção inválida");
                        break;
                    }
                }

                if (opcao != 11) {
                    if (!in.respondeuSim("Deseja continuar (S/N)? ")) {
                        opcao = 11;
                    }
                }

            }
        } finally {
            teclasDigitadas.close();
        }
    }
}
