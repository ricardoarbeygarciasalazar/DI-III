package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

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

        try {

            String stMensaje = "";

            if (request.getParameter("txtEmail").equals("")) {
                stMensaje += "Ingrese email,";
            }
            if (request.getParameter("txtPassword").equals("")) {
                stMensaje += "Ingrese password,";
            }

            if (!stMensaje.equals("")) {
                throw new Exception(stMensaje.substring(0, stMensaje.length() - 1));
            }

            //instanciando objeto
            Models.clsLogin obclsLogin = new Models.clsLogin();

            //asignado las propiedades
            obclsLogin.setStEmail(request.getParameter("txtEmail").toString());
            obclsLogin.setStPassword(request.getParameter("txtPassword").toString());

            //instanciando controlador
            BL.clsLogin obBLclsLogin = new BL.clsLogin();

            if (request.getParameter("btnAceptar") != null) {
                String stMensajeConfirmacion
                        = obBLclsLogin.stInsertarUsuario(obclsLogin);

                if (!stMensajeConfirmacion.equals("Se realizo proceso con exito")) {
                    request.setAttribute("stMensaje", stMensajeConfirmacion);
                    request.setAttribute("stTipo", "error");
                    request.getRequestDispatcher("Registrar.jsp").forward(request, response);
                } else {
                    request.setAttribute("stMensaje", stMensajeConfirmacion);
                    request.setAttribute("stTipo", "success");
                    request.getRequestDispatcher("Registrar.jsp").forward(request, response);
                }
            } else {

                //invoco el metodo validarLogin
                int inPerfil = obBLclsLogin.validarLogin(obclsLogin);
                
                HttpSession session = request.getSession(true);
                session.setAttribute("stLogin", request.getParameter("txtEmail").toString());

                switch (inPerfil) {
                //direccionamiento JSP
                    case 1:
                        request.getRequestDispatcher("Index.jsp").forward(request, response);
                        break;
                    case 2:
                        request.getRequestDispatcher("IndexCliente.jsp").forward(request, response);
                        break;
                    default:
                        throw new Exception("Email o password incorrecto");
                }
            }

        } catch (Exception ex) {
            //envio de parametros o valores
            request.setAttribute("stError", ex.getMessage());
            //direccionamiento JSP
            request.getRequestDispatcher("Login.jsp").forward(request, response);
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
