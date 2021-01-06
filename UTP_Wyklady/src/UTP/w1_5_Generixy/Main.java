package UTP.w1_5_Generixy;

public class Main {

    public static void main(String[] args) {

        Integer[] arr1 = {1, 12, -35, -87, 128};
        String[] arr2 = {"A", "Z", "ZAB", "ZZZ"};

        Integer lastElt = A.<Integer>last(arr1);
        System.out.println(lastElt);

        //String lastStr = A.last(arr2);
        String lastStr2 = A.<String>last(arr2);
        System.out.println(lastStr2);

        //konkludowanie typów (type inferring)

        Integer n = A.last(new Integer[]{1, 4, 7});
        System.out.println(n+1);

        String  s = A.last(new String[]{"Ala", "ma", "okers"});
        System.out.println(s +" "+ s.length());



    }

}
