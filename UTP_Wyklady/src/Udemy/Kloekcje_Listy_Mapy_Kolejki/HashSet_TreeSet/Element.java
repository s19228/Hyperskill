package Udemy.Kloekcje_Listy_Mapy_Kolejki.HashSet_TreeSet;

public class Element {

    int wartosc;
    double dupa;

    public Element(int wartość) {
        this.wartosc = wartość;
    }

    @Override
    public boolean equals(Object obj) {
        return this.wartosc == ((Element) obj).wartosc;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 14 * hash + this.wartosc;
        return hash;
    }


}
