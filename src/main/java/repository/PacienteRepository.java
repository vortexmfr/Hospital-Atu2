package repository;

import entity.Medico;
import entity.Paciente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.UBICACION;

public class PacienteRepository {

    public static List<Paciente> getAll() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
            String url = "jdbc:mysql://localhost:3306/hospital";
            Paciente paciente;
            Connection conexion = DriverManager.getConnection(url, "root", "");
            System.out.println("Abrierta la conexion ");
            Statement stmt = conexion.createStatement();
            //ResultSet rs = stmt.executeQuery("Select * from persona");
            ResultSet rs = stmt.executeQuery("SELECT persona.dni, firstName,lastName,password,email,birthdate,role,urgencyLevel,desease,historicId, patients.create_at \n" +
                    "FROM `persona` INNER JOIN patients ON persona.dni = patients.dni");

            //Obtener los datos de los campos de la tabla.
            while (rs.next()) {
                paciente= new Paciente(rs.getString(1), rs.getString(2), rs.getString(3), null, rs.getString(5), rs.getString(6), null, rs.getString(8));
                pacientes.add(paciente);
            }

            conexion.close();
            return pacientes;
        } catch (Exception e) {
            return null;
        }
    }
}