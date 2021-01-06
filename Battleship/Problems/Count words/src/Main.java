import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String tmp = reader.readLine().trim();
        reader.close();

        if(tmp.isEmpty()){
            System.out.println("0");
        } else {
            String[] arr = tmp.split("\\s");
            int counter = 0;
            for (String s : arr) {
                if (!s.isEmpty()) {
                    counter++;
                }
            }
            System.out.println(counter);
        }
        reader.close();
    }
}