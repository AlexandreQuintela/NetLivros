/*
 * Livro.java
 *
 * Created on 11 de Novembro de 2008, 20:52
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Alexandre Scheffer Quintela
 */
public class Livro {

    /** Creates a new instance of Livro */
    public Livro() {
    }
    private String isbn;
    private String titulo;
    private int numeroEdicao;
    private int anoPublicacao;
    private String descricao;

    public Livro(String isbn, String titulo, int numeroEdicao, int anoPublicacao, String descricao) {
        this.setIsbn(isbn);
        this.setTitulo(titulo);
        this.setNumeroEdicao(numeroEdicao);
        this.setAnoPublicacao(anoPublicacao);
        this.setDescricao(descricao);
    }
    
    public Livro(String isbn, String titulo) {
        this.setIsbn(isbn);
        this.setTitulo(titulo);
    }
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumeroEdicao() {
        return numeroEdicao;
    }

    public void setNumeroEdicao(int numeroEdicao) {
        this.numeroEdicao = numeroEdicao;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
