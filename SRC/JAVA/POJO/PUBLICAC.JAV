/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author administrador
 */
public class PublicacaoPOJO {

    private int idPublicacao;
    private String titulo;
    private String autor;
    private String nomeEditora;
    private String categoria;
    private double preco;
    private String descricao;
    private int edicao;
    private String ano;

    public PublicacaoPOJO(int idPublicacao, String titulo, String autor, String nomeEditora, String categoria, double preco, String descricao, int edicao, String ano) {
        this.idPublicacao = idPublicacao;
        this.titulo = titulo;
        this.autor = autor;
        this.nomeEditora = nomeEditora;
        this.categoria = categoria;
        this.preco = preco;
        this.descricao = descricao;
        this.edicao = edicao;
        this.ano = ano;
    }

    /**
     * @return the idPublicacao
     */
    public int getIdPublicacao() {
        return idPublicacao;
    }

    /**
     * @param idPublicacao the idPublicacao to set
     */
    public void setIdPublicacao(int idPublicacao) {
        this.idPublicacao = idPublicacao;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the nomeEditora
     */
    public String getNomeEditora() {
        return nomeEditora;
    }

    /**
     * @param nomeEditora the nomeEditora to set
     */
    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
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

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the edicao
     */
    public int getEdicao() {
        return edicao;
    }

    /**
     * @param edicao the edicao to set
     */
    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    /**
     * @return the ano
     */
    public String getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(String ano) {
        this.ano = ano;
    }
}
