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
import modelo.Editora;
import persistencia.EditoraDAO;


/**
 *
 * @author Alexandre Scheffer Quintela
 * @version
 */
public class ServletEditora extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //pego todos os campos e par�metros do formul�rio html
        String cmd = request.getParameter("cmd");
        String nomeEditora = request.getParameter("nomeeditora");
        
        RequestDispatcher rd = null;
        try{
            EditoraDAO dao = new EditoraDAO();
// uso equals para comparar string
            if(cmd.equals(null)){ //se n�o requisitar opera��o vai para a p�gina iniciall
                
                rd = request.getRequestDispatcher("index.jsp");
                
            } else
                if (cmd.equals("salvar")) {
                dao.incluir(new Editora(nomeEditora));
                rd = request.getRequestDispatcher("ServletEditora?cmd=listar");
                }
            if (cmd.equals("listar")) {
                //usar o mesmo nome da lista no jsp
                List editoraList = null;
                editoraList = dao.todasEditoras();
                //seta o atributo
                request.setAttribute("editoraList", editoraList);
                rd = request.getRequestDispatcher("mostrareditora.jsp");
            }
            if (cmd.equals("excluir")){
                int id = Integer.parseInt(request.getParameter("id"));
                Editora edi = dao.procurarEditora(id);
                dao.excluir(edi);
                rd = request.getRequestDispatcher("ServletEditora?cmd=listar");
            }
            if (cmd.equals("alterar")){
                int id = Integer.parseInt(request.getParameter("id"));
                Editora edi = dao.procurarEditora(id);
                request.setAttribute("edi", edi);
                rd = request.getRequestDispatcher("alterareditora.jsp");
            }
            if (cmd.equals("salvaralteracao")){
                int id = Integer.parseInt(request.getParameter("id"));
                dao.atualizar(new Editora(id, nomeEditora));
                rd = request.getRequestDispatcher("ServletEditora?cmd=listar");
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
