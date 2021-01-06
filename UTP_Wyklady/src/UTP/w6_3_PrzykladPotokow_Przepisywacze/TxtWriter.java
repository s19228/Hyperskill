package UTP.w6_3_PrzykladPotokow_Przepisywacze;

import java.io.*;

public class TxtWriter extends Thread {  // Klasa przepisywacza

  private LineNumberReader in;   // strumie� sk�d czyta
  private SpaceToWrite spw;      // miejsce gdzie pisze
    
  public TxtWriter(String name,      // nazwa przepisywacza
                   Reader in_,       // z jakiego strumeinia czyta 
                   SpaceToWrite spw_ // gdzie pisze 
                   ) 
  {
    super(name);
    in = new LineNumberReader(in_);  // filtrowanie strumienia
                                     // by mie� numery wierszy 
    spw = spw_;                                     
  }
  
  // Kod w�tku przepisywacza
  // czyta wiersze ze strumienia wej�ciowego
  // i zapisuje je w miejscu oznaczanym spw (SpaceToWrite) 
  // dop�ki nie nadszedl sygna� o ko�cu pracy (tekst "Koniec pracy")
  public void run() {
    spw.writeLine(" *** " + getName() + " rozpocz�� prac�" + " ***");
    spw.writeLine("---> czekam na teksty !");
    String txt;
    try {
      txt = in.readLine();
      while(!txt.equals("Koniec pracy")) { 
        spw.writeLine(in.getLineNumber() + " " + txt);
        txt = in.readLine();
      }
      in.close();
      spw.writeLine("**** " + getName() + " sko�czy� prac�"); 
    } catch(IOException exc) {
        spw.writeLine("****" + getName() + " - zakonczenie na skutek bledu");
        exc.printStackTrace();
        return;
    }
  }
}        
    
        