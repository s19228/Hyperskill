package Udemy.Kloekcje_Listy_Mapy_Kolejki.ArrayList_i_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        ArrayList listaTablicowa;
        LinkedList listaPolaczona;

        ListaPolaczona listaPolaczona1 = new ListaPolaczona();
        listaPolaczona1.wartosc = 10;

        listaPolaczona1.nastepna = new ListaPolaczona();
        listaPolaczona1.nastepna.wartosc = 20;

        listaPolaczona1.nastepna.nastepna = new ListaPolaczona();
        listaPolaczona1.nastepna.nastepna.wartosc = 30;

        System.out.println(listaPolaczona1.wartosc);
        System.out.println(listaPolaczona1.nastepna.wartosc);
        System.out.println(listaPolaczona1.nastepna.nastepna.wartosc);



    }


}
