import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calc {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    char c;

        do {
        try {
            c = (char) br.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(c);
    } while (c != 'q');

    public String doCalc(String arg) {
        
    }
}
