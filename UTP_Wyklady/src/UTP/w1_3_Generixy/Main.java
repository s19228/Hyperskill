package UTP.w1_3_Generixy;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

     NaszeZwierze<Pies> p = new NaszeZwierze<>(new Pies("Kuba"));
    for (Method m : p.getClass().getDeclaredMethods()){
        System.out.println(m);
    }

    p.startSpeakAndStop();
    p.get().merda();





    }

}
