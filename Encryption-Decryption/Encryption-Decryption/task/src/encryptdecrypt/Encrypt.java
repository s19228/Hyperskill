package encryptdecrypt;

public class Encrypt {

    private String mode;
    private String data;
    private int num;

    public Encrypt(String[] tab) {

        boolean foundMode = false;
        boolean foundKey = false;
        boolean foundData = false;


        for (int i = 0; i < tab.length; i++) {
            if (!foundMode) {
                if (tab[i].equals("-mode")) {
                    this.mode = tab[i + 1];
                    foundMode = true;
                } else {
                    this.mode = "enc";
                }
            }

            if(!foundKey){
                if (tab[i].equals("-key")) {
                    this.num = Integer.parseInt(tab[i + 1]);
                    foundKey = true;
                } else {
                    this.num = 0;
                }
            }

            if(!foundData){
                if (tab[i].equals("-data")) {
                    this.data = tab[i + 1];
                    foundData = true;
                } else {
                    this.data = "";
                }
            }
        }
    }

    public StringBuilder encrypt() {

        StringBuilder sb;

        if (mode.equals("enc")) {
            char[] tab = data.toCharArray();
            sb = new StringBuilder();

            for (char c : tab) {
                sb.append((char) (c + num));
            }
        } else {
            char[] tab = data.toCharArray();
            sb = new StringBuilder();

            for (char c : tab) {
                sb.append((char) (c - num));
            }
        }
        return sb;
    }

}


/*
        char[] tab = msg.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == ' ' || tab[i] == '!') {
                sb.append(tab[i]);
            } else {
                if(tab[i] + num > 122){
                    sb.append((char) (tab[i] + num - 26));
                } else {
                    sb.append((char) (tab[i] + num));
                }
            }
        }

       for (char c : tab) {
            switch (c) {
                case 'a':
                    sb.append('z');
                    break;
                case 'b':
                    sb.append('y');
                    break;
                case 'c':
                    sb.append('x');
                    break;
                case 'd':
                    sb.append('w');
                    break;
                case 'e':
                    sb.append('v');
                    break;
                case 'f':
                    sb.append('u');
                    break;
                case 'g':
                    sb.append('t');
                    break;
                case 'h':
                    sb.append('s');
                    break;
                case 'i':
                    sb.append('r');
                    break;
                case 'j':
                    sb.append('q');
                    break;
                case 'k':
                    sb.append('p');
                    break;
                case 'l':
                    sb.append('o');
                    break;
                case 'm':
                    sb.append('n');
                    break;
                case 'n':
                    sb.append('m');
                    break;
                case 'o':
                    sb.append('l');
                    break;
                case 'p':
                    sb.append('k');
                    break;
                case 'q':
                    sb.append('j');
                    break;
                case 'r':
                    sb.append('i');
                    break;
                case 's':
                    sb.append('h');
                    break;
                case 't':
                    sb.append('g');
                    break;
                case 'u':
                    sb.append('f');
                    break;
                case 'v':
                    sb.append('e');
                    break;
                case 'w':
                    sb.append('d');
                    break;
                case 'x':
                    sb.append('c');
                    break;
                case 'y':
                    sb.append('b');
                    break;
                case 'z':
                    sb.append('a');
                    break;
                case ' ':
                    sb.append(' ');
                    break;
                case '!':
                    sb.append('!');
                    break;
            }
        }

    static StringBuilder encrypt(String msg) {
        char[] tab = msg.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char c : tab) {
            switch (c) {
                case 'a':
                    sb.append('z');
                    break;
                case 'b':
                    sb.append('y');
                    break;
                case 'c':
                    sb.append('x');
                    break;
                case 'd':
                    sb.append('w');
                    break;
                case 'e':
                    sb.append('v');
                    break;
                case 'f':
                    sb.append('u');
                    break;
                case 'g':
                    sb.append('t');
                    break;
                case 'h':
                    sb.append('s');
                    break;
                case 'i':
                    sb.append('r');
                    break;
                case 'j':
                    sb.append('q');
                    break;
                case 'k':
                    sb.append('p');
                    break;
                case 'l':
                    sb.append('o');
                    break;
                case 'm':
                    sb.append('n');
                    break;
                case 'n':
                    sb.append('m');
                    break;
                case 'o':
                    sb.append('l');
                    break;
                case 'p':
                    sb.append('k');
                    break;
                case 'q':
                    sb.append('j');
                    break;
                case 'r':
                    sb.append('i');
                    break;
                case 's':
                    sb.append('h');
                    break;
                case 't':
                    sb.append('g');
                    break;
                case 'u':
                    sb.append('f');
                    break;
                case 'v':
                    sb.append('e');
                    break;
                case 'w':
                    sb.append('d');
                    break;
                case 'x':
                    sb.append('c');
                    break;
                case 'y':
                    sb.append('b');
                    break;
                case 'z':
                    sb.append('a');
                    break;
                case ' ':
                    sb.append(' ');
                    break;
                case '!':
                    sb.append('!');
                    break;
            }
        }
        return sb;
    }


}
*/