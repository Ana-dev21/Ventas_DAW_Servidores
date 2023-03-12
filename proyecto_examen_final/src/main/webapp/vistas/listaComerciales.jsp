<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Comerciales</title>
</head>
<body>
    <h1>Comerciales</h1>
    <table>
        <tr>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Comisión</th>
            <th>Opciones</th>
        </tr>
        <c:forEach items="${comerciales}" var="comercial">
            <tr>
                <td>${comercial.nombre}</td>
                <td>${comercial.apellido1} ${comercial.apellido2}</td>
                <td>${comercial.comision}</td>
                <td>
                    <a href="detalle/${comercial.idComercial}">Detalle</a>
                    <a href="editar/${comercial.idComercial}">Editar</a>
                    <a href="eliminar/${comercial.idComercial}">Eliminar</a>

                </td>
            </tr>
        </c:forEach>
    </table>