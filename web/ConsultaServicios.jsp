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
        <title>Servicios</title>
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
            List<Models.clsServicios> lstclsServicios = new ArrayList<Models.clsServicios>();
            
            if (request.getAttribute("lstclsServicios") != null) {
                lstclsServicios = (List<Models.clsServicios>) request.getAttribute("lstclsServicios");
            }
        %>      
        <div class="container">
            <div class="card mx-auto mt-5">
                <div class="card-header">Servicios
                </div>
                <div class="card-body">
                    <form action="ServiciosController" method="POST">
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <input type="submit" value="Consultar" class="btn btn-primary" name="btnConsultar"/>
                                    <a href="Index.jsp" class="btn btn-primary">Volver</a>                                    
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-4">
                                    <label name="lblEmpresa">Empresa</label>
                                    <input type="text" placeholder="Ingrese empresa" name="txtEmpresa" class="form-control"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-4">
                                    <label name="lblNIT">NIT</label>
                                    <input type="text" placeholder="Ingrese NIT" name="txtNIT" class="form-control"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-4">
                                    <label name="lblResponsable">Responsable</label>                                   
                                    <input type="text" placeholder="Ingrese responsable" name="txtResponsable" class="form-control"/>
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
                                        Registros: <%= lstclsServicios.size()%>
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
                                            <td>Empresa</td>
                                            <td>NIT</td>
                                            <td>Nombre completo</td>
                                            <td>Telefono</td>
                                            <td>Correo</td>                                           
                                            <td>Accion</td>
                                            <td>Descripcion</td>
                                            <td>Fecha inicio vigencia</td>
                                            <td>Fecha fin vigencia</td>                                          
                                            <td>Responsable</td>
                                            <td>Fecha entrega</td>
                                        </tr>
                                        <%
                                            for (Models.clsServicios elem : lstclsServicios) {
                                        %>
                                        <tr>
                                            <td><%=elem.getInCodigo()%></td>
                                            <td><%=elem.getStEmpresa()%></td>                                            
                                            <td><%=elem.getStNIT()%></td>
                                            <td><%=elem.getStNombreCompleto()%></td>
                                            <td><%=elem.getStTelefono()%></td>
                                            <td><%=elem.getStCorreo()%></td>
                                            <td><%=elem.getObclsAccion().getStDescripcion() %></td>
                                            <td><%=elem.getStDescripcion()%></td>
                                            <td><%=elem.getStFechaInicioVigencia()%></td>
                                            <td><%=elem.getStFechaFinVigencia()%></td>
                                            <td><%=elem.getStResponsable()%></td>
                                            <td><%=elem.getStFechaEntrega()%></td>
                                            
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