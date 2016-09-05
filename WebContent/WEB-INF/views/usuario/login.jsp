<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login do Usuário</title>
</head>
<body>
	<h3>Seja bem vindo - Usuario :)</h3>
	
	<form action="efetuaLogin" method="post">
		<label>Login:</label>
		<br/>
		<input type="text" name="login" />
		<form:errors path="conta.descricao" />
		<br/>
		<br/>
		<label>Senha:</label>
		<input type="password" name="senha" />
		<br/>
		<br/>
		<input type="submit" value="Entrar nas contas"/>
	</form>
</body>
</html>