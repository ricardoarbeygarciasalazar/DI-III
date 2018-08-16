package BL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class clsTratos {

    Connection conn = null;

    public clsTratos() {
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public String stInsertarTratos(Models.clsTratos obclsTratos) {
        try {

            PreparedStatement ps
                    = conn.prepareStatement("{call spInsertarTratos(?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            ps.setString(1, obclsTratos.getStImporte());
            ps.setString(2, obclsTratos.getStNombre());
            ps.setString(3, obclsTratos.getStFechaCierre());
            ps.setString(4, obclsTratos.getStNumeroCuenta());
            ps.setInt(5, obclsTratos.getObclsFaseTrato().getInCodigo());
            ps.setInt(6, obclsTratos.getObclsTipoTrato().getInCodigo());
            ps.setDouble(7, obclsTratos.getDbProbabilidad());
            ps.setString(8, obclsTratos.getStSiguientePaso());
            ps.setDouble(9, obclsTratos.getDbIngresosEsperados());
            ps.setInt(10,obclsTratos.getObclsFuentePosibleCliente().getInCodigo());
            ps.setString(11,obclsTratos.getStFuenteCampaña());
            ps.setString(12,obclsTratos.stNombreContacto);
            ps.setString(13,obclsTratos.getStDescripcion());

            ps.execute();
            return "Se realizo proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String stModificarTratos(Models.clsTratos obclsTratos) {
        try {

            PreparedStatement ps
                    = conn.prepareStatement("{call spModificarTratos(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            ps.setInt(1, obclsTratos.getInCodigo());
            ps.setString(2, obclsTratos.getStImporte());
            ps.setString(3, obclsTratos.getStNombre());
            ps.setString(4, obclsTratos.getStFechaCierre());
            ps.setString(5, obclsTratos.getStNumeroCuenta());
            ps.setInt(6, obclsTratos.getObclsFaseTrato().getInCodigo());
            ps.setInt(7, obclsTratos.getObclsTipoTrato().getInCodigo());
            ps.setDouble(8, obclsTratos.getDbProbabilidad());
            ps.setString(9, obclsTratos.getStSiguientePaso());
            ps.setDouble(10, obclsTratos.getDbIngresosEsperados());
            ps.setInt(11,obclsTratos.getObclsFuentePosibleCliente().getInCodigo());
            ps.setString(12,obclsTratos.getStFuenteCampaña());
            ps.setString(13,obclsTratos.stNombreContacto);
            ps.setString(14,obclsTratos.getStDescripcion());

            ps.execute();
            return "Se realizo proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String stEliminarTratos(Models.clsTratos obclsTratos) {
        try {

            PreparedStatement ps
                    = conn.prepareStatement("{call spEliminarTratos(?)}");

            ps.setInt(1, obclsTratos.getInCodigo());
            ps.execute();
            return "Se realizo proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public List<Models.clsTratos> consultarTratos() {
        List<Models.clsTratos> lstclsTratos = new ArrayList<Models.clsTratos>();
        try {
            ResultSet rsConsulta = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarTratos() }");
            rsConsulta = ps.executeQuery();

            while (rsConsulta.next()) {

                Models.clsTratos obclsTratos = new Models.clsTratos();
                obclsTratos.setInCodigo(rsConsulta.getInt("tratCodigo"));
                obclsTratos.setStImporte(rsConsulta.getString("tratImporte"));
                obclsTratos.setStNombre(rsConsulta.getString("tratNombre"));
                obclsTratos.setStFechaCierre(rsConsulta.getString("tratFechaCierre"));
                obclsTratos.setStNumeroCuenta(rsConsulta.getString("tratNumeroCuenta"));

                Models.clsFaseTrato obclsFaseTrato = new Models.clsFaseTrato();
                obclsFaseTrato.setInCodigo(rsConsulta.getInt("faseCodigo"));
                obclsFaseTrato.setStDescripcion(rsConsulta.getString("faseDescripcion"));
                obclsTratos.setObclsFaseTrato(obclsFaseTrato);

                Models.clsTipoTrato obclsTipoTrato = new Models.clsTipoTrato();
                obclsTipoTrato.setInCodigo(rsConsulta.getInt("titrCodigo"));
                obclsTipoTrato.setStDescripcion(rsConsulta.getString("titrDescripcion"));
                obclsTratos.setObclsTipoTrato(obclsTipoTrato);

                obclsTratos.setDbProbabilidad(rsConsulta.getDouble("tratProbabilidad"));
                obclsTratos.setStSiguientePaso(rsConsulta.getString("tratSiguientePaso"));
                obclsTratos.setDbIngresosEsperados(rsConsulta.getDouble("tratIngresosEsperados"));
                                
                Models.clsFuentePosibleCliente obclsFuentePosibleCliente = new Models.clsFuentePosibleCliente();
                obclsFuentePosibleCliente.setInCodigo(rsConsulta.getInt("fuenCodigo"));
                obclsFuentePosibleCliente.setStDescripcion(rsConsulta.getString("fuenDescripcion"));
                obclsTratos.setObclsFuentePosibleCliente(obclsFuentePosibleCliente);
                
                obclsTratos.setStFuenteCampaña(rsConsulta.getString("tratFuente"));
                obclsTratos.setStNombreContacto(rsConsulta.getString("tratNombreContacto"));
                obclsTratos.setStDescripcion(rsConsulta.getString("tratDescripcion"));

                lstclsTratos.add(obclsTratos);
            }

        } catch (Exception ex) {
        }
        return lstclsTratos;
    }
}
