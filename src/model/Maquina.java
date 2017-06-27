
package model;

/**
 *
 * @author Thulio
 */
public class Maquina {
    private int id;
    private String nome;
    private String caminho;
    private String grupo;
    private boolean importar;
    private boolean importado;
    

    //Construtor
    public Maquina(String nome, String caminho, String grupo) {
        this.nome = nome;
        this.caminho = caminho;
        this.grupo = grupo;
        this.importar = false;
        this.importado = false;
    }
    
    //Construtor Vazio
    public Maquina() {
    
    }

    public boolean isImportado() {
        return importado;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }
    
    public boolean isImportar() {
        return importar;
    }

    public void setImportar(boolean importar) {
        this.importar = importar;
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

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
    
    
    
}
