package UTP.w6_3_PrzykladPotokow_Przepisywacze;

import java.io.IOException;
import java.io.Writer;
import java.util.Random;

public class Author {

    private int linesToWrite;    // ile wierszy ma napisac autor
    String[] words;              // z jakich sl�w si� b�d� sk�ada�
    private Writer out;          // strumie� do kt�rego zapisuje teksty
    static final int N = 5;      // maksymalna liczba s��w w wierszu

    public Author(int l, String[] words, Writer w) {
        linesToWrite = l;
        this.words = words;
        out = w;
        try {
            write();                  // wywo�anie pisania
        } catch (IOException exc) {
            System.out.println(exc.toString());
        } catch (InterruptedException exc) {
        }
    }

    // Metoda pisania przez autora
    public void write() throws IOException,
            InterruptedException {
        Random rand = new Random();
        for (int i = 0; i < linesToWrite; i++) {

            // Ka�dy wiersz sk�ada si� z losowo wybranej nw liczby s��w
            int nw = rand.nextInt(N) + 1;
            String line = "";

            for (int k = 0; k < nw; k++) {   // s�owa s� losowane z tablicy words
                int wordNum = rand.nextInt(words.length);
                line += words[wordNum] + " ";
            }
            out.write(line);
            out.write('\n');
            Thread.sleep((rand.nextInt(3) + 1) * 1000);  // autor my�i nad
        }                                              // nast�pnym wierszem :-)
        out.write("Koniec pracy\n");
        out.close();
        System.out.println("Autor sko�czy� pisa�");
    }
}
        
      
    