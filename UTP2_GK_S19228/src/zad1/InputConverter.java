/**
 * @author Gryka Konrad S19228
 */

package zad1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class InputConverter<T> {

    private T t;

    public InputConverter(T t) {
        this.t = t;
    }

//Uwaga: w klasie InputConverter musi występować tylko jedna metoda o nazwie convertBy (czyli w tym zadaniu nie dopuszczamy przeciążania metody convertBy).

    public <T> T convertBy(Function<?, ?>... tablicaFunkcji) {

        Object zrodlo = t;
        Object wynik = null;
        for (Function func : tablicaFunkcji) {
            wynik = func.apply(zrodlo);
            zrodlo = wynik;
        }
        return (T) wynik;
    }

    ;
}
