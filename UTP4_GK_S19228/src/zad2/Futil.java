package zad2;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Futil {

    public static void processDir(String dir, String resultFileName) {

        try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(resultFileName)), Charset.forName("UTF8")))) {
            if (Files.notExists(Paths.get(dir)))
                System.out.println("There is no such dir");
            else {
                Files.walk(Paths.get(dir)).filter(Files::isRegularFile)
                        .filter(path -> Files.isReadable(path))
                        .forEach(cat -> {
                            try {
                                Files.lines(cat, Charset.forName("Cp1250"))
                                        .forEach((String str) -> {
                                            try {
                                                out.write(str);
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                                e.getMessage();
                                            }
                                        });
                            } catch (IOException e) {
                                e.printStackTrace();
                                e.getMessage();
                            }
                        });
            }
        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
            System.out.println("Something goes wrong...");
        }
    }
}

