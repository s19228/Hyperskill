package Udemy.Kloekcje_Listy_Mapy_Kolejki;

public class NaszaKlasa<Cokolwiek> {

    Cokolwiek nazwaZmiennejTypuCokolwiek;

    public Cokolwiek zwroc(){
        return this.nazwaZmiennejTypuCokolwiek;
    }

    public void nadajWartosc(Cokolwiek wartosc){
        this.nazwaZmiennejTypuCokolwiek = wartosc;
    }

    @Override
    public String toString() {
        return "NaszaKlasa{" +
                "nazwaZmiennejTypuCokolwiek=" + nazwaZmiennejTypuCokolwiek +
                '}';
    }
}
