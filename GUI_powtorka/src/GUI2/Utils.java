package GUI2;

public class Utils {

    public static <T> boolean areEqual (T o1, T o2){
        return o1.equals(o2);
    }

    public static <T> T findMaxItem(T[] tab, ItemComparator<T> comparator){
        // Zabezpieczenia przed bezsensownymi danymi
        if (tab == null || tab.length == 0 || comparator == null)
            return null;

        // Ustawienie maximum na pierwszy obiekt
        T max = tab[0];
        // Przeglądanie dalszych obiektów z tablicy
        for (int i = 1; i < tab.length; i++) {
            // Jeżeli któryś z obiektów jest większy niż obecne maksimum,
            if (comparator.compare(tab[i], max) > 0)
                // to on powinien stać się obecnym maksimum
                max = tab[i];
        }
        // Zwracanie znalezionego maksimum
        return max;
    }


}
