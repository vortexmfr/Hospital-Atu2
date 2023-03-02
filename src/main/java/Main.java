import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{

        System.out.println("Hello World!");

        // Consulta base de datos
        String dni = "1223563-W";
        try {
            String url = "jdbc:mysql://localhost:3306/hospital2";

            Connection conexion = DriverManager.getConnection(url, "dorime", "dorime");
            System.out.println("Abrierta la conexion ");
            Statement stmt = conexion.createStatement();
            //ResultSet rs = stmt.executeQuery("Select * from persona");
            ResultSet rs = stmt.executeQuery("SELECT persona.dni, firstName,lastName,password,email,birthdate,role,speciality,doctors.colegiatenumber, doctors.create_at \n" +
                    "FROM `persona` INNER JOIN doctors ON persona.dni = doctors.dni \n" +
                    "WHERE persona.dni = \""+dni+"\"; ");

            //Metadatos de la base de datos
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            int rowCount = 0;
            for (int i = 1; i <= colCount; i++) {
                System.out.println("Información acerca de la columna " + i);
                System.out.println("   Nombre........: " + rsmd.getColumnName(i));
                System.out.println("   Tipo de datos.....: " + rsmd.getColumnType(i) +
                        " ( " + rsmd.getColumnTypeName(i) + " )");
                System.out.println("   Precisión.....: " + rsmd.getPrecision(i));
                System.out.println("   Escala........: " + rsmd.getScale(i));
                System.out.print  ("   Permitir nulos: ");
                if (rsmd.isNullable(i)==0)
                    System.out.println("false");
                else
                    System.out.println("true");
            }

            //Obtener los datos de los campos de la tabla.
            while (rs.next()) {
                System.out.println(
                          rs.getString(1) + " | "
                        + rs.getString(2) + " | "
                        + rs.getString(3)+ " | "
                        + rs.getString(4)+ " | "
                        + rs.getString(5)+ " | "
                        + rs.getString(6)+ " | "
                        + rs.getString(7)+ " | "
                        + rs.getString(8)+ " | "
                        + rs.getString(9)+ " | "
                        + rs.getString(10));
            }
            conexion.close();
            System.out.println("Cerrada la conexion");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}