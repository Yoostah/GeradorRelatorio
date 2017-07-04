package _propriedades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thulio
 */
public class Configuracoes {

    private Properties props;
    private String nomeDoProperties = "C:/SISAT-v2/config.properties";

    protected Configuracoes() {
        props = new Properties();
        FileInputStream in;
        try {
            in = new FileInputStream(nomeDoProperties);
            props.load(in);
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configuracoes.class.getName()).log(Level.SEVERE, null, ex);
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

    protected void setValor(String host, String porta, String banco, String usuario, String senha) {
        Properties prop = new Properties();
        OutputStream output = null;

        try {

            output = new FileOutputStream("C:/SISAT-v2/config.properties");

            // set the properties value
            prop.setProperty("sisat.host", host);
            prop.setProperty("sisat.port", porta);
            prop.setProperty("sisat.db", banco);
            prop.setProperty("sisat.login", usuario);
            prop.setProperty("sisat.password", senha);

            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
