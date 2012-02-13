/*
 * ServletCliente.java
 *
 * Created on 1 de Novembro de 2008, 11:41
 */

package controlador;

import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import modelo.Cliente;
import persistencia.ClienteDAO;


/**
 *
* @author Alexandre Scheffer Quintela
 * @version
 */
public class ServletCliente extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //pego todos os campos e par�metros do formul�rio html
        String cmd = request.getParameter("cmd");
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");
        String estado = request.getParameter("estado");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        RequestDispatcher rd = null;
        try{
            ClienteDAO dao = new ClienteDAO();
// uso equals para comparar string
            if(cmd.equals(null)){ //se n�o requisitar opera��o vai para a p�gina iniciall
                
                rd = request.getRequestDispatcher("index.jsp");
                
            } else
                if (cmd.equals("salvar")) {
                dao.incluir(new Cliente(nome, endereco, telefone, estado, email, senha));
                rd = request.getRequestDispatcher("ServletCliente?cmd=listar");
                }
            if (cmd.equals("listar")) {
                //usar o mesmo nome da lista no jsp
                List clientesList = null;
                clientesList = dao.todosClientes();
                //seta o atributo
                request.setAttribute("clientesList", clientesList);
                rd = request.getRequestDispatcher("mostrarcliente.jsp");
            }
            if (cmd.equals("excluir")){
                int idCliente = Integer.parseInt(request.getParameter("idCliente"));
                Cliente cli = dao.procurarCliente(idCliente);
                dao.excluir(cli);
                rd = request.getRequestDispatcher("ServletCliente?cmd=listar");
            }
            if (cmd.equals("alterar")){
                int idCliente = Integer.parseInt(request.getParameter("idCliente"));
                Cliente cli = dao.procurarCliente(idCliente);
                request.setAttribute("cli", cli);
                rd = request.getRequestDispatcher("alterarcliente.jsp");
            }
            if (cmd.equals("salvaralteracao")){
                int id = Integer.parseInt(request.getParameter("idCliente"));
                dao.atualizar(new Cliente(id, nome, endereco, telefone, estado, email, senha));
                rd = request.getRequestDispatcher("ServletCliente?cmd=listar");
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
