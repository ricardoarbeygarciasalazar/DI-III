package BL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class clsRequerimientos {

    Connection conn = null;

    public clsRequerimientos() {
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public String stInsertarRequerimientos(Models.clsRequerimientos obclsRequerimientos) {
        try {

            PreparedStatement ps
                    = conn.prepareStatement("{call spInsertarRequerimientos(?,?,?,?,?,?,?,?,?)}");

            ps.setString(1, obclsRequerimientos.getStFecha());
            ps.setInt(2, obclsRequerimientos.getObclsContactos().getInCodigo());
            ps.setString(3, obclsRequerimientos.getStCargo());
            ps.setString(4, obclsRequerimientos.getStNombreModulo());
            ps.setString(5, obclsRequerimientos.getStOpcionModulo());
            ps.setString(6, obclsRequerimientos.getStVersionActual());
            ps.setString(7, obclsRequerimientos.getStDescripcionDetallada());
            ps.setInt(8, obclsRequerimientos.getInDuracion());
            ps.setInt(9, obclsRequerimientos.getObclsEstadoRequerimiento().getInCodigo());

            ps.execute();
            return "Se realizo proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String stModificarRequerimientos(Models.clsRequerimientos obclsRequerimientos) {
        try {

            PreparedStatement ps
                    = conn.prepareStatement("{call spModificarRequerimientos(?,?,?,?,?,?,?,?,?,?)}");

            ps.setInt(1, obclsRequerimientos.getInCodigo());
            ps.setString(2, obclsRequerimientos.getStFecha());
            ps.setInt(3, obclsRequerimientos.getObclsContactos().getInCodigo());
            ps.setString(4, obclsRequerimientos.getStCargo());
            ps.setString(5, obclsRequerimientos.getStNombreModulo());
            ps.setString(6, obclsRequerimientos.getStOpcionModulo());
            ps.setString(7, obclsRequerimientos.getStVersionActual());
            ps.setString(8, obclsRequerimientos.getStDescripcionDetallada());
            ps.setInt(9, obclsRequerimientos.getInDuracion());
            ps.setInt(10, obclsRequerimientos.getObclsEstadoRequerimiento().getInCodigo());

            ps.execute();
            return "Se realizo proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public List<Models.clsRequerimientos> consultarRequerimientos() {
        List<Models.clsRequerimientos> lstclsRequerimientos = new ArrayList<Models.clsRequerimientos>();
        try {
            ResultSet rsConsulta = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarRequerimientos() }");
            rsConsulta = ps.executeQuery();

            while (rsConsulta.next()) {

                Models.clsRequerimientos obclsRequerimientos = new Models.clsRequerimientos();
                obclsRequerimientos.setInCodigo(rsConsulta.getInt("requCodigo"));
                obclsRequerimientos.setStFecha(rsConsulta.getString("requFecha"));

                Models.clsContactos obclsContactos = new Models.clsContactos();
                obclsContactos.setInCodigo(rsConsulta.getInt("contCodigo"));
                obclsContactos.setStNombres(rsConsulta.getString("contNombres"));
                obclsContactos.setStApellidos(rsConsulta.getString("contApellidos"));
                obclsRequerimientos.setObclsContactos(obclsContactos);

                obclsRequerimientos.setStCargo(rsConsulta.getString("requCargo"));
                obclsRequerimientos.setStNombreModulo(rsConsulta.getString("requNombreModulo"));
                obclsRequerimientos.setStOpcionModulo(rsConsulta.getString("requOpcionModulo"));
                obclsRequerimientos.setStVersionActual(rsConsulta.getString("requVersionActual"));
                obclsRequerimientos.setStDescripcionDetallada(rsConsulta.getString("requDescripcionDetallada"));
                obclsRequerimientos.setInDuracion(rsConsulta.getInt("requDuracion"));

                Models.clsEstadoRequerimiento obclsEstadoRequerimiento = new Models.clsEstadoRequerimiento();
                obclsEstadoRequerimiento.setInCodigo(rsConsulta.getInt("esreCodigo"));
                obclsEstadoRequerimiento.setStDescripcion(rsConsulta.getString("esreDescripcion"));
                obclsRequerimientos.setObclsEstadoRequerimiento(obclsEstadoRequerimiento);

                lstclsRequerimientos.add(obclsRequerimientos);
            }

        } catch (Exception ex) {
        }
        return lstclsRequerimientos;
    }    
    
    public List<Models.clsRequerimientos> consultarRequerimientos(Models.clsRequerimientos p_obclsRequerimientos) {
        List<Models.clsRequerimientos> lstclsRequerimientos = new ArrayList<Models.clsRequerimientos>();
        try {
            ResultSet rsConsulta = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarRequerimientos(?,?) }");
            ps.setInt(1, p_obclsRequerimientos.getObclsContactos().getInCodigo());
            ps.setInt(2, p_obclsRequerimientos.getObclsEstadoRequerimiento().getInCodigo());
            
            rsConsulta = ps.executeQuery();

            while (rsConsulta.next()) {

                Models.clsRequerimientos obclsRequerimientos = new Models.clsRequerimientos();
                obclsRequerimientos.setInCodigo(rsConsulta.getInt("requCodigo"));
                obclsRequerimientos.setStFecha(rsConsulta.getString("requFecha"));

                Models.clsContactos obclsContactos = new Models.clsContactos();
                obclsContactos.setInCodigo(rsConsulta.getInt("contCodigo"));
                obclsContactos.setStNombres(rsConsulta.getString("contNombres"));
                obclsContactos.setStApellidos(rsConsulta.getString("contApellidos"));
                obclsRequerimientos.setObclsContactos(obclsContactos);

                obclsRequerimientos.setStCargo(rsConsulta.getString("requCargo"));
                obclsRequerimientos.setStNombreModulo(rsConsulta.getString("requNombreModulo"));
                obclsRequerimientos.setStOpcionModulo(rsConsulta.getString("requOpcionModulo"));
                obclsRequerimientos.setStVersionActual(rsConsulta.getString("requVersionActual"));
                obclsRequerimientos.setStDescripcionDetallada(rsConsulta.getString("requDescripcionDetallada"));
                obclsRequerimientos.setInDuracion(rsConsulta.getInt("requDuracion"));

                Models.clsEstadoRequerimiento obclsEstadoRequerimiento = new Models.clsEstadoRequerimiento();
                obclsEstadoRequerimiento.setInCodigo(rsConsulta.getInt("esreCodigo"));
                obclsEstadoRequerimiento.setStDescripcion(rsConsulta.getString("esreDescripcion"));
                obclsRequerimientos.setObclsEstadoRequerimiento(obclsEstadoRequerimiento);

                lstclsRequerimientos.add(obclsRequerimientos);
            }

        } catch (Exception ex) {
        }
        return lstclsRequerimientos;
    }
}
