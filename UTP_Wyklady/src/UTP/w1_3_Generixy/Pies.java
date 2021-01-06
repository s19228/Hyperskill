package UTP.w1_3_Generixy;

public class Pies extends Zwierz implements Speakable, Moveable, Breathable {

    public Pies() {

    }

    public Pies(String imie) {
        super(imie);
    }

    public Pies merda(){
        System.out.println("Pieseczek merda ogonkiem");
        return this;
    }


    @Override
    public Moveable start() {
        System.out.println("Piesek "  + getImie() + " biegnie.");
        return this;
    }

    @Override
    public Moveable stop() {
        System.out.println("Piesek "  + getImie() + " niucha");
        return this;
    }

    @Override
    public String getVoice(int voice) {
        if (voice == LOUD)
            return "Hau, hau, hau!!";
        else
            return "Hau...";
    }

    @Override
    public String getTyp() {
        return "Pies";
    }

    @Override
    public Breathable breath() {
        System.out.println("Piesek radośnie oddycha");
        return this;
    }

    @Override
    public Breathable dontBreath() {
        System.out.println("Piesek is dead - nie dycha zwierz");
        return this;
    }
}
