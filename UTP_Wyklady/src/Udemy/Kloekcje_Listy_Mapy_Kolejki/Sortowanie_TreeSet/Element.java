package Udemy.Kloekcje_Listy_Mapy_Kolejki.Sortowanie_TreeSet;

class Element implements Comparable
{
    int wartosc;
    String opis;
    public Element(int wartosc)
    {
        this.wartosc = wartosc;
    }
    public Element(int wartosc, String opis)
    {
        this(wartosc);
        this.opis = opis;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return this.wartosc == ((Element)obj).wartosc;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 14 * hash + this.wartosc;
        return hash;
    }
    public String pobierzOpis()
    {
        return opis;
    }

    public int getWartosc() {
        return wartosc;
    }

    public int compareTo(Object o)
    {
        return wartosc - ((Element)o).wartosc;
    }

    @Override
    public String toString() {
        return wartosc + ", opis='" + opis;
    }
}