/**
 * @author Gryka Konrad S19228
 */

package zad1;

import java.util.*;

public class Main {
  public Main() {
    List<Integer> src1 = Arrays.asList(1, 7, 9, 11, 12);
    System.out.println(test1(src1));

    List<String> src2 = Arrays.asList("a", "zzzz", "vvvvvvv");
    System.out.println(test2(src2));
  }

  public List<Integer> test1(List<Integer> src) {
    Selector sel = new Selector() {
      @Override
      public boolean select(Object elm) {
        if ((Integer) elm < 10)
          return true;
        else
          return false;
      }
    };

    Mapper map = new Mapper() {
      @Override
      public Object map(Object elm) {
        if (sel.select(elm))
          return (Integer) elm + 10;
        else
          return null;
      }
    };

    return ListCreator.collectFrom(src).when(sel).mapEvery(map);
  }

  public List<Integer> test2(List<String> src) {
    Selector sel = new Selector() {
      @Override
      public boolean select(Object arg) {
        if (arg.toString().getBytes().length > 3)
          return true;
        else
          return false;
      }
    };

    Mapper map = new Mapper() {
      @Override
      public Object map(Object argument) {
        if (sel.select(argument)) return argument.toString().getBytes().length + 10;
        else return false;
      }
    };

    return ListCreator.collectFrom(src).when(sel).mapEvery(map);
  }

  public static void main(String[] args) {
    new Main();
  }
}
