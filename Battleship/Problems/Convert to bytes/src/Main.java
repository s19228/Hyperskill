import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        int tmp = inputStream.read();
        while (tmp != -1) {
            System.out.print(tmp);
            tmp = inputStream.read();
        }
        inputStream.close();
    }
}
