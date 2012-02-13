/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author administrador
 */
public class Categoria {
private int idCategoria;
private String categoria;

    public Categoria(int idCategoria, String categoria) {
        this.idCategoria = idCategoria;
        this.categoria = categoria;
    }

    public Categoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the idCategoria
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param idCategoria the idCategoria to set
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
