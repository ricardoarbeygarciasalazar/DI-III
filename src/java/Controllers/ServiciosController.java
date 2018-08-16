package Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServiciosController", urlPatterns = {"/ServiciosController"})
public class ServiciosController extends HttpServlet {

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

            BL.clsServicios bl_obclsServicios = new BL.clsServicios();  
            Models.clsServicios obclsServicios = new Models.clsServicios();
            
            obclsServicios.setStEmpresa(request.getParameter("txtEmpresa") != null ? request.getParameter("txtEmpresa") : "");
            obclsServicios.setStNIT(request.getParameter("txtNIT") != null ? request.getParameter("txtNIT") : "");
            obclsServicios.setStResponsable(request.getParameter("txtResponsable") != null ? request.getParameter("txtResponsable") : "");
                        
            request.setAttribute("lstclsServicios", bl_obclsServicios.consultarServicios(obclsServicios));
            request.getRequestDispatcher("ConsultaServicios.jsp").forward(request, response);
        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("ConsultaServicios.jsp").forward(request, response);
        }
    }

    public void cargarModificar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {

            BL.clsServicios bl_obclsServicios = new BL.clsServicios();

            List<Models.clsServicios> lstclsServicios = new ArrayList<Models.clsServicios>();
            Models.clsServicios obclsServicios = new Models.clsServicios();

            lstclsServicios = bl_obclsServicios.consultarServicios();

            for (Models.clsServicios item : lstclsServicios) {
                if (item.getInCodigo() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsServicios = item;
                }
            }

            request.setAttribute("obclsServicios", obclsServicios);
            request.getRequestDispatcher("Servicios.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Servicios.jsp").forward(request, response);
        }
    }

    public void btnModificar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {

            BL.clsServicios bl_obclsServicios = new BL.clsServicios();

            Models.clsServicios obclsServicios = new Models.clsServicios();
            Models.clsAccion obclsAccion = new Models.clsAccion();

            if (request.getParameter("codigoSeleccionado") != null) {
                obclsServicios.setInCodigo(Integer.valueOf(request.getParameter("codigoSeleccionado")));
            }
            if (request.getParameter("txtEmpresa") != null) {
                obclsServicios.setStEmpresa(request.getParameter("txtEmpresa"));
            }
            if (request.getParameter("txtNIT") != null) {
                obclsServicios.setStNIT(request.getParameter("txtNIT"));
            }
            if (request.getParameter("txtNombreCompleto") != null) {
                obclsServicios.setStNombreCompleto(request.getParameter("txtNombreCompleto"));
            }
            if (request.getParameter("txtTelefono") != null) {
                obclsServicios.setStTelefono(request.getParameter("txtTelefono"));
            }
            if (request.getParameter("txtCorreo") != null) {
                obclsServicios.setStCorreo(request.getParameter("txtCorreo"));
            }
            if (request.getParameter("ddlAccion") != null) {
                obclsAccion.setInCodigo(Integer.parseInt(request.getParameter("ddlAccion")));
                obclsServicios.setObclsAccion(obclsAccion);
            }
            if (request.getParameter("txtDescripcion") != null) {
                obclsServicios.setStDescripcion(request.getParameter("txtDescripcion"));
            }
            if (request.getParameter("txtFechaInicioVigencia") != null) {
                obclsServicios.setStFechaInicioVigencia(request.getParameter("txtFechaInicioVigencia"));
            }
            if (request.getParameter("txtFechaFinVigencia") != null) {
                obclsServicios.setStFechaFinVigencia(request.getParameter("txtFechaFinVigencia"));
            }
            if (request.getParameter("txtResponsable") != null) {
                obclsServicios.setStResponsable(request.getParameter("txtResponsable"));
            }
            if (request.getParameter("txtFechaEntrega") != null) {
                obclsServicios.setStFechaEntrega(request.getParameter("txtFechaEntrega"));
            }

            request.setAttribute("stMensaje", bl_obclsServicios.stModificarServicios(obclsServicios));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsServicios", bl_obclsServicios.consultarServicios());

            request.getRequestDispatcher("Servicios.jsp").forward(request, response);
        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Servicios.jsp").forward(request, response);
        }
    }

    public void btnGuardar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {

            BL.clsServicios bl_obclsServicios = new BL.clsServicios();

            Models.clsServicios obclsServicios = new Models.clsServicios();
            Models.clsAccion obclsAccion = new Models.clsAccion();

            if (request.getParameter("txtEmpresa") != null) {
                obclsServicios.setStEmpresa(request.getParameter("txtEmpresa"));
            }
            if (request.getParameter("txtNIT") != null) {
                obclsServicios.setStNIT(request.getParameter("txtNIT"));
            }
            if (request.getParameter("txtNombreCompleto") != null) {
                obclsServicios.setStNombreCompleto(request.getParameter("txtNombreCompleto"));
            }
            if (request.getParameter("txtTelefono") != null) {
                obclsServicios.setStTelefono(request.getParameter("txtTelefono"));
            }
            if (request.getParameter("txtCorreo") != null) {
                obclsServicios.setStCorreo(request.getParameter("txtCorreo"));
            }
            if (request.getParameter("ddlAccion") != null) {
                obclsAccion.setInCodigo(Integer.parseInt(request.getParameter("ddlAccion")));
                obclsServicios.setObclsAccion(obclsAccion);
            }
            if (request.getParameter("txtDescripcion") != null) {
                obclsServicios.setStDescripcion(request.getParameter("txtDescripcion"));
            }
            if (request.getParameter("txtFechaInicioVigencia") != null) {
                obclsServicios.setStFechaInicioVigencia(request.getParameter("txtFechaInicioVigencia"));
            }
            if (request.getParameter("txtFechaFinVigencia") != null) {
                obclsServicios.setStFechaFinVigencia(request.getParameter("txtFechaFinVigencia"));
            }
            if (request.getParameter("txtResponsable") != null) {
                obclsServicios.setStResponsable(request.getParameter("txtResponsable"));
            }
            if (request.getParameter("txtFechaEntrega") != null) {
                obclsServicios.setStFechaEntrega(request.getParameter("txtFechaEntrega"));
            }

            request.setAttribute("stMensaje", bl_obclsServicios.stInsertarServicios(obclsServicios));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsServicios", bl_obclsServicios.consultarServicios());

            request.getRequestDispatcher("Servicios.jsp").forward(request, response);
        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Servicios.jsp").forward(request, response);
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
