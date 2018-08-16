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
        <title>Llamadas</title>
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
            List<Models.clsLlamadas> lstclsLlamadas = new ArrayList<Models.clsLlamadas>();
            Models.clsLlamadas obclsLlamadas = new Models.clsLlamadas();

            if (request.getAttribute("obclsLlamadas") != null) {
                obclsLlamadas = (Models.clsLlamadas) request.getAttribute("obclsLlamadas");
            }
            if (request.getAttribute("lstclsLlamadas") != null) {
                lstclsLlamadas = (List<Models.clsLlamadas>) request.getAttribute("lstclsLlamadas");
            }
        %>      
        <div class="container">
            <div class="card mx-auto mt-5">
                <div class="card-header">Crear llamada
                    <p>
                        Todas las conversaciones con los clientes se guardan en la ficha del propio cliente
                        que es accesible por todos los trabajadores de tu empresa. Así evitas la pérdida de
                        tiempo y productividad que ocurre cuando envías recibes emails pidiendo y
                        solicitando información a otros compañeros de trabajo.
                    </p>
                </div>
                <div class="card-body">
                    <form action="LlamadasController" method="POST">
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <input type="submit" value="Guardar" class="btn btn-primary" name="btnGuardar"/>
                                    <input type="submit" value="Modificar" class="btn btn-primary" name="btnModificar"/>
                                    <input type="submit" value="Cancelar" class="btn btn-primary" name="btnCancelar"/>
                                    <a href="Index.jsp" class="btn btn-primary">Volver</a>
                                    <input type="text" hidden=""
                                           name="codigoSeleccionado"
                                           value="<%= obclsLlamadas.getInCodigo()%>"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <h1>Información sobre la llamada</h1>                                
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblNombreContacto">Nombre de contacto</label>
                                    <input type="text" placeholder="Nombre de contacto" name="txtNombreContacto" class="form-control"
                                           value="<%= obclsLlamadas.getStContacto() != null ? obclsLlamadas.getStContacto() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblAsunto">Asunto</label>
                                    <input type="text" placeholder="Asunto" name="txtAsunto" class="form-control"
                                           value="<%= obclsLlamadas.getStAsunto() != null ? obclsLlamadas.getStAsunto() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblProposito">Proposito de la llamada</label>
                                    <select class="form-control" name="ddlProposito">                                        
                                        <option value="1" <%= obclsLlamadas.obclsProposito != null ? obclsLlamadas.obclsProposito.getInCodigo() == 1 ? "selected" : "" : ""%>>Ninguno</option>
                                        <option value="2" <%= obclsLlamadas.obclsProposito != null ? obclsLlamadas.obclsProposito.getInCodigo() == 2 ? "selected" : "" : ""%>>Posible</option>
                                        <option value="3" <%= obclsLlamadas.obclsProposito != null ? obclsLlamadas.obclsProposito.getInCodigo() == 3 ? "selected" : "" : ""%>>Administrativo</option>
                                        <option value="4" <%= obclsLlamadas.obclsProposito != null ? obclsLlamadas.obclsProposito.getInCodigo() == 4 ? "selected" : "" : ""%>>Negociacion</option>
                                        <option value="5" <%= obclsLlamadas.obclsProposito != null ? obclsLlamadas.obclsProposito.getInCodigo() == 5 ? "selected" : "" : ""%>>Demostracion</option>
                                        <option value="6" <%= obclsLlamadas.obclsProposito != null ? obclsLlamadas.obclsProposito.getInCodigo() == 6 ? "selected" : "" : ""%>>Proyecto</option>
                                    </select>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblRelacionadoCon">Relacionado con</label>
                                    <select name="ddlRelacionadoCon" class="form-control">                                        
                                        <option value="1" <%= obclsLlamadas.obclsRelacionadoCon != null ? obclsLlamadas.obclsRelacionadoCon.getInCodigo() == 1 ? "selected" : "" : ""%>>Posible cliente</option>
                                        <option value="2" <%= obclsLlamadas.obclsRelacionadoCon != null ? obclsLlamadas.obclsRelacionadoCon.getInCodigo() == 2 ? "selected" : "" : ""%>>Contacto</option>
                                        <option value="3" <%= obclsLlamadas.obclsRelacionadoCon != null ? obclsLlamadas.obclsRelacionadoCon.getInCodigo() == 3 ? "selected" : "" : ""%>>Otros</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblTipo">Tipo de llamada</label><br/>
                                    <input type="radio" name="rbTipo" value="1" <%= obclsLlamadas.obclsTipoLlamada != null ? obclsLlamadas.obclsTipoLlamada.getInCodigo() == 1 ? "selected" : "" : ""%>/>Llamada actual<br/>
                                    <input type="radio" name="rbTipo" value="2" <%= obclsLlamadas.obclsTipoLlamada != null ? obclsLlamadas.obclsTipoLlamada.getInCodigo() == 2 ? "selected" : "" : ""%>/>Llamada completada<br/>
                                    <input type="radio" name="rbTipo" value="3" <%= obclsLlamadas.obclsTipoLlamada != null ? obclsLlamadas.obclsTipoLlamada.getInCodigo() == 3 ? "selected" : "" : ""%>/>Programar llamada<br/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblDetalles">Detalles de la llamada</label>                                   
                                    <input type="text" placeholder="Detalles de la llamada" name="txtDetalles" class="form-control"
                                           value="<%= obclsLlamadas.getStDetalles() != null ? obclsLlamadas.getStDetalles() : ""%>"/>
                                </div>
                            </div>
                        </div>     
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblFecha">Fecha</label>
                                    <input type="date" name="txtFecha" class="form-control"
                                           value="<%= obclsLlamadas.getStFecha() != null ? obclsLlamadas.getStFecha() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblDuracion">Duración (Minutos)</label>                                   
                                    <input type="text" placeholder="Duración (Minutos)" name="txtDuracion" class="form-control"
                                           value="<%= obclsLlamadas.getInDuracion() != 0 ? obclsLlamadas.getInDuracion() : ""%>"/>
                                </div>
                            </div>
                        </div> 
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <label name="lblDescripcion">Descripción</label>
                                    <input type="text" placeholder="Descripcion" name="txtDescripcion" class="form-control"
                                           value="<%= obclsLlamadas.getStDescripcion() != null ? obclsLlamadas.getStDescripcion() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <label name="lblResultado">Resultado de la llamada</label>
                                    <input type="text" placeholder="Resultado de la llamada" name="txtResultado" class="form-control"
                                           value="<%= obclsLlamadas.getStResultado() != null ? obclsLlamadas.getStResultado() : ""%>"/>
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
                                        Registros: <%= lstclsLlamadas.size()%>
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
                                            <td>Código</td> <!--COLUMNA-->
                                            <td>Nombre</td>
                                            <td>Asunto</td>
                                            <td>Proposito de la llamada</td>
                                            <td>Relacionado con</td>
                                            <td>Tipo de llamada</td>                                           
                                            <td>Detalles de la llamada</td>
                                            <td>Fecha</td>
                                            <td>Duracion (minutos)</td>
                                            <td>Descripcion</td>
                                            <td>Resultado de la llamada</td>                                           
                                            <td>Opciones</td>
                                        </tr>

                                        <%
                                            for (Models.clsLlamadas elem : lstclsLlamadas) {
                                        %>
                                        <tr>
                                            <td><%=elem.getInCodigo()%></td>
                                            <td><%=elem.getStContacto()%></td>
                                            <td><%=elem.getStAsunto()%></td>
                                            <td><%=elem.obclsProposito.getStDescripcion()%></td>
                                            <td><%=elem.obclsRelacionadoCon.getStDescripcion()%></td>
                                            <td><%=elem.obclsTipoLlamada.getStDescripcion()%></td>
                                            <td><%=elem.getStDetalles()%></td>
                                            <td><%=elem.getStFecha()%></td>
                                            <td><%=elem.getInDuracion()%></td>
                                            <td><%=elem.getStDescripcion()%></td>
                                            <td><%=elem.getStResultado()%></td>                                                                                             
                                            <td>
                                                <a class="btn btn-success btn-sm" 
                                                   href="PosiblesClientesController?stOpcion=M&codigoSeleccionado=<%= elem.getInCodigo()%>">
                                                    Modificar</a>
                                                <a class="btn btn-danger btn-sm" 
                                                   href="PosiblesClientesController?stOpcion=E&codigoSeleccionado=<%= elem.getInCodigo()%>">
                                                    Eliminar</a>
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