/**
 *
 *  @author Gryka Konrad S19228
 *
 */

package zad1;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Futil {

    public static void processDir(String dir, String resultFileName) {

        FileSystem fs = FileSystems.getDefault();
        Path p = fs.getPath(dir);

        try {
            try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(resultFileName)), Charset.forName("UTF8")))) {
                FileVisitor<Path> simpleFileVisitor = new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path visitedFilePath, BasicFileAttributes fileAttributes)
                            throws IOException {
                        try (BufferedReader in = new BufferedReader(
                                new InputStreamReader(new FileInputStream(visitedFilePath.toFile()), "Cp1250"))) {
                            String str;
                            while (!((str = in.readLine()) == null)) {
                                out.write(str);
                            }
                        }
                        return FileVisitResult.CONTINUE;
                    }
                };
                Files.walkFileTree(p, simpleFileVisitor);
            }
        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
            System.out.println("Something goes wrong...");
        }
    }
}
