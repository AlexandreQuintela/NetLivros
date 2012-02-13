/*
 * Usuario.java
 *
 * Created on 11 de Novembro de 2008, 21:37
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author Alexandre Scheffer Quintela
 */
public class Usuario {
    
    /** Creates a new instance of Usuario */
    public Usuario() {
    }
    private int idUsuario;
    private String usuario;
    private String senha;
    
    public Usuario(int idUsuario, String usuario, String senha) {
        this.setIdUsuario(idUsuario);
        this.setUsuario(usuario);
        this.setSenha(senha);
    }
    public Usuario(String usuario, String senha) {
        this.setUsuario(usuario);
        this.setSenha(senha);
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
