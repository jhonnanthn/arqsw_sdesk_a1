<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Listar Chamados</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/jquery.dataTables.min.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
    <c:import url="Menu.jsp" />
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Consultar Chamados</h3>
        <form action="listar_chamados_exibir" method="get">
            <div class="row">
                <div class="form-group col-md-12">
				    <table id="example" class="display" cellspacing="0" width="100%">
				        <thead>
				            <tr>
				                <th>Nº</th>
				                <th>Fila</th>
				                <th>Descrição</th>
				                <th>Status</th>
				                <th>Abertura</th>
				                <th>Fechamento</th>
				            </tr>
				        </thead>
				        <tfoot>
				            <tr>
				                <th>Nº</th>
				                <th>Fila</th>
				                <th>Descrição</th>
				                <th>Status</th>
				                <th>Abertura</th>
				                <th>Fechamento</th>
				            </tr>
				        </tfoot>
				        <tbody>
				            <c:forEach var="chamado" items="${chamado}">
					            <tr>
					                <td>${chamado.numero}</td>
					                <td>${chamado.fila.nome}</td>
					                <td>${chamado.nome}</td>
					                <td>${chamado.status}</td>
					                <td>${chamado.dataAbertura}</td>
					                <td>${chamado.dataFechamento}</td>
					            </tr>
				            </c:forEach>

				        </tbody>
				    </table>
                </div>
            </div>
            <div id="actions" class="row">
                <div class="col-md-12">
                    <a href="listar_filas_exibir" class="btn btn-default">Voltar</a>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.dataTables.min.js"></script>
    <script>
	    $(document).ready(function() {
	        $('#example').DataTable( {
	            scrollY:        '50vh',
	            scrollCollapse: true,
	            paging:         false
	        } );
	    } );
    </script>
</body>

</html>