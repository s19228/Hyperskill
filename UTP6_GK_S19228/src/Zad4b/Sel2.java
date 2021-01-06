
package Zad4b;

import java.sql.*;

public class Sel2 {

    static public void main(String[] args) {
        new Sel2();
    }

    Statement stmt;
    Connection con;
    String driverName = "org.apache.derby.jdbc.EmbeddedDriver";
    String url = "jdbc:derby:C:/DerbyDbs/ksidb";

    Sel2() {

        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url);

        } catch (Exception exc) {
            System.out.println(exc);
            System.exit(1);
        }

        String sel = "SELECT A.NAME, P.TYTUL, P.ROK, P.CENA FROM POZYCJE P , AUTOR A WHERE A.AUTID = P.AUTID";

        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery(sel);
            ResultSetMetaData rsmd = rs.getMetaData();
            int count = 1;

            /*
                while (rs.next()) {
                String nazwisko = rs.getString(1);
                String rok = rs.getString(3);
                double cena = rs.getDouble(4);
                String tytul = rs.getString(2);
                System.out.println(count + ". Autor: " + nazwisko + " rok: " + rok + " cena: " + cena + " tytuł: " + tytul);
                count++;
            }*/

            int cc = rsmd.getColumnCount();

            for (int i = 1; i <= cc; i++) {
                System.out.print(rsmd.getColumnLabel(i) + "     ");
                //System.out.println(rsmd.getColumnName(i));           // - nazwa
                //System.out.println(rsmd.getColumnDisplaySize(i));    // - szerokość
                //System.out.println(rsmd.getColumnClassName(i));      // - klasa Javy
                //System.out.println(rsmd.getColumnType(i));           // - typ SQL
                //System.out.println(rsmd.getColumnTypeName(i));       // - typ RDBMS
            }

            rs.afterLast();
            System.out.println("\n------------------------------ przewijanie do góry");

            while (rs.previous()) {
                String nazwisko = rs.getString(1);
                String rok = rs.getString(3);
                double cena = rs.getDouble(4);
                String tytul = rs.getString(2);
                System.out.println(count + ". Autor: " + nazwisko + " rok: " + rok + " cena: " + cena + " tytuł: " + tytul);
                count++;
            }

            System.out.println("\n----------------------------- pozycjonowanie abs.");
            rs.first();
            int[] poz = {3, 7, 9};
            for (int p = 0; p < poz.length; p++) {
                System.out.print("[ " + poz[p] + " ] ");

                for (int i = 1; i <= cc; i++){
                    System.out.print(rs.getString(i) + ", ");
                    rs.absolute(poz[i]);
                }
                System.out.println("");
            }
            stmt.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
