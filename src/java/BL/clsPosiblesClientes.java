package BL;

import Models.clsCalificacion;
import Models.clsEstadoPosibleCliente;
import Models.clsFuentePosibleCliente;
import Models.clsSector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class clsPosiblesClientes {

    Connection conn = null;

    public clsPosiblesClientes() {
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public String stInsertarPosiblesClientes(Models.clsPosiblesClientes obclsPosiblesClientes) {
        try {

            PreparedStatement ps
                    = conn.prepareStatement("{call spInsertarPosiblesClientes(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            ps.setString(1, obclsPosiblesClientes.getStEmpresa());
            ps.setString(2, obclsPosiblesClientes.getStNombre());
            ps.setString(3, obclsPosiblesClientes.getStApellidos());
            ps.setString(4, obclsPosiblesClientes.getStTitulo());
            ps.setString(5, obclsPosiblesClientes.getStCorreoElectronico());
            ps.setString(6, obclsPosiblesClientes.getStTelefono());
            ps.setString(7, obclsPosiblesClientes.getStFax());
            ps.setString(8, obclsPosiblesClientes.getStMovil());
            ps.setString(9, obclsPosiblesClientes.getStSitioWeb());
            ps.setInt(10, obclsPosiblesClientes.getObclsFuentePosibleCliente().getInCodigo());
            ps.setInt(11, obclsPosiblesClientes.getObclsEstadoPosibleCliente().getInCodigo());
            ps.setInt(12, obclsPosiblesClientes.getObclsSector().getInCodigo());
            ps.setInt(13, obclsPosiblesClientes.getInCantidadEmpleados());
            ps.setDouble(14, obclsPosiblesClientes.getDbIngresosAnuales());
            ps.setInt(15, obclsPosiblesClientes.getObclsCalificacion().getInCodigo());
            ps.setString(16, String.valueOf(obclsPosiblesClientes.getChNoParticipacionCorreoElectronico()));
            ps.setString(17, obclsPosiblesClientes.getStIDSkype());
            ps.setString(18, obclsPosiblesClientes.getStTwitter());
            ps.setString(19, obclsPosiblesClientes.getStCorreoElectronicoSecundario());

            ps.execute();
            return "Se realizo proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public String stModificarPosiblesClientes(Models.clsPosiblesClientes obclsPosiblesClientes) {
        try {

            PreparedStatement ps
                    = conn.prepareStatement("{call spModificarPosiblesClientes(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            ps.setInt(1, obclsPosiblesClientes.getInCodigo());
            ps.setString(2, obclsPosiblesClientes.getStEmpresa());
            ps.setString(3, obclsPosiblesClientes.getStNombre());
            ps.setString(4, obclsPosiblesClientes.getStApellidos());
            ps.setString(5, obclsPosiblesClientes.getStTitulo());
            ps.setString(6, obclsPosiblesClientes.getStCorreoElectronico());
            ps.setString(7, obclsPosiblesClientes.getStTelefono());
            ps.setString(8, obclsPosiblesClientes.getStFax());
            ps.setString(9, obclsPosiblesClientes.getStMovil());
            ps.setString(10, obclsPosiblesClientes.getStSitioWeb());
            ps.setInt(11, obclsPosiblesClientes.getObclsFuentePosibleCliente().getInCodigo());
            ps.setInt(12, obclsPosiblesClientes.getObclsEstadoPosibleCliente().getInCodigo());
            ps.setInt(13, obclsPosiblesClientes.getObclsSector().getInCodigo());
            ps.setInt(14, obclsPosiblesClientes.getInCantidadEmpleados());
            ps.setDouble(15, obclsPosiblesClientes.getDbIngresosAnuales());
            ps.setInt(16, obclsPosiblesClientes.getObclsCalificacion().getInCodigo());
            ps.setString(17, String.valueOf(obclsPosiblesClientes.getChNoParticipacionCorreoElectronico()));
            ps.setString(18, obclsPosiblesClientes.getStIDSkype());
            ps.setString(19, obclsPosiblesClientes.getStTwitter());
            ps.setString(20, obclsPosiblesClientes.getStCorreoElectronicoSecundario());

            ps.execute();
            return "Se realizo proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }    
    
    public String stEliminarPosiblesClientes(Models.clsPosiblesClientes obclsPosiblesClientes) {
        try {

            PreparedStatement ps
                    = conn.prepareStatement("{call spEliminarPosiblesClientes(?)}");

            ps.setInt(1, obclsPosiblesClientes.getInCodigo());
            ps.execute();
            return "Se realizo proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }  

    public List<Models.clsPosiblesClientes> consultarPosiblesClientes() {
        List<Models.clsPosiblesClientes> lstclsPosiblesClientes = new ArrayList<Models.clsPosiblesClientes>();
        try {
            ResultSet rsConsulta = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarPosiblesClientes() }");
            rsConsulta = ps.executeQuery();

            while (rsConsulta.next()) {

                Models.clsPosiblesClientes obclsPosiblesClientes = new Models.clsPosiblesClientes();
                obclsPosiblesClientes.setInCodigo(rsConsulta.getInt("poclCodigo"));
                obclsPosiblesClientes.setStEmpresa(rsConsulta.getString("poclEmpresa"));
                obclsPosiblesClientes.setStNombre(rsConsulta.getString("poclNombres"));
                obclsPosiblesClientes.setStApellidos(rsConsulta.getString("poclApellidos"));
                obclsPosiblesClientes.setStTitulo(rsConsulta.getString("poclTitulo"));
                obclsPosiblesClientes.setStCorreoElectronico(rsConsulta.getString("poclCorreo"));
                obclsPosiblesClientes.setStTelefono(rsConsulta.getString("poclTelefono"));
                obclsPosiblesClientes.setStFax(rsConsulta.getString("poclFax"));
                obclsPosiblesClientes.setStMovil(rsConsulta.getString("poclMovil"));
                obclsPosiblesClientes.setStSitioWeb(rsConsulta.getString("poclSitioWeb"));

                Models.clsFuentePosibleCliente obclsFuentePosibleCliente = new clsFuentePosibleCliente();
                obclsFuentePosibleCliente.setInCodigo(rsConsulta.getInt("fuenCodigo"));
                obclsFuentePosibleCliente.setStDescripcion(rsConsulta.getString("fuenDescripcion"));
                obclsPosiblesClientes.setObclsFuentePosibleCliente(obclsFuentePosibleCliente);

                Models.clsEstadoPosibleCliente obclsEstadoPosibleCliente = new clsEstadoPosibleCliente();
                obclsEstadoPosibleCliente.setInCodigo(rsConsulta.getInt("esclCodigo"));
                obclsEstadoPosibleCliente.setStDescripion(rsConsulta.getString("esclDescripcion"));
                obclsPosiblesClientes.setObclsEstadoPosibleCliente(obclsEstadoPosibleCliente);

                Models.clsSector obclsSector = new clsSector();
                obclsSector.setInCodigo(rsConsulta.getInt("sectCodigo"));
                obclsSector.setStDescripion(rsConsulta.getString("sectDescripcion"));
                obclsPosiblesClientes.setObclsSector(obclsSector);

                obclsPosiblesClientes.setInCantidadEmpleados(rsConsulta.getInt("poclCantidadEmpleados"));
                obclsPosiblesClientes.setDbIngresosAnuales(rsConsulta.getDouble("poclIngresosAnuales"));

                Models.clsCalificacion obclsCalificacion = new clsCalificacion();
                obclsCalificacion.setInCodigo(rsConsulta.getInt("caliCodigo"));
                obclsCalificacion.setStDescripion(rsConsulta.getString("caliDescripcion"));
                obclsPosiblesClientes.setObclsCalificacion(obclsCalificacion);

                obclsPosiblesClientes.setChNoParticipacionCorreoElectronico(rsConsulta.getString("poclNoParticipacionCorreoElectronico").charAt(0));
                obclsPosiblesClientes.setStIDSkype(rsConsulta.getString("poclIdSkype"));
                obclsPosiblesClientes.setStTwitter(rsConsulta.getString("poclTwitter"));
                obclsPosiblesClientes.setStCorreoElectronicoSecundario(rsConsulta.getString("poclCorreoSecundario"));

                lstclsPosiblesClientes.add(obclsPosiblesClientes);
            }

        } catch (Exception ex) {
        }
        return lstclsPosiblesClientes;
    }
}
