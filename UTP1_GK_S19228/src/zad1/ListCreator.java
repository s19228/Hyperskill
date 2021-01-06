/**
 * @author Gryka Konrad S19228
 */

package zad1;

import java.util.ArrayList;
import java.util.List;

public class ListCreator <T>{ // Uwaga: klasa musi być sparametrtyzowana

    private List<T> list;

    public ListCreator(List<T> list) {
        this.list = list;
    }

    public static <T> ListCreator<T> collectFrom(List<T> list) {
        return new ListCreator<>(list);
    }

    public ListCreator<T> when(Selector<T> sel) {
        List<T> outList = new ArrayList<>();
        for (int i = 0; i < this.list.size(); i++) {
            T unit = this.list.get(i);
            if (sel.select(unit)) {
                outList.add(unit);
            }
        }
        this.list = outList;
        return this;
    }

    public List<T> mapEvery(Mapper<T> map) {
        List<T> outList = new ArrayList<>();
        for (int i = 0; i < this.list.size(); i++) {
            T unit = this.list.get(i);
            outList.add(map.map(unit));
        }
        this.list = outList;
        return this.list;
    }
}