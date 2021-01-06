package Ksiazka.Programowanie_Wielowatkowe.Synhronizacja_metod.Po_uzyciu_synchronized;

public class Callme {

    void call(String msg){
        System.out.println("["+ msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("]");
    }

}
