package repository;

import entity.Medico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MedicoRepository {

    public static ArrayList<Medico> getAll() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ArrayList<Medico> medicos = new ArrayList<Medico>();
            String url = "jdbc:mysql://localhost:3306/hospital";
            Medico medico;
            Connection conexion = DriverManager.getConnection(url, "root", "");
            System.out.println("Abrierta la conexion ");
            Statement stmt = conexion.createStatement();
            //ResultSet rs = stmt.executeQuery("Select * from persona");
            ResultSet rs = stmt.executeQuery("SELECT persona.dni, firstName,lastName,password,email,birthdate,role,urgencyLevel,desease,historicId, patients.create_at \n" +
                    "FROM `persona` INNER JOIN patients ON persona.dni = patients.dni");

            //Obtener los datos de los campos de la tabla.
            while (rs.next()) {
                medico= new Medico(rs.getString(1), rs.getString(2), rs.getString(3), null, rs.getString(5), rs.getString(6), null, rs.getString(8));
                medicos.add(medico);
            }
            conexion.close();
            return medicos;
        } catch (Exception e) {
            return null;
        }
    }
}