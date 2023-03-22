package repository;

import entity.Medico;

import static config.DatabaseConfig.getConnection;
import entity.Medico;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedicoRepository {

    private final String medicoTable = "doctors";

    public static List<Medico> getAll() throws SQLException, ClassNotFoundException, IOException {
        List<Medico> medicos = new ArrayList<>();
        Medico medico;
        //String sql = "SELECT * FROM doctors";
        String sql = "SELECT persona.dni, firstName,lastName,birthdate,password,email,role,colegiatenumber,speciality FROM persona INNER JOIN doctors On persona.dni = doctors.dni";
        // Consulta base de datos
        try ( Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                medico = new Medico(resultSet.getString("dni"), resultSet.getString("firstName"), resultSet.getString("lastName"), resultSet.getDate("birthdate"), resultSet.getString("password"), resultSet.getString("email"),
                        resultSet.getString("role"), resultSet.getString("colegiatenumber"), resultSet.getString("speciality"));
                medicos.add(medico);
                System.out.println(medicos);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return medicos;
    }

    public static Medico getById(String dni) throws SQLException, ClassNotFoundException, IOException {
        //String sql = "SELECT * FROM doctors where dni='" + dni + "'";
        String sql = "SELECT persona.dni, firstName,lastName,birthdate,password,email,role,colegiatenumber,speciality FROM persona INNER JOIN doctors On persona.dni = doctors.dni AND doctors.dni ='" + dni + "'";
        try ( Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                return (Medico) new Medico(
                        resultSet.getString("dni"), resultSet.getString("firstName"),
                        resultSet.getString("lastName"), resultSet.getDate("birthdate"), resultSet.getString("password"),
                        resultSet.getString("email"), resultSet.getString("role"),
                        resultSet.getString("colegiatenumber"), resultSet.getString("speciality")
                );
            } else {
                System.out.println("Sin resultado -> Medico");
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Medico medico) throws SQLException, ClassNotFoundException, IOException {
        String sql = "UPDATE  " + medicoTable + "( dni=?, firstName=?, lastName=?, birthdate=?, password=?, email=?, role=?,colegiatenumber = ?, speciality = ? ) WHERE dni=?";
        try ( PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, medico.getDni());
            preparedStatement.setString(2, medico.getFirstName());
            preparedStatement.setString(3, medico.getLastName());
            preparedStatement.setDate(4, new java.sql.Date(medico.getBirthdate().getTime()));
            preparedStatement.setString(5, medico.getPassword());
            preparedStatement.setString(6, medico.getEmail());
            preparedStatement.setString(7, medico.getRole());
            preparedStatement.setString(8, medico.getDni());
            preparedStatement.setString(7, medico.getNumColegiado());
            preparedStatement.setString(8, medico.getEspecialidad());
            //  StringU
            return preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean create(Medico medico) throws SQLException, ClassNotFoundException, IOException {
        String sql = "INSERT INTO " + medicoTable + "( dni, firstName, lastName, birthdate, password, email, role, colegiatenumber,speciality ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try ( PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, medico.getDni());
            preparedStatement.setString(2, medico.getFirstName());
            preparedStatement.setString(3, medico.getLastName());
            preparedStatement.setDate(4, new java.sql.Date(medico.getBirthdate().getTime()));
            preparedStatement.setString(5, medico.getPassword());
            preparedStatement.setString(6, medico.getEmail());
            preparedStatement.setString(7, medico.getRole());
            preparedStatement.setString(7, medico.getNumColegiado());
            preparedStatement.setString(8, medico.getEspecialidad());

            return preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete(Medico medico) throws SQLException, ClassNotFoundException, IOException {
        String sql = "DELETE FROM " + medicoTable + " WHERE dni=?";
        try ( PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, medico.getDni());
            return preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
