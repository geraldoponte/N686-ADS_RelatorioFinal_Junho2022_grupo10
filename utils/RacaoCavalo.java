/** @author Alexandre Teixeira de Oliveira 2124755 */
public class RacaoCavalo {
    public double calculaRacao (double peso){
        Calculadora calc = new Calculadora();
        return calc.teto((peso / 50));
    }
}
