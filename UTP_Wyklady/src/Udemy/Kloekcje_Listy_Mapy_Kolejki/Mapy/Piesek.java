package Udemy.Kloekcje_Listy_Mapy_Kolejki.Mapy;

import java.util.stream.Stream;

public class Piesek {

    String imie;
    String rasa;
    Integer wiek;

    public Piesek(String imie, String rasa, Integer wiek) {
        this.imie = imie;
        this.rasa = rasa;
        this.wiek = wiek;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public Integer getWiek() {
        return wiek;
    }

    public void setWiek(Integer wiek) {
        this.wiek = wiek;
    }

    @Override
    public String toString() {
        return "Piesek: " + imie + " " + rasa + " " + wiek;
    }
}
