package UTP.w6_3_PrzykladPotokow_Przepisywacze;

import java.io.*;

class PipesShow {
  
  PipedWriter authorWrites = new PipedWriter(); // potok, do kt�rego pisze autor 
  PipedReader duplicatorReads;                  // potok, z ktorego czyta duplikator
  
  Duplicator dup;                                
  
  PipesShow(int numLines, int numWriters) {
    
    // ka�dy przepisywacz na swoj� przestrze� pisania
    SpaceToWrite[] writeSpace = new SpaceToWrite[numWriters];
    for (int i=0; i < writeSpace.length; i++) 
      writeSpace[i] = new SpaceToWrite(20, 30); // 20 wierszy, 30 kolumn
    
    try {
      // Po��czenie potoku do ktorego pisze autor
      // z nowoutworzonym potokiem, z kt�rego b�dzie czyta� duplikator
      duplicatorReads = new PipedReader(authorWrites);
      
      // utworzenie duplikatora (on z kolei stworzy i uruchomi przepisywaczy)
      dup = new Duplicator(duplicatorReads, // sk�d b�dzie czyta�
                           writeSpace);     // przetstrze� pisania dla przepisywaczy
      
      // start w�tku duplikatora
      dup.start();    
      
    } catch (IOException exc) {
        System.out.println("Nie mo�na stworzy� duplikatora");
        exc.printStackTrace();
        System.exit(1);
    }
    
    SpaceToWrite.show(numWriters); // pokazanie og�lnej przestrzeni pisania
                                   // grupuj�cej przestrzenie pisania 
                                   // ka�dego przepisywacza 

    // Teraz autor b�dzie pisa�!
    // Utworzenie obiektu klasy Autor powoduje rozpocz�cie przez niego pisania
    
    String words[] = { "Ala", "ma", "kota", "i", "psa" };
    
    Author autor = new Author(numLines,      // ile wierszy ma napisa�
                              words,         // z jakich s��w sk�ada� teksty
                              authorWrites); // Dok�d je zapisywa� 
  }

  public static void main(String args[]) { 
    int numLin = 0; // ile wierszy ma napisa� autor
    int numWri = 0; // ilu jest przepisywaczy
    try {
      numLin = Integer.parseInt(args[0]);
      numWri = Integer.parseInt(args[1]);
    } catch(Exception exc) {
        System.out.println("Syntax: java  PipesShow numLines numWri");
        System.exit(1);
    }    
    new PipesShow(numLin, numWri);  
  }
}
