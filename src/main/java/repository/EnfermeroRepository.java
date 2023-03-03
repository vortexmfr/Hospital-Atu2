package repository;

import entity.Enfermero;
import entity.Medico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EnfermeroRepository {

    public static ArrayList<Enfermero> getAll() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ArrayList<Enfermero> enfermeros = new ArrayList<Enfermero>();
            String url = "jdbc:mysql://localhost:3306/hospital";
            Enfermero enfermero;
            Connection conexion = DriverManager.getConnection(url, "root", "");
            System.out.println("Abrierta la conexion ");
            Statement stmt = conexion.createStatement();
            //ResultSet rs = stmt.executeQuery("Select * from persona");
            ResultSet rs = stmt.executeQuery("SELECT persona.dni, firstName,lastName,password,email,birthdate,role,urgencyLevel,desease,historicId, patients.create_at \n" +
                    "FROM `persona` INNER JOIN patients ON persona.dni = patients.dni");

            //Obtener los datos de los campos de la tabla.
            while (rs.next()) {
                enfermero= new Enfermero(rs.getString(1), rs.getString(2), rs.getString(3), null, rs.getString(5), rs.getString(6), rs.getString(8));
                enfermeros.add(enfermero);
            }
            conexion.close();
            return enfermeros;
        } catch (Exception e) {
            return null;
        }
    }
}