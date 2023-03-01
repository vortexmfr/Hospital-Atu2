import java.sql.*;

import static repository.DataBaseRequest.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println("Hello World!");

        //Consulta select
        selectDatosDoctor("1223563-W");
        selectDatosNursey( "6483945-W");
        selectDatosPatient("36486483-H");
    }
}