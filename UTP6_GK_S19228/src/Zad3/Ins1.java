/**
 * @author Gryka Konrad S19228
 */

package Zad3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ins1 {

    static public void main(String[] args) {
        new Ins1();
    }

    PreparedStatement stmt;
    Connection con;
    String driverName = "org.apache.derby.jdbc.EmbeddedDriver";
    String url = "jdbc:derby:C:/DerbyDbs/ksidb";


    Ins1() {
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url);

        } catch (Exception exc) {
            System.out.println(exc);
            System.exit(1);
        }

        // nazwy wydawców do wpisywania do tabeli`
        String[] wyd = {"PWN", "PWE", "Czytelnik", "Amber", "HELION", "MIKOM"};

        // pierwszy numer wydawcy do wpisywania do tabeli: PWN ma numer 15, PWE ma 16, ...
        int beginKey = 15;
        int counter = 0;

        try {
            stmt = con.prepareStatement("INSERT INTO WYDAWCA VALUES(?,?)");
            for (int i = 0; i < wyd.length; i++) {
                stmt.setInt(1, beginKey + i);
                stmt.setString(2, wyd[i]);
                stmt.executeUpdate();     //         Uwaga: inna forma executeUpdate()
                System.out.println("Dodano wiersz w tabeli WYDAWCA, ID: " + (beginKey + i) + " wartość: " + wyd[i]);
                counter++;
            }
            System.out.println("Do tabeli dodano: " + counter + " rekordów");


        /*
        String[] ins = {"tu", "instukcje", "sql"}; // ? ... tablica instrukcji SQL do wpisywania rekordów do tabeli: INSERT ...
        int insCount = 0;   // ile rekordów wpisano
        try {
            for (int i = 0; i < ins.length; i++) // wpisywanie rekordów
            {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

            /*
             * przy ponownym wykonaniu programu otrzymujemy błąd:
             * org.apache.derby.shared.common.error.DerbySQLIntegrityConstraintViolationException: Instrukcja została przerwana, ponieważ mogła spowodować powstanie duplikatu wartości klucza w regule ograniczającej klucz unikalny
             * lub podstawowy albo w unikalnym indeksie identyfikowanym przez obiekt 'SQL200627150854690' zdefiniowany dla 'WYDAWCA'.
             */

            counter = 0;
            stmt = con.prepareStatement("DELETE FROM WYDAWCA WHERE WYDID = ?");
            for (int i = 0; i < wyd.length; i++) {
                stmt.setInt(1, beginKey + i);
                stmt.executeUpdate();     //         Uwaga: inna forma executeUpdate()
                System.out.println("Usunięto wiersz z tabeli WYDAWCA, ID: " + (beginKey + i) + " wartość: " + wyd[i]);
                counter++;
            }
            System.out.println("Z tabeli usunięto: " + counter + " rekordów"); // long getLargeUpdateCount()
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
