public class Calculadora {

    public double soma(double numeroA, double numberoB) {
        return 0.0;
    }

    public double subtracao(double numeroA, double numberoB) {
        return 0.0;
    }

    public double multiplicacao(double numeroA, double numeroB) {
        return 0.0;
    }

    public double piso(double numeroA) {
        return 0.0;
    }

    public double teto(double numero) {
        return 0.0;
    }

    public double exponencial(double base, double expoente) {
        return 0.0;
    }

    /** @author Geraldo Giovani Pinho da Ponte (mat. 2124713) */
    public double divisao(double dividendo, double divisor) {
        if (divisor == 0) {
            String sinal = "";
            if (dividendo < 0) {
                sinal = "-";
            }
            throw new IllegalArgumentException(
                    "Não é possível dividir por zero. Java retornaria '" + sinal + "Infinity'.");
        }
        return (dividendo) / divisor;
    }

    /** @author Geraldo Giovani Pinho da Ponte (mat. 2124713) */
    public double raizQuadrada(double radicando) {
        if (radicando < 0) {
            throw new IllegalArgumentException(
                    "\n\n Parâmetro: " + radicando
                            + "\n Não existe raiz quadrada de números negativos no conjunto de números "
                            + "reais.\n "
                            + "Java retornaria 'NaN'.\n");
        }
        return Math.sqrt(radicando);
    }

}