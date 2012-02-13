package util;

/*
 * Login.java
 *
 * Created on 28 de Julho de 2008, 17:46
 */
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import modelo.Cliente;
import persistencia.ClienteDAO;

/**
 *
 * @author Alexandre
 * @version
 */
public class LoginAdmin extends HttpServlet {

    String mail = "";

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    private void enviaFormLogin(HttpServletResponse resposta, boolean mensagemErro) throws ServletException, IOException {
        resposta.setContentType("text/html");
        PrintWriter saida = resposta.getWriter();
        saida.println("<HTML>");
        saida.println("<HEAD>");
        saida.println("<TITLE>Login</TITLE>");
        saida.println("</HEAD>");
        saida.println("<body bgcolor=''>");
        if (mensagemErro) {
            saida.println(" Acesso Negado! Por favor, tente novamente.<BR>");
        }
        saida.println("<BR>");
        saida.println("<BR><center><table border='1' bordercolor = '#2f1c09' cellspacing='0' cellpadding='0' width='101%'><tr align ='center' bgcolor='#e8e5f7'><td>Primeira pagina restrita</td></tr><tr><td><h3>Por Gentileza, entre seu mail e senha.</h3></td></tr></table></center>");
        saida.println("<BR><FORM METHOD=POST>");
        saida.println("<BR>E-mail: <INPUT TYPE=TEXT NAME=email value = " + mail + "><br>");
        saida.println("<BR><INPUT TYPE=PASSWORD NAME=senha><br>");
        saida.println("<BR><INPUT TYPE=SUBMIT VALUE=Enviar");
        saida.println("</FORM>");
        saida.println("</BODY>");
        saida.println("</HTML>");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = null;
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        try {
            ClienteDAO dao = new ClienteDAO();
            Cliente cli = dao.procurarCliente(email);
            if (email != null && senha != null && email.equals(cli.getEmail()) && senha.equals(cli.getSenha())) {
                int cod = 1;
                HttpSession session = request.getSession(true);
                session.setAttribute("autorizado", new Integer(cod));
                //if entra qqui
                rd = request.getRequestDispatcher("admin.jsp");
                rd.forward(request, response);
            } else {
                enviaFormLogin(response, true);
            }
        } catch (Exception e) {
        }


    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            int tamanho = cookies.length;
            for (int i = 0; i <
                    tamanho; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("email")) {
                    mail = cookie.getValue();
                }

            }
        }
        enviaFormLogin(response, false);
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

