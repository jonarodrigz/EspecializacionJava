package edu.formas.FM3S6.ctrl;

import edu.formas.FM3S6.modelo.dao.daoAbonos;
import edu.formas.FM3S6.modelo.dao.daoCliente;
import edu.formas.FM3S6.modelo.dao.daoCuenta;
import edu.formas.FM3S6.modelo.entidad.Abonos;
import edu.formas.FM3S6.modelo.entidad.Cliente;
import edu.formas.FM3S6.modelo.entidad.Cuenta;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ctrlCuenta", urlPatterns = {"/ctrlCuenta"})
public class ctrlCuenta extends HttpServlet {

    private daoCuenta daoCta;
    private daoCliente daoCli;
    private daoAbonos daoAbo;

    public ctrlCuenta() {
        this.daoCta = new daoCuenta();
        this.daoCli = new daoCliente();
        this.daoAbo = new daoAbonos();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("accion");
            if (accion == null) {
                List<Cuenta> lst = this.daoCta.getAll();
                request.setAttribute("lista", lst);
                request.setAttribute("op", "mostrar");
                RequestDispatcher rd = request.getRequestDispatcher("/cuenta.jsp");
                rd.forward(request, response);
            } else {
                if (accion.equals("1")) {
                    //formulario de captura
                    List<Cliente> lstCli = this.daoCli.getAll();
                    request.setAttribute("op", "form");
                    request.setAttribute("listaCli", lstCli);
                    RequestDispatcher rd = request.getRequestDispatcher("/cuenta.jsp");
                    rd.forward(request, response);
                }
                if (accion.equals("2")) {
                    //Guardar los datos capturados
                    int id = Integer.parseInt(request.getParameter("idcliente"));

                    Cliente cli = this.daoCli.getCliById(id);
                    Cuenta cta = new Cuenta(cli);
                    request.setAttribute("op", "msg");
                    if (this.daoCta.Insertar(cta)) {
                        request.setAttribute("mensaje", "Datos fueron guardados con exito");
                    } else {
                        request.setAttribute("mensaje", "Hubo un error");
                    }
                    RequestDispatcher rd = request.getRequestDispatcher("/cuenta.jsp");
                    rd.forward(request, response);
                }
                if (accion.equals("3")) {
                    //Editar
                    List<Cliente> lstCli = this.daoCli.getAll();
                    int ncuenta;
                    ncuenta = Integer.parseInt(request.getParameter("ncuenta"));
                    request.setAttribute("listaCli", lstCli);
                    request.setAttribute("ncuenta", ncuenta);
                    request.setAttribute("op", "formMod");
                    RequestDispatcher rd = request.getRequestDispatcher("/cuenta.jsp");
                    rd.forward(request, response);

                }
                if (accion.equals("4")) {
                    //modificar
                    int id, ncuenta;

                    ncuenta = Integer.parseInt(request.getParameter("id"));
                    id = Integer.parseInt(request.getParameter("cliente"));
                    Cliente cli = this.daoCli.getCliById(id);

                    Cuenta cta = new Cuenta(cli);
                    cta.setNumeroCuenta(ncuenta);
                    request.setAttribute("op", "msg");
                    if (this.daoCta.Actualizar(cta)) {
                        request.setAttribute("mensaje", "Datos fueron guardados con exito");
                    } else {
                        request.setAttribute("mensaje", "Hubo un error");
                    }
                    RequestDispatcher rd = request.getRequestDispatcher("/cuenta.jsp");
                    rd.forward(request, response);
                }
                if (accion.equals("5")) {
                    int id;
                    id = Integer.parseInt(request.getParameter("nCuenta"));
                  
                    request.setAttribute("op", "msg");
                    if (this.daoCta.Eliminar(id)) {
                        request.setAttribute("mensaje", "datos fueron eliminados con exito");
                    } else {
                        request.setAttribute("mensaje", "Hubo un error");
                    }
                    RequestDispatcher rd = request.getRequestDispatcher("/cuenta.jsp");
                    rd.forward(request, response);
                }
                if(accion.equals("6")){
                    int ncuenta;
                    ncuenta = Integer.parseInt(request.getParameter("nCuenta"));
                     request.setAttribute("op", "formAbono");
                     request.setAttribute("ncuenta", ncuenta);
                     RequestDispatcher rd = request.getRequestDispatcher("/cuenta.jsp");
                    rd.forward(request, response);
                }
                if(accion.equals("7")){
                    int ncuenta;
                    SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
                    String f = (String) request.getParameter("fechaAbono");
                    Date fecha = new Date();
                    fecha = dtf.parse(f);
                    Float monto;
                     ncuenta = Integer.parseInt(request.getParameter("id"));
                     monto = Float.parseFloat(request.getParameter("montoAbono"));
                   
                     Cuenta cta = daoCta.getCtaById(ncuenta);
                     
                     Abonos abo = new Abonos(cta, fecha, monto);
                      request.setAttribute("op", "msg");
                    if (this.daoAbo.Insertar(abo)) {
                        request.setAttribute("mensaje", "Datos fueron guardados con exito");
                    } else {
                        request.setAttribute("mensaje", "Hubo un error");
                    }
                    RequestDispatcher rd = request.getRequestDispatcher("/cuenta.jsp");
                    rd.forward(request, response);
                }
                if(accion.equals("8")){
                    int ncuenta;
                    ncuenta = Integer.parseInt(request.getParameter("nCuenta"));
                    List<Abonos> listAbono = this.daoAbo.getAbonoByNCuenta(ncuenta);
                    request.setAttribute("op", "mostrarAbono");
                    request.setAttribute("listaAbonos", listAbono);
                    RequestDispatcher rd = request.getRequestDispatcher("/cuenta.jsp");
                rd.forward(request, response);
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(ctrlCuenta.class.getName()).log(Level.SEVERE, null, ex);
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
