<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
    <!-- Container Principal -->
    <form action="logar">
	    <div id="main" class="container" style="padding-bottom: 10px;">
	        <div class="jumbotron">
	            <h1> Login </h1>
	            <div class="row">
	            	    <div class="form-group col-md-4">
					    Usuário
					</div>
		            <div class="form-group col-md-4">
					    <input type="text" class="form-control" id="usuario.nome" name="nome">
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-4">
					    Senha
					</div>
		            <div class="form-group col-md-4">
					    <input type="password" class="form-control" id="password" name="password">
					</div>
				</div>
				<div id="actions" class="row">
	                <div class="col-md-12">
                		    <button type="submit" class="btn btn-primary">Acessar</button>
	                </div>
	            </div>
	        </div>
	    </div>
    </form>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>