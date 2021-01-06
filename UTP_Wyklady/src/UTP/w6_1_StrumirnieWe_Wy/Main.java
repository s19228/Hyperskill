package UTP.w6_1_StrumirnieWe_Wy;

import java.io.*;
import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        try {
            FileReader in = new FileReader("informatyka.txt");
            FileWriter out = new FileWriter("copy_informatyka.txt");

            Stream.copy(in, out);

            in.close();
            out.close();

            //***************************************************************//

            String msg = "Ale daje za pieniadze";
            StringReader sr = new StringReader(msg);

            FileWriter fr = new FileWriter("ala.txt");
            Stream.copy(sr, fr);

            sr.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Program zapisuje do strumienia obiekty - datę, tablicę opisów i odpowiadającą każdemu opisowi temperaturę. Następnie odczytuje te obiekty ze strumienia i odtwarza je.

        Date data = new Date();
        int[] tenperatura = {25, 19, 22};
        String[] opis = {"dzień", "noc", "woda"};

        //Zapis obiektów


        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.ser"));

            out.writeObject(data);
            out.writeObject(tenperatura);
            out.writeObject(opis);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // odtworzenie obiektów np. w innym programie

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.ser"));

            Date odczytDaty = (Date) in.readObject();
            int [] odczytTemperatury = (int []) in.readObject();
            String [] odczytOpisu = (String []) in.readObject();
            in.close();

            System.out.println(String.valueOf(odczytDaty));
            for (int i =0; i < odczytOpisu.length; i++){
                System.out.println(odczytOpisu[i] + " " + odczytTemperatury[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //spróbujmy podziałać na naszych obiektach

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.down"));

            TestClass [] klasaTestowa = {
                    new TestClass("Dupa", 12, true),
                    new TestClass("Jasia", -14, false),
                    new TestClass("Pierdzi", 120, true),
                    new TestClass("Najebana", -142, false),
                    new TestClass("Stasia", 0, false),
                    new TestClass("", 02, true),
            };

            out.writeObject(klasaTestowa);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.down"));
            TestClass [] odczyt = (TestClass[]) in.readObject();
            in.close();

            System.out.println(Arrays.asList(odczyt));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




    }


}
