package UTP.w6_4_ObiektyPlikowe_SwobodnyDostep_Kompresja;

import javax.swing.*;
import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

class ZipArch {

    // rozmiar bufora dla plików
    static final int BUF_SIZE = 4096;

    // Znak separatora katalogu ("\" lub "/" - zależnie od platformy)
    static final private String fileSep = System.getProperty("file.separator");

    private String zipFileName;  // archiwum ZIP

    // konstruktor; argument - nazwa archiwum (tworzonego lub rozpakowywanego)
    public ZipArch(String fileName) {
        zipFileName = fileName;
    }

    private boolean verbose = true; // czy pokazywać postępy?

    public void setVerbose(boolean b) {
        verbose = b;
    }

    public boolean isVerbose() {
        return verbose;
    }

    // Metoda rozpakowuje archiwum o nazwie zipFileName
    public void unzip() throws IOException, ZipException {


        // Zbiór createdDirs przechowuje utworzone przy rozpakowywaniu katalogi,
        // tak by szybko stwierdzić czy już katalog utworzyliśmy
        // i nie próbować go tworzyć jeszcze raz (zob. zbiory w rozdz.o kolekcjach)
        Set createdDirs = new HashSet();

        // Utworzenie wejściowego strumienia związanego z plikiem ZIP
        FileInputStream fis = new FileInputStream(zipFileName);

        // Nałożenie na ten strumień przetwarzania w postaci
        // - najpierw buforowania, następnie - dekompresji
        ZipInputStream zis = new  ZipInputStream(
                new BufferedInputStream(fis));

        ZipEntry entry; // element archiwum (spakowany plik lub katalog)

        // Dopóki są w w archiwum elementy
        // Pobieramy je i przetwarzamy
        while((entry = zis.getNextEntry()) != null) {

            String ename = entry.getName(); // nazwa elementu archiwum
            // np. \windows\bum.txt
            // Gdy wączona opcja pokazywania postępów (zob. pole verbose)
            if (verbose) System.out.println("Inflating " + ename);

            // Tworzenie ew. pustych katalogów zapisanych w ZIPie
            // Tylko dla pustego katalogu entry.isDirectory() będzie true
            // Nazwa każdego innego elementu archiwum będzie miała postać
            // [d:][\katalog1\katalog2\...\]plik
            if (entry.isDirectory()) {
                new File(ename).mkdirs(); // tworzymy pusty (z nadkatalogami)
                continue;                 // z pustego nie ma co rozpakować!
            }

            // Jeżeli archiwum zawiera (niepuste) katalogi,
            // to musimy je utworzyć przed rozpakowaniem plików

            int p = ename.lastIndexOf(fileSep); // ostatni znak "/" lub "\"
            if (p != -1) {     // czy "entry" jest plikiem w katalogu?

                // Nazwa katalogu
                String dirName = ename.substring(0,p+1);

                // Jeśli go jeszcze nie utworzyliśmy ...
                if (!createdDirs.contains(dirName)) {

                    createdDirs.add(dirName);       // rejestrujemy, że utworzony!
                    File dir = new File(dirName);
                    boolean created = dir.mkdirs(); // tworzymy (wraz z nadkatalogami)

                    if (!created) {                 // nie udało się utworzyć
                        int rc = JOptionPane.showConfirmDialog(null,
                                "Katalog " + dirName + " już istnieje." +
                                        "Kontynuować?");
                        if (rc != 0)  { // niezgoda na kontynuację programu
                            throw
                                    new IOException("Unable to create directory "+ dirName);
                        }
                    }
                }
            }  // Koniec tworzenia ew. niezbędnego katalogu

            // Teraz dla każdego elementu (pliku) archiwum tworzymy
            // buforowany strumień wyjściowy (do zapisu)
            // o nazwie takiej samej jak w archiwum (ename)

            BufferedOutputStream out = new BufferedOutputStream(
                    new FileOutputStream(ename), // plik out
                    BUF_SIZE                // rozmiar bufora
            );

            byte data[] = new byte[BUF_SIZE]; // tablica. do wczytywania danych
            int count;                        // liczba przeczytanych bajtów
            while ((count = zis.read(data, 0, BUF_SIZE)) != -1) {
                out.write(data, 0, count);
            }
            out.close();
        }
        zis.close();
    }  // Koniec metody unzip

    // Metoda kompresująca: argument - plik lub katalog do spakowania
    public void zip(String srcFileName) throws IOException, ZipException {

        // Zbiór createdDirs przechowuje utworzone przy rozpakowywaniu katalogi,
        // tak by szybko stwierdzić czy już katalog utworzyliśmy
        // i nie próbować go tworzyć jeszcze raz (zob. zbiory w rozdz.o kolekcjach)
        Set createdDirs = new HashSet();

        // Utworzenie wejściowego strumienia związanego z plikiem ZIP
        FileInputStream fis = new FileInputStream(zipFileName);

        // Nałożenie na ten strumień przetwarzania w postaci
        // - najpierw buforowania, następnie - dekompresji
        ZipInputStream  zis = new  ZipInputStream(
                new BufferedInputStream(fis));

        ZipEntry entry; // element archiwum (spakowany plik lub katalog)

        // Dopóki są w w archiwum elementy
        // Pobieramy je i przetwarzamy
        while((entry = zis.getNextEntry()) != null) {

            String ename = entry.getName(); // nazwa elementu archiwum
            // np. \windows\bum.txt
            // Gdy wączona opcja pokazywania postępów (zob. pole verbose)
            if (verbose) System.out.println("Inflating " + ename);

            // Tworzenie ew. pustych katalogów zapisanych w ZIPie
            // Tylko dla pustego katalogu entry.isDirectory() będzie true
            // Nazwa każdego innego elementu archiwum będzie miała postać
            // [d:][\katalog1\katalog2\...\]plik
            if (entry.isDirectory()) {
                new File(ename).mkdirs(); // tworzymy pusty (z nadkatalogami)
                continue;                 // z pustego nie ma co rozpakować!
            }

            // Jeżeli archiwum zawiera (niepuste) katalogi,
            // to musimy je utworzyć przed rozpakowaniem plików

            int p = ename.lastIndexOf(fileSep); // ostatni znak "/" lub "\"
            if (p != -1) {     // czy "entry" jest plikiem w katalogu?

                // Nazwa katalogu
                String dirName = ename.substring(0,p+1);

                // Jeśli go jeszcze nie utworzyliśmy ...
                if (!createdDirs.contains(dirName)) {

                    createdDirs.add(dirName);       // rejestrujemy, że utworzony!
                    File dir = new File(dirName);
                    boolean created = dir.mkdirs(); // tworzymy (wraz z nadkatalogami)

                    if (!created) {                 // nie udało się utworzyć
                        int rc = JOptionPane.showConfirmDialog(null,
                                "Katalog " + dirName + " już istnieje." +
                                        "Kontynuować?");
                        if (rc != 0)  { // niezgoda na kontynuację programu
                            throw
                                    new IOException("Unable to create directory "+ dirName);
                        }
                    }
                }
            }  // Koniec tworzenia ew. niezbędnego katalogu

            // Teraz dla każdego elementu (pliku) archiwum tworzymy
            // buforowany strumień wyjściowy (do zapisu)
            // o nazwie takiej samej jak w archiwum (ename)

            BufferedOutputStream out = new BufferedOutputStream(
                    new FileOutputStream(ename), // plik out
                    BUF_SIZE                // rozmiar bufora
            );

            byte data[] = new byte[BUF_SIZE]; // tablica. do wczytywania danych
            int count;                        // liczba przeczytanych bajtów
            while ((count = zis.read(data, 0, BUF_SIZE)) != -1) {
                out.write(data, 0, count);
            }
            out.close();
        }
        zis.close();
    }  // Koniec metody unzip

    public void zipNewMethod(String srcFileName) throws IOException, ZipException {

        // Strumień wyjściowy archiuwm ZIP
        // na zapisywany plik ZIP nałożone jest buforowanie,
        // a następnie kompresja (strumień przetwarzający ZipOutputStream)
        ZipOutputStream zos = new ZipOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(zipFileName),
                        BUF_SIZE
                )
        );
        // Ze względu na ew. rekurencyjne wchodzenie w podkatalogi żródła
        // wywołujemy wewnętrzną metodę doZip
        // z argumentami plik (lub katalog) do archiwizacji,
        //               zip-strumień wyjściowy
        doZip(new File(srcFileName), zos);
        zos.close();
    }

    // Metoda rekurencyjnie archiwizuje pliki podane jako fileToZip
    // do archiwum, do którego przyłączony jest strumień zos
    private void doZip(File fileToZip, ZipOutputStream zos)
            throws IOException, ZipException
    {
        if (fileToZip.isDirectory()) {  // Jeżeli archiwizacja ma dotyczyć katalogu

            File[] listToZip = fileToZip.listFiles(); // lista obiektów plikowych

            for (int i=0; i<listToZip.length; i++) {
                doZip(listToZip[i], zos);  // dla każdego obiektu plikowego w tym
            }                            // katalogu wolamy rekurencyjnie doZip

        }
        else {  // jezeli to plik - zipujemy!

            String fname = fileToZip.toString();   // nazwa pliku

            // czy przypadkiem nie ma postaci d:\plik_lub_katalog
            // w tym przypadku w nazwie elementu ("wejścia") archiwum
            // pominiemy literowe oznaczenie dysku, dwukropek i separator
            int colon = fname.indexOf(":") + 1;
            if (colon!= 0) fname = fname.substring(colon); // bez "d:"
            if (fname.charAt(0) == fileSep.charAt(0)) { // zdjąć ew. separator
                fname = fname.substring(1);
            }

            // Tworzymy nowe "wejście" - opisujące nowy element archiwum
            ZipEntry entry = new ZipEntry(fname);
            // i zapisujemy to "wejście"
            zos.putNextEntry(entry);

            // informacja o postępach kompresji
            if (verbose) System.out.println("Deflating " + entry);

            // Czytamy plik i zapisujemy jego zawartość
            // w skompresowanej postaci "pod" otwartym "wejściem" entry
            BufferedInputStream in = new BufferedInputStream(
                    new FileInputStream(fileToZip),
                    BUF_SIZE
            );
            byte data[] = new byte[BUF_SIZE]; // tablica. do wczytywania danych
            int count;                        // liczba przeczytanych bajtów

            while ((count = in.read(data)) != -1) { // czytanie i zapis z kompresją
                zos.write(data, 0, count);
            }
            in.close(); // zamknięcie pliku wejściowego

            zos.closeEntry(); // zamknięcie elementu (koniec zapisu elementu)
        }
    }

}

