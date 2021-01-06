public class TwoGen <T, V> {

    T ob1;
    V ob2;

    public TwoGen(T o1, V o2) {
        this.ob1 = o1;
        this.ob2 = o2;
    }

    void showTypes(){
        System.out.println("Typ T to" + ob1.getClass().getName());
        System.out.println("Typ V to" + ob2.getClass().getName());
    }

    /*void showValues(){
        System.out.println("Wartosc T to " + getOb1();
        System.out.println("Wartosc V to" + getOb2());
    }*/

    public T getOb1() {
        return ob1;
    }

    public V getOb2() {
        return ob2;
    }
}
