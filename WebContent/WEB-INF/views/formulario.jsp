<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Adicionar Contas</title>
</head>
<body>
	<h3>Adicionar Contas</h3>
	
	<form action="adicionaConta" method="post">
		<label>Descrição:</label>
		<br/>
		<textarea name="descricao" rows="5" cols="100"></textarea>
		<br/>
		<br/>
		<label>Valor:</label>
		<input type="text" name="valor"/>
		<br/>
		<br/>
		<label>Tipo:</label>
		<select name="tipo">
			<option value="ENTRADA">Entrada</option>
			<option value="SAIDA">Saída</option>
		</select>
		<br/>
		<br/>
		<input type="submit" value="Adicionar"/>
	</form>
</body>
</html>