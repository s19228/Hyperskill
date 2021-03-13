package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encrypt {

    private String algorithm;
    private String mode;
    private String data;
    private int num;
    boolean foundMode = false;
    boolean foundKey = false;
    boolean foundData = false;
    boolean foundIn = false;
    boolean foundOut = false;
    boolean foundAlgorithm = false;
    FileWriter fileWriter;
    String nameOfOutFile;

    public Encrypt(String[] tab) throws IOException {

        for (int i = 0; i < tab.length; i++) {
            if (!foundMode) {
                if (tab[i].equals("-mode")) {
                    this.mode = tab[i + 1];
                    foundMode = true;
                } else {
                    this.mode = "-enc";
                }
            }

            if (!foundAlgorithm) {
                if (tab[i].equals("-alg")) {
                    algorithm = tab[i + 1];
                    foundAlgorithm = true;
                } else {
                    algorithm = "shift";
                }
            }

            if (!foundIn) {
                if (tab[i].equals("-in")) {
                    File inputFile = new File(tab[i + 1]);
                    Scanner scanner = new Scanner(inputFile);
                    this.data = scanner.nextLine();
                    foundIn = true;
                    foundData = true;
                    scanner.close();
                }
            }

            if (!foundData) {
                if (tab[i].equals("-data")) {
                    this.data = tab[i + 1];
                    foundData = true;
                } else {
                    this.data = "";
                }
            }

            if (!foundKey) {
                if (tab[i].equals("-key")) {
                    this.num = Integer.parseInt(tab[i + 1]);
                    foundKey = true;
                } else {
                    this.num = 0;
                }
            }

            if (!foundOut) {
                if (tab[i].equals("-out")) {
                    nameOfOutFile = tab[i + 1];
                    foundOut = true;
                }
            }


        }
    }

    public StringBuilder encrypt() throws IOException {

        StringBuilder sb = new StringBuilder();
        File outputFile;

        if (algorithm.equals("unicode")) {
            if (mode.equals("enc")) {
                if (foundData) {
                    char[] arr = data.toCharArray();
                    for (char c : arr) {
                        sb.append((char) (c + num));
                    }
                }
                if (foundOut) {
                    writeToFile(sb);
                }

            } else { // decode
                char[] tab = data.toCharArray();

                for (char c : tab) {
                    sb.append((char) (c - num));
                }
                if (foundOut) {
                    writeToFile(sb);
                }

            }
        } else {
            //shift
            if (mode.equals("enc")) {
                char[] tab = data.toCharArray();
                /*
                 *  A = 65
                 *  Z = 90
                 *  a = 97
                 *  z = 122
                 */
                for (char c : data.toCharArray()) {
                    if (c >= 65 && c <= 90) {
                        sb.append(c + num > 90 ? (char) (c + num - 26) : (char) (c + num));
                    } else if (c >= 97 && c <= 122) {
                        sb.append(c + num > 122 ? (char) (c + num - 26) : (char) (c + num));
                    } else {
                        sb.append(c);
                    }

                    writeToFile(sb);

                }
            } else { // decode
                char[] tab = data.toCharArray();
                /*
                 *  A = 65
                 *  Z = 90
                 *  a = 97
                 *  z = 122
                 */

                for (char c : data.toCharArray()) {
                    if (c >= 65 && c <= 90) {
                        sb.append(c - num < 65 ? (char) (c - num + 26) : (char) (c - num));
                    } else if (c >= 97 && c <= 122) {
                        sb.append(c - num < 97 ? (char) (c - num + 26) : (char) (c - num));
                    } else {
                        sb.append(c);
                    }
                }

                writeToFile(sb);
            }

        }

        if (!foundOut) {
            System.out.println(sb);
        }

        return sb;
    }

    private void writeToFile(StringBuilder sb) throws IOException {
        File outputFile;
        outputFile = new File(nameOfOutFile);
        fileWriter = new FileWriter(outputFile);
        fileWriter.write(sb.toString());
        fileWriter.close();
    }

}