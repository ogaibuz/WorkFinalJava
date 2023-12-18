<%@page import="dao.ContactosDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Contacto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Gestión de Contactos</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container-fluid mt-5">
            <h2>Gestión de Contactos</h2>
            <table class="table table-bordered" style="border-collapse: collapse">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Email</th>
                        <th>Telefono</th>
                        <th>Curso</th>
                        <th>Nombre del Curso</th>
                        <th>Mensaje</th>
                        <th>Fecha Alta</th>
                        <th>Asignado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ContactosDAO contactosDAO = new ContactosDAO();
                        List<Contacto> contactos = contactosDAO.obtenerTodos();

                        if (contactos != null && !contactos.isEmpty()) {
                            for (Contacto contacto : contactos) {
                            
                            String asignado = "No";
                            
                            if (contacto.getAsignado() == 1){
                                asignado = "Si";
                            } 
                    %>
                    <tr>
                        <td><%= contacto.getIdContacto()%></td>
                        <td><%= contacto.getNombre()%></td>
                        <td><%= contacto.getEmail()%></td>
                        <td><%= contacto.getTelefono() %></td>
                        <td><%= contacto.getIdCurso() %></td>
                        <td><%= contacto.getNombreCurso() %></td>
                        <td><%= contacto.getMensaje() %></td>
                        <td><%= contacto.getFechaAlta()%></td>
                        <td><%= asignado %></td>
                        <td>
                            <div class="d-flex">
                                <!-- Formulario para actualizar -->
                                <form action="GestionContactoServlet" method="post" class="mr-2">
                                    <input type="hidden" name="accion" value="actualizar">
                                    <input type="hidden" name="id" value="<%= contacto.getIdContacto()%>">
                                    <button type="submit" class="btn btn-warning btn-block">Actualizar</button>
                                </form>

                                <!-- Formulario para eliminar -->
                                <form action="GestionContactoServlet" method="post">
                                    <input type="hidden" name="accion" value="eliminar">
                                    <input type="hidden" name="id" value="<%= contacto.getIdContacto()%>">
                                    <button type="submit" class="btn btn-danger btn-block">Eliminar</button>
                                </form>
                            </div>
                        </td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="6">No hay oradores registrados.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <a href="../" class="btn btn-success">Volver</a>   
        </div>
    </body>
</html>
