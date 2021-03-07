import java.util.*;
import java.util.Arrays;

class AsciiCharSequence implements CharSequence {

    // implementation

    byte[] array;

    public AsciiCharSequence(byte[] array) {
        this.array = array;
    }

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public char charAt(int i) {
        return (char) array[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        //CharSequence charSequence = new AsciiCharSequence(array);
        //charSequence.subSequence(i, i1);
        return new AsciiCharSequence(Arrays.copyOfRange(array, i, i1));
    }

    @Override
    public String toString() {
        /*StringBuilder sb = new StringBuilder();
        for (byte b : array) {
            sb.append((char) b);
        }
        return sb.toString();*/
        return new String(array);
    }
}