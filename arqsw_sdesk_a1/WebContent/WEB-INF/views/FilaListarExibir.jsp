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
        <h3 class="page-header">Consultar Filas</h3>
        <div class="modal fade  bs-example-modal-lg" id="myModal"  style="overflow:hidden">
			<div class="modal-dialog  modal-lg" style="width:20%">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title">Editar</h4>
					</div>
					<div class="modal-body">
						<div class="box-body">
							<div class="row">
								<div class="col-sm-12">
									<div class="form group input-group col-sm-12">
										<label for="txtNome" class="control-label">Nome</label>
										<div class="input-group col-sm-12">
											<input id="txtNome" class="form-control" style="text-transform: uppercase;" data-identifvisitado="visitado" maxlength="25" />
										</div> 
										<p class="erro hide" id="erroNome" style="color: rgb(221, 90, 67); font-weight: bold;"><i class="ace-icon fa fa-exclamation-circle bigger-110"></i> Preenchimento Obrigatório. </p> 
									</div>
									<div class="form group input-group col-sm-12">
										<label for="txtImagem" class="control-label">Imagem</label>
										<div class="input-group col-sm-12">
											<input id="txtImagem" class="form-control" style="text-transform: uppercase;" maxlength="25" />
										</div> 
										<p class="erro hide" id="erroImagem" style="color: rgb(221, 90, 67); font-weight: bold;"><i class="ace-icon fa fa-exclamation-circle bigger-110"></i> Preenchimento Obrigatório. </p> 
									</div>
								</div>
							</div>
						</div>
						<br>
						<div class="modal-footer">
						<!--         <button type="button" class="btn btn-warning backToPage" data-backpage="adicionar" data-dismiss="modal"><i class="fa fa-arrow-left"></i> Voltar</button> -->
						        <button type="button" class="btn" style="background-color: #15A2C1; color: white" id="btnEditar"> <i class="fa fa-floppy-o"></i> Editar</button>
					      </div>
					</div>
				</div>
			</div>
		</div>
        <form action="listar_chamados_exibir" method="get">
        		<input type="hidden" id="idFila">
            <div class="row">
                <div class="form-group col-md-12">
				    <table id="example" class="display" cellspacing="0" width="100%">
				        <thead>
				            <tr>
				                <th>Fila</th>
				                <th>Imagem</th>
				                	<th></th>
				            </tr>
				        </thead>
				        <tfoot>
				            <tr>
				                <th>Fila</th>
				                <th>Imagem</th>
				                <th></th>
				            </tr>
				        </tfoot>
				        <tbody>
				            <c:forEach var="fila" items="${fila}">
					            <tr>
					                <td>${fila.nome}</td>
					                <td>${fila.figura}</td>
					                <td>
					                		<input type="hidden" name="id">
					                		<a type="submit" class="btn btn-danger pull-right removerFila" data-id="${fila.id}">Excluir</a>
					                		<a type="submit" class="btn btn-warning pull-right editarFila" data-id="${fila.id}" data-nome="${fila.nome }" data-imagem="${fila.figura }" style="margin-right: 3px;">Editar</a>
					                	</td>
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
	    
	    $( ".removerFila" ).click(function() {
	    		idFila = $(this).attr("data-id");
	    		var requestData = {
	    				id: idFila
	    		};
		    $.get('${pageContext.request.contextPath}/rest/removeFila/' + idFila,requestData,function(data){
		    		if(data == 'OK'){
		    			alert('Deletado com sucesso!');
		    			location.reload();
		    		} else{
		    			alert('Falha!');
		    		}
		    		console.log(data);
		    });
	    	});
	    
	    $( ".editarFila" ).click(function(e) {
	    		e.preventDefault();
	    		$('.erro').addClass('hide');
	    		idFila = $(this).attr("data-id");
	    		nome = $(this).attr("data-nome");
	    		imagem = $(this).attr("data-imagem");

			$('#txtNome').val(nome);
			$('#txtImagem').val(imagem);
			$('#idFila').val(idFila);
			$("#myModal").modal({
				"keyboard": false,
				"show":true
			})
			
	    	});
	    
	    $( "#btnEditar" ).click(function() {
    		var requestData = {
    				id: $('#idFila').val(),
    				nome: $('#txtNome').val(),
    				imagem: $('#txtImagem').val()
    		};
	    $.get('${pageContext.request.contextPath}/rest/editarFila',requestData,function(data){
	    		if(data == 'Alterado'){
	    			alert('Alterado com sucesso!');
	    			location.reload();
	    		} else{
	    			alert('Falha!');
	    		}
	    });
    	});

    </script>
</body>

</html>