package controlador;

import connect.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/views/LoginServlet")
public class LoginServlet extends HttpServlet{
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtengo los valores de la pagina
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (autenticarUsuario(username, password)) {
            // Usuario autenticado
            HttpSession session = request.getSession();
            session.setAttribute("usuario", username);
            response.sendRedirect("gestionContactos.jsp");  // Redirigir a la pagina de gestion
        } else {
            // Autenticación fallida
            request.setAttribute("error", "Nombre de usuario o contraseña inválidos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    
    }
    
    private boolean autenticarUsuario(String username, String password){
        // Aquí va la lógica para conectarse a la base de datos y verificar las credenciales
        Connection conn= null;
        PreparedStatement pstmt= null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getConnection();
            String sql = "SELECT * FROM login WHERE usuario = ? AND contraseña = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();

            return rs.next(); // Si hay un resultado las credenciales son correctas
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {  // finally si lo ponemos siempre se ejecuta
            // cerramos los recursos manualmente
            try {
                if (rs != null) rs.close();
                if (pstmt !=null) pstmt.close();
                if (conn != null) conn.close();
                
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
