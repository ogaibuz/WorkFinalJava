
package controlador;

import dao.ContactosDAO;
import model.Contacto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/registroContacto")
// RegistroContacto ---> es un servlet
public class RegistroContacto extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenemos datos del formulario
        String nombre = request.getParameter("name");
        String email = request.getParameter("email");
        String telefono = request.getParameter("phone");
        String mensaje = request.getParameter("message");
        String curso = request.getParameter("course");
        
        int  cursoId  = Integer.parseInt(curso);

        // Crear un objeto Contacto con los datos
        Contacto contacto = new Contacto();
        contacto.setNombre(nombre);
        contacto.setEmail(email);
        contacto.setTelefono(telefono);
        contacto.setMensaje(mensaje);
        contacto.setIdCurso(cursoId);

        // Obtener la fecha actual. java.until.Date ---> es propio de JAVA
        java.util.Date fechaActual = new java.util.Date(); //es una forma de utilizar la clase sin necesitar una declaracion 'import'
        contacto.setFechaAlta(new Date(fechaActual.getTime()));

        // Agregar el orador a la base de datos utilizando el metodo "agregarContacto"
        ContactosDAO contactosDAO = new ContactosDAO();
        contactosDAO.agregarcontacto(contacto);

        // Una vez agregado el contacto nos va a redireccionar a la pagina verContactos.jsp
        // Redireccionar a la página de visualización de Contactos
        response.sendRedirect(request.getContextPath() + "/views/verContactos.jsp");
    }
}
