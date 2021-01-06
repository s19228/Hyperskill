/*
import java.sql.*;


public class Main {

    public static void main(String[] args) {

        Connection con;
        DatabaseMetaData md;

        String driverName = "org.apache.derby.jdbc.EmbeddedDriver";
        String url = "jdbc:derby:C:/DerbyDbs/ksidb";

        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url);
            md = con.getMetaData();

            getDBinfo(md);


            int columnCount = md.getMaxColumnNameLength();

            System.out.println(columnCount);

            Statement statement = con.createStatement();
            //statement.execute("SELECT * FROM POZYCJE");

            ResultSet result = statement.executeQuery("SELECT * FROM POZYCJE");
            while (result.next()) {
                for (int i = 1; i < 7; i++){
                    System.out.print(result.getString(i) + "\t");
                }
                System.out.println();
            }

        } catch (Exception exc)  {
            exc.printStackTrace();
            System.exit(1);
        }

    }

    public static void getDBinfo(DatabaseMetaData md) throws SQLException {
        // odpytywanie metadanych o różne
        // informacje
        System.out.println(md.getDatabaseProductName());
        System.out.println(md.getDatabaseProductVersion());
        System.out.println(md.getDriverName());
        System.out.println(md.getURL());
        System.out.println(md.getUserName());
        System.out.println(md.supportsAlterTableWithAddColumn());
        System.out.println(md.supportsAlterTableWithDropColumn());
        System.out.println(md.supportsANSI92FullSQL());
        System.out.println(md.supportsBatchUpdates());
        System.out.println(md.supportsMixedCaseIdentifiers());
        System.out.println(md.supportsMultipleTransactions());
        System.out.println(md.supportsPositionedDelete());
        System.out.println(md.supportsPositionedUpdate());
        System.out.println(md.supportsSchemasInDataManipulation());
        System.out.println(md.supportsTransactions());
        System.out.println(md.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
        System.out.println(md.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));
        System.out.println(md.insertsAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
        System.out.println(md.updatesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
    }
    */