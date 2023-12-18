<%@page import="model.Contacto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Actualizar Contacto</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-5">
            <h2>Actualizar Contacto</h2>
            <form action="GestionContactoServlet" method="post">
                <input type="hidden" name="accion" value="confirmarActualizacion">
                <input type="hidden" name="id" value="${contacto.idContacto}">

                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" value="${contacto.nombre}" required>
                </div>

                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="text" class="form-control" id="email" name="email" value="${contacto.email}" required>
                </div>
                
                <div class="form-group">
                    <label for="telefono">Telefono</label>
                    <input type="text" class="form-control" id="telefono" name="telefono" value="${contacto.telefono}" required>
                </div>

                <div class="form-group">
                    <label for="idCurso">Curso</label>
                    <input type="text" class="form-control" id="idCurso" name="idCurso" value="${contacto.idCurso}" required>
                </div>
               
                <div class="form-group">
                    <label for="mensaje">Mensaje:</label>
                    <input type="text" class="form-control" id="mensaje" name="mensaje" value="${contacto.mensaje}" required>
                </div>
                
                <div class="form-group">
                    <label for="fechaAlta">Fecha Alta:</label>
                    <input type="date" class="form-control" id="fechaAlta" name="fechaAlta" value="${contacto.fechaAlta}" required>
                </div>
                
                <div class="form-group">
                    <label for="asignado">Asignado:
                        <input type="checkbox" class="form-control" id="asignado" name="asignado" value="${contacto.asignado}">
                    </label>
                </div>

                    <div>${contacto.asignado}</div>
                <button type="submit" class="btn btn-primary">Actualizar</button>
                <a href="gestionContactos.jsp" class="btn btn-success">Volver</a>

            </form>
        </div>
                
        <script>
            document.getElementById("asignado").checked = ${contacto.asignado}
        </script>
    </body>
    
    
</html>
