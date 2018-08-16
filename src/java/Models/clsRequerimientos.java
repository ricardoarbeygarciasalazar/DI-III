package Models;

public class clsRequerimientos {

    public int getInCodigo() {
        return inCodigo;
    }

    public void setInCodigo(int inCodigo) {
        this.inCodigo = inCodigo;
    }

    public String getStFecha() {
        return stFecha;
    }

    public void setStFecha(String stFecha) {
        this.stFecha = stFecha;
    }

    public clsContactos getObclsContactos() {
        return obclsContactos;
    }

    public void setObclsContactos(clsContactos obclsContactos) {
        this.obclsContactos = obclsContactos;
    }

    public String getStCargo() {
        return stCargo;
    }

    public void setStCargo(String stCargo) {
        this.stCargo = stCargo;
    }

    public String getStNombreModulo() {
        return stNombreModulo;
    }

    public void setStNombreModulo(String stNombreModulo) {
        this.stNombreModulo = stNombreModulo;
    }

    public String getStOpcionModulo() {
        return stOpcionModulo;
    }

    public void setStOpcionModulo(String stOpcionModulo) {
        this.stOpcionModulo = stOpcionModulo;
    }

    public String getStVersionActual() {
        return stVersionActual;
    }

    public void setStVersionActual(String stVersionActual) {
        this.stVersionActual = stVersionActual;
    }

    public String getStDescripcionDetallada() {
        return stDescripcionDetallada;
    }

    public void setStDescripcionDetallada(String stDescripcionDetallada) {
        this.stDescripcionDetallada = stDescripcionDetallada;
    }

    public int getInDuracion() {
        return inDuracion;
    }

    public void setInDuracion(int inDuracion) {
        this.inDuracion = inDuracion;
    }

    public clsEstadoRequerimiento getObclsEstadoRequerimiento() {
        return obclsEstadoRequerimiento;
    }

    public void setObclsEstadoRequerimiento(clsEstadoRequerimiento obclsEstadoRequerimiento) {
        this.obclsEstadoRequerimiento = obclsEstadoRequerimiento;
    }

    public int inCodigo;
    public String stFecha;
    public Models.clsContactos obclsContactos;
    public String stCargo;
    public String stNombreModulo;
    public String stOpcionModulo;
    public String stVersionActual;
    public String stDescripcionDetallada;
    public int inDuracion;
    public Models.clsEstadoRequerimiento obclsEstadoRequerimiento;
}
