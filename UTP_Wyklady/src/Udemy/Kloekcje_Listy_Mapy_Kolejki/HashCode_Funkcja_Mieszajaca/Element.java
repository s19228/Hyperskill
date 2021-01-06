package Udemy.Kloekcje_Listy_Mapy_Kolejki.HashCode_Funkcja_Mieszajaca;

import java.util.Objects;

public class Element {

    int wartość;
    double dupa;

    public Element(int wartość) {
        this.wartość = wartość;
    }

    @Override
    public boolean equals(Object obj) {
        return this.wartość == ((Element) obj).wartość;
    }


}
