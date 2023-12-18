<%@page import="dao.ContactosDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Contacto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Lista de Registro </title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-5">
            <h2>Lista de Usuarios Registrados</h2>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Email</th>
                        <th>Telefono</th>
                        <th>Mensaje</th>
                        <th>Fecha Alta</th>
                        <th>Curso</th>
                        <th>Nombre Curso</th>
                        <th>Asignado</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        // Crear una instancia de ContactosDAO para acceder a la base de datos
                        ContactosDAO contactosDAO = new ContactosDAO();

                        // Obtener la lista de contactos desde la base de datos
                        List<Contacto> contactos =   contactosDAO.obtenerTodos();

                        if (contactos != null && !contactos.isEmpty()) {
                            // Iterar sobre la lista de contactos y mostrar sus datos en la tabla
                            for (Contacto contacto : contactos) {
                    %>
                    <tr>
                        <td><%= contacto.getIdContacto()%></td>
                        <td><%= contacto.getNombre()%></td>
                        <td><%= contacto.getEmail()%></td>
                        <td><%= contacto.getTelefono()%></td>
                        <td><%= contacto.getMensaje()%></td>
                        <td><%= contacto.getFechaAlta()%></td>
                        <td><%= contacto.getIdCurso() %></td>
                        <td><%= contacto.getNombreCurso() %></td>
                        <td><%= contacto.getAsignado() %></td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="5">No hay contactos registrados.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <!-- Botón para volver al índice -->
            <a href="../" class="btn btn-success">Volver</a>   
        </div>
    </body>
</html>