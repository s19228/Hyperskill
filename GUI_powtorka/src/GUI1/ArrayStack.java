package GUI1;

public class ArrayStack implements Stack {

    private  int [] tab;

    //eltsNumer mowi o tym ile elementów zostało odłożone na stos

    private int eltsNumber;

    // Zadeklarujmy konstruktor, któryj jako parametr przyjmie maksymalną liczbę elementów, które można odłożyć na stos


    public ArrayStack(int size) {
        //tablica przechowująca elementy stosu powinna przyjąć podany rozmiar
        tab = new int[size];
        //na stosie na poczatku nie ma zaddnych elementow
        eltsNumber = 0;
    }

    @Override
    public int pop() {
       return tab[--eltsNumber];
    }

    @Override
    public void push(int elt) {
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
