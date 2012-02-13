/*
 * ClienteDAO.java
 *
 * Created on 1 de Novembro de 2008, 10:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

/**
 *
 * @author Alexandre Scheffer Quintela
 */
public class ClienteDAO {

    private Connection conn;

    public ClienteDAO() throws Exception {
        try {
            this.conn = Conexao2.getConexao();
        } catch (Exception e) {
            throw new Exception("Erro: " + ":\n" + e.getMessage());
        }
    }

    public void incluir(Cliente cliente) throws Exception {
        PreparedStatement ps = null;
        if (cliente == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            String SQL = "INSERT INTO cliente (nomedocliente, enderecodocliente, telefonedocliente, estadodocliente, email, senha) values(?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEndereco());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getEstado());
            ps.setString(5, cliente.getEmail());
            ps.setString(6, cliente.getSenha());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            Conexao2.fecharConexao(conn, ps);
        }
    }

    public void atualizar(Cliente cliente) throws Exception {
        PreparedStatement ps = null;
        if (cliente == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = Conexao2.getConexao();
            String SQL = "update cliente set idcliente=?, nomedocliente=?, enderecodocliente=?, telefonedocliente=?, estadodocliente=?, email=?, senha=? where idcliente = ?";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, cliente.getIdCliente());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEndereco());
            ps.setString(4, cliente.getTelefone());
            ps.setString(5, cliente.getEstado());
            ps.setString(6, cliente.getEmail());
            ps.setString(7, cliente.getSenha());
            ps.setInt(8, cliente.getIdCliente());

            ps.executeUpdate();
        } catch (SQLException sqle) {
            while (sqle != null) {
                System.out.println("Messagem:   " + sqle.getMessage());
                System.out.println("SQLState:  " + sqle.getSQLState());
                System.out.println("Código do erro: " + sqle.getErrorCode());
                sqle = sqle.getNextException();
                System.out.println("");
            }

            throw new Exception("Erro ao atualizar dados: " + sqle);
        } finally {
            Conexao2.fecharConexao(conn, ps);
        }
    }

    public void excluir(Cliente cliente) throws Exception {
        PreparedStatement ps = null;
        if (cliente == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = Conexao2.getConexao();
            String SQL = "delete from cliente where idCliente=?";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, cliente.getIdCliente());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados:" + sqle);
        } finally {
            Conexao2.fecharConexao(conn, ps);
        }
    }
    //quero uma lista como retorno public list

    public List todosClientes() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from cliente");
            rs = ps.executeQuery();
            List<Cliente> list = new ArrayList<Cliente>();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String endereco = rs.getString(3);
                String telefone = rs.getString(4);
                String estado = rs.getString(5);
                String email = rs.getString(6);
                String senha = "*";
                list.add(new Cliente(id, nome, endereco, telefone, estado, email, senha));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            Conexao2.fechar(conn, ps, rs);
        }
    }
    //quero de retorno um cliente por isso uso o public cliente

    public Cliente procurarCliente(Integer id) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = Conexao2.getConexao();
            ps = conn.prepareStatement("select * from cliente where idcliente=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new Exception("Não foi encontrado nenhum registro com o ID: " + id);
            }
            String nome = rs.getString(2);
            String endereco = rs.getString(3);
            String telefone = rs.getString(4);
            String estado = rs.getString(5);
            String email = rs.getString(6);
            String senha = rs.getString(7);
            return new Cliente(id, nome, endereco, telefone, estado, email, senha);
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            Conexao2.fechar(conn, ps, rs);
        }
    }
    public Cliente procurarCliente(String email) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from cliente where email=?");
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new Exception("Não foi encontrado nenhum registro com o email: " + email);
            }
            String nome = rs.getString(2);
            String endereco = rs.getString(3);
            String telefone = rs.getString(4);
            String estado = rs.getString(5);
            String senha = rs.getString(7);

            return new Cliente(nome, endereco, telefone, estado, email, senha);
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            Conexao2.fechar(conn, ps, rs);
        }
    }
}