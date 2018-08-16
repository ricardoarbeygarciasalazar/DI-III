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
                                    <input type="submit" value="Consultar" class="btn btn-primary" name="btnConsultar"/>
                                    <a href="IndexCliente.jsp" class="btn btn-primary">Volver</a>                                    
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblContacto">Solicitante</label>
                                    <select class="form-control" name="ddlContacto">
                                        <%
                                            for (Models.clsContactos elem : lstclsContactos) {
                                        %>
                                        <option value="<%= elem.getInCodigo()%>">
                                            <%= elem.getStNombres() + " " + elem.getStApellidos()%>
                                        </option>
                                        <%}
                                        %>
                                    </select>
                                </div>
                                <div class="col-md-6">
                                    <label name="lblEstado">Estado</label>
                                    <select class="form-control" name="ddlEstado">
                                        <option value="-1">Todos</option>                                        
                                        <option value="1">Pendiente</option>
                                        <option value="2">En progreso</option>
                                        <option value="3">Finalizado</option>
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
                                        </tr>

                                        <%
                                            for (Models.clsRequerimientos elem : lstclsRequerimientos) {
                                        %>
                                        <tr>
                                            <td><%=elem.getInCodigo()%></td>
                                            <td><%=elem.getStFecha()%></td>
                                            <td><%=elem.getObclsContactos().getStNombres() + " " + elem.getObclsContactos().getStApellidos()%></td>
                                            <td><%=elem.getStCargo()%></td>
                                            <td><%=elem.getStNombreModulo()%></td>
                                            <td><%=elem.getStOpcionModulo()%></td>
                                            <td><%=elem.getStVersionActual()%></td>
                                            <td><%=elem.getStDescripcionDetallada()%></td>
                                            <td><%=elem.getInDuracion()%></td>
                                            <td><%=elem.getObclsEstadoRequerimiento().getStDescripcion()%></td>                                                            

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