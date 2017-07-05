package model;

/**
 *
 * @author Thulio
 */
public class Pergunta {
    private int id;
    private String pergunta;

    //Construtor
    public Pergunta(String perg) {
        this.pergunta = perg;
    }
    
    //Construtor Vazio
    public Pergunta() {
    
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String perg) {
        this.pergunta = perg;
    }
    
    
    
    
    
}
