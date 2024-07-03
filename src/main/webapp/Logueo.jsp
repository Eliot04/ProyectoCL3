<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <title>Ingresar al sistema</title>
</head>
<body bgcolor="#c5dec9">
    <h2 align="center">Iniciar Sesión</h2>
    <form action="ControladorUsuario" method="post">
        <table border="2" align="center" cellpadding="5" cellspacing="0">
            <tr>
                <td><label for="usuario">Usuario:</label></td>
                <td><input type="text" id="usuario" name="usuario" required></td>
            </tr>
            <tr>
                <td><label for="password">Contraseña:</label></td>
                <td><input type="password" id="password" name="password" required></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Iniciar Sesión">
                </td>
            </tr>
            <tr>
                
            </tr>
        </table>
    </form>
</body>
</html>
