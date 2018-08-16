package Controllers;

import Models.clsRequerimientos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RequerimientosController", urlPatterns = {"/RequerimientosController"})
public class RequerimientosController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("btnGuardar") != null) {
            btnGuardar(request, response);
        } else if (request.getParameter("btnModificar") != null) {
            btnModificar(request, response);
        } else if (request.getParameter("codigoSeleccionado") != null) {
            if (request.getParameter("stOpcion").equals("M")) {
                cargarModificar(request, response);
            }
        } else if (request.getParameter("btnConsultar") != null) {
            btnConsultar(request, response);
        }
    }

    public void btnConsultar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {

            BL.clsRequerimientos bl_obclsRequerimientos = new BL.clsRequerimientos();

            Models.clsRequerimientos obclsRequerimientos = new clsRequerimientos();
            Models.clsContactos obclsContactos = new Models.clsContactos();
            Models.clsEstadoRequerimiento obclsEstadoRequerimiento = new Models.clsEstadoRequerimiento();
            
            if (request.getParameter("ddlContacto") != null) {
                obclsContactos.setInCodigo(Integer.parseInt(request.getParameter("ddlContacto")));
                obclsRequerimientos.setObclsContactos(obclsContactos);
            }
            if (request.getParameter("ddlEstado") != null) {
                obclsEstadoRequerimiento.setInCodigo(Integer.parseInt(request.getParameter("ddlEstado")));
                obclsRequerimientos.setObclsEstadoRequerimiento(obclsEstadoRequerimiento);
            }

            request.setAttribute("lstclsRequerimientos", bl_obclsRequerimientos.consultarRequerimientos(obclsRequerimientos));

            request.getRequestDispatcher("ConsultaRequerimientos.jsp").forward(request, response);
        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("ConsultaRequerimientos.jsp").forward(request, response);
        }
    }

    public void cargarModificar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {

            BL.clsRequerimientos bl_obclsRequerimientos = new BL.clsRequerimientos();

            List<Models.clsRequerimientos> lstclsRequerimientos = new ArrayList<Models.clsRequerimientos>();
            Models.clsRequerimientos obclsRequerimientos = new Models.clsRequerimientos();

            lstclsRequerimientos = bl_obclsRequerimientos.consultarRequerimientos();

            for (Models.clsRequerimientos item : lstclsRequerimientos) {
                if (item.getInCodigo() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsRequerimientos = item;
                }
            }

            request.setAttribute("obclsRequerimientos", obclsRequerimientos);
            request.getRequestDispatcher("Requerimientos.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Requerimientos.jsp").forward(request, response);
        }
    }

    public void btnModificar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {

            BL.clsRequerimientos bl_obclsRequerimientos = new BL.clsRequerimientos();

            Models.clsRequerimientos obclsRequerimientos = new clsRequerimientos();
            Models.clsContactos obclsContactos = new Models.clsContactos();
            Models.clsEstadoRequerimiento obclsEstadoRequerimiento = new Models.clsEstadoRequerimiento();

            if (request.getParameter("codigoSeleccionado") != null) {
                obclsRequerimientos.setInCodigo(Integer.valueOf(request.getParameter("codigoSeleccionado")));
            }
            if (request.getParameter("txtFechaRequerimiento") != null) {
                obclsRequerimientos.setStFecha(request.getParameter("txtFechaRequerimiento"));
            }
            if (request.getParameter("ddlSolicitante") != null) {
                obclsContactos.setInCodigo(Integer.parseInt(request.getParameter("ddlSolicitante")));
                obclsRequerimientos.setObclsContactos(obclsContactos);
            }
            if (request.getParameter("txtCargo") != null) {
                obclsRequerimientos.setStCargo(request.getParameter("txtCargo"));
            }
            if (request.getParameter("txtNombreModulo") != null) {
                obclsRequerimientos.setStNombreModulo(request.getParameter("txtNombreModulo"));
            }
            if (request.getParameter("txtOpcionModulo") != null) {
                obclsRequerimientos.setStOpcionModulo(request.getParameter("txtOpcionModulo"));
            }
            if (request.getParameter("txtVersionActualEjecutable") != null) {
                obclsRequerimientos.setStVersionActual(request.getParameter("txtVersionActualEjecutable"));
            }
            if (request.getParameter("txtDescripcionDetallada") != null) {
                obclsRequerimientos.setStDescripcionDetallada(request.getParameter("txtDescripcionDetallada"));
            }
            if (request.getParameter("txtDuracion") != null) {
                obclsRequerimientos.setInDuracion(Integer.parseInt(request.getParameter("txtDuracion")));
            }
            if (request.getParameter("ddlEstado") != null) {
                obclsEstadoRequerimiento.setInCodigo(Integer.parseInt(request.getParameter("ddlEstado")));
                obclsRequerimientos.setObclsEstadoRequerimiento(obclsEstadoRequerimiento);
            }

            request.setAttribute("stMensaje", bl_obclsRequerimientos.stModificarRequerimientos(obclsRequerimientos));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsRequerimientos", bl_obclsRequerimientos.consultarRequerimientos());

            request.getRequestDispatcher("Requerimientos.jsp").forward(request, response);
        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Requerimientos.jsp").forward(request, response);
        }
    }

    public void btnGuardar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {

            BL.clsRequerimientos bl_obclsRequerimientos = new BL.clsRequerimientos();

            Models.clsRequerimientos obclsRequerimientos = new clsRequerimientos();
            Models.clsContactos obclsContactos = new Models.clsContactos();
            Models.clsEstadoRequerimiento obclsEstadoRequerimiento = new Models.clsEstadoRequerimiento();

            if (request.getParameter("txtFechaRequerimiento") != null) {
                obclsRequerimientos.setStFecha(request.getParameter("txtFechaRequerimiento"));
            }
            if (request.getParameter("ddlSolicitante") != null) {
                obclsContactos.setInCodigo(Integer.parseInt(request.getParameter("ddlSolicitante")));
                obclsRequerimientos.setObclsContactos(obclsContactos);
            }
            if (request.getParameter("txtCargo") != null) {
                obclsRequerimientos.setStCargo(request.getParameter("txtCargo"));
            }
            if (request.getParameter("txtNombreModulo") != null) {
                obclsRequerimientos.setStNombreModulo(request.getParameter("txtNombreModulo"));
            }
            if (request.getParameter("txtOpcionModulo") != null) {
                obclsRequerimientos.setStOpcionModulo(request.getParameter("txtOpcionModulo"));
            }
            if (request.getParameter("txtVersionActualEjecutable") != null) {
                obclsRequerimientos.setStVersionActual(request.getParameter("txtVersionActualEjecutable"));
            }
            if (request.getParameter("txtDescripcionDetallada") != null) {
                obclsRequerimientos.setStDescripcionDetallada(request.getParameter("txtDescripcionDetallada"));
            }
            if (request.getParameter("txtDuracion") != null) {
                obclsRequerimientos.setInDuracion(Integer.parseInt(request.getParameter("txtDuracion")));
            }
            if (request.getParameter("ddlEstado") != null) {
                obclsEstadoRequerimiento.setInCodigo(Integer.parseInt(request.getParameter("ddlEstado")));
                obclsRequerimientos.setObclsEstadoRequerimiento(obclsEstadoRequerimiento);
            }

            request.setAttribute("stMensaje", bl_obclsRequerimientos.stInsertarRequerimientos(obclsRequerimientos));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsRequerimientos", bl_obclsRequerimientos.consultarRequerimientos());

            request.getRequestDispatcher("Requerimientos.jsp").forward(request, response);
        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Requerimientos.jsp").forward(request, response);
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
