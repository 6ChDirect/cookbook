<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Homepage</title>
</head>
<body>
	<form method="POST" action="/recipes">
	Titulo: <input type="text" name="titulo"/><br/>
	Problema: <input type="text" name="problema"/><br/>
	Solução: <input type="text" name="solucao"/><br/>
	Autor: <input type="text" name="autor"/><br/>
	<input type="submit" value="Criar Nova Receita"/>
	</form>
</body>
</html>