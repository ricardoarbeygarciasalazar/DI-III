package BL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class clsLogin {
    
    Connection conn = null;
    
    public clsLogin(){
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    
    public int validarLogin(Models.clsLogin obclsLogin){
        try{
            ResultSet rsConsulta = null;
            PreparedStatement ps = 
                    conn.prepareStatement("{call spConsultarUsuario(?,?)}");
            
            ps.setString(1, obclsLogin.getStEmail());
            ps.setString(2, obclsLogin.getStPassword());
            
            rsConsulta = ps.executeQuery();
            int inPerfil = -1;
            
            while(rsConsulta.next()){
                inPerfil = rsConsulta.getInt("perfCodigo");
            }
            
            return inPerfil;
        }catch(Exception ex){
            return -1;
        }
    }
    
    public String stInsertarUsuario(Models.clsLogin obclsLogin){
        try{
            
            PreparedStatement ps = 
                    conn.prepareStatement("{call spInsertarUsuarios(?,?)}");
            
            ps.setString(1, obclsLogin.getStEmail());
            ps.setString(2, obclsLogin.getStPassword());
            
            ps.execute();
            return "Se realizo proceso con exito";
        }catch(Exception ex){
            return ex.getMessage();
        }
    } 
}
