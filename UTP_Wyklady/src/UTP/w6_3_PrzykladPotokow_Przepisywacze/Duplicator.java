package UTP.w6_3_PrzykladPotokow_Przepisywacze;

import java.io.*;

public class Duplicator extends Thread {
  
  PipedReader fromAuthor;    // potok od autora
  PipedWriter[] toWriters;   // potoki do przepisywaczy
  
  public Duplicator(PipedReader pr,       // potok od autora
                    SpaceToWrite[] space  // na czym pisz� pzrepisywacze?
                    ) throws IOException {
    fromAuthor = pr;
    
    int numOfWriters = space.length;      // tylu jest przepisywaczy
                                          // ile miejsc na kt�rych pisz�  
    
    // Tworzymy tablic� potok�w do przepisywaczy
    toWriters = new PipedWriter[numOfWriters];
    
    for (int i = 0; i < numOfWriters; i++) { // dla ka�dego przepisywacza
      
      // tworzymy potok do niego
      toWriters[i] = new PipedWriter();     
      
      // tworzymy przepisywacza
      // podaj�c: nazw�, z jakiego potoku ma czyta�, miejsce gdzie ma pisa�
      TxtWriter tw = new TxtWriter("TxtWriter " + (i+1),
                                   new PipedReader( toWriters[i]), // po��czenie! 
                                   space[i]);
      
      // uruchamiamy w�tek przepisywacza
      tw.start();  
    }
  }
  
  // Kod wykonywany w w�tku Duplikatora
  public void run() {
    try {
      // Buforowanie potoku od autora
      BufferedReader in = new BufferedReader(fromAuthor);
      
      // czytanie wierszy z potoku od autora 
      // i zapisywanie ich do potok�w, czytanych przez przepisywaczy
      while (true) {
        String line = in.readLine();
        for (int i = 0; i < toWriters.length; i++) {
          toWriters[i].write(line);
          toWriters[i].write('\n');
        }
        if (line.equals("Koniec pracy")) break;
      }
    } catch (IOException exc) { return; }
    System.out.println("Duplikator zako�czy� dzia�anie");
  }  
        
} 
      
    
    
  