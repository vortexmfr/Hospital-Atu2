package repository;

import dto.EnfermedadDto;
import entity.Enfermedad;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static config.DatabaseConfig.getConnection;

public class EnfermedadRepository {
    private final String enfermedadTable = "disease";

    public static List<Enfermedad> getAll() throws SQLException, ClassNotFoundException, IOException {
        List<Enfermedad> enfermedades = new ArrayList<>();
        Enfermedad enfermedad;
        String sql = "SELECT * FROM desease";
        // Consulta base de datos
        try ( Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                enfermedad = new Enfermedad(resultSet.getInt("deseaseId"), resultSet.getString("deseaseName"), resultSet.getInt("deseaseTime"));
                enfermedades.add(enfermedad);
                System.out.println(enfermedad);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return enfermedades;
    }

    public static Enfermedad getById(String id) throws SQLException, ClassNotFoundException, IOException {
        String sql = "SELECT * FROM desease where deseaseId='" + id + "'";

        try ( Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                return (Enfermedad) new Enfermedad( resultSet.getInt("deseaseId"), resultSet.getString("deseaseName"), resultSet.getInt("deseaseTime"));
            } else {
                System.out.println("Sin resultado -> Enfermedad");
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Enfermedad enfermedad) throws SQLException, ClassNotFoundException, IOException {
        String sql = "UPDATE  " + enfermedadTable + "( deseaseId=?, deseaseName=?, deseaseTime=?) WHERE deseaseId=?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setInt(1, enfermedad.getId());
            preparedStatement.setString(2, enfermedad.getEnfermedad());
            preparedStatement.setInt(3, enfermedad.getTiempo());
            //  StringU
            return  preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean create(EnfermedadDto enfermedad) throws SQLException, ClassNotFoundException, IOException {
        String sql = "INSERT INTO " + enfermedadTable + "( deseaseId, deseaseName, deseaseTime) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setInt(1, enfermedad.getId());
            preparedStatement.setString(2, enfermedad.getEnfermedad());
            preparedStatement.setInt(3, enfermedad.getTiempo());

            return  preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete(Enfermedad enfermedad) throws SQLException, ClassNotFoundException, IOException {
        String sql = "DELETE FROM " + enfermedadTable + " WHERE deseaseId=?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setInt(1, enfermedad.getId());
            return  preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
