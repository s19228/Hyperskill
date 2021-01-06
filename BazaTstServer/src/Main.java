/*import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {

        Connection con;
        DatabaseMetaData md;

        String driverName = "org.apache.derby.jdbc.ClientDriver";
        String url = "jdbc:derby://localhost/ksidb";

        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url);
            md = con.getMetaData();
            

            wykonywanie operacji np. zapytań

        } catch (Exception exc)  {
            exc.printStackTrace();
        }

    }


}
*/