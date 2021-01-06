/**
 * @author Gryka Konrad S19228
 */

package zad3;

import java.util.*;
import java.util.function.BiConsumer;

public class XList<T> extends ArrayList<T> {

    private XList() {
    }

    public XList(Object... o) {
        this.addAll(XList.of(o));
    }

    public static <T> XList<T> of(Object... o) {
        XList list = new XList<>();
        boolean test = false;
        if (o.length > 1) {
            test = true;
            for (Object object : o) {
                if (!(object instanceof Collection || object.getClass().isArray())) {
                    test = false;
                    break;
                }
            }
        }

        for (Object object : o) {
            if (object instanceof Collection && !test) {
                ((Collection) object).forEach(obj -> list.addAll(XList.of(obj)));
            } else if (object.getClass().isArray() && !test) {
                Arrays.stream(((Object[]) object)).forEach(objc -> list.addAll(XList.of(o)));
            } else {
                if (test == true) {
                    list.add(XList.of(object));
                } else {
                    list.add(object);
                }
            }
        }
        return list;
    }

    public static XList<String> ofChars(String s) {
        List<String> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(String.valueOf(c));
        }
        return XList.of(list);
    }

    public static XList<String> ofTokens(String s) {
        return XList.ofTokens(s, "\\s+");
    }

    public static XList<String> ofTokens(String s, String delimiter) {
        return XList.of(s.split(delimiter));
    }

    public XList<Integer> union(Object... o) {
        XList list = new XList(this);
        list.addAll(XList.of(o));
        return list;
    }

    public XList diff(Object... o) {
        XList list = new XList(this);
        list.removeAll(XList.of(o));
        return list;
    }

    public XList<T> unique() {
        XList list = new XList();
        this.forEach(elm -> {
            if (!list.contains(elm)) {
                list.add(elm);
            }
        });
        return list;
    }

    public void forEachWithIndex(BiConsumer<T, Integer> cons) {
        for (int i = 0; i < this.size(); i++) {
            cons.accept(this.get(i), i);
        }
    }
}