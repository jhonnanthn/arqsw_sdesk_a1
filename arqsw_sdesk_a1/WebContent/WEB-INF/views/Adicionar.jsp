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
    <title>Adicionar Chamado</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    
</head>
<body>
    <!-- Barra superior com os menus de navegação -->
    <c:import url="Menu.jsp" />
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Selecione o tipo que deseja adicionar</h3>
        <div class="row">
            <div class="col-md-12">
                <a class="btn btn-primary menuAdicionar" data-tipo="fila">Fila</a>
                <a class="btn btn-danger menuAdicionar" data-tipo="chamado">Chamado</a>
            </div>
        </div>
        <div class="hide" id="chamado">
	        <h3 class="page-header">Adicionar Chamados</h3>
	        <form action="adicionar_chamado" method="get">
	            <div class="row">
	                <div class="form-group col-md-4">
	                    <label for="fila">Escolha a Fila:</label>
	                    <form:errors path="fila.id" cssStyle="color:red"/><br>
	                    <select class="form-control" name="id">
	                        <option value="0"></option>
	                        <c:forEach var="fila" items="${filas}">
	                            <option value="${fila.id}">${fila.nome}</option>
	                        </c:forEach>
	                    </select>
	                </div>
	            </div>
	            <div class="row">
		            <div class="form-group col-md-4">
					    <label for="descricao">Descrição</label>
					    <textarea class="form-control" id="chamado.nome" name="nome" rows="3"></textarea>
					</div>
				</div>
	            <div id="actions" class="row">
	                <div class="col-md-12">
	                    <button type="submit" class="btn btn-primary" >Salvar</button>
	                    <a href="index" class="btn btn-default">Cancelar</a>
	                </div>
	            </div>
	        </form>
	    </div>
	    <div class="hide" id="fila">
	        <h3 class="page-header">Adicionar Fila</h3>
	        <form action="adicionar_fila" method="get">
	            <div class="row">
	                <div class="form-group col-md-4">
	                    <label for="nome">Nome</label>
	                    <input type="text" class="form-control" name="nome" id="nome"/>
	                </div>
	            </div>
	            <div class="row">
		             <div class="form-group col-md-4">
	                    <label for="Imagem">Imagem</label>
	                    <input type="text" class="form-control" name="figura" id="figura"/>
	                </div>
				</div>
	            <div id="actions" class="row">
	                <div class="col-md-12">
	                    <button type="submit" class="btn btn-primary" >Salvar</button>
	                    <a href="index" class="btn btn-default">Cancelar</a>
	                </div>
	            </div>
	         </form>
	     </div>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
	    $( ".menuAdicionar" ).click(function() {
	    	  menu = $(this).attr("data-tipo");
	    	  if(menu == 'fila'){
	    		  $("#fila").removeClass("hide");
	    		  $("#chamado").addClass("hide");
	    	  } else if(menu == 'chamado'){
	    		  $("#chamado").removeClass("hide");
	    		  $("#fila").addClass("hide");
	    	  }
	    	});
    </script>
</body>

</html>