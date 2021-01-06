package Udemy.Kloekcje_Listy_Mapy_Kolejki.Wildcards;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

      // znak wieloznaczności
      // bounded - ograniczony znak wieloznaczności

        List<String> listaStingów = new ArrayList<>();

        List<SuperClass> listaClass = new ArrayList<>();

        listaClass.add(new SuperClass());
        listaClass.add(new SubClass());

        //SuperClass.tester(listaStingów);
        SuperClass.tester(listaClass); // -> w klasie SuperdClass dodaliśmy oraniczenie co do parametrów klasy która może być użyta
        // możemy zastosować SuperClass albo klasy pochodne
        //  <? extends SuperClass>

    }


}
