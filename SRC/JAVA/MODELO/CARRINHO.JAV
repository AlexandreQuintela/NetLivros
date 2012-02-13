    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author Alexandre
 */
public class Carrinho {
  private int idPublicacao;
    private double preco;
    private String titulo;
    private String descricao;
    private int quantidade;

    public Carrinho() {
    }

    public Carrinho(int idPublicacao, double preco, String titulo, String descricao, int quantidade) {
        this.idPublicacao = idPublicacao;
        this.preco = preco;
        this.titulo = titulo;
        this.descricao = descricao;
        this.quantidade = quantidade;
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
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
