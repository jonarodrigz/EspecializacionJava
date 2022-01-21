
package edu.formas.FM2S8.controlador;

import edu.formas.FM2S8.modelo.dao.daoUsuario;
import edu.formas.FM2S8.modelo.entidad.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ctrlLogin", urlPatterns = {"/ctrlLogin"})
public class ctrlLogin extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           String accion = request.getParameter("accion");
           if(accion == null){
               request.getRequestDispatcher("/login.jsp").forward(request, response);
           }
           else{
               String usuario = request.getParameter("txtUsuario");
               String clave = request.getParameter("txtClave");
               if(usuario==null){
                   usuario = "";
               }
               if(clave == null){
                   clave="";
               }
               try{
                   daoUsuario du = new daoUsuario();
                   Usuario us = du.login(usuario, clave);
                   if(us.getLogin().equals("")){
                       request.getRequestDispatcher("login.jsp?error=1").forward(request, response);
                   }
                   else{
                       HttpSession miSesion = request.getSession(true);
                       miSesion.setAttribute("isLogin", "true");
                       response.sendRedirect("ctrlMenu");
                   }
               }
               catch(Exception e){
                   request.getRequestDispatcher("login.jsp?error=Error de conexion").forward(request, response);
               }
           }
        }
        catch(Exception e){
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
