package sample;

import java.awt.*;

public class BezpiecznyWatekSwing implements Runnable {

    int i = 0;

    @Override
    public void run() {
        while (i < 1000){
            EventQueue.invokeLater(() -> {
                bezpiecznaEdycjaComboBoxa();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public void bezpiecznaEdycjaComboBoxa() {
        Main.combo.insertItemAt("dupa" + i, 0);
        i++;
    }
}
