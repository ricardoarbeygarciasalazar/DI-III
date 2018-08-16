package BL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class clsContactos {
    Connection conn = null;

    public clsContactos() {
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public String stInsertarContactos(Models.clsContactos obclsContactos) {
        try {

            PreparedStatement ps
                    = conn.prepareStatement("{call spInsertarContactos(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            ps.setInt(1, obclsContactos.getObclsFuentePosibleCliente().getInCodigo());
            ps.setString(2, obclsContactos.getStNombres());
            ps.setString(3, obclsContactos.getStApellidos());
            ps.setString(4, obclsContactos.getStNumeroCuenta());
            ps.setString(5, obclsContactos.getStTitulo());
            ps.setString(6, obclsContactos.getStCorreo());
            ps.setString(7, obclsContactos.getStDepartamento());
            ps.setString(8, obclsContactos.getStTelefono());
            ps.setString(9, obclsContactos.getStTelefonoParticular());
            ps.setString(10,obclsContactos.getStOtroTelefono());
            ps.setString(11, obclsContactos.getStFax());
            ps.setString(12, obclsContactos.getStMovil());
            ps.setString(13, obclsContactos.getStFechaNacimiento());
            ps.setString(14, obclsContactos.getStAsistente());
            ps.setString(15, obclsContactos.getStTelefonoAsistente());
            ps.setString(16, obclsContactos.getStRespondeA());
            ps.setString(17, String.valueOf(obclsContactos.getChNoParticipacionCorreo()));
            ps.setString(18, obclsContactos.getStIdSkype());
            ps.setString(19, obclsContactos.getStCorreoSecundario());

            ps.execute();
            return "Se realizo proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public String stModificarContactos(Models.clsContactos obclsContactos) {
        try {

            PreparedStatement ps
                    = conn.prepareStatement("{call spModificarContactos(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            ps.setInt(1, obclsContactos.getInCodigo());
            ps.setInt(2, obclsContactos.getObclsFuentePosibleCliente().getInCodigo());
            ps.setString(3, obclsContactos.getStNombres());
            ps.setString(4, obclsContactos.getStApellidos());
            ps.setString(5, obclsContactos.getStNumeroCuenta());
            ps.setString(6, obclsContactos.getStTitulo());
            ps.setString(7, obclsContactos.getStCorreo());
            ps.setString(8, obclsContactos.getStDepartamento());
            ps.setString(9, obclsContactos.getStTelefono());
            ps.setString(10, obclsContactos.getStTelefonoParticular());
            ps.setString(11,obclsContactos.getStOtroTelefono());
            ps.setString(12, obclsContactos.getStFax());
            ps.setString(13, obclsContactos.getStMovil());
            ps.setString(14, obclsContactos.getStFechaNacimiento());
            ps.setString(15, obclsContactos.getStAsistente());
            ps.setString(16, obclsContactos.getStTelefonoAsistente());
            ps.setString(17, obclsContactos.getStRespondeA());
            ps.setString(18, String.valueOf(obclsContactos.getChNoParticipacionCorreo()));
            ps.setString(19, obclsContactos.getStIdSkype());
            ps.setString(20, obclsContactos.getStCorreoSecundario());

            ps.execute();
            return "Se realizo proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }    
    
    public String stEliminarContactos(Models.clsContactos obclsContactos) {
        try {

            PreparedStatement ps
                    = conn.prepareStatement("{call spEliminarContactos(?)}");

            ps.setInt(1, obclsContactos.getInCodigo());
            ps.execute();
            return "Se realizo proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }  

    public List<Models.clsContactos> consultarContactos() {
        List<Models.clsContactos> lstclsContactos = new ArrayList<Models.clsContactos>();
        try {
            ResultSet rsConsulta = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarContactos() }");
            rsConsulta = ps.executeQuery();

            while (rsConsulta.next()) {

                Models.clsContactos obclsContactos = new Models.clsContactos();
                obclsContactos.setInCodigo(rsConsulta.getInt("contCodigo"));
                
                Models.clsFuentePosibleCliente obclsFuentePosibleCliente = new Models.clsFuentePosibleCliente();
                obclsFuentePosibleCliente.setInCodigo(rsConsulta.getInt("fuenCodigo"));
                obclsFuentePosibleCliente.setStDescripcion(rsConsulta.getString("fuenDescripcion"));
                obclsContactos.setObclsFuentePosibleCliente(obclsFuentePosibleCliente);
                
                obclsContactos.setStNombres(rsConsulta.getString("contNombres"));
                obclsContactos.setStApellidos(rsConsulta.getString("contApellidos"));
                obclsContactos.setStNumeroCuenta(rsConsulta.getString("contNumeroCuenta"));
                obclsContactos.setStTitulo(rsConsulta.getString("contTitulo"));
                obclsContactos.setStCorreo(rsConsulta.getString("contCorreo"));
                obclsContactos.setStDepartamento(rsConsulta.getString("contDepartamento"));
                obclsContactos.setStTelefono(rsConsulta.getString("contTelefono"));
                obclsContactos.setStTelefonoParticular(rsConsulta.getString("contTelefonoParticular"));
                obclsContactos.setStOtroTelefono(rsConsulta.getString("contOtroTelefono"));
                obclsContactos.setStFax(rsConsulta.getString("contFax"));
                obclsContactos.setStMovil(rsConsulta.getString("contMovil"));
                obclsContactos.setStFechaNacimiento(rsConsulta.getString("contFechaNacimiento"));
                obclsContactos.setStAsistente(rsConsulta.getString("contAsistente"));
                obclsContactos.setStTelefonoAsistente(rsConsulta.getString("contTelefonoAsistente"));                
                obclsContactos.setStRespondeA(rsConsulta.getString("contRespondeA"));
                obclsContactos.setChNoParticipacionCorreo(rsConsulta.getString("contNoParticipacionCorreo").charAt(0));
                obclsContactos.setStIdSkype(rsConsulta.getString("contIdSkype"));
                obclsContactos.setStCorreoSecundario(rsConsulta.getString("contCorreoSecundario"));                
                
                lstclsContactos.add(obclsContactos);
            }

        } catch (Exception ex) {
        }
        return lstclsContactos;
    }
}
