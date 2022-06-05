/** @author Geraldo Giovani Pinho da Ponte (2124713) */

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader {

    private Scanner in;

    public ConsoleReader(Scanner in) {
        this.in = in;
    }

    public double readDouble(String mensagem) {
        boolean argumentoValido = false;
        double input = 0.0;

        do {
            System.out.print(mensagem);
            try {
                input = in.nextDouble();
                argumentoValido = true;
            } catch (InputMismatchException e) {
                in.nextLine();
                argumentoValido = false;
            }
        } while (!argumentoValido);

        return input;
    }

    public int readInteger(String mensagem) {
        boolean argumentoValido = false;
        int input = 0;

        do {
            System.out.print(mensagem);
            try {
                input = in.nextInt();
                argumentoValido = true;
            } catch (InputMismatchException e) {
                in.nextLine();
                argumentoValido = false;
            }
        } while (!argumentoValido);

        return input;
    }

    public boolean respondeuSim(String pergunta) {
        String resposta = "";
        boolean respostaValida = false;
        String sim = "S";
        String nao = "N";

        in.nextLine();
        do {
            System.out.print(pergunta);
            try {
                resposta = in.nextLine();
                respostaValida = resposta.equalsIgnoreCase(sim) || resposta.equalsIgnoreCase(nao);
            } catch (InputMismatchException e) {
                in.nextLine();
                respostaValida = false;
            }

        } while (!respostaValida);
        return resposta.equalsIgnoreCase(sim);
    }

}