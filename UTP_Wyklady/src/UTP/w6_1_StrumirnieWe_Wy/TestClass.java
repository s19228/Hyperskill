package UTP.w6_1_StrumirnieWe_Wy;

import java.io.Serializable;

public class TestClass implements Serializable {

    transient int a; // Nie jest trwała
    int b; // Jest trwała
    volatile int c;



    //volatile informuje kompilator, iż oznaczona nim zmienna może zostać nieoczekiwanie
    //zmieniona przez inną część programu.

    /*
    Takie interfejsy jak Serializable (bez metod) nazywane są interfejsami znacznikowymi. Ich jedyną funkcją jest umożliwienie sprawdzenia typu np. za pomocą operatora instanceof.
    Metoda writeObject to własnie robi, gdy podejmuje decyzje o zapisie: jeśli jej argument x jest typu Serializable (x instanceof Serializable ma wartośc true),
    to obiekt jest zapisywany do strumienia, w przeciwnym razie - nie
     */

    String name;
    int number;
    boolean value;

    public TestClass(String name, int number, boolean value) {
        this.name = name;
        this.number = number;
        this.value = value;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", value=" + value +
                '}';
    }
}
