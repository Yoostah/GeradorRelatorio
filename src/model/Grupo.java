package classes;

/**
 *
 * @author Thulio
 */
public class Grupo {
    private int id;
    private String nome;

    //Construtor
    public Grupo(String nome) {
        this.nome = nome;
    }
    
    //Construtor Vazio
    public Grupo() {
    
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
    
    
}
