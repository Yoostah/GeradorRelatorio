
package model;

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
    private String maquina;
    private String grupo;
    private int textop;

    //Construtor
    public Pesquisa(String pesquisa, Date data, int pergunta, int resposta, int colaborador, String maquina, String grupo, int textop) {
        this.pesquisa = pesquisa;
        this.data = data;
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.id_colaborador = colaborador;
        this.maquina = maquina;
        this.grupo = grupo;
        this.textop = textop;
    }
    
    //Construtor Vazio
    public Pesquisa() {
    
    }

    public int getTextop() {
        return textop;
    }

    public void setTextop(int textop) {
        this.textop = textop;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
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


}
