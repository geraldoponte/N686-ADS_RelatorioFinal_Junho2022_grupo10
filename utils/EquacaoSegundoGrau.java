/** @author Geraldo Giovani Pinho da Ponte (2124713) */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class EquacaoSegundoGrau {

    public final static String LEIAUTE_DA_EQUACAO = "ax" + "\u00B2" + " + bc + c";
    private double a, b, c;
    private ArrayList<Double> raizes = new ArrayList<>();

    private double getDelta() {
        Calculadora calc = new Calculadora();
        double resultado = calc.exponencial(b, 2);
        resultado = resultado - 4 * calc.multiplicacao(a, c);
        return resultado;
    }

    private void bhaskara() {
        raizes.clear();

        if (a == 0.0) {
            throw new IllegalArgumentException("A equação informada não é de segundo grau! (a=0)");
        }
        double delta = getDelta();
        if (delta < 0.0) {
            throw new IllegalArgumentException("Não existem raízes válidas para a equação informada! (delta negativo)");
        }

        Calculadora calc = new Calculadora();
        double menosB = calc.multiplicacao(-1, this.b);
        double denominador = calc.multiplicacao(2, this.a);

        if (delta == 0.0) {
            raizes.add(calc.divisao(menosB, denominador));
            return;
        }

        double raizDeDelta = calc.raizQuadrada(delta);
        raizes.add(calc.divisao(calc.soma(menosB, raizDeDelta), denominador));
        raizes.add(calc.divisao(calc.subtracao(menosB, raizDeDelta), denominador));

        Collections.sort(raizes);
    }

    public EquacaoSegundoGrau(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getQtdeRaizes() {
        return raizes.size();
    };

    public Collection<Double> getRaizes() {
        this.bhaskara();
        return Collections.unmodifiableCollection(raizes);
    }

    @Override
    public String toString() {
        String sinal = "+";
        StringBuffer sb = new StringBuffer();
        sb.append(this.a);
        sb.append("x" + "\u00B2");
        sinal = (b < 0 ? " " : " + ");
        sb.append(sinal + this.b + "x");
        sinal = (c < 0 ? " " : " + ");
        sb.append(sinal + this.c);
        return sb.toString();
    }

    public String getRelatorioDoResultado(String descricao) {
        StringBuffer sb = new StringBuffer();
        sb.append(descricao + "\n");
        sb.append("equação: " + this.toString() + "\n");
        try {
            sb.append("raízes: " + this.getRaizes().toString() + "\n");
        } catch (IllegalArgumentException e) {
            sb.append("raízes: " + e.getMessage() + "\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    public String getExemplos() {
        StringBuffer sb = new StringBuffer();
        var eq = new EquacaoSegundoGrau(1, -5, 6);
        sb.append(eq.getRelatorioDoResultado("Exemplo 1: duas raízes válidas"));
        eq = new EquacaoSegundoGrau(4, -4, 1);
        sb.append(eq.getRelatorioDoResultado("Exemplo 2: uma raíz válida"));
        eq = new EquacaoSegundoGrau(5, 1, 6);
        sb.append(eq.getRelatorioDoResultado("Exemplo 3: não existem raízes válidas"));
        eq = new EquacaoSegundoGrau(0, 2, 4);
        sb.append(eq.getRelatorioDoResultado("Exemplo 4: não é equação do segundo grau (a = 0)"));
        return sb.toString();
    }
}
