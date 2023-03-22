package repository;

import entity.Enfermero;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static config.DatabaseConfig.getConnection;

public class EnfermeroRepository {
    private final String enfermeroTable = "nursey";

    public static List<Enfermero> getAll() throws SQLException, ClassNotFoundException, IOException {
        List<Enfermero> enfermeros = new ArrayList<>();
        Enfermero enfermero;
        //String sql = "SELECT * FROM doctors";
        String sql = "SELECT persona.dni, firstName,lastName,birthdate,password,email,role,colegiatenumber,speciality FROM persona INNER JOIN nurseys On persona.dni = nurseys.dni";
        // Consulta base de datos
        try ( Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                enfermero = new Enfermero(resultSet.getString("dni"), resultSet.getString("firstName"),
                        resultSet.getString("lastName"), resultSet.getDate("birthdate"),
                        resultSet.getString("password"), resultSet.getString("email"),
                        resultSet.getString("role"), resultSet.getString("colegiatenumber"),
                        resultSet.getString("speciality"));

                enfermeros.add(enfermero);
                System.out.println(enfermeros);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return enfermeros;
    }

    public static Enfermero getById(String dni) throws SQLException, ClassNotFoundException, IOException {
        //String sql = "SELECT * FROM doctors where dni='" + dni + "'";
        String sql = "SELECT persona.dni, firstName,lastName,birthdate,password,email,role,colegiatenumber,speciality FROM persona INNER JOIN doctors On persona.dni = nurseys.dni AND nurseys.dni ='" + dni + "'";
        try ( Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                return (Enfermero) new Enfermero(
                        resultSet.getString("dni"), resultSet.getString("firstName"),
                        resultSet.getString("lastName"), resultSet.getDate("birthdate"),
                        resultSet.getString("password"),
                        resultSet.getString("email"), resultSet.getString("role"),
                        resultSet.getString("colegiatenumber"), resultSet.getString("speciality"));
            } else {
                System.out.println("Sin resultado -> Enfermero");
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Enfermero enfermero) throws SQLException, ClassNotFoundException, IOException {
        String sql = "UPDATE  " + enfermeroTable + "( dni=?, firstName=?, lastName=?, birthdate=?, password=?, email=?, role=?,colegiatenumber = ?, speciality = ? ) WHERE dni=?";
        try ( PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, enfermero.getDni());
            preparedStatement.setString(2, enfermero.getFirstName());
            preparedStatement.setString(3, enfermero.getLastName());
            preparedStatement.setDate(4, new java.sql.Date(enfermero.getBirthdate().getTime()));
            preparedStatement.setString(5, enfermero.getPassword());
            preparedStatement.setString(6, enfermero.getEmail());
            preparedStatement.setString(7, enfermero.getRole());
            preparedStatement.setString(8, enfermero.getDni());
            preparedStatement.setString(7, enfermero.getNumColegiado());
            preparedStatement.setString(8, enfermero.getEspecialidad());
            //  StringU
            return preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean create(Enfermero enfermero) throws SQLException, ClassNotFoundException, IOException {
        String sql = "INSERT INTO " + enfermeroTable + "( dni, firstName, lastName, birthdate, password, email, role, colegiatenumber,speciality ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try ( PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, enfermero.getDni());
            preparedStatement.setString(2, enfermero.getFirstName());
            preparedStatement.setString(3, enfermero.getLastName());
            preparedStatement.setDate(4, new java.sql.Date(enfermero.getBirthdate().getTime()));
            preparedStatement.setString(5, enfermero.getPassword());
            preparedStatement.setString(6, enfermero.getEmail());
            preparedStatement.setString(7, enfermero.getRole());
            preparedStatement.setString(7, enfermero.getNumColegiado());
            preparedStatement.setString(8, enfermero.getEspecialidad());

            return preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete(Enfermero enfermero) throws SQLException, ClassNotFoundException, IOException {
        String sql = "DELETE FROM " + enfermeroTable + " WHERE dni=?";
        try ( PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, enfermero.getDni());
            return preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
