<%@page import="java.util.AbstractList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Requerimientos</title>
        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <link href="css/sweetalert.css" rel="stylesheet" type="text/css" />
        <script src="js/sweetalert.min.js" type="text/javascript"></script>
    </head>
    <body>       
        <!-- SCRIPTLETS -->
        <%
            if (request.getAttribute("stMensaje") != null) {
        %>     
        <input type="text" hidden="" id="txtMensaje" value="<%=request.getAttribute("stMensaje").toString()%>"/>
        <input type="text" hidden="" id="txtTipo" value="<%=request.getAttribute("stTipo").toString()%>"/>
        <script>
            swal("Mensaje", document.getElementById("txtMensaje").value, document.getElementById("txtTipo").value);
        </script>
        <%
            }
        %>    

        <%
            List<Models.clsContactos> lstclsContactos = new ArrayList<Models.clsContactos>();
            List<Models.clsRequerimientos> lstclsRequerimientos = new ArrayList<Models.clsRequerimientos>();
            Models.clsRequerimientos obclsRequerimientos = new Models.clsRequerimientos();

            if (request.getAttribute("obclsRequerimientos") != null) {
                obclsRequerimientos = (Models.clsRequerimientos) request.getAttribute("obclsRequerimientos");
            }
            if (request.getAttribute("lstclsRequerimientos") != null) {
                lstclsRequerimientos = (List<Models.clsRequerimientos>) request.getAttribute("lstclsRequerimientos");
            }

            BL.clsContactos obclsContactos = new BL.clsContactos();
            lstclsContactos = obclsContactos.consultarContactos();
        %>      
        <div class="container">
            <div class="card mx-auto mt-5">
                <div class="card-header">Requerimientos
                </div>
                <div class="card-body">
                    <form action="RequerimientosController" method="POST">
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <input type="submit" value="Guardar" class="btn btn-primary" name="btnGuardar"/>
                                    <input type="submit" value="Modificar" class="btn btn-primary" name="btnModificar"/>
                                    <a href="Index.jsp" class="btn btn-primary">Volver</a>
                                    <input type="text" hidden=""
                                           name="codigoSeleccionado"
                                           value="<%= obclsRequerimientos.getInCodigo()%>"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblFechaRequerimiento">Fecha del requerimiento</label>
                                    <input type="date" placeholder="Fecha del requerimiento" name="txtFechaRequerimiento" class="form-control"
                                           value="<%= obclsRequerimientos.getStFecha() != null ? obclsRequerimientos.getStFecha() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblSolicitante">Solicitante</label>
                                    <select class="form-control" name="ddlSolicitante">
                                        <%
                                            for (Models.clsContactos elem : lstclsContactos) {
                                        %>
                                        <option value="<%= elem.getInCodigo()%>" <%= obclsRequerimientos.obclsContactos != null ? obclsRequerimientos.obclsContactos.getInCodigo() == elem.getInCodigo() ? "selected" : "" : ""%>>
                                            <%= elem.getStNombres() + " " + elem.getStApellidos()%>
                                        </option>
                                        <%}
                                        %>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblCargo">Cargo</label>
                                    <input type="text" placeholder="Ingrese cargo" name="txtCargo" class="form-control"
                                           value="<%= obclsRequerimientos.getStCargo() != null ? obclsRequerimientos.getStCargo() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblNombreModulo">Nombre del modulo (ejecutable)</label>
                                    <input type="text" placeholder="Ingrese nombre del modulo (ejecutable)" name="txtNombreModulo" class="form-control"
                                           value="<%= obclsRequerimientos.getStNombreModulo() != null ? obclsRequerimientos.getStNombreModulo() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblOpcionModulo">Opción del modulo</label>
                                    <input type="text" placeholder="Ingrese opción del modulo" name="txtOpcionModulo" class="form-control"
                                           value="<%= obclsRequerimientos.getStOpcionModulo() != null ? obclsRequerimientos.getStOpcionModulo() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblVersionActualEjecutable">Versión actual del ejecutable</label>                                   
                                    <input type="text" placeholder="Ingrese versión actual del ejecutable" name="txtVersionActualEjecutable" class="form-control"
                                           value="<%= obclsRequerimientos.getStVersionActual() != null ? obclsRequerimientos.getStVersionActual() : ""%>"/>
                                </div>
                            </div>
                        </div>     
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblDescripcionDetallada">Descripcion detallada del requerimiento</label>
                                    <input type="text" placeholder="Ingrese descripcion detallada del requerimiento" name="txtDescripcionDetallada" class="form-control"
                                           value="<%= obclsRequerimientos.getStDescripcionDetallada() != null ? obclsRequerimientos.getStDescripcionDetallada() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblDuracion">Duración (Dias)</label>                                   
                                    <input type="text" placeholder="Ingrese duración (Dias)" name="txtDuracion" class="form-control"
                                           value="<%= obclsRequerimientos.getInDuracion() != 0 ? obclsRequerimientos.getInDuracion() : ""%>"/>
                                </div>
                            </div>
                        </div> 
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <label name="lblEstado">Estado</label>
                                    <select class="form-control" name="ddlEstado">                                        
                                        <option value="1" <%= obclsRequerimientos.obclsEstadoRequerimiento != null ? obclsRequerimientos.obclsEstadoRequerimiento.getInCodigo() == 1 ? "selected" : "" : ""%>>Pendiente</option>
                                        <option value="2" <%= obclsRequerimientos.obclsEstadoRequerimiento != null ? obclsRequerimientos.obclsEstadoRequerimiento.getInCodigo() == 2 ? "selected" : "" : ""%>>En progreso</option>
                                        <option value="3" <%= obclsRequerimientos.obclsEstadoRequerimiento != null ? obclsRequerimientos.obclsEstadoRequerimiento.getInCodigo() == 3 ? "selected" : "" : ""%>>Finalizado</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <!--FILA-->
                        <div class="form-group">
                            <div class="form-row">
                                <!--COLUMNA-->
                                <div class="col-12">
                                    <b>
                                        <i class="fa fa-clipboard"></i>
                                        Registros: <%= lstclsRequerimientos.size()%>
                                    </b>                                   
                                </div>                               
                            </div>
                        </div> 
                        <!--FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-12">
                                    <table class="table table-bordered 
                                           table-responsive">
                                        <tr> <!--FILA-->
                                            <td>Código</td> 
                                            <td>Fecha</td>
                                            <td>Solicitante</td>
                                            <td>Cargo</td>
                                            <td>Nombre del modulo</td>
                                            <td>Opción del modulo</td>                                           
                                            <td>Version actual</td>
                                            <td>Descripción detallada</td>
                                            <td>Duracion (dias)</td>
                                            <td>Estado</td>                                          
                                            <td>Opciones</td>
                                        </tr>

                                        <%
                                            for (Models.clsRequerimientos elem : lstclsRequerimientos) {
                                        %>
                                        <tr>
                                            <td><%=elem.getInCodigo()%></td>
                                            <td><%=elem.getStFecha()%></td>
                                            <td><%=elem.getObclsContactos().getStNombres() + " " + elem.getObclsContactos().getStApellidos()%></td>
                                            <td><%=elem.getStCargo() %></td>
                                            <td><%=elem.getStNombreModulo() %></td>
                                            <td><%=elem.getStOpcionModulo() %></td>
                                            <td><%=elem.getStVersionActual() %></td>
                                            <td><%=elem.getStDescripcionDetallada() %></td>
                                            <td><%=elem.getInDuracion() %></td>
                                            <td><%=elem.getObclsEstadoRequerimiento().getStDescripcion() %></td>                                                            
                                            <td>
                                                <a class="btn btn-success btn-sm" 
                                                   href="RequerimientosController?stOpcion=M&codigoSeleccionado=<%= elem.getInCodigo()%>">
                                                    Modificar</a>
                                            </td>
                                        </tr>
                                        <%
                                            }
                                        %>

                                    </table>
                                </div>
                            </div>                                
                        </div>
                    </form>
                </div>                
            </div>
        </div>
    </body>
</html>