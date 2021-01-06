/**
 * @author Gryka Konrad S19228
 */

package zad3;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class XList<T> extends ArrayList<T> {

    public XList() {
    }

    //addAll z ArrayList
    public XList(T... objects) {
        this.addAll(XList.of(objects));
    }

    public XList(Set set) {
        this.addAll(XList.of(set));
    }

    public static <T> XList<T> of(T... obj) {
        XList<T> myXlist = new XList<>();
        myXlist.addAll(Arrays.asList(obj));
        return myXlist;
    }

    public static <T> XList<T> of(Set set) {
        XList myXlist = new XList();
        myXlist.addAll(set);
        return myXlist;
    }

    private static <T> XList<T> of(List<T> list) {
        XList<T> myList = new XList<>();
        myList.addAll(list);
        return myList;
    }

    public static XList<String> charsOf(String s) {
        List<String> listOfChars = new ArrayList<String>();
        for (char c : s.toCharArray()) {
            listOfChars.add(String.valueOf(c));
        }
        return XList.of(listOfChars);
    }

    public static XList<String> tokensOf(String s) {
        List<String> listOfWords;
        String[] tab = s.split("\\s");
        listOfWords = Arrays.asList(tab);
        return XList.of(listOfWords);
    }

    public static XList<String> tokensOf(String text, String toRemowe) {
        List<String> listOfWords;
        String upgradedText = text.replace(toRemowe, ", ");
        listOfWords = Arrays.asList(upgradedText);
        return XList.of(listOfWords);
    }

    public XList<T> union(XList<T> givenList) {
        List myNewList = Stream.concat(this.stream(), givenList.stream()).collect(Collectors.toList());
        return XList.of(myNewList);

    }

    public XList<T> union(Integer[] obj) {
        List tmpList = new ArrayList();
        tmpList.addAll(Arrays.asList(obj));
        List myNewList = (List) Stream.concat(this.stream(), tmpList.stream()).collect(Collectors.toList());
        return XList.of(myNewList);
    }

    public XList<T> union(Set<T> set) {
        List newList = Stream.concat(this.stream(), set.stream()).collect(Collectors.toList());
        return XList.of(newList);
    }

    public XList diff(Object... objects) {
        List myList = (List) Stream.of(this);
        if (this.equals(objects))
            remove(this);

        return XList.of(myList);
    }

    public XList<T> unique() {
        XList<T> myList = new XList<T>();

        this.forEach(o -> {
            if (!myList.contains(o)) {
                myList.add(o);
            }
        });
        return myList;
    }

    /*
    // NIE ZAIMPLEMENTOWANE

    public XList<XList<String>> combine(Arrays ... arr) {
        List tmpList = new ArrayList();
        Stream.concat().toArray()

        return XList.of(tmpList);
    }
    */

    public void forEachWithIndex(BinaryOperator<Integer> operator) {
        for (int i = 0; i < this.size(); i++) {
            operator.apply((Integer) this.get(i), i);
        }
    }
}
