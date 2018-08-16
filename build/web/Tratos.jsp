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
        <title>Tratos</title>
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
            //DECLARAMOS EL TIPO DE OBJETO A RESIVIR
            Models.clsTratos obclsTratos = new Models.clsTratos();
            //VALIDAMOS DE QUE EL OBJETO NO SEA NULO Y LE ASIGNAMOS AL OBJETO EL VALOR DEL OBJETO
            if (request.getAttribute("obclsTratos") != null) {
                obclsTratos = (Models.clsTratos) request.getAttribute("obclsTratos");
            }

            //INSTANCIO LSITA DE OBJETO
            List<Models.clsTratos> lstclsTratos = new ArrayList<Models.clsTratos>();

            //VALIDO QUE LA VARIABLE DE SESION CONTENGA VALORES
            if (request.getAttribute("lstclsTratos") != null) {
                //REALIZO CAST PARA DEFINIR QUE TIPO DE OBJETO ALMACENA LA VARIABLE DE SESION
                //ASIGNO VARIABLE DE SESION A OBJETO
                lstclsTratos = (List<Models.clsTratos>) request.getAttribute("lstclsTratos");
            }
        %>
        <div class="container">
            <div class="card mx-auto mt-5">
                <div class="card-header">Crear Tratos - Registros: (<%=lstclsTratos.size()%>)
                    <p>
                        En caso de que esas conversaciones sean ventas, puedes abrir un trato con ese
                        contacto.
                    </p>
                </div>

                <div class="card-body">
                    <form action="TratosController" method="POST">
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <input type="submit" value="Guardar" class="btn btn-primary" name="btnGuardar"/>
                                    <input type="submit" value="Modificar" class="btn btn-primary" name="btnModificar"/>
                                    <input type="submit" value="Cancelar" class="btn btn-primary" name="btnCancelar"/>
                                    <a href="Index.jsp" class="btn btn-primary">Volver</a>
                                    <input type="text"
                                           name="codigoModificar"
                                           value="<%=obclsTratos.getInCodigo() != 0
                                                   ? obclsTratos.getInCodigo() : ""%>"
                                           hidden=""/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <h1>Información sobre el trato</h1>                                
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblImporte">Importe</label>
                                    <input type="text" placeholder="Importe" name="txtImporte" 
                                           class="form-control" 
                                           value="<%=obclsTratos.getStImporte() != null ? obclsTratos.getStImporte() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblNombre">Nombre de trato</label>
                                    <input type="text" placeholder="Nombre de trato" name="txtNombre" class="form-control" value="<%=obclsTratos.getStNombre() != null ? obclsTratos.getStNombre() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblFechaCierre">Fecha de cierre</label>
                                    <input type="date" name="txtFechaCierre" class="form-control" value="<%=obclsTratos.getStFechaCierre() != null ? obclsTratos.getStFechaCierre() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblNumeroCuenta">Numero de cuenta</label>
                                    <input type="text" placeholder="Numero de cuenta" name="txtNumeroCuenta" class="form-control" value="<%=obclsTratos.getStNumeroCuenta() != null ? obclsTratos.getStNumeroCuenta() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblFase">Fase</label>
                                    <select class="form-control" name="ddlFase">
                                        <option value="-1" <%=obclsTratos.getObclsFaseTrato() != null ? obclsTratos.getObclsFaseTrato().getInCodigo() == -1 ? "Selected" : "" : ""%>>Seleccione</option>
                                        <option value="1" <%=obclsTratos.getObclsFaseTrato() != null ? obclsTratos.getObclsFaseTrato().getInCodigo() == 1 ? "Selected" : "" : ""%>>Ninguno</option>
                                        <option value="2" <%=obclsTratos.getObclsFaseTrato() != null ? obclsTratos.getObclsFaseTrato().getInCodigo() == 2 ? "Selected" : "" : ""%>>Clasificacion</option>
                                        <option value="3" <%=obclsTratos.getObclsFaseTrato() != null ? obclsTratos.getObclsFaseTrato().getInCodigo() == 3 ? "Selected" : "" : ""%>>Necesita analisis</option>
                                        <option value="4" <%=obclsTratos.getObclsFaseTrato() != null ? obclsTratos.getObclsFaseTrato().getInCodigo() == 4 ? "Selected" : "" : ""%>>Propuesta de valor</option>
                                        <option value="5" <%=obclsTratos.getObclsFaseTrato() != null ? obclsTratos.getObclsFaseTrato().getInCodigo() == 5 ? "Selected" : "" : ""%>>Identificar responsables</option>
                                        <option value="6" <%=obclsTratos.getObclsFaseTrato() != null ? obclsTratos.getObclsFaseTrato().getInCodigo() == 6 ? "Selected" : "" : ""%>>Cotizacion de propuesta/precio</option>
                                    </select>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblTipo">Tipo</label>
                                    <select class="form-control" name="ddlTipo">
                                        <option value="-1" <%=obclsTratos.getObclsTipoTrato() != null ? obclsTratos.getObclsTipoTrato().getInCodigo() == -1 ? "Selected" : "" : ""%>>Seleccione</option>
                                        <option value="1" <%=obclsTratos.getObclsTipoTrato() != null ? obclsTratos.getObclsTipoTrato().getInCodigo() == 1 ? "Selected" : "" : ""%>>Negocios existentes</option>
                                        <option value="2" <%=obclsTratos.getObclsTipoTrato() != null ? obclsTratos.getObclsTipoTrato().getInCodigo() == 2 ? "Selected" : "" : ""%>>Nuevo negocio</option>
                                    </select>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblProbabilidad">Probabilidad</label>
                                    <input type="number" placeholder="Probabilidad" name="txtProbabilidad" class="form-control" value="<%=obclsTratos.getDbProbabilidad()%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblSiguientePaso">Siguiente paso</label>
                                    <input type="text" placeholder="Siguiente paso" name="txtSiguientePaso" class="form-control" value="<%=obclsTratos.getStSiguientePaso() != null ? obclsTratos.getStSiguientePaso() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblIngresosEsperados">Ingresos esperados</label>
                                    <input type="number" placeholder="Ingresos esperados" name="txtIngresosEsperados" class="form-control" value="<%=obclsTratos.getDbIngresosEsperados()%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblFuentePosibleCliente">Fuente de posible cliente</label>
                                    <select class="form-control" name="ddlFuentePosibleCliente">
                                        <option value="-1" <%=obclsTratos.getObclsFuentePosibleCliente() != null ? obclsTratos.getObclsFuentePosibleCliente().getInCodigo() == -1 ? "Selected" : "" : ""%>>Seleccione</option>
                                        <option value="1" <%=obclsTratos.getObclsFuentePosibleCliente() != null ? obclsTratos.getObclsFuentePosibleCliente().getInCodigo() == 1 ? "Selected" : "" : ""%>>Ninguno</option>
                                        <option value="2" <%=obclsTratos.getObclsFuentePosibleCliente() != null ? obclsTratos.getObclsFuentePosibleCliente().getInCodigo() == 2 ? "Selected" : "" : ""%>>Aviso</option>
                                        <option value="3" <%=obclsTratos.getObclsFuentePosibleCliente() != null ? obclsTratos.getObclsFuentePosibleCliente().getInCodigo() == 3 ? "Selected" : "" : ""%>>Llamada no solicitada</option>
                                        <option value="4" <%=obclsTratos.getObclsFuentePosibleCliente() != null ? obclsTratos.getObclsFuentePosibleCliente().getInCodigo() == 4 ? "Selected" : "" : ""%>>Recomendacion de empleado</option>
                                        <option value="5" <%=obclsTratos.getObclsFuentePosibleCliente() != null ? obclsTratos.getObclsFuentePosibleCliente().getInCodigo() == 5 ? "Selected" : "" : ""%>>Recomendacion externa</option>
                                        <option value="6" <%=obclsTratos.getObclsFuentePosibleCliente() != null ? obclsTratos.getObclsFuentePosibleCliente().getInCodigo() == 6 ? "Selected" : "" : ""%>>Tienda en linea</option>
                                    </select>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblFuenteCampana">Fuente de campaña</label>
                                    <input type="text" placeholder="Fuente de campaña" name="txtFuenteCampana" class="form-control" value="<%=obclsTratos.getStFuenteCampaña() != null ? obclsTratos.getStFuenteCampaña() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblNombreContacto">Nombre de contacto</label>
                                    <input type="text" placeholder="Nombre de contacto" name="txtNombreContacto" class="form-control" value="<%=obclsTratos.getStNombreContacto() != null ? obclsTratos.getStNombreContacto() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-12">
                                    <label name="lblDescripcion">Descripción</label>
                                    <input type="text" placeholder="Descripción" name="txtDescripcion" class="form-control" value="<%=obclsTratos.getStDescripcion() != null ? obclsTratos.getStDescripcion() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!--FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <table class="table table-bordered table-responsive">
                                        <tr> <!--FILA-->
                                            <td>Codigo</td>
                                            <td>Importe</td> <!--COLUMNA-->
                                            <td>Nombre</td>
                                            <td>Fecha de Cierre</td>
                                            <td>N˙mero de Cuenta</td>
                                            <td>Fase Trato</td>
                                            <td>Tipo Trato</td>
                                            <td>Probabilidad</td>
                                            <td>Siguiente Paso</td>
                                            <td>Ingresos Esperados</td>
                                            <td>Fuente Posible Cliente</td>
                                            <td>Fuente Campaña</td>
                                            <td>Nombre de Contacto</td>
                                            <td>Descripción</td>
                                            <td>Opciones</td>
                                        </tr>

                                        <%
                                            for (Models.clsTratos elem : lstclsTratos) {
                                        %>
                                        <tr>
                                            <td><%=elem.getInCodigo()%></td>
                                            <td><%=elem.getStImporte()%></td>
                                            <td><%=elem.getStNombre()%></td>
                                            <td><%=elem.getStFechaCierre()%></td>
                                            <td><%=elem.getStNumeroCuenta()%></td>
                                            <td><%=elem.obclsFaseTrato.getStDescripcion()%></td>
                                            <td><%=elem.obclsTipoTrato.getStDescripcion()%></td>
                                            <td><%=elem.getDbProbabilidad()%></td>
                                            <td><%=elem.getStSiguientePaso()%></td>
                                            <td><%=elem.getDbIngresosEsperados()%></td>
                                            <td><%=elem.obclsFuentePosibleCliente.getStDescripcion()%></td>
                                            <td><%=elem.getStFuenteCampaña()%></td>
                                            <td><%=elem.getStNombreContacto()%></td>
                                            <td><%=elem.getStDescripcion()%></td>
                                            <td>
                                                <a href="TratosController?stOpcion=M&codigoSeleccionado=<%=elem.getInCodigo()%>"
                                                   class="btn btn-success btn-sm">
                                                    Modificar</a>
                                                <a href="TratosController?stOpcion=E&codigoSeleccionado=<%=elem.getInCodigo()%>"
                                                   class="btn btn-danger btn-sm">
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