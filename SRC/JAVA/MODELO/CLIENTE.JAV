/*
 * Cliente.java
 *
 * Created on 1 de Novembro de 2008, 09:06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Alexandre Scheffer Quintela
 */
public class Cliente {

    /** Creates a new instance of Cliente */
    public Cliente() {
    }
    private int idCliente;
    private String nome;
    private String endereco;
    private String telefone;
    private String estado;
    private String email;
    private String senha;

    //Construtor criado automaticamente pelo menu adicionar clicando em cima de contrutores
    public Cliente(String nome, String endereco, String telefone, String estado, String email, String senha) {
        //crio para fazer persistencia no banco não preciso passar o id pois ele é autoincremento
        this.setNome(nome);
        this.setEndereco(endereco);
        this.setTelefone(telefone);
        this.setEstado(estado);
        this.setEmail(email);
        this.setSenha(senha);
    }

    public Cliente(int id, String nome, String endereco, String telefone, String estado, String email, String senha) {
        //crio para fazer persistencia no banco não preciso passar o id pois ele é autoincremento
        this.setIdCliente(id);
        this.setNome(nome);
        this.setEndereco(endereco);
        this.setTelefone(telefone);
        this.setEstado(estado);
        this.setEmail(email);
        this.setSenha(senha);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
