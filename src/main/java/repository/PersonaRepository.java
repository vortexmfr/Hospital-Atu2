/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import static config.DatabaseConfig.getConnection;
import entity.Persona;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Rostro
 */
public class PersonaRepository {
    
    private final String personaTable = "persona";

    public List<Persona> getAll() throws SQLException, ClassNotFoundException, IOException {
        List<Persona> personas = new ArrayList<>();
        Persona persona;
        String sql = "SELECT * FROM persona";
        // Consulta base de datos
        try ( Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                persona = new Persona(resultSet.getString("dni"), resultSet.getString("firstName"), resultSet.getString("lastName"), resultSet.getDate("birthdate"), resultSet.getString("password"), resultSet.getString("email"), resultSet.getString("role"));
                personas.add(persona);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personas;
    }

    public static Persona getById(String dni) throws SQLException, ClassNotFoundException, IOException {
        String sql = "SELECT * FROM persona where dni='" + dni + "'";
        try ( Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                return new Persona(resultSet.getString("dni"), resultSet.getString("firstName"), resultSet.getString("lastName"), resultSet.getDate("birthdate"), resultSet.getString("password"), resultSet.getString("email"), resultSet.getString("role"));
            } else {
                System.out.println("Sin resultado");
            }
            // resultSet.absolute(1);
            // resultSet.first();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Add field status    Only search Personas Active
       public List<Persona> getAllByField(String field, String value) throws SQLException, ClassNotFoundException, IOException {
        List<Persona> personas = new ArrayList<>();
           Persona persona;
           String sql = "SELECT * FROM persona" + (StringUtils.isNotEmpty(field) ? "WHERE " + field + "=" + value : "");
           // Consulta base de datos
        try ( Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                persona = new Persona(resultSet.getString("dni"), resultSet.getString("firstName"), resultSet.getString("lastName"), resultSet.getDate("birthdate"), resultSet.getString("password"), resultSet.getString("email"), resultSet.getString("role"));
                personas.add(persona);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personas;
    } 
  
  public boolean update(Persona persona) throws SQLException, ClassNotFoundException, IOException {
        String sql = "UPDATE  " + personaTable + "( firstName=?, lastName=?, birthdate=?, password=?, email=?, role=?) WHERE dni=?";
       try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            
            preparedStatement.setString(1, persona.getFirstName());
            preparedStatement.setString(2, persona.getLastName());
            preparedStatement.setDate(3, new java.sql.Date(persona.getBirthdate().getTime()));
            preparedStatement.setString(4, persona.getPassword());
            preparedStatement.setString(5, persona.getEmail());
            preparedStatement.setString(6, persona.getRole());
            preparedStatement.setString(7, persona.getDni());
          //  StringU
          return  preparedStatement.execute();

        } catch (SQLException e) {
            // Mandar menu propio
            throw new RuntimeException(e);
        }
    }

    public boolean create(Persona persona) throws SQLException, ClassNotFoundException, IOException {
        String sql = "INSERT INTO " + personaTable + "( dni, firstName, lastName, birthdate, password, email, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
       try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, persona.getDni());
            preparedStatement.setString(2, persona.getFirstName());
            preparedStatement.setString(3, persona.getLastName());
            preparedStatement.setDate(4, new java.sql.Date(persona.getBirthdate().getTime()));
            preparedStatement.setString(5, persona.getPassword());
            preparedStatement.setString(6, persona.getEmail());
            preparedStatement.setString(7, persona.getRole());

          return  preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
        public boolean delete(Persona persona) throws SQLException, ClassNotFoundException, IOException {
        String sql = "DELETE FROM " + personaTable + " WHERE dni=?";
       try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, persona.getDni());
          return  preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
