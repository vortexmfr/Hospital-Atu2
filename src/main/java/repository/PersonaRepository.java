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
            statement.setMaxRows(1);
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

    public static int update(Persona persona) throws SQLException, ClassNotFoundException, IOException {
        String sql = "SELECT * FROM persona where dni='" + persona.getDni() + "'";
        try ( Statement statement = getConnection().createStatement()) {
            int resultSet = statement.executeUpdate(sql);

            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int create(Persona persona) throws SQLException, ClassNotFoundException, IOException {
        String sql = "SELECT * FROM persona where dni='" + persona.getDni() + "'";
        try ( Statement statement = getConnection().createStatement()) {
            int resultSet = statement.executeUpdate(sql);

            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
