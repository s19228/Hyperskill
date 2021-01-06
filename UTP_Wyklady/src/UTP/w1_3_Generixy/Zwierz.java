package UTP.w1_3_Generixy;

public abstract class Zwierz {

    private String imie = "Bez imienia";

    Zwierz() {
    }

    public Zwierz(String imie) {
        this.imie = imie;
    }

    public abstract String getTyp();

    public String getImie(){
        return this.imie;
    }



}
