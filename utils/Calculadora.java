public class Calculadora {

    /** @author Victor Maciel Sousa Silva (mat. 2124704) */
    public double soma(double numeroA, double numberoB) {
        return numeroA + numberoB;
    }

    /** @author Victor Maciel Sousa Silva (mat. 2124704) */
    public double subtracao(double numeroA, double numberoB) {
        return numeroA - numberoB;
    }

    /** @author Pedro Gabriel Suprimio de Almeida (mat. 2124706) */
    public double multiplicacao(double numeroA, double numeroB) {
        return numeroA * numeroB;
    }

    public double piso(double numero) {
        return Math.floor(numero);
    }

    public double teto(double numero) {
        return Math.ceil(numero);
    }

    /** @author Pedro Gabriel Suprimio de Almeida (mat. 2124706) */
    public double exponencial(double base, double expoente) {
        return Math.pow(base, expoente);
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