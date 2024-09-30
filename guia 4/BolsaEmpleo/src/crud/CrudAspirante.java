/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

/**
 *
 * @author maribelmoreno
 */

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Aspirante;

public class CrudAspirante {
    
    // Metodo para cargar lo que quedo en la base de datos
    public List<Aspirante> obtenerTodosLosAspirantes() {
        List<Aspirante> listaAspirantes = new ArrayList<>();
        String sql = "SELECT * FROM aspirantes";
        Connection conn = Conexion.getConnection();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        
            while (rs.next()) {
                Aspirante aspirante = new Aspirante();
                aspirante.setCedula(rs.getString("cedula"));
                aspirante.setNombreCompleto(rs.getString("nombre"));
                aspirante.setEdad(rs.getInt("edad"));
                aspirante.setExperiencia(rs.getInt("experiencia"));
                aspirante.setProfesion(rs.getString("profesion"));
                aspirante.setTelefono(rs.getString("telefono"));
                listaAspirantes.add(aspirante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.closeConnection(conn);
        }

        return listaAspirantes;
    }
    
    public void agregarAspirante(Aspirante aspirante) {
        Connection conn = Conexion.getConnection(); // Obtiene la conexión

        try {
            String query = "INSERT INTO aspirantes (cedula, nombre, edad, experiencia, profesion, telefono) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, aspirante.getCedula());
            stmt.setString(2, aspirante.getNombreCompleto());
            stmt.setInt(3, aspirante.getEdad());
            stmt.setInt(4, aspirante.getExperiencia());
            stmt.setString(5, aspirante.getProfesion());
            stmt.setString(6, aspirante.getTelefono());

            stmt.executeUpdate();
            System.out.println("Aspirante agregado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al agregar aspirante: " + e.getMessage());
        } finally {
            Conexion.closeConnection(conn); // Cierra la conexión
        }
    }

    public List<String> obtenerCedulas() {
        List<String> cedulas = new ArrayList<>();
        String sql = "SELECT cedula FROM aspirantes";
        Connection conn = Conexion.getConnection(); // Obtiene la conexión
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cedulas.add(rs.getString("cedula"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.closeConnection(conn); // Cierra la conexión
        }
        return cedulas;
    }
    
    // Método para obtener todos los aspirantes
    public List<Aspirante> obtenerAspirantes() {
        List<Aspirante> listaAspirantes = new ArrayList<>();
        String sql = "SELECT * FROM aspirantes";
        
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Aspirante aspirante = new Aspirante(
                    rs.getString("cedula"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getInt("experiencia"),
                    rs.getString("profesion"),
                    rs.getString("telefono")
                );
                listaAspirantes.add(aspirante);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaAspirantes;
    }


    public Aspirante buscarPorNombre(String nombreBuscado) {
        String sql = "SELECT * FROM aspirantes WHERE nombre LIKE ?";
        Connection conn = Conexion.getConnection(); // Obtiene la conexión
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + nombreBuscado + "%");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Aspirante(
                    rs.getString("cedula"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getInt("experiencia"),
                    rs.getString("profesion"),
                    rs.getString("telefono")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.closeConnection(conn); // Cierra la conexión
        }
        return null; // Devuelve null si no se encuentra
    }
    
    public Aspirante buscarPorCedula(String cedulaBuscada) {
    String sql = "SELECT * FROM aspirantes WHERE cedula = ?";
    Aspirante aspirante = null;

    try (Connection con = Conexion.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, cedulaBuscada);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            aspirante = new Aspirante(
                rs.getString("cedula"),
                rs.getString("nombre"),
                rs.getInt("edad"),
                rs.getInt("experiencia"),
                rs.getString("profesion"),
                rs.getString("telefono")
            );
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return aspirante; // Retorna el aspirante o null si no lo encontró
    }


    public void eliminarPorExperiencia(int anios) {
        String sql = "DELETE FROM aspirantes WHERE experiencia <= ?"; // Cambia '<' por '<='
        Connection conn = Conexion.getConnection(); // Obtiene la conexión
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, anios);
            int filasEliminadas = stmt.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Aspirantes eliminados exitosamente.");
            } else {
                System.out.println("No se encontraron aspirantes con menos de " + anios + " años de experiencia.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.closeConnection(conn); // Cierra la conexión
        }
    }
    
    
    public boolean eliminarAspirante(String cedula) {
        String sql = "DELETE FROM aspirantes WHERE cedula = ?";
        Connection conn = Conexion.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cedula);
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Aspirante eliminado exitosamente.");
                return true; // La eliminación fue exitosa
            } else {
                System.out.println("No se encontró un aspirante con esa cédula.");
                return false; // No se eliminó nada (posiblemente la cédula no existe)
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // En caso de error, puedes decidir cómo manejarlo
        } finally {
            Conexion.closeConnection(conn);
        }
    }

    // Método para ordenear de acuerdo a elección
    public List<Aspirante> obtenerAspirantesOrdenados(String criterio) {
        String sql = "";
    
        // Definir la consulta SQL según el criterio
        switch (criterio) {
            case "experiencia":
                sql = "SELECT * FROM aspirantes ORDER BY experiencia ASC";  // Ordenar por experiencia
                break;
            case "edad":
                sql = "SELECT * FROM aspirantes ORDER BY edad ASC";  // Ordenar por edad
                break;
            case "profesion":
                sql = "SELECT * FROM aspirantes ORDER BY profesion ASC";  // Ordenar por profesión
                break;
            default:
                return new ArrayList<>();  // Retornar una lista vacía si el criterio no es válido
        }
    
        List<Aspirante> listaAspirantes = new ArrayList<>();
        Connection conn = Conexion.getConnection();
    
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // Crear un nuevo objeto Aspirante y añadirlo a la lista
                Aspirante aspirante = new Aspirante(
                    rs.getString("cedula"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getInt("experiencia"),
                    rs.getString("profesion"),
                    rs.getString("telefono")
                );
                listaAspirantes.add(aspirante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.closeConnection(conn);
        }
    
        return listaAspirantes;  // Retornar la lista ordenada de aspirantes
    }
    
    
    
    // Métodos adicionales para ordenar y consultar
    public Aspirante obtenerAspiranteMayorExperiencia() {
    String sql = "SELECT * FROM aspirantes ORDER BY experiencia DESC LIMIT 1";
    Connection conn = Conexion.getConnection();
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new Aspirante(
                rs.getString("cedula"),
                rs.getString("nombre"),
                rs.getInt("edad"),
                rs.getInt("experiencia"),
                rs.getString("profesion"),
                rs.getString("telefono")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        Conexion.closeConnection(conn);
    }
    return null;
    }


    public Aspirante obtenerAspiranteMasJoven() {
        String sql = "SELECT * FROM aspirantes ORDER BY edad ASC LIMIT 1";
        Connection conn = Conexion.getConnection(); // Obtiene la conexión
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Aspirante(
                    rs.getString("cedula"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getInt("experiencia"),
                    rs.getString("profesion"),
                    rs.getString("telefono")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.closeConnection(conn); // Cierra la conexión
        }
        return null; // Devuelve null si no se encuentra
    }
    public double obtenerPromedioEdad() {
    String sql = "SELECT AVG(edad) AS promedioEdad FROM aspirantes";
    Connection conn = Conexion.getConnection();
    double promedio = 0.0;
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            promedio = rs.getDouble("promedioEdad");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        Conexion.closeConnection(conn);
    }
    return promedio;
    }

}

