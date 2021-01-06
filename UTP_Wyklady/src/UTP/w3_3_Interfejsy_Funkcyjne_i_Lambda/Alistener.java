package UTP.w3_3_Interfejsy_Funkcyjne_i_Lambda;

import javax.swing.*;
import java.awt.*;

public class Alistener extends JFrame {

    public Alistener() throws HeadlessException {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JButton b = new JButton("OK");
        b.addActionListener( e -> b.setText(b.getText() + " -*"));
        add(b);
        setSize(100,100);
        setVisible(true);

    }
}
