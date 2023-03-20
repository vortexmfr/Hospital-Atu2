package repository;

import static config.DatabaseConfig.getConnection;
import entity.Paciente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import entity.Persona;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class PacienteRepository {
    
    private static final String pacienteTable = "patients";
    
    public static List<Paciente> getAll() throws SQLException, ClassNotFoundException, IOException {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM `patients`";
        // Consulta base de datos
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            Paciente paciente;
            while (resultSet.next()) {
                paciente = new Paciente(resultSet.getString("dni"), Integer.parseInt(resultSet.getString("historicId")), Integer.parseInt(resultSet.getString("urgencyLevel")) , resultSet.getString("desease"));
                System.out.println(paciente.toString());
                //System.out.println(paciente.toString());
                pacientes.add(paciente);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pacientes;
    }

    public boolean create(Paciente paciente) throws SQLException, ClassNotFoundException, IOException {

        String sql = "INSERT INTO " + pacienteTable + "( dni, urgencyLevel, desease) VALUES (?, ?, ?)";
        try ( PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, paciente.getDniPersona());
            preparedStatement.setInt(2, paciente.getUrgencyLevel());
            preparedStatement.setString(3, paciente.getDeseaseId());

            return preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Paciente getById(String dni) throws SQLException, ClassNotFoundException, IOException {
        String sql = "SELECT * FROM " + pacienteTable + " where dni='" + dni + "'";
        try ( Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Paciente(resultSet.getString("dni"), resultSet.getInt("historicId"), resultSet.getInt("urgencyLevel"), resultSet.getString("desease"));
            } else {
                System.out.println("Sin resultado");
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
