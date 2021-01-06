package UTP.w2_1_Progamowanie_Funkcyjne;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> src = Arrays.asList(5, 34, 342, 2, 12, 43, 55, 56, 77, 887, 90, 768, 67, 4, 6, 45, 323, 4);
        List<Integer> target = TestClass.create(src, new Filter<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer < 10;
                    }
                },
                new Transformer<Integer, Integer>() {
                    @Override
                    public Integer transform(Integer n) {
                        return n * n;
                    }
                });

//        List<Integer> src = Arrays.asList(5, 34, 342, 2, 12, 43, 55, 56, 77, 887, 90, 768, 67, 4, 6, 45, 323, 4);
//        List<Integer> target = TestClass.create(src, integer -> integer < 10,
//                n -> n * n);

        for (Integer x : target){
            System.out.print(x + ", ");
        }
        System.out.println();



    }
}
