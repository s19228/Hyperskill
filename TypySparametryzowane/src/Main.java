import java.util.List;

public class Main {
    public static void main(String[] args) {

        Gen<Integer> g1 = new Gen(2);
        Gen<Integer> iOb = new Gen<Integer>(880);

        g1.showType();
        iOb.showType();

        int a = g1.getObj();
        System.out.println(a);

        Gen<String> sOb = new Gen<String>("MAkumba");
        sOb.showType();
        String s = sOb.getObj();

        System.out.println(s);

        System.out.println(
        );

        Gen <Double> dOb = new Gen<>(3.14);
        dOb.showType();

        int b = iOb.getObj().intValue();
        System.out.println(b);

        System.out.println(g1.equals(sOb));

        System.out.println();

        TwoGen <Integer, String> tgObj = new TwoGen<>(99, "Parametryzacja");

        tgObj.showTypes();

        TwoGen <String, String> tgObj2 = new TwoGen<>("null", "");

        tgObj2.showTypes();



    }

}
