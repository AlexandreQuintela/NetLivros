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
import modelo.Autor;
import persistencia.AutorDAO;

/**
 *
 * @author Alexandre Scheffer Quintela
 * @version
 */
public class ServletAutor extends HttpServlet {

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //pego todos os campos e par�metros do formul�rio html
        String cmd = request.getParameter("cmd");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String dataNascimento = request.getParameter("dataNascimento");

        RequestDispatcher rd = null;
        try {
            AutorDAO dao = new AutorDAO();
// uso equals para comparar string
            if (cmd.equals(null)) { //se n�o requisitar opera��o vai para a p�gina iniciall

                rd = request.getRequestDispatcher("index.jsp");

            } else if (cmd.equals("salvar")) {
                dao.incluir(new Autor(nome, email, dataNascimento));
                rd = request.getRequestDispatcher("ServletAutor?cmd=listar");
            }
            if (cmd.equals("listar")) {
                List autoresList = null;
                autoresList = dao.todosAutores();
                request.setAttribute("autoresList", autoresList);
                rd = request.getRequestDispatcher("mostrarautor.jsp");
            }
            if (cmd.equals("excluir")) {
                int idAutor = Integer.parseInt(request.getParameter("idAutor"));
                Autor aut = dao.procurarAutor(idAutor);
                dao.excluir(aut);
                rd = request.getRequestDispatcher("ServletAutor?cmd=listar");
            }
            if (cmd.equals("alterar")) {
                int idAutor = Integer.parseInt(request.getParameter("idAutor"));
                Autor aut = dao.procurarAutor(idAutor);
                request.setAttribute("aut", aut);
                rd = request.getRequestDispatcher("alterarautor.jsp");
            }
            if (cmd.equals("salvaralteracao")) {
                int idAutor = Integer.parseInt(request.getParameter("idAutor"));
                dao.atualizar(new Autor(idAutor, nome, email, dataNascimento));
                rd = request.getRequestDispatcher("ServletAutor?cmd=listar");
            }
            rd.forward(request, response);
        } catch (Exception sqle) {
        }
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
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
