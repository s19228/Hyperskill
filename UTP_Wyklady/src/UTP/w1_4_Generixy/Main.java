package UTP.w1_4_Generixy;

public class Main {

    public static void main(String[] args) {

        Integer[] arr1 = {1, 12, -35, -87, 128};
        Integer[] arr2 = {6, 16, 66, -77, 365};
        String [] arr3 = {"A", "Z", "C"};

        GenArr<Integer> gai = new GenArr<>(arr1);
        System.out.println(gai.max() + " " + gai.min());

        gai.init(arr2);
        System.out.println(gai.max() + " " + gai.min());

        GenArr<String> gas = new GenArr<>(arr3);
        System.out.println(gas.max() + " " + gas.min());




    }


}
