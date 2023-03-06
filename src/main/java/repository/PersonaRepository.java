/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import static config.DatabaseConfig.getConnection;
import entity.Persona;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rostro
 */
public class PersonaRepository {
    
      public static List<Persona> getAll() throws SQLException, ClassNotFoundException, IOException {
        List<Persona> personas = new ArrayList<>();
        Persona persona;
        String sql = "SELECT * FROM persona";
        // Consulta base de datos
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                persona = new Persona(resultSet.getString("dni"), resultSet.getString("firstName") , resultSet.getString("lastName"), resultSet.getDate("birthdate"),resultSet.getString("password"), resultSet.getString("email"), resultSet.getString("role"));
                personas.add(persona);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personas;
    }
}
