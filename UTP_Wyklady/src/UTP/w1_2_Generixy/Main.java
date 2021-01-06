package UTP.w1_2_Generixy;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        Para p1 = new Para();
        Para<String, Integer> p2 = new Para<>("Kaja", 123);
        Para<String, String> p3 = new Para<>("Kajka", "Dupodajka");
        System.out.println(Para.getCount());

        System.out.println(p2.getFirst().getClass() + " " + p2.getLast().getClass());

        System.out.println("******************************");

        for (Method m : p2.getClass().getDeclaredMethods()){
            if( !m.getName().equals("main"))
                System.out.println(m);
        }
        System.out.println();

    }
}
