/*
 * Editora.java
 *
 * Created on 11 de Novembro de 2008, 08:56
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author Alexandre Scheffer Quintela
 */
public class Editora {
    
    /** Creates a new instance of Editora */
    public Editora() {
    }

    private int idEditora;
    private String nomeEditora;

    public Editora(int idEditora, String nomeEditora) {
        this.setIdEditora(idEditora);
        this.setNomeEditora(nomeEditora);
    }

    public Editora(String nomeEditora) {
        this.setNomeEditora(nomeEditora);
    }

    public int getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(int idEditora) {
        this.idEditora = idEditora;
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

    
}
