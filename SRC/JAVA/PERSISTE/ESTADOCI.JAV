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
import modelo.EstadoCivil;



/**
 *
* @author Alexandre Scheffer Quintela
 */
public class EstadoCivilDAO{
    
    private Connection conn;
    
    public EstadoCivilDAO( ) throws Exception{
        try{
            this.conn = Conexao2.getConexao( );
        } catch( Exception e ) {
            throw new Exception( "Erro: " +":\n" + e.getMessage( ) );
        }
    }
    
    public void incluir(EstadoCivil estadoCivil) throws Exception{
        PreparedStatement ps = null;
        if (estadoCivil == null)
            throw new Exception("O valor passado não pode ser nulo");
        try{
            String SQL = "INSERT INTO estadocivil (estadoCivil) values(?)";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, estadoCivil.getDescricao());
            ps.executeUpdate();
        } catch (SQLException sqle){
            throw new Exception("Erro ao inserir dados "+ sqle);
        } finally{
            Conexao2.fecharConexao(conn,ps);
        }
    }
    
    public void atualizar(EstadoCivil estadoCivil) throws Exception{
        PreparedStatement ps = null;
        if (estadoCivil == null)
            throw new Exception("O valor passado não pode ser nulo");
        try{
            conn = Conexao2.getConexao();
            String SQL = "update estadocivil set idestadoCivil=?, descricao=? where idestadoCivil = ?";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, estadoCivil.getIdEstadoCivil());
            ps.setString(2, estadoCivil.getDescricao());
            ps.setInt(3, estadoCivil.getIdEstadoCivil());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            while (sqle != null) {
		System.out.println("Messagem:   "
                                   + sqle.getMessage ());
		System.out.println("SQLState:  "
                                   + sqle.getSQLState ());
		System.out.println("Cï¿½digo do erro: "
                                   + sqle.getErrorCode ());
		sqle = sqle.getNextException();
		System.out.println("");
	}

            throw new Exception("Erro ao atualizar dados: "+ sqle);
        } finally{
            Conexao2.fecharConexao(conn, ps);
        }
    }
    
    public void excluir(EstadoCivil estadoCivil) throws Exception{
        PreparedStatement ps = null;
        if (estadoCivil == null)
            throw new Exception("O valor passado nï¿½o pode ser nulo");
        try{
            conn = Conexao2.getConexao();
            String SQL = "delete from estadocivil where estadoCivil_id=?";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, estadoCivil.getIdEstadoCivil());
            ps.executeUpdate( );
        } catch (SQLException sqle) {
            throw new
                    Exception("Erro ao excluir dados:" + sqle);
        } finally{
            Conexao2.fecharConexao(conn, ps);
        }
    }
    
    //quero uma lista como retorno public list
    public List todosEstadoCivil( ) throws Exception{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("select * from estadoCivil");
            rs = ps.executeQuery( );
            List <EstadoCivil> list = new ArrayList<EstadoCivil>( );
            while( rs.next( ) ) {
                int idEstadoCivil = rs.getInt(1);
                String descricao = rs.getString(2);
                list.add( new EstadoCivil(idEstadoCivil,descricao));
            } return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally{
            Conexao2.fechar(conn, ps, rs);
        }
    }

    //quero de retorno uma EstadoCivil por isso uso o public objeto EstadoCivil
    public EstadoCivil procurarEstadoCivil(Integer idEstadoCivil) throws Exception{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("select * from estadocivil where idestadoCivil=?");
            ps.setInt(1, idEstadoCivil);
            rs = ps.executeQuery( );
            if( !rs.next( ) ) {
                throw new Exception( "Não foi encontrado nenhum registro com o ID: " + idEstadoCivil );
            }
            String descricao = rs.getString(2);
                  return new EstadoCivil(idEstadoCivil,descricao) ;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally{
            Conexao2.fechar(conn, ps, rs);
        }
    }
}