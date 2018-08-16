package BL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class clsLlamadas {

    Connection conn = null;

    public clsLlamadas() {
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public String stInsertarLlamadas(Models.clsLlamadas obclsLlamadas) {
        try {

            PreparedStatement ps
                    = conn.prepareStatement("{call spInsertarLlamadas(?,?,?,?,?,?,?,?,?,?)}");

            ps.setString(1, obclsLlamadas.getStContacto());
            ps.setString(2, obclsLlamadas.getStAsunto());
            ps.setInt(3, obclsLlamadas.getObclsProposito().getInCodigo());
            ps.setInt(4, obclsLlamadas.getObclsRelacionadoCon().getInCodigo());
            ps.setInt(5, obclsLlamadas.getObclsTipoLlamada().getInCodigo());
            ps.setString(6, obclsLlamadas.getStDetalles());
            ps.setString(7, obclsLlamadas.getStFecha());
            ps.setInt(8, obclsLlamadas.getInDuracion());
            ps.setString(9, obclsLlamadas.getStDetalles());
            ps.setString(10, obclsLlamadas.getStResultado());

            ps.execute();
            return "Se realizo proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String stModificarLlamadas(Models.clsLlamadas obclsLlamadas) {
        try {

            PreparedStatement ps
                    = conn.prepareStatement("{call spModificarLlamadas(?,?,?,?,?,?,?,?,?,?,?)}");

            ps.setInt(1, obclsLlamadas.getInCodigo());
            ps.setString(2, obclsLlamadas.getStContacto());
            ps.setString(3, obclsLlamadas.getStAsunto());
            ps.setInt(4, obclsLlamadas.getObclsProposito().getInCodigo());
            ps.setInt(5, obclsLlamadas.getObclsRelacionadoCon().getInCodigo());
            ps.setInt(6, obclsLlamadas.getObclsTipoLlamada().getInCodigo());
            ps.setString(7, obclsLlamadas.getStDetalles());
            ps.setString(8, obclsLlamadas.getStFecha());
            ps.setInt(9, obclsLlamadas.getInDuracion());
            ps.setString(10, obclsLlamadas.getStDetalles());
            ps.setString(11, obclsLlamadas.getStResultado());

            ps.execute();
            return "Se realizo proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String stEliminarLlamadas(Models.clsLlamadas obclsLlamadas) {
        try {

            PreparedStatement ps
                    = conn.prepareStatement("{call spEliminarLlamadas(?)}");

            ps.setInt(1, obclsLlamadas.getInCodigo());
            ps.execute();
            return "Se realizo proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public List<Models.clsLlamadas> consultarLlamadas() {
        List<Models.clsLlamadas> lstclsLlamadas = new ArrayList<Models.clsLlamadas>();
        try {
            ResultSet rsConsulta = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarLlamadas() }");
            rsConsulta = ps.executeQuery();

            while (rsConsulta.next()) {

                Models.clsLlamadas obclsLlamadas = new Models.clsLlamadas();
                obclsLlamadas.setInCodigo(rsConsulta.getInt("llamCodigo"));
                obclsLlamadas.setStContacto(rsConsulta.getString("llamContacto"));
                obclsLlamadas.setStAsunto(rsConsulta.getString("llamAsunto"));

                Models.clsProposito obclsProposito = new Models.clsProposito();
                obclsProposito.setInCodigo(rsConsulta.getInt("propCodigo"));
                obclsProposito.setStDescripcion(rsConsulta.getString("propDescripcion"));
                obclsLlamadas.setObclsProposito(obclsProposito);

                Models.clsRelacionadoCon obclsRelacionadoCon = new Models.clsRelacionadoCon();
                obclsRelacionadoCon.setInCodigo(rsConsulta.getInt("recoCodigo"));
                obclsRelacionadoCon.setStDescripcion(rsConsulta.getString("recoDescripcion"));
                obclsLlamadas.setObclsRelacionadoCon(obclsRelacionadoCon);

                Models.clsTipoLlamada obclsTipoLlamada = new Models.clsTipoLlamada();
                obclsTipoLlamada.setInCodigo(rsConsulta.getInt("tillCodigo"));
                obclsTipoLlamada.setStDescripcion(rsConsulta.getString("tillDescripcion"));
                obclsLlamadas.setObclsTipoLlamada(obclsTipoLlamada);

                obclsLlamadas.setStDetalles(rsConsulta.getString("llamDetalles"));
                obclsLlamadas.setStFecha(rsConsulta.getString("llamFecha"));
                obclsLlamadas.setInDuracion(rsConsulta.getInt("llamDuracion"));
                obclsLlamadas.setStDescripcion(rsConsulta.getString("llamDescripcion"));
                obclsLlamadas.setStResultado(rsConsulta.getString("llamResultado"));
                
                lstclsLlamadas.add(obclsLlamadas);
            }

        } catch (Exception ex) {
        }
        return lstclsLlamadas;
    }
}
