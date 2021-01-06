package UTP.w1_2_Generixy;

public class Para <S, T> {

    private S first;
    private T last;
    private static int count;

    public Para(S first, T last) {
        count++;
        this.first = first;
        this.last = last;
    }

    public Para(){

    };

    @Override
    public String toString() {
        return first + " " + last;
    }

    public S getFirst() {
        return first;
    }

    public void setFirst(S first) {
        this.first = first;
    }

    public T getLast() {
        return last;
    }

    public void setLast(T last) {
        this.last = last;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Para.count = count;
    }
}
