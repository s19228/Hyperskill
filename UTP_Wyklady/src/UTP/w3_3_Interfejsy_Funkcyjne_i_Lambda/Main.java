package UTP.w3_3_Interfejsy_Funkcyjne_i_Lambda;

import javax.swing.*;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws ParseException {

        SwingUtilities.invokeLater( ()-> new Alistener());

        System.out.println(Arrays.toString(getfiles("C:\\Users\\conra\\Downloads", "exe", "1998-05-01")));


    }

    static File [] getfiles(String dir, String ext, String afterDate) throws ParseException {
        long time = new SimpleDateFormat("yyyy-MM-dd").parse(afterDate).getTime();
        File [] files =  new File(dir).listFiles(f -> f.isFile() && f.getName().endsWith(ext) && f.lastModified() > time);
        return files;
    }
}
