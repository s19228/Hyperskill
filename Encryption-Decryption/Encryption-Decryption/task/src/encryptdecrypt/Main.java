package encryptdecrypt;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Encrypt en =  new Encrypt(args);

        en.encrypt();

    }
}
