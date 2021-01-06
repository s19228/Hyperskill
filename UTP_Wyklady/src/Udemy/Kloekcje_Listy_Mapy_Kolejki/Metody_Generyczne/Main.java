package Udemy.Kloekcje_Listy_Mapy_Kolejki.Metody_Generyczne;

import Udemy.Kloekcje_Listy_Mapy_Kolejki.Wildcards.SuperClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Figura figura1 = new Kolo();
        Figura figura2 = new Kwadrat();
        Figura [] figury = new Figura[50];

        List<Figura> listaFigur = new ArrayList<>();
        listaFigur.add(figura1);
        listaFigur.add(figura2);


        Edytor.wypisz(listaFigur);

        Float [] fl = new Float[50];
        Integer [] in = new Integer[50];
        Number [] nu = new Number[50];

        Collection <Number> cn = new ArrayList<>();

        Edytor.przepiszTabliceDoKolekcji(fl, cn);
        Edytor.przepiszTabliceDoKolekcji(in, cn);
        Edytor.przepiszTabliceDoKolekcji(nu, cn);
        Edytor.przepiszTabliceDoKolekcji(figury, cn);

        Edytor.wypisz2(listaFigur);

    }


}
