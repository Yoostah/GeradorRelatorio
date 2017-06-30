package _propriedades;

/**
 *
 * @author Thulio
 */
public class CarregarConfig {

    private static Configuracoes loader = new Configuracoes();

    public static String getValor(String chave) {
        return (String) loader.getValor(chave);
    }

}
