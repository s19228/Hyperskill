package UTP.w1_4_Generixy;

/*
// GENERYCZNA TABLICA
 */


import UTP.w1_1_Generixy.Para;

public class GenArr<T extends Comparable<T>> {
    private T[] arr;

    //przechowanie wartosci min max
    private Para<T, T> minMax;

    public GenArr(T[] a){
        init(a);
    }

    public void init (T[] a){
        if ( a == null || a.length == 0)
            throw new IllegalArgumentException("Invalid array init");
        minMax = null;
        arr = a;
    }

    public T max(){
        return evaluate("MAX").getFirst();
    }

    public T min(){
        return evaluate("MIN").getLast();
    }

    private Para<T, T> evaluate(String kind) {
        //korzystamy z konstuktora bezparametrowego
        if (minMax == null)
            minMax = new Para<T, T>();

        T v = arr[0];
        switch (kind){
            case "MAX": {
                // liczymy te dotąd niepoliczone
                if(minMax.getFirst() == null){
                    // mozemy to napisac dzieki temu ze T extends Copmarable
                    for (T e : arr)
                        if (e.compareTo(v) > 0) v = e;
                        minMax.setFirst(v);
                }
            }
            case "MIN":{
                // liczymy te dotąd niepoliczone
                if(minMax.getLast() == null){
                    // mozemy to napisac dzieki temu ze T extends Copmarable
                    for (T e : arr)
                        if (e.compareTo(v) < 0) v = e;
                    minMax.setLast(v);
                }
            }
        }
        return minMax;



    };




}
