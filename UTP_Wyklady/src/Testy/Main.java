package Testy;


import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String filename = "file.txt";
        char [] chars = {35, 104, 111, 116, 49, 54, 99, 104, 97, 108, 108, 101, 110, 103, 101, 50};
        BufferedWriter write = new BufferedWriter(new FileWriter(new File(filename)));
        write.write(chars);
        write.close();
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(filename));

    }
}
