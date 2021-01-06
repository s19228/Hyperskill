package GUI2;

public class ArrayStack <T> implements Stack<T> {

    private  T [] tab;

    //eltsNumer mowi o tym ile elementów zostało odłożone na stos

    private int eltsNumber;

    // Zadeklarujmy konstruktor, któryj jako parametr przyjmie maksymalną liczbę elementów, które można odłożyć na stos


    public ArrayStack(int size) {
        //tablica przechowująca elementy stosu powinna przyjąć podany rozmiar
        tab = (T[])(new Object[size]);
        //na stosie na poczatku nie ma zaddnych elementow
        eltsNumber = 0;
    }

    @Override
    public T pop() {
        return tab[--eltsNumber];
    }


    @Override
    public void push(T elt) {
        tab[eltsNumber++] = elt;
    }

    @Override
    public boolean empty() {
        return eltsNumber == 0;
    }

    @Override
    public boolean full() {
        return eltsNumber == tab.length;
    }
}
