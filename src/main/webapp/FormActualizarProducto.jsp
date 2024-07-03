<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.TblProductocl3" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Producto</title>
</head>
<body bgcolor="#c5dec9">
<h1 align="center">Actualizar Producto</h1>

<form method="post" action="ControladorProducto">
<%
    String cod = (request.getAttribute("codigo") != null) ? request.getAttribute("codigo").toString() : "";
    String nom = (request.getAttribute("nombre") != null) ? request.getAttribute("nombre").toString() : "";
    String pv = (request.getAttribute("precioventa") != null) ? request.getAttribute("precioventa").toString() : "";
    String pc = (request.getAttribute("preciocomp") != null) ? request.getAttribute("preciocomp").toString() : "";
    String est = (request.getAttribute("estado") != null) ? request.getAttribute("estado").toString() : "";
    String desc = (request.getAttribute("descrip") != null) ? request.getAttribute("descrip").toString() : "";
%>

<table align="center" border="2">
<input type="hidden" name="codigo" value="<%=cod%>">
<tr>
    <td>Nombre</td>
    <td>
        <input type="text" name="nombre" value="<%=nom%>">
    </td>
</tr>
<tr>
    <td>Precio de Venta</td>
    <td><input type="text" name="precioventa" value="<%=pv%>"></td>
</tr>
<tr>
    <td>Precio de Compra</td>
    <td><input type="text" name="preciocomp" value="<%=pc%>"></td>
</tr>
<tr>
    <td>Estado</td>
    <td><input type="text" name="estado" value="<%=est%>"></td>
</tr>
<tr>
    <td>Descripción</td>
    <td><input type="text" name="descrip" value="<%=desc%>"></td>
</tr>
<tr>
    <td colspan="2" align="center"><input type="submit" value="Actualizar Producto"></td>
</tr>
</table>
</form>

</body>
</html>
