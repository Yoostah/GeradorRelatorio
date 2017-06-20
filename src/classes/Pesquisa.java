
package classes;

import java.util.Date;


/**
 *
 * @author Thulio
 */
public class Pesquisa {
    private String pesquisa;
    private Date data;
    private int pergunta;
    private int resposta;
    private int colaborador;

    public Pesquisa(String pesquisa, Date data, int pergunta, int resposta, int colaborador) {
        this.pesquisa = pesquisa;
        this.data = data;
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.colaborador = colaborador;
    }

    public int getColaborador() {
        return colaborador;
    }

    public void setColaborador(int colaborador) {
        this.colaborador = colaborador;
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
        return "Pesquisa=" + pesquisa + ", Data=" + data + ", Pergunta=" + pergunta + ", Resposta=" + resposta + ", Colaborador=" + colaborador + '}';
    }
    
    
    
    
    
}
