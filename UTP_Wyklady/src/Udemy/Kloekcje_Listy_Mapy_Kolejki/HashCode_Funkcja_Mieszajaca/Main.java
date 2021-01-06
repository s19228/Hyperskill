package Udemy.Kloekcje_Listy_Mapy_Kolejki.HashCode_Funkcja_Mieszajaca;

public class Main {

    public static void main(String[] args) {

        //hascode (liczba całkowita) - to tzw kod mieszający
        System.out.println("abba".hashCode());

        Element a = new Element(5);
        Element b = new Element(5);

        System.out.println(a==b);
        System.out.println(a.equals(b));

        System.out.println(a.hashCode() + " " + b.hashCode());



    }



}
