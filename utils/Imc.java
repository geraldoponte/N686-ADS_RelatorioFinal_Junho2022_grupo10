/** @author Geraldo Giovani Pinho da Ponte (2124713) */

public class Imc {
    private final double[] faixas = { 16.9, 18.4, 24.9, 29.9, 34.9, 40.0 };

    private final double IMC_NORMAL_MINIMO = 18.5;
    private final double IMC_NORMAL_MAXIMO = 24.9;
    private final String[] descricao = {
            "muito abaixo do peso",
            "abaixo do peso",
            "peso normal",
            "acima do peso",
            "obesidade grau 1",
            "obesidade grau 2",
            "obesidade grau 3"
    };

    final String linhaDivisoria = "=".repeat(43) + "\n";

    private double peso;
    private double altura;

    public String getTabelaIMC() {
        final String linhaDivisoria = "=".repeat(43) + "\n";
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        sb.append(linhaDivisoria);
        sb.append("Faixa  Valor           Descricao" + "\n");
        sb.append(linhaDivisoria);
        sb.append("    1     " + 0.0 + " a " + faixas[0] + "0  " + descricao[0]);
        sb.append("\n");
        for (int i = 1; i < faixas.length; i++) {
            sb.append("    " + (i + 1) + "   " + (faixas[i - 1] + 0.01) + " a " + faixas[i] + "0  " + descricao[i]);
            sb.append("\n");
        }
        sb.append("    " + descricao.length + "  acima de " + faixas[faixas.length - 1] + "0  "
                + descricao[descricao.length - 1]);
        sb.append("\n" + linhaDivisoria);
        sb.append("FONTE: https://www.tuasaude.com/imc/");
        sb.append("\n\n");
        return sb.toString();
    }

    public double getPeso() {
        return this.peso;
    }

    public double getAltura() {
        return this.altura;
    }

    public int getFaixa() {
        int faixa = 0;
        double valorImc = this.getValorImc();
        for (int i = 0; i < faixas.length; i++) {
            if (valorImc > faixas[i]) {
                faixa++;
            } else {
                break;
            }
        }
        return faixa + 1;
    }

    public String getDescricao() {
        return descricao[this.getFaixa() - 1];
    }

    public double getValorImc() {
        Calculadora calc = new Calculadora();
        double denominador = calc.exponencial(this.altura, 2);
        double resultado = Math.round(calc.divisao(this.peso, denominador) * 100.0);
        resultado = resultado / 100.0;
        return resultado;
    }

    public double getPesoIdealMinimo() {
        Calculadora calc = new Calculadora();
        double resultado = calc.multiplicacao(calc.exponencial(this.altura, 2), IMC_NORMAL_MINIMO);
        return Math.round(resultado * 100.0) / 100.0;
    }

    public double getPesoIdealMaximo() {
        Calculadora calc = new Calculadora();
        double resultado = calc.multiplicacao(calc.exponencial(this.altura, 2), IMC_NORMAL_MAXIMO);
        return Math.round(resultado * 100.0) / 100.0;
    }

    public Imc(final double peso, final int alturaEmCentimetros) {
        if (peso <= 0) {
            throw new IllegalArgumentException("O peso informado é inválido: " + peso + "Kg.");
        }

        if (alturaEmCentimetros <= 0) {
            throw new IllegalArgumentException("O altura informada é inválida: " + alturaEmCentimetros + "cm.");
        }

        this.peso = peso;
        this.altura = alturaEmCentimetros / 100.0;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append(linhaDivisoria);
        sb.append("Relatório\n");
        sb.append(linhaDivisoria);
        sb.append("Altura: " + this.altura + "m\n");
        sb.append("Peso: " + this.peso + "Kg\n");
        sb.append("IMC: " + this.getValorImc() + "\n");
        sb.append("Faixa IMC: " + this.getFaixa() + "\n");
        sb.append("Classificação: " + this.getDescricao() + "\n");
        sb.append("Peso Ideal Mínimo: " + this.getPesoIdealMinimo() + " Kg\n");
        sb.append("Peso Ideal Máximo: " + this.getPesoIdealMaximo() + " Kg\n");
        sb.append(linhaDivisoria);
        return sb.toString();
    }

}