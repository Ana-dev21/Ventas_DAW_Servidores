<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Clientes</title>
</head>
<body>
    <h1>Clientes</h1>
    <table>
        <tr>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Ciudad</th>
            <th>Categoria</th>
            <th>Opciones</th>
        </tr>
        <c:forEach items="${clientes}" var="cliente">
            <tr>
                <td>${cliente.nombre}</td>
                <td>${cliente.apellido1} ${cliente.apellido2}</td>
                <td>${cliente.ciudad}</td>
                <td>${cliente.categoria}</td>
                <td>
                    <a href="clientes/editar/${cliente.idCliente}">Editar</a>
                    <a href="clientes/eliminar/${cliente.idCliente}">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <h2>Buscar</h2>
    <form action="/clientes/verPorCiudad" method="post">
        <input type="search" name="ciudad" placeholder="Ciudad">
        <input type="submit" value="Buscar">
    </form>
</body>