package UTP.w1_5_Generixy;

public class A {

    //przyklad sparametryzowanej metody zwroacającej ostatni element tablicy dowolnych obiektów

    static <T> T last(T[] elts) {
        return elts[elts.length - 1];
    }


}
