/*
 * /admin/ServletPublicacao.java
 *
 * Created on 11 de Novembro de 2008, 22:01
 */
package controlador;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import modelo.Publicacao;
import persistencia.PublicacaoDAO;
import pojo.PublicacaoPOJO;



/**
 *
 * @author Alexandre Scheffer Quintela
 * @version
 */
public class ServletPublicacao extends HttpServlet {

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cmd = request.getParameter("cmd");
        int idPublicacao = Integer.parseInt((request.getParameter("idPublicacao") == null || request.getParameter("idPublicacao").equals("")) ? "0" : request.getParameter("idPublicacao"));
        String isbn = request.getParameter("isbn");
        String tipoBusca = request.getParameter("tipoBusca");
        String busca = request.getParameter("busca");
        int idAutor = Integer.parseInt((request.getParameter("idAutor") == null || request.getParameter("idAutor").equals("")) ? "0" : request.getParameter("idAutor"));
        int idEditora = Integer.parseInt((request.getParameter("idEditora") == null || request.getParameter("idEditora").equals("")) ? "0" : request.getParameter("idEditora"));
        int idCategoria = Integer.parseInt((request.getParameter("idCategoria") == null || request.getParameter("idCategoria").equals("")) ? "0" : request.getParameter("idCategoria"));
        double preco = Double.parseDouble((request.getParameter("preco") == null || request.getParameter("preco").equals("")) ? "0" : request.getParameter("preco"));
        RequestDispatcher rd = null;
        try {
            PublicacaoDAO dao = new PublicacaoDAO();
            if (cmd == null) {
                rd = request.getRequestDispatcher("index.jsp");

            } else if (cmd.equals("salvar")) {
                dao.incluir(new Publicacao(isbn, idAutor, idEditora, idCategoria, preco));
                rd = request.getRequestDispatcher("ServletPublicacao?cmd=listar");
            }
            if (cmd.equals("publica")) {
                List listaAutor = null;
                listaAutor = dao.listaAutor();
                List listaEditora = null;
                listaEditora = dao.listaEditora();
                List listaLivro = null;
                listaLivro = dao.listarLivro();
                List listaCategoria = null;
                listaCategoria = dao.listaCategoria();
                request.setAttribute("listAutor", listaAutor);
                request.setAttribute("listEditora", listaEditora);
                request.setAttribute("listLivro", listaLivro);
                request.setAttribute("listCategoria", listaCategoria);
                if (idPublicacao == 0) {
                    rd = request.getRequestDispatcher("formpublicacao.jsp");
                } else {
                    Publicacao pub = dao.procurarPublicacao(idPublicacao);
                    request.setAttribute("pub", pub);
                    rd = request.getRequestDispatcher("alterarpublicacao.jsp");
                }
            }
            if (cmd.equals("detalhe")) {
                PublicacaoPOJO pub = dao.procurarPublicacaoPOJO(idPublicacao);
                request.setAttribute("pub", pub);
                rd = request.getRequestDispatcher("detalhe.jsp");
            }
            if (cmd.equals("listar")) {
                //usar o mesmo nome da lista no jsp
                List publicacaoList = null;
                publicacaoList = dao.listaCompleta();
                //seta o atributo
                request.setAttribute("publicacaoList", publicacaoList);
                rd = request.getRequestDispatcher("mostrarpublicacao.jsp");
            }
            if (cmd.equals("pesquisa")) {
                //usar o mesmo nome da lista no jsp
                List publicacaoList = null;
                List listaCategoria = null;
                publicacaoList = dao.listaCompletaCategoria(idCategoria);
                listaCategoria = dao.listaCategoria();
                //seta o atributo
                request.setAttribute("listCategoria", listaCategoria);
                request.setAttribute("publicacaoList", publicacaoList);
                rd = request.getRequestDispatcher("publicacao.jsp");
            }
            if (cmd.equals("buscar")) {
                //usar o mesmo nome da lista no jsp
                List publicacaoList = null;
                List listaCategoria = null;
                publicacaoList = dao.listaCompletaPesquisa(tipoBusca, busca);
                listaCategoria = dao.listaCategoria();
                //seta o atributo
                request.setAttribute("listCategoria", listaCategoria);
                request.setAttribute("publicacaoList", publicacaoList);
                rd = request.getRequestDispatcher("publicacao.jsp");
            }
            if (cmd.equals("excluir")) {
                Publicacao pub = dao.procurarPublicacao(idPublicacao);
                dao.excluir(pub);
                rd = request.getRequestDispatcher("ServletPublicacao?cmd=listar");
            }
            if (cmd.equals("salvaralteracao")) {
                dao.atualizar(new Publicacao(isbn, idAutor, idEditora, idCategoria, preco));
                rd = request.getRequestDispatcher("ServletPublicacao?cmd=listar");
            }
            if (cmd.equals("categoria")) {
                List listaCategoria = null;
                listaCategoria = dao.listaCompleta();
                request.setAttribute("listCategoria", listaCategoria);
                rd = request.getRequestDispatcher("alterarpublicacao.jsp");
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