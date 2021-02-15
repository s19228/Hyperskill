import java.io.IOException;

class Converter {
    public static char[] convert(String[] words) throws IOException {

        StringBuilder sb = new StringBuilder();
        for (String s : words) {
            sb.append(s);
        }
        return sb.toString().toCharArray();
    }
}