/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author administrador
 */
public class ServletPortal extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String url = "loja.jsp";
        
        try {
            if (acao != null) {
                if (acao.equals("portal")) {
                    url = ("Principal");
                } else if (acao.equals("busca")) {
                    url = ("pesquisa.jsp");
                } else if (acao.equals("catalogo")) {
                    url = ("catalogo.jsp");
                } else if (acao.equals("detelhesproduto")) {
                    url = ("detalhes.jsp");
                } else if (acao.equals("adicionaitemcarrinho") || acao.equals("atualizaitemcarrinho") || acao.equals("apagaitemcarrinho")) {
                    url = ("carrinho.jsp");
                } else if (acao.equals("pagamento")) {
                    url = ("pagamento.jsp");
                } else if (acao.equals("finalizacompra")) {
                    url = ("ordem.jsp");
                } else if (acao.equals("categoria")){
                    url= ("categoria.jsp");
                } else if (acao.equals("alterar"))
                    url=("alterarcliente.jsp");
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (Exception e) {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Métodos HttpServlet. Clique no sinal de + à esquerda para editar o código.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
