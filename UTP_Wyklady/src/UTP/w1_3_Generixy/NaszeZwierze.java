package UTP.w1_3_Generixy;

public class NaszeZwierze <T extends Zwierz & Moveable & Speakable & Breathable>{

    private T zmienna;

    public NaszeZwierze(T zwierze) {
        this.zmienna = zwierze;
    }

    public void speak(){
        System.out.println(zmienna.getTyp() + " " + zmienna.getImie()  + " mowi " + zmienna.getVoice(Speakable.LOUD) );
    }

    T get(){
        return zmienna;
    }

    public void startSpeakAndStop(){
        zmienna.start();
        speak();
        zmienna.stop();
    }




}
