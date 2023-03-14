package repository;

import dto.EnfermedadDto;
import dto.EspecialidadDto;
import entity.Enfermedad;
import entity.Especialidad;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static config.DatabaseConfig.getConnection;

public class EspecialidadRepository {
    private final String especialidadTable = "speciality";

    public static List<Especialidad> getAll() throws SQLException, ClassNotFoundException, IOException {
        List<Especialidad> especialidades = new ArrayList<>();
        Especialidad especialidad;
        String sql = "SELECT * FROM speciality";
        // Consulta base de datos
        try ( Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                especialidad = new Especialidad(resultSet.getInt("specialityId"), resultSet.getString("specialityName"));
                especialidades.add(especialidad);
                System.out.println(especialidad);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return especialidades;
    }

    public static Especialidad getById(String id) throws SQLException, ClassNotFoundException, IOException {
        String sql = "SELECT * FROM speciality where specialityId='" + id + "'";

        try ( Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                return (Especialidad) new Especialidad( resultSet.getInt("specialityId"), resultSet.getString("specialityName"));
            } else {
                System.out.println("Sin resultado -> Especialidad");
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Especialidad especialidad) throws SQLException, ClassNotFoundException, IOException {
        String sql = "UPDATE  " + especialidadTable + " SET specialityId=?, specialityName=? WHERE specialityId=?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setInt(1, especialidad.getId());
            preparedStatement.setString(2, especialidad.getEspecialidad());
            preparedStatement.setInt(3, especialidad.getId());
            return  preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean create(Especialidad especialidad) throws SQLException, ClassNotFoundException, IOException {

        // Miro que no este creado
        if( getById(Integer.toString(especialidad.getId())) != null) {
            System.out.println("El elemento existe y no se puede crear");
            return false;
        } else{
            String sql = "INSERT INTO " + especialidadTable + "( specialityId, specialityName) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

                preparedStatement.setInt(1, especialidad.getId());
                preparedStatement.setString(2, especialidad.getEspecialidad());

                return preparedStatement.execute();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean delete(EspecialidadDto especialidad) throws SQLException, ClassNotFoundException, IOException {
        String sql = "DELETE FROM " + especialidadTable + " WHERE specialityId=?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

            preparedStatement.setInt(1, especialidad.getId());
            return  preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
