package UTP.w6_3_PrzykladPotokow_Przepisywacze;// Klasa, okre�laj�ca przestrzenie
// na kt�rych pisz� przepisywacze
// oraz grupuj�ca te przestrzenie w oknie.
// Ka�dy przepisywacz wypisuje tekst 
// do wielowierszowego pola edycyjnego (TextArea z pakietu AWT)
// do czego s�u�y mu metoda writeLine.
// Wszystkie przestrzenie grupowane s� w oknie frame.

import java.awt.*;
import java.awt.event.*;

public class SpaceToWrite extends TextArea {
  
  private static Frame frame = new Frame("Write space");
  
  // Konstruktor: tworzy now� przetrze� pisania dla jednego przepisywacza
  public SpaceToWrite(int rows, int cols) {
    super(rows, cols);  // utworzenie TextArea  - z podan� liczb� wierszy, kolumn 
    frame.add(this);    // dodanie TextArea do okna
  }
  
  // Metoda dopisuj�ca nowy wiersz do textarea
  public void writeLine(String s) {
    this.append(s + '\n');
  }

  // Metoda ustalaj�ca u�o�enie p�l edycyjnych w oknie
  // rozmiar okna (pack daje rozmiar taki jak akurat potrzreba)
  // i pokazuj�ca okno    
  public static void show(int numWriters) {
    frame.setLayout(new GridLayout(0, numWriters));  
    frame.pack();
    frame.show();
    
    // Umo�liwienie zako�czenia aplikacji poprzez zamkni�cie okna
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        frame.dispose();
        System.exit(1);
      }
    });
  }  

  
}