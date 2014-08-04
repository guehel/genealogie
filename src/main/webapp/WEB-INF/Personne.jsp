<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserrer une personne</title>
</head>
<body>
<form action="/genealogie/personne"  method = "POST">

<table>
<tr><td>Personne</td><td><input id="idPersonne" name ='idPersonne' type="text"/></td>
</tr>
<tr>
<td>Pere</td><td><input id="idPere" name ='idPere' type="text"/></td>
</tr>
<tr>
<td>Mere</td><td><input id="idMere" name ='idMere' type="text"/></td>
</tr>
<td>Date de naissance </td><td><input id="naissance" name ='naissance' type="date"/></td>
</tr>
</table>
<input type = 'submit' value ='Envoyer'/>
</form>
</body>
</html>