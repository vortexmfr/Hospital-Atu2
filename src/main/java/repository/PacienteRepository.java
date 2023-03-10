package repository;

import entity.Medico;
import entity.Paciente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import static config.DatabaseConfig.getConnection;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.UBICACION;

public class PacienteRepository {
    
    public static List<Paciente> getAll() throws SQLException, ClassNotFoundException, IOException {
        String sql = "SELECT * FROM `patients`";
        // Consulta base de datos
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            Paciente paciente;
            while (resultSet.next()) {
                paciente = new Paciente(resultSet.getString("dni"), resultSet.getString("historicId"), Integer.parseInt(resultSet.getString("urgencyLevel")) , resultSet.getString("desease"));
                System.out.println(paciente.toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}