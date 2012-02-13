/*
 * Conexao2.java
 *
 * Created on 1 de Novembro de 2008, 14:31
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
* @author Alexandre Scheffer Quintela
 */
public class Conexao2 {
    
    /** Creates a new instance of Conexao2 */
    public Conexao2() {
    }
        // usada como padrï¿½o para ser usada pelas outras classes.
    /** Creates a new instance of conexao */
    
    public static Connection getConexao( ){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/livrariavirtual", "root", "root");
        } catch (Exception e) {
            System.out.println("Falha na conexão com o Servidor de banco de dados. Inicialize o serviço de banco de dados");
        }
        return con;
    }
    
    public static void fechar(Connection conn, Statement stmt, ResultSet rs){
        try{
            if (rs != null) rs.close( );
            if (stmt != null) stmt.close( );
            if (conn != null) conn.close( );
        } catch (Exception e) { }
    }
    
    public static void fecharConexao(Connection conn){
        try{
            if (conn!= null) conn.close( );
        } catch (Exception e) { }
    }
    
    public static void fecharConexao(Connection conn, PreparedStatement ps){
        try{
            if (ps != null) ps.close( );
            if (conn != null) conn.close( );
        } catch (Exception e) { }
    }
}
