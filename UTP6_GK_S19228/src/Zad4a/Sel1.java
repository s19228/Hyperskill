package Zad4a;

import java.sql.*;

public class Sel1 {

    static public void main(String[] args) {
        new Sel1();
    }

    Statement stmt;
    Connection con;
    String driverName = "org.apache.derby.jdbc.EmbeddedDriver";
    String url = "jdbc:derby:C:/DerbyDbs/ksidb";

    Sel1() {
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url);

        } catch (Exception exc) {
            System.out.println(exc);
            System.exit(1);
        }
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "SELECT A.NAME, P.TYTUL, P.ROK, P.CENA FROM POZYCJE P , AUTOR A WHERE P.ROK > 2000 AND P.CENA > 30 AND A.AUTID = P.AUTID";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String nazwisko = rs.getString(1);
                String rok = rs.getString(3);
                double cena = rs.getDouble(4);
                String tytul = rs.getString(2);
                System.out.println("Autor: " + nazwisko + " rok: " + rok + " cena: " + cena + " tytuł: " + tytul);
            }
            stmt.close();
            con.close();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

