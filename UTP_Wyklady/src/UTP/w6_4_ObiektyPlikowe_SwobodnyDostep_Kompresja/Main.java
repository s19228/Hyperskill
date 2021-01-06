package UTP.w6_4_ObiektyPlikowe_SwobodnyDostep_Kompresja;

import java.io.*;
import java.net.URI;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) throws IOException {

        File f = new File("test.down");
        URI myURi = f.toURI();
        System.out.println(myURi);

        RandomAccessFile raf = new RandomAccessFile("test.down", "r");
        try {
            System.out.println(raf.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Aby skompresować (spakować) dane i zapisać je do pliku ZIP trzeba wykonać następujące kroki.

        ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("nazwa.zip")
                )
        );

        ZipEntry entry = new ZipEntry("nazwa");
        zip.putNextEntry(entry);

        zip.closeEntry();

        //Przy rozpakowaniu archiwum możemy użyć klasy ZipFile lub ZipInputSteram. W tym ostatnim przypadku kolejność działań jest następująca.
        //Stworzenie rozpakowującego strumienia wejściowego:

        ZipInputStream zis = new  ZipInputStream(
                new BufferedInputStream(
                        new FileInputStream("nazwa.zip")
                )
        );

        //Przetwarzanie (rozpakownaie) elementów archiwum:

        ZipEntry entry2; // element archiwum (spakowany plik lub katalog)

        // Dopóki są w w archiwum elementy
        // Pobieramy je i przetwarzamy
        while((entry2 = zis.getNextEntry()) != null) {
            String ename = entry.getName(); // nazwa elementu archiwum
             //...
        }


    }
}
