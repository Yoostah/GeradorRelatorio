package _propriedades;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Thulio
 */
public class Configuracoes {

    private Properties props;
    private String nomeDoProperties = "/_propriedades/config.properties";

    protected Configuracoes() {
        props = new Properties();
        InputStream in = this.getClass().getResourceAsStream(nomeDoProperties);
        try {
            props.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String getValor(String chave) {
        String config = null;
        switch (chave) {
            case "porta":
                config = (String) props.getProperty("sisat.port");
                break;
            case "host":
                config = (String) props.getProperty("sisat.host");
                break;
            case "db":
                config = (String) props.getProperty("sisat.db");
                break;
            case "login":
                config = (String) props.getProperty("sisat.login");
                break;
            case "senha":
                config = (String) props.getProperty("sisat.password");
                break;
            default:
                System.out.println("Parâmetro " + chave + " não encontrado");
        }
        return config;
    }

}
