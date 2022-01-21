package edu.formas.FM2S8.controlador;

import edu.formas.FM2S8.modelo.dao.daoEstudiante;
import edu.formas.FM2S8.modelo.entidad.Estudiantes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ctrlEstudiante", urlPatterns = {"/ctrlEstudiante"})
public class ctrlEstudiante extends HttpServlet {
        private daoEstudiante daoEst;
        
        public ctrlEstudiante(){
            this.daoEst = new daoEstudiante();
        }
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           String accion = request.getParameter("accion");
            if (accion == null) {
                List<Estudiantes> lst = this.daoEst.getAll();
                request.setAttribute("lista", lst);
                request.setAttribute("op", "mostrar");
                RequestDispatcher rd = request.getRequestDispatcher("/estudiante.jsp");
                rd.forward(request, response);
            }else {
                if (accion.equals("1")) {
                    //formulario de captura
                    request.setAttribute("op", "form");
                    RequestDispatcher rd = request.getRequestDispatcher("/estudiante.jsp");
                    rd.forward(request, response);
                }
                if (accion.equals("2")) {
                    //Guardar los datos capturados
                    String nom, ape,email,carrera;
                    nom = request.getParameter("nom");
                    ape = request.getParameter("ape");
                    email = request.getParameter("email");
                    carrera = request.getParameter("carre");
                    Estudiantes est = new Estudiantes(nom, ape, email, carrera);
                    request.setAttribute("op", "msg");
                    if (this.daoEst.Insertar(est)) {
                        request.setAttribute("mensaje", "Datos fueron guardados con exito");
                    } else {
                        request.setAttribute("mensaje", "Hubo un error");
                    }
                    RequestDispatcher rd = request.getRequestDispatcher("/estudiante.jsp");
                    rd.forward(request, response);
                }
                if (accion.equals("3")) {
                    //Editar
                      int id;
                    String nom, ape, email, carrera;
                    id = Integer.parseInt(request.getParameter("id"));
                    nom = request.getParameter("nom");
                    ape = request.getParameter("ape");
                    email = request.getParameter("email");
                    carrera = request.getParameter("carre");
                    Estudiantes est = new Estudiantes(nom, ape, email, carrera);
                    est.setIdestudiante(id);
                    request.setAttribute("estudiante", est);
                    request.setAttribute("op", "formMod");
                    RequestDispatcher rd = request.getRequestDispatcher("/estudiante.jsp");
                    rd.forward(request, response);

                }
                if (accion.equals("4")) {
                    //modificar
                    int id;
                    String nom, ape,email,carrera;
                    id = Integer.parseInt(request.getParameter("id"));
                    nom = request.getParameter("nom");
                    ape = request.getParameter("ape");
                    email = request.getParameter("email");
                    carrera = request.getParameter("carre");
                    Estudiantes est = new Estudiantes(nom, ape, email, carrera);
                    est.setIdestudiante(id);
                    request.setAttribute("op", "msg");
                    if(this.daoEst.Actualizar(est))
                        request.setAttribute("mensaje", "Datos fueron guardados con exito");
                    else
                        request.setAttribute("mensaje", "Hubo un error");
                    RequestDispatcher rd = request.getRequestDispatcher("/estudiante.jsp");
                    rd.forward(request, response);
                }
                if (accion.equals("5")) {
                    int id;
                    id = Integer.parseInt(request.getParameter("id"));
                  
                    request.setAttribute("op", "msg");
                    if (this.daoEst.Eliminar(id)) {
                        request.setAttribute("mensaje", "datos fueron eliminados con exito");
                    } else {
                        request.setAttribute("mensaje", "Hubo un error");
                    }
                    RequestDispatcher rd = request.getRequestDispatcher("/estudiante.jsp");
                    rd.forward(request, response);
                }
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
