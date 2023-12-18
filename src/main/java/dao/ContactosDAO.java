/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import model.Contacto;

/**
 *
 * @author sistemas
 */
    public class ContactosDAO {
    
        // Método para agregar un nuevo Contacto
        public void agregarcontacto(Contacto contacto) {
        String sql = "INSERT INTO contactos (nombre, email, telefono, mensaje, fecha_alta, id_curso) VALUES (?, ?, ?, ?, ?, ?)";
        //bloque try-with-resources
        //asegura que los recursos abiertos en su declaración (dentro de los paréntesis) se cierren automáticamente al final del bloque try 
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, contacto.getNombre());
            pstmt.setString(2, contacto.getEmail());
            pstmt.setString(3, contacto.getTelefono());
            pstmt.setString(4, contacto.getMensaje());
            pstmt.setDate(5, contacto.getFechaAlta());
            pstmt.setInt(6, contacto.getIdCurso());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
    // Método para obtener un Contacto por el Id    
    public Contacto obtenerPorId(int id) {
        String sql = "SELECT * FROM contactos WHERE id_contacto = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Contacto contacto = new Contacto();
                contacto.setIdContacto(rs.getInt("id_contacto"));
                contacto.setNombre(rs.getString("nombre"));
                contacto.setEmail(rs.getString("email"));
                contacto.setTelefono(rs.getString("telefono"));
                contacto.setMensaje(rs.getString("mensaje"));
                contacto.setFechaAlta(rs.getDate("fecha_alta"));
                contacto.setIdCurso(rs.getInt("id_curso"));
                contacto.setAsignado(rs.getInt("asignado"));
                
                return contacto;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    // Método para listar todos los contactos
        public List<Contacto> obtenerTodos() {
        List<Contacto> contactos = new ArrayList<>();
        String sql = "SELECT id_contacto, nombre, email, telefono, contactos.id_curso, nombre_curso, mensaje, fecha_alta, asignado FROM " +
                            "contactos INNER JOIN cursos ON contactos.id_curso = cursos.id_curso";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Contacto contacto = new Contacto();
                contacto.setIdContacto(rs.getInt("id_contacto"));
                contacto.setNombre(rs.getString("nombre"));
                contacto.setEmail(rs.getString("email"));
                contacto.setTelefono(rs.getString("telefono"));
                contacto.setMensaje(rs.getString("mensaje"));
                contacto.setFechaAlta(rs.getDate("fecha_alta"));
                contacto.setIdCurso(rs.getInt("id_curso"));
                contacto.setNombreCurso(rs.getString("nombre_curso"));
                contacto.setAsignado(rs.getInt("asignado"));
                contactos.add(contacto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactos;
    }
        
    // Método para ACTUALIZAR el registro de contactos
    public void actualizarContacto(Contacto contacto) {
        String sql = "UPDATE contactos SET nombre = ?, email = ?, telefono = ?, mensaje = ?, fecha_alta = ?, id_curso = ?, asignado = ? WHERE id_contacto = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, contacto.getNombre());
            pstmt.setString(2, contacto.getEmail());
            pstmt.setString(3, contacto.getTelefono());
            pstmt.setString(4, contacto.getMensaje());
            pstmt.setDate(5, contacto.getFechaAlta());
            pstmt.setInt(6, contacto.getIdCurso());
            pstmt.setInt(7, contacto.getAsignado());
            pstmt.setInt(8, contacto.getIdContacto());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
    // Método para eliminar Contacto
        public void eliminarContacto(int id) {
        String sql = "DELETE FROM contactos WHERE id_contacto = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
