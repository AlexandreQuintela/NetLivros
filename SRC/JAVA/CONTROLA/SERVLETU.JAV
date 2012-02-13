/*
 * ServletUsuario.java
 *
 * Created on 11 de Novembro de 2008, 22:01
 */
package controlador;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

import modelo.Usuario;
import persistencia.UsuarioDAO;

/**
 *
 * @author Alexandre Scheffer Quintela
 * @version
 */
public class ServletUsuario extends HttpServlet {

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cmd = request.getParameter("cmd");
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        RequestDispatcher rd = null;
        try {
            UsuarioDAO dao = new UsuarioDAO();
            if (cmd.equals(null)) { //se n�o requisitar opera��o vai para a p�gina iniciall
                rd = request.getRequestDispatcher("index.jsp");

            } else if (cmd.equals("salvar")) {
                dao.incluir(new Usuario(usuario, senha));
                rd = request.getRequestDispatcher("user?cmd=listar");
            }
            if (cmd.equals("listar")) {
                //usar o mesmo nome da lista no jsp
                List usuariosList = null;
                usuariosList = dao.todosUsuarios();
                //seta o atributo
                request.setAttribute("usuariosList", usuariosList);
                rd = request.getRequestDispatcher("mostrarusuario.jsp");
            }
            if (cmd.equals("excluir")) {
                Usuario usr = dao.procurarUsuario(usuario);
                dao.excluir(usr);
                rd = request.getRequestDispatcher("user?cmd=listar");
            }
            if (cmd.equals("alterar")) {
                Usuario usr = dao.procurarUsuario(usuario);
                request.setAttribute("usr", usr);
                rd = request.getRequestDispatcher("alterarusuario.jsp");
            }
            if (cmd.equals("salvaralteracao")) {
                dao.atualizar(new Usuario(usuario, senha));
                rd = request.getRequestDispatcher("user?cmd=listar");
            }
            rd.forward(request, response);
        } catch (Exception sqle) {
        }

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
