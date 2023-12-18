package controlador;

import dao.ContactosDAO;
import model.Contacto;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.HashSet;

@WebServlet("/views/GestionContactoServlet")
public class GestionContactoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        ContactosDAO contactosDAO = new ContactosDAO();

        // Inicializar idContacto antes del switch para que esté disponible en todos los casos
        int idContacto = Integer.parseInt(request.getParameter("id"));

        switch (accion) {
            case "actualizar":
                Contacto contacto = contactosDAO.obtenerPorId(idContacto);
                request.setAttribute("contacto", contacto); //Esto permite pasar datos del servlet a una vista (como un archivo JSP) o a otro servlet al que se redirige o se reenvía la solicitud
                request.getRequestDispatcher("actualizar.jsp").forward(request, response);
                break;
            case "confirmarActualizacion":
                
                int cursoId = Integer.parseInt(request.getParameter("idCurso"));
                
                // Asigno a un variable el valor 0 (cero) que es la que va  a tener el valor del checkbox de la pagina de actualización
                int cursoAsignado = 0;
                // Si el checkbox está seleccionado le establezco el valor 1 para grabar en la base de datos
                if (request.getParameter("asignado") != null){
                    cursoAsignado = 1;
                }
                
                // System.out.println("El valor de la variable cursoAsignado es --->" +  cursoAsignado);
                // System.out.println("El valor STRING de la variable cursoAsignado es --->" +  request.getParameter("asignado"));
                
                Contacto contactoActualizado = new Contacto();
                contactoActualizado.setIdContacto(idContacto);
                contactoActualizado.setNombre(request.getParameter("nombre"));
                contactoActualizado.setTelefono(request.getParameter("telefono"));
                contactoActualizado.setEmail(request.getParameter("email"));
                contactoActualizado.setMensaje(request.getParameter("mensaje"));
                contactoActualizado.setIdCurso(cursoId);
                // Asume que el método setFechaAlta acepta un java.sql.Date
                contactoActualizado.setFechaAlta(java.sql.Date.valueOf(request.getParameter("fechaAlta")));
                contactoActualizado.setAsignado(cursoAsignado);
                

                contactosDAO.actualizarContacto(contactoActualizado);
                response.sendRedirect("gestionContactos.jsp");
                break;
            case "eliminar":
                contactosDAO.eliminarContacto(idContacto);
                response.sendRedirect("gestionContactos.jsp");
                break;
            default:
                response.sendRedirect("gestionContactos.jsp");
                break;
        }
    }
}