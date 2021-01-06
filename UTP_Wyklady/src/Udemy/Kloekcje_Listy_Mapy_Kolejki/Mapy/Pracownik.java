package Udemy.Kloekcje_Listy_Mapy_Kolejki.Mapy;

public class Pracownik {

    public static int i =0;
    private int ID;
    String imie;


    public Pracownik() {
        i ++;
        ID = i;
    }

    public Pracownik(String imie) {
        this(); // tu wywołujemy konstruktor wyżej!
        this.imie = imie;
    }

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        Pracownik.i = i;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "ID=" + ID +
                ", imie='" + imie + '\'' +
                '}';
    }
}
