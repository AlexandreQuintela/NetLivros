/*
 * Publicacao.java
 *
 * Created on 11 de Novembro de 2008, 21:29
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Alexandre Scheffer Quintela
 */
public class Publicacao {

    /** Creates a new instance of Publicacao */
    public Publicacao() {
    }
    private int idPublicacao;
    private String isbn;
    private int idAutor;
    private int idEditora;
    private int idCategoria;
    private double preco;

    public Publicacao(int idPublicacao, String isbn, int idAutor, int idEditora, int idCategoria, double preco) {
        this.setIdPublicacao(idPublicacao);
        this.setIsbn(isbn);
        this.setIdAutor(idAutor);
        this.setIdEditora(idEditora);
        this.setIdCategoria(idCategoria);
        this.setPreco(preco);
    }

    public Publicacao(String isbn, int idAutor, int idEditora, int idCategoria, double preco) {
        this.setIsbn(isbn);
        this.setIdAutor(idAutor);
        this.setIdEditora(idEditora);
        this.setIdCategoria(idCategoria);
        this.setPreco(preco);
    }

    public int getIdPublicacao() {
        return idPublicacao;
    }

    public void setIdPublicacao(int idPublicacao) {
        this.idPublicacao = idPublicacao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(int idEditora) {
        this.idEditora = idEditora;
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
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }
}