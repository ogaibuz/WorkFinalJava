/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sistemas
 */
public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/integrador_java";
    private static final String USER = "root";
    private static final String PASS = "";
    
    // metodo estatico que devuelve un objeto de tipo Connection
    // al decir que es "static" quiere decir que pertenece a la clase y no a la instancia.
    // La palabra clave "static" también se usa para crear bloques estáticos, que son bloques de código que se ejecutan solo una vez cuando la clase se carga en la memoria.
    
    // La idea es que la clase de mysql sea la primera que se cargue
    static {
        try {
            // Carga dinámicamente la clase especificada y la inicializa, retornando su objeto Class.
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al cargar el controlador JDBC");
        }
    }

    public static Connection getConnection() throws SQLException{   // La clase "Conexion" devuelve un objeto del tipo Connection
        return DriverManager.getConnection( URL, USER, PASS);
    }
    
    
}
