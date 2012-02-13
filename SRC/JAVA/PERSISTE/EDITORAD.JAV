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
import modelo.Editora;



/**
 *
* @author Alexandre Scheffer Quintela
 */
public class EditoraDAO{
    
    private Connection conn;
    
    public EditoraDAO( ) throws Exception{
        try{
            this.conn = Conexao2.getConexao( );
        } catch( Exception e ) {
            throw new Exception( "Erro: " +":\n" + e.getMessage( ) );
        }
    }
    
    public void incluir(Editora editora) throws Exception{
        PreparedStatement ps = null;
        if (editora == null)
            throw new Exception("O valor passado n�o pode ser nulo");
        try{
            String SQL = "INSERT INTO editora (editora_nome) values(?)";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, editora.getNomeEditora());
            ps.executeUpdate( );
        } catch (SQLException sqle){
            throw new Exception("Erro ao inserir dados "+ sqle);
        } finally{
            Conexao2.fecharConexao(conn,ps);
        }
    }
    
    public void atualizar(Editora editora) throws Exception{
        PreparedStatement ps = null;
        if (editora == null)
            throw new Exception("O valor passado n�o pode ser nulo");
        try{
            conn = Conexao2.getConexao();
            String SQL = "update editora set editora_id=?, editora_nome=? where editora_id = ?";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, editora.getIdEditora());
            ps.setString(2, editora.getNomeEditora());
            ps.setInt(3, editora.getIdEditora());
            ps.executeUpdate( );
        } catch (SQLException sqle) {
            while (sqle != null) {
		System.out.println("Messagem:   "
                                   + sqle.getMessage ());
		System.out.println("SQLState:  "
                                   + sqle.getSQLState ());
		System.out.println("C�digo do erro: "
                                   + sqle.getErrorCode ());
		sqle = sqle.getNextException();
		System.out.println("");
	}

            throw new Exception("Erro ao atualizar dados: "+ sqle);
        } finally{
            Conexao2.fecharConexao(conn, ps);
        }
    }
    
    public void excluir(Editora editora) throws Exception{
        PreparedStatement ps = null;
        if (editora == null)
            throw new Exception("O valor passado n�o pode ser nulo");
        try{
            conn = Conexao2.getConexao();
            String SQL = "delete from editora where editora_id=?";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, editora.getIdEditora());
            ps.executeUpdate( );
        } catch (SQLException sqle) {
            throw new
                    Exception("Erro ao excluir dados:" + sqle);
        } finally{
            Conexao2.fecharConexao(conn, ps);
        }
    }
    
    //quero uma lista como retorno public list
    public List todasEditoras( ) throws Exception{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("select * from editora");
            rs = ps.executeQuery( );
            List <Editora> list = new ArrayList<Editora>( );
            while( rs.next( ) ) {
                int id = rs.getInt(1);
                String nomeeditora = rs.getString(2);
                list.add( new Editora(id,nomeeditora));
            } return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally{
            Conexao2.fechar(conn, ps, rs);
        }
    }

    //quero de retorno uma Editora por isso uso o public objeto Editora
    public Editora procurarEditora(Integer id) throws Exception{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("select * from editora where editora_id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery( );
            if( !rs.next( ) ) {
                throw new Exception( "Não foi encontrado nenhum registro com o ID: " + id );
            }
            String nomeeditora = rs.getString(2);
                  return new Editora(id,nomeeditora) ;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally{
            Conexao2.fechar(conn, ps, rs);
        }
    }
}