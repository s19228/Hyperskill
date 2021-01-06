package UTP.w3_1_Lambda_Wyrazenia;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        /*
        SKLADNIA LAMBDA WYRAZENIA

        (lista_parametrow) -> cialo lambda

        lp - rozdzielone przecinkami deklaracje argumentow przekazywanych  lambda wyrazeniu
        cl - jednow ywrazenie lub blok instrukcji ujetych w nawiasy {}
         */

       IntProcesor ip = (int i) -> {
           return i+1;
       };

       SAMA sama = (int a) -> {
           System.out.println((a + 2));
       };

       sama.doWork(3);

        System.out.println(sama.toString());

       int arr[] = {1 , 2 , 3};

       Object obj = LampSample.getProcessor();

       int x = ip.process(1);
       System.out.println(x);

       LampSample.arrOp(arr, i -> i+3);
       System.out.println(Arrays.toString(arr));

        String [] tab1 = {"Ale numer...", "Potwierdzone info!", "Słow nie ma co oni wyprawiają!", "Puść dalej", "Szok nie mogę uwierzyć...", "A to już słyszałeś?"};

        Sample.aarrOp(tab1, n -> n+1);
        System.out.println(Arrays.toString(tab1));




    }

}
