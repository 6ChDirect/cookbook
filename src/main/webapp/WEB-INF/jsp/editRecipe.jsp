<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Recipe</title>
<script type= "text/javascript" src= "js/jquery.js"></script>
<link rel= "stylesheet" href= "/static/css/bootstrap.css" />
</head>
<body>
	<div class= "container-fluid">
		<div class= "row-fluid">
			<div class= "span12" align= "center">
				<div class= "hero-unit">
					<h1>Cookbook Manager</h1>
				</div>
			</div>
		</div>
		
		<div class= "row-fluid">
			<div class= "span12">
				<div class= "navbar">
					<div class= "navbar-inner">
						<ul class= "nav">
							<li><a href= "/">Início</a></li>
						</ul>
						<form class= "navbar-search pull-right" method="POST" action="/recipes/search">
							<input type= "text" class= "search-query" placeholder= "Inserir palavra a pesquisar" name= "param"/>
							<button type= "submit" class= "btn">Procurar</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		
		<div class= "row-fluid">
			<div class= "span12">
				<div class= "row-fluid">
					<div class= "span3">
						<ul class= "nav nav-list">
							<li><a href="/recipes/create">Criar Receita</a></li>
							<li><a href="/recipes">Listar Receitas</a></li>
						</ul>
					</div>
					<div class= "span6" align= "center">
						<div class= "hero-unit">
							<h3>Editar Receita</h3>
						</div>
						<form class= "form-horizontal" method="POST" action="/recipes/${recipe.externalId}/edit">
							<div class= "control-group">
								<label class= "control-label" for= "inputTitulo">Titulo</label>
								<div class= "controls">
									<input type="text" value= "${recipe.lastVersion.titulo}" name="titulo"/>
								</div>
							</div>
							<div class= "control-group">
								<label class= "control-label" for= "inputProblema">Problema</label>
								<div class= "controls">
									<input type="text" value= "${recipe.lastVersion.problema}" name="problema"/>
								</div>
							</div>
							<div class= "control-group">
								<label class= "control-label" for= "inputSolucao">Solução</label>
								<div class= "controls">
									<input type="text" value= "${recipe.lastVersion.solucao}" name="solucao"/>
								</div>
							</div>
							<div class= "control-group">
								<label class= "control-label" for= "inputAutor">Autor</label>
								<div class= "controls">
									<input type="text" value= "${recipe.lastVersion.autor}" name="autor"/>
								</div>
							</div>
							<div class= "control-group">
								<label class= "control-label" for= "inputClassificacao">Classificação</label>
								<div class= "controls">
									<input type="text" value= "${recipe.lastVersion.classificacao}" name="classificacao"/>
								</div>
							</div>
							<div class= "form-actions">
								<button type= "submit" class= "btn btn-success">Guardar</button>
								<button type= "reset" class= "btn btn-danger">Cancelar</button>
							</div>
						</form>
						<p><br/></p>
						<p><br/></p>
						<p><br/></p>
					</div>
					<div class= "span3">
					</div>
				</div>			
			</div>
		</div>
	</div>
</body>
</html>