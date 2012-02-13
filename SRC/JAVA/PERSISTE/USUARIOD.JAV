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
import modelo.Usuario;

/**
 *
 * @author Alexandre Scheffer Quintela
 */
public class UsuarioDAO {

    private Connection conn;

    public UsuarioDAO() throws Exception {
        try {
            this.conn = Conexao2.getConexao();
        } catch (Exception e) {
            throw new Exception("Erro: " + ":\n" + e.getMessage());
        }
    }

    public void incluir(Usuario usuario) throws Exception {
        PreparedStatement ps = null;
        if (usuario == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            String SQL = "INSERT INTO usuarios (usuario, senha) values(?,?)";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getSenha());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            while (sqle != null) {
                System.out.println("Messagem:   " + sqle.getMessage());
                System.out.println("SQLState:  " + sqle.getSQLState());
                System.out.println("Código do erro: " + sqle.getErrorCode());
                sqle = sqle.getNextException();
                System.out.println("");
            }
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            Conexao2.fecharConexao(conn, ps);
        }
    }

    public void atualizar(Usuario usuario) throws Exception {
        PreparedStatement ps = null;
        if (usuario == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = Conexao2.getConexao();
            String SQL = "update usuarios set usuario=?, senha=? where usuario=?";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getSenha());
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

    public void excluir(Usuario usuario) throws Exception {
        PreparedStatement ps = null;
        if (usuario == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = Conexao2.getConexao();
            String SQL = "delete from usuarios where usuario=?";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, usuario.getUsuario());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            while (sqle != null) {
                System.out.println("Messagem:   " + sqle.getMessage());
                System.out.println("SQLState:  " + sqle.getSQLState());
                System.out.println("Código do erro: " + sqle.getErrorCode());
                sqle = sqle.getNextException();
                System.out.println("");
            }
            throw new Exception("Erro ao excluir dados:" + sqle);
        } finally {
            Conexao2.fecharConexao(conn, ps);
        }
    }
    //quero uma lista como retorno public list

    public List todosUsuarios() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from usuarios");
            rs = ps.executeQuery();
            List<Usuario> list = new ArrayList<Usuario>();
            while (rs.next()) {
                int idUsuario = rs.getInt(1);
                String usuario = rs.getString(2);
                String senha = rs.getString(3);
                list.add(new Usuario(idUsuario, usuario, senha));
            }
            return list;
        } catch (SQLException sqle) {
            while (sqle != null) {
                System.out.println("Messagem:   " + sqle.getMessage());
                System.out.println("SQLState:  " + sqle.getSQLState());
                System.out.println("Código do erro: " + sqle.getErrorCode());
                sqle = sqle.getNextException();
                System.out.println("");
            }
            throw new Exception(sqle);
        } finally {
            Conexao2.fechar(conn, ps, rs);
        }
    }
    //quero de retorno uma Usuario por isso uso o public objeto Usuario

    public Usuario procurarUsuario(String usuario) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from usuarios where usuario=?");
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new Exception("Não foi encontrado nenhum registro com o nome: " + usuario);
            }
            String senha = rs.getString(3);
            return new Usuario(usuario, senha);
        } catch (SQLException sqle) {
            while (sqle != null) {
                System.out.println("Messagem:   " + sqle.getMessage());
                System.out.println("SQLState:  " + sqle.getSQLState());
                System.out.println("Código do erro: " + sqle.getErrorCode());
                sqle = sqle.getNextException();
                System.out.println("");
            }
            throw new Exception(sqle);
        } finally {
            Conexao2.fechar(conn, ps, rs);
        }
    }
}