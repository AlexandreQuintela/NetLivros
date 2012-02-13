/*
 * ServletClientes.java
 *
 * Created on 1 de Novembro de 2008, 11:41
 */

package controlador;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import modelo.EstadoCivil;
import persistencia.EstadoCivilDAO;



/**
 *
 * @author Alexandre Scheffer Quintela
 * @version
 */
public class ServletEstadoCivil extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String cmd = request.getParameter("cmd");
        String descricao = request.getParameter("descricao");
        
        RequestDispatcher rd = null;
        try{
            EstadoCivilDAO dao = new EstadoCivilDAO();

            if(cmd.equals(null)){ 
                
                rd = request.getRequestDispatcher("index.jsp");
                
            } else
                if (cmd.equals("salvar")) {
                dao.incluir(new EstadoCivil(descricao));
                rd = request.getRequestDispatcher("ServletestadoCivil?cmd=listar");
                }
            if (cmd.equals("listar")) {
                
                List estadoCivilList = null;
                estadoCivilList = dao.todosEstadoCivil();
                
                request.setAttribute("estadoCivilLista", estadoCivilList);
                rd = request.getRequestDispatcher("mostrarestadocivil.jsp");
            }
            if (cmd.equals("excluir")){
                int idEstadoCivil = Integer.parseInt(request.getParameter("idEstadoCivil"));
                EstadoCivil ec = dao.procurarEstadoCivil(idEstadoCivil);
                dao.excluir(ec);
                rd = request.getRequestDispatcher("ServletEstadoCivil?cmd=listar");
            }
            if (cmd.equals("alterar")){
                int idEstadoCivil = Integer.parseInt(request.getParameter("idEstadoCivil"));
                EstadoCivil ec = dao.procurarEstadoCivil(idEstadoCivil);
                request.setAttribute("ec", ec);
                rd = request.getRequestDispatcher("alterarestadocivil.jsp");
            }
            if (cmd.equals("salvaralteracao")){
                int idEstadoCivil = Integer.parseInt(request.getParameter("idEstadoCivil"));
                dao.atualizar(new EstadoCivil(idEstadoCivil, descricao));
                rd = request.getRequestDispatcher("ServletestadoCivil?cmd=listar");
            }
            rd.forward(request, response);
        }catch (Exception sqle){}
        // aqui esvia para o jsp
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
    
    
    
}
