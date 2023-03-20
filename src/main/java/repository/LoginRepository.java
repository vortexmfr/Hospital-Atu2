package repository;

import entity.Persona;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static config.DatabaseConfig.getConnection;

public class LoginRepository {

    public static String validateUser(String user, String password) throws SQLException, ClassNotFoundException, IOException {
        String sql = "SELECT role FROM persona where dni = ? and password = ?";
        String role = null;
        // Consulta base de datos
        try ( PreparedStatement statement = Objects.requireNonNull(getConnection()).prepareStatement(sql)) {
            statement.setString(1, user);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                //System.out.println(resultSet.getString("role"));
                role = resultSet.getString("role");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (role != null) {
            return role;
        } else {
            return "Other";
        }
    }
}
