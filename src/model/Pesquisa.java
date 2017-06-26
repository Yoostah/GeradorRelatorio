
package classes;

import java.util.Date;


/**
 *
 * @author Thulio
 */
public class Pesquisa {
    private int id;
    private String pesquisa;
    private Date data;
    private int pergunta;
    private int resposta;
    private int id_colaborador;

    //Construtor
    public Pesquisa(String pesquisa, Date data, int pergunta, int resposta, int colaborador) {
        this.pesquisa = pesquisa;
        this.data = data;
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.id_colaborador = colaborador;
    }
    
    //Construtor Vazio
    public Pesquisa() {
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId_colaborador() {
        return id_colaborador;
    }

    public void setId_colaborador(int id_colaborador) {
        this.id_colaborador = id_colaborador;
    }
  
    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getPergunta() {
        return pergunta;
    }

    public void setPergunta(int pergunta) {
        this.pergunta = pergunta;
    }

    public int getResposta() {
        return resposta;
    }

    public void setResposta(int resposta) {
        this.resposta = resposta;
    }

    @Override
    public String toString() {
        return "Pesquisa=" + pesquisa + ", Data=" + data + ", Pergunta=" + pergunta + ", Resposta=" + resposta + ", Colaborador=" + id_colaborador + '}';
    }
    
    
    
    
    
}
