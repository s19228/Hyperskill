import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer s = new StringBuffer(reader.readLine());
        s.reverse();
        System.out.println(s.toString());
        reader.close();
    }
}