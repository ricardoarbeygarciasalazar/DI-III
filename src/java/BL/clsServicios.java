package BL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class clsServicios {

    Connection conn = null;

    public clsServicios() {
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public String stInsertarServicios(Models.clsServicios obclsServicios) {
        try {

            PreparedStatement ps
                    = conn.prepareStatement("{call spInsertarServicios(?,?,?,?,?,?,?,?,?,?,?)}");

            ps.setString(1, obclsServicios.getStEmpresa());
            ps.setString(2, obclsServicios.getStNIT());
            ps.setString(3, obclsServicios.getStNombreCompleto());
            ps.setString(4, obclsServicios.getStTelefono());
            ps.setString(5, obclsServicios.getStCorreo());
            ps.setInt(6, obclsServicios.getObclsAccion().getInCodigo());
            ps.setString(7, obclsServicios.getStDescripcion());
            ps.setString(8, obclsServicios.getStFechaInicioVigencia());
            ps.setString(9, obclsServicios.getStFechaFinVigencia());
            ps.setString(10, obclsServicios.getStResponsable());
            ps.setString(11, obclsServicios.getStFechaEntrega());

            ps.execute();
            return "Se realizo proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String stModificarServicios(Models.clsServicios obclsServicios) {
        try {

            PreparedStatement ps
                    = conn.prepareStatement("{call spModificarServicios(?,?,?,?,?,?,?,?,?,?,?,?)}");

            ps.setInt(1, obclsServicios.getInCodigo());
            ps.setString(2, obclsServicios.getStEmpresa());
            ps.setString(3, obclsServicios.getStNIT());
            ps.setString(4, obclsServicios.getStNombreCompleto());
            ps.setString(5, obclsServicios.getStTelefono());
            ps.setString(6, obclsServicios.getStCorreo());
            ps.setInt(7, obclsServicios.getObclsAccion().getInCodigo());
            ps.setString(8, obclsServicios.getStDescripcion());
            ps.setString(9, obclsServicios.getStFechaInicioVigencia());
            ps.setString(10, obclsServicios.getStFechaFinVigencia());
            ps.setString(11, obclsServicios.getStResponsable());
            ps.setString(12, obclsServicios.getStFechaEntrega());

            ps.execute();
            return "Se realizo proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public List<Models.clsServicios> consultarServicios() {
        List<Models.clsServicios> lstclsServicios = new ArrayList<Models.clsServicios>();
        try {
            ResultSet rsConsulta = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarServicios() }");
            rsConsulta = ps.executeQuery();

            while (rsConsulta.next()) {

                Models.clsServicios obclsclsServicios = new Models.clsServicios();
                obclsclsServicios.setInCodigo(rsConsulta.getInt("servCodigo"));
                obclsclsServicios.setStEmpresa(rsConsulta.getString("servEmpresa"));
                obclsclsServicios.setStNIT(rsConsulta.getString("servNIT"));
                obclsclsServicios.setStNombreCompleto(rsConsulta.getString("servNombreCompleto"));
                obclsclsServicios.setStTelefono(rsConsulta.getString("servTelefono"));
                obclsclsServicios.setStCorreo(rsConsulta.getString("servCorreo"));
                
                Models.clsAccion obclsAccion = new Models.clsAccion();
                obclsAccion.setInCodigo(rsConsulta.getInt("acciCodigo"));
                obclsAccion.setStDescripcion(rsConsulta.getString("acciDescripcion"));
                obclsclsServicios.setObclsAccion(obclsAccion);
                
                obclsclsServicios.setStDescripcion(rsConsulta.getString("servDescripcion"));
                obclsclsServicios.setStFechaInicioVigencia(rsConsulta.getString("servFechaInicioVigencia"));
                obclsclsServicios.setStFechaFinVigencia(rsConsulta.getString("servFechaFinVigencia"));
                obclsclsServicios.setStResponsable(rsConsulta.getString("servResponsable"));
                obclsclsServicios.setStFechaEntrega(rsConsulta.getString("servFechaEntrega"));
                
                lstclsServicios.add(obclsclsServicios);
            }

        } catch (Exception ex) {
        }
        return lstclsServicios;
    }
    
    public List<Models.clsServicios> consultarServicios(Models.clsServicios obclsServicios) {
        List<Models.clsServicios> lstclsServicios = new ArrayList<Models.clsServicios>();
        try {
            ResultSet rsConsulta = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarServicios(?,?,?) }");
            ps.setString(1, obclsServicios.getStEmpresa());
            ps.setString(2, obclsServicios.getStNIT());
            ps.setString(3, obclsServicios.getStResponsable());
            
            rsConsulta = ps.executeQuery();

            while (rsConsulta.next()) {

                Models.clsServicios obclsclsServicios = new Models.clsServicios();
                obclsclsServicios.setInCodigo(rsConsulta.getInt("servCodigo"));
                obclsclsServicios.setStEmpresa(rsConsulta.getString("servEmpresa"));
                obclsclsServicios.setStNIT(rsConsulta.getString("servNIT"));
                obclsclsServicios.setStNombreCompleto(rsConsulta.getString("servNombreCompleto"));
                obclsclsServicios.setStTelefono(rsConsulta.getString("servTelefono"));
                obclsclsServicios.setStCorreo(rsConsulta.getString("servCorreo"));
                
                Models.clsAccion obclsAccion = new Models.clsAccion();
                obclsAccion.setInCodigo(rsConsulta.getInt("acciCodigo"));
                obclsAccion.setStDescripcion(rsConsulta.getString("acciDescripcion"));
                obclsclsServicios.setObclsAccion(obclsAccion);
                
                obclsclsServicios.setStDescripcion(rsConsulta.getString("servDescripcion"));
                obclsclsServicios.setStFechaInicioVigencia(rsConsulta.getString("servFechaInicioVigencia"));
                obclsclsServicios.setStFechaFinVigencia(rsConsulta.getString("servFechaFinVigencia"));
                obclsclsServicios.setStResponsable(rsConsulta.getString("servResponsable"));
                obclsclsServicios.setStFechaEntrega(rsConsulta.getString("servFechaEntrega"));
                
                lstclsServicios.add(obclsclsServicios);
            }

        } catch (Exception ex) {
        }
        return lstclsServicios;
    }
}
