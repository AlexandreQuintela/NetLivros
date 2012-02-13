/*
 * ClienteDAO.java
 *
 * Created on 1 de Novembro de 2008, 10:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 *   isbn,titulo,edicao_num,ano_publicacao,descricao
 */

package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Livro;

/**
 *
* @author Alexandre Scheffer Quintela
 */
public class LivroDAO{
    
    private Connection conn;
    
    public LivroDAO( ) throws Exception{
        try{
            this.conn = Conexao2.getConexao( );
        } catch( Exception e ) {
            throw new Exception( "Erro: " +":\n" + e.getMessage( ) );
        }
    }
    
    public void incluir(Livro livro) throws Exception{
        PreparedStatement ps = null;
        if (livro == null)
            throw new Exception("O valor passado não pode ser nulo");
        try{
            String SQL = "INSERT INTO livros (isbn, titulo, edicao_num, ano_publicacao, descricao) values(?,?,?,?,?)";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, livro.getIsbn());
            ps.setString(2, livro.getTitulo());
            ps.setInt(3, livro.getNumeroEdicao());
            ps.setInt(4, livro.getAnoPublicacao());
            ps.setString(5, livro.getDescricao());
            ps.executeUpdate();
        } catch (SQLException sqle){
            throw new Exception("Erro ao inserir dados "+ sqle);
        } finally{
            Conexao2.fecharConexao(conn,ps);
        }
    }
    
    public void atualizar(Livro livro) throws Exception{
        PreparedStatement ps = null;
        if (livro == null)
            throw new Exception("O valor passado não pode ser nulo");
        try{
            conn = Conexao2.getConexao();
            String SQL = "update livros set isbn=?, titulo=?, edicao_num=?, ano_publicacao=?, descricao=? where isbn = ?";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, livro.getIsbn());
            ps.setString(2, livro.getTitulo());
            ps.setInt(3, livro.getNumeroEdicao());
            ps.setInt(4, livro.getAnoPublicacao());
            ps.setString(5, livro.getDescricao());
            ps.setString(6, livro.getIsbn());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            while (sqle != null) {
		System.out.println("Messagem:   "
                                   + sqle.getMessage ());
		System.out.println("SQLState:  "
                                   + sqle.getSQLState ());
		System.out.println("Código do erro: "
                                   + sqle.getErrorCode ());
		sqle = sqle.getNextException();
		System.out.println("");
	}
            throw new Exception("Erro ao atualizar dados: "+ sqle);
        } finally{
            Conexao2.fecharConexao(conn, ps);
        }
    }
    
    public void excluir(Livro livro) throws Exception{
        PreparedStatement ps = null;
        if (livro == null)
            throw new Exception("O valor passado não pode ser nulo");
        try{
            conn = Conexao2.getConexao();
            String SQL = "delete from livros where isbn=?";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, livro.getIsbn());
            ps.executeUpdate( );
        } catch (SQLException sqle) {
            throw new
                    Exception("Erro ao excluir dados:" + sqle);
        } finally{
            Conexao2.fecharConexao(conn, ps);
        }
    }
    
    //quero uma lista como retorno public list
    public List todosLivros() throws Exception{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("select * from livros");
            rs = ps.executeQuery();
            List <Livro> list = new ArrayList<Livro>( );
            while( rs.next( ) ) {              
                String isbn = rs.getString(1);
                String nomeLivro = rs.getString(2);
                int numeroEdicao = rs.getInt(3);
                int anoPublicacao = rs.getInt(4);
                String descricao = rs.getString(5);
                list.add( new Livro(isbn,nomeLivro,numeroEdicao,anoPublicacao,descricao));
            }return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally{
            Conexao2.fechar(conn, ps, rs);
        }
    }
    //quero de retorno uma Livro por isso uso o public objeto Livro
    public Livro procurarLivro(String isbn) throws Exception{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("select * from livros where isbn=?");
            ps.setString(1, isbn);
            rs = ps.executeQuery( );
            if( !rs.next( ) ) {
                throw new Exception( "N�o foi encontrado nenhum registro com o ID: " + isbn);
            }
                String nomeLivro = rs.getString(2);
                int numeroEdicao = rs.getInt(3);
                int anoPublicacao = rs.getInt(4);
                String descricao = rs.getString(5);
                 return new Livro(isbn,nomeLivro,numeroEdicao,anoPublicacao,descricao);
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally{
            Conexao2.fechar(conn, ps, rs);
        }
    }
}