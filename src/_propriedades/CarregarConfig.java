package _propriedades;

/**
 *
 * @author Thulio
 */
public class CarregarConfig {

    private Configuracoes loader = new Configuracoes();

    public String getValor(String chave) {
        return (String) loader.getValor(chave);
    }
    
    public void setValor(String host, String porta, String banco, String usuario, String senha) {
        loader.setValor(host, porta, banco, usuario, senha);
    }

}
