/*
 * ServletLivro.java
 *
 * Created on 11 de Novembro de 2008, 22:01
 */
package controlador;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

import modelo.Livro;
import persistencia.LivroDAO;

/**
 *
 * @author Alexandre Scheffer Quintela
 * @version
 */
public class ServletLivro extends HttpServlet {

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String cmd = request.getParameter("cmd");  

        try {
            LivroDAO dao = new LivroDAO();
          
            String isbn = request.getParameter("isbn");
            String titulo = request.getParameter("titulo");
            int numeroEdicao = Integer.parseInt((request.getParameter("numeroEdicao") == null || request.getParameter("numeroEdicao").equals("")) ? "0" : request.getParameter("numeroEdicao"));
            int ano = Integer.parseInt((request.getParameter("anoPublicacao") == null || request.getParameter("anoPublicacao").equals("")) ? "0" : request.getParameter("anoPublicacao"));
            String descricao = request.getParameter("descricao");
            RequestDispatcher rd = null;
            if (cmd == null) { //se n�o requisitar opera��o vai para a p�gina iniciall
                rd = request.getRequestDispatcher("index.jsp");

            } else if (cmd.equals("salvar")) {
                dao.incluir(new Livro(isbn, titulo, numeroEdicao, ano, descricao));
                rd = request.getRequestDispatcher("ServletLivro?cmd=listar");
            }
            if (cmd.equals("listar")) {
                //usar o mesmo nome da lista no jsp
                List livrosList = null;
                livrosList = dao.todosLivros();
                //seta o atributo
                request.setAttribute("livrosList", livrosList);
                rd = request.getRequestDispatcher("mostrarlivro.jsp");
            }
            if (cmd.equals("excluir")) {
                Livro liv = dao.procurarLivro(isbn);
                dao.excluir(liv);
                rd = request.getRequestDispatcher("ServletLivro?cmd=listar");
            }
            if (cmd.equals("alterar")) {
                Livro liv = dao.procurarLivro(isbn);
                request.setAttribute("liv", liv);
                rd = request.getRequestDispatcher("alterarlivro.jsp");
            }
            if (cmd.equals("salvaralteracao")) {
                dao.atualizar(new Livro(isbn, titulo, numeroEdicao, ano, descricao));
                rd = request.getRequestDispatcher("ServletLivro?cmd=listar");
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
