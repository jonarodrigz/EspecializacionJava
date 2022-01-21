package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proceso.Rusa;

@WebServlet(name = "ctrlApp", urlPatterns = {"/ctrlApp"})
public class ctrlApp extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         String accion = request.getParameter("accion");
         if(accion == null){
             request.setAttribute("op", "Captura");
             RequestDispatcher rd = request.getRequestDispatcher("vistaApp.jsp");
             rd.forward(request, response);
         }
         else{
             int n1, n2,res;
             n1 = Integer.parseInt(request.getParameter("n1"));
             n2 = Integer.parseInt(request.getParameter("n2"));
             Rusa rs = new Rusa(n1,n2);
             res = rs.obtenerResultado();
             request.setAttribute("op", "Mostrar");
             request.setAttribute("Resultado", res);
              RequestDispatcher rd = request.getRequestDispatcher("vistaApp.jsp");
             rd.forward(request, response);
         }
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
