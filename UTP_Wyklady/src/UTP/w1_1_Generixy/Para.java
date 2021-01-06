package UTP.w1_1_Generixy;

public class Para <S, T> {

    private S first;
    private T last;

    public Para(S f, T l) {
        this.first = f;
        this.last = l;
    }

    public Para() {

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

    @Override
    public String toString() {
        return first + " " + last;
    }
}
