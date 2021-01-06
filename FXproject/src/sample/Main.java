package sample;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    //kolejka zdarzeń służy do przechowywania zdarzeń
    public static void main(String[] args) {

    }

    public Main() {

        this.setTitle("Iwent Qju");
        this.setSize(400, 300);
        this.setVisible(true);

        this.getContentPane().add(combo, BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    final static JComboBox combo = new JComboBox();

}
