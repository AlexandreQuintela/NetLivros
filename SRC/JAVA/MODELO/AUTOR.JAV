/*
 * Autor.java
 *
 * Created on 11 de Novembro de 2008, 21:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author Alexandre Scheffer Quintela
 */
public class Autor {
    
    /** Creates a new instance of Autor */
    public Autor() {
    }
    
    private int idAutor;
    private String nome;
    private String email;
    private String dataNascimento;
    
    //ConvData cd = null;
    
    public Autor(int idAutor, String nome, String email, String dataNascimento) {
        this.setIdAutor(idAutor);
        this.setNome(nome);
        this.setEmail(email);
        this.setDataNascimento(dataNascimento);
    }
    public Autor(String nome, String email, String dataNascimento) {
        this.setNome(nome);
        this.setEmail(email);
        this.setDataNascimento(dataNascimento);
    }
    public Autor(int idAutor, String nome) {
        this.setIdAutor(idAutor);
        this.setNome(nome);
    }
    
    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        //dataNascimento = cd.parseDataIso(dataNascimento);
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {       
        this.dataNascimento = dataNascimento;
    }
}
