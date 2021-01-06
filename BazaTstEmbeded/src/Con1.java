/**
 * @author Gryka Konrad S19228
 */

import java.sql.*;
import java.lang.reflect.*;


public class Con1 {
    private  DatabaseMetaData md;
    Connection con;

    String driverName = "org.apache.derby.jdbc.EmbeddedDriver";
    String url = "jdbc:derby:C:/DerbyDbs/ksidb";

    public Con1() {

        this.driverName = driverName;
        this.url = url;

        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url);
            md = con.getMetaData();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.exit(1);
        }
    }


// Metoda raportująca informacje zebrane w DatabaseMetaData
// w wywołaniach metody info podano jako argumenty nazwy metod tego interfejsu
// a w metodzie info korszystamy z metod refleksji;
// ten sposób oprogramowania jest zaawansowany, ale wygodny, bo dużo mniej pisania
// i kod jest bardziej klarowny
// klauzula throws SQLException mówi o tym, że w trakcie działania reportInfo może powstać wyjątek
// SQLException, ale nie będziemy go tu obsługiwać, obsługę przekażemy do miejsca wywołania
// czyli bloku try w konstruktorze

    void reportInfo() throws SQLException {

        info("getDatabaseProductName");
        info("getDatabaseProductVersion");
        info("getDriverName");
        info("getURL");
        info("getUserName");

        info("supportsAlterTableWithAddColumn");
        info("supportsAlterTableWithDropColumn");
        info("supportsANSI92FullSQL");
        info("supportsBatchUpdates");
        info("supportsMixedCaseIdentifiers");
        info("supportsMultipleTransactions");
        info("supportsPositionedDelete");
        info("supportsPositionedUpdate");
        info("supportsSchemasInDataManipulation");
        info("supportsTransactions");

        System.out.println("ResultSet  TYPE_SCROLL_INSENSITIVE :" +
                md.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
        System.out.println("ResultSet  TYPE_SCROLL_SENSITIVE :" +
                md.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));
        System.out.println("insertsAreDetected :" +
                md.insertsAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
        System.out.println("updatesAreDetected :" +
                md.updatesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
    }

    // Metoda info korzysta z metod refleksji do wywołania metod podanych "przez" nazwy.
    void info(String metName) {
        Class mdc = DatabaseMetaData.class;
        Class[] paramTypes = {};
        Object[] params = {};
        String infoTyp;
        if (metName.startsWith("get"))
            infoTyp = metName.substring(3);  //infoTyp = metName.substring(3, metName.length()) - redundancja
        else infoTyp = metName;
        try {
            Method m = mdc.getDeclaredMethod(metName, paramTypes);
            System.out.println(infoTyp + ": " + m.invoke(md, params));  // dynamiczne wywołanie metody
        } catch (Exception exc) {   // Możliwe powody wyjątków: nie ma takiej metody, niewłaściwe wywołanie
            System.out.println(exc);
        }
    }

    public static void main(String[] args) {
        try {
            new Con1().reportInfo();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
}
