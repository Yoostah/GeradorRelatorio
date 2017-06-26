
package model;

/**
 *
 * @author Thulio
 */
public class Colaborador {
    private int id;
    private String nome;
    private String grupo;

    //Construtor
    public Colaborador(int id, String nome, String grupo) {
        this.id = id;
        this.nome = nome;
        this.grupo = grupo;
    }
    //Construtor Vazio
    public Colaborador() {
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

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
    
    
}
