<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recipe ${recipe.id }</title>
</head>
<body>
<form method="POST" action="/recipes">
	Titulo: <input type="text" name="titulo"/><br/>
	Problema: <input type="text" name="problema"/><br/>
	Solucao: <input type="text" name="solucao"/><br/>
 	<input type="submit" value="Criar Receita"/>
</form>
</body>
</html>