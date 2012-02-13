/*
 * AutorDAO.java
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
import modelo.Autor;
import util.ConvData;


/**
 *
 * @author Alexandre Scheffer Quintela
 */
public class AutorDAO {

    private Connection conn;
    ConvData cd = new ConvData();
    public AutorDAO() throws Exception {
        try {
            this.conn = Conexao2.getConexao();
        } catch (Exception e) {
            throw new Exception("Erro: " + ":\n" + e.getMessage());
        }
    }

    public void incluir(Autor autor) throws Exception {
        PreparedStatement ps = null;
        if (autor == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            String SQL = "INSERT INTO autores (nome, email, dt_nasc) values(?, ?, ?)";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, autor.getNome());
            ps.setString(2, autor.getEmail());
            ps.setString(3, cd.parseDataIso(autor.getDataNascimento()));
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            Conexao2.fecharConexao(conn, ps);
        }
    }

    public void atualizar(Autor autor) throws Exception {
        PreparedStatement ps = null;
        if (autor == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = Conexao2.getConexao();
            String SQL = "update autores set autor_id=?, nome=?, email=?, dt_nasc=? where autor_id = ?";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, autor.getIdAutor());
            ps.setString(2, autor.getNome());
            ps.setString(3, autor.getEmail());
            ps.setString(4, cd.parseDataIso(autor.getDataNascimento()));
            ps.setInt(5, autor.getIdAutor());
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

    public void excluir(Autor autor) throws Exception {
        PreparedStatement ps = null;
        if (autor == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
            conn = Conexao2.getConexao();
            String SQL = "delete from autores where autor_id=?";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, autor.getIdAutor());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados:" + sqle);
        } finally {
            Conexao2.fecharConexao(conn, ps);
        }
    }
    //quero uma lista como retorno public list
    public List todosAutores() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from autores");
            rs = ps.executeQuery();
            
            List <Autor> list = new ArrayList<Autor>();
            while (rs.next()) {
                int idAutor = rs.getInt(1);
                String nome = rs.getString(2);
                String email = rs.getString(3);
                String dataNascimento = cd.parseDataBra(rs.getString(4));
                list.add(new Autor(idAutor, nome, email, dataNascimento));
            }return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            Conexao2.fechar(conn, ps, rs);
        }
    }
    
    
    //quero de retorno um autor por isso uso o public autor
    public Autor procurarAutor(Integer idAutor) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from autores where autor_id=?");
            ps.setInt(1, idAutor);
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new Exception("Não foi encontrado nenhum registro com o ID: " + idAutor);
            }
            String nome = rs.getString(2);
            String email = rs.getString(3);
            String dataNascimento = cd.parseDataBra(rs.getString(4));
            return new Autor(idAutor, nome, email, dataNascimento);
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            Conexao2.fechar(conn, ps, rs);
        }
    }
}
