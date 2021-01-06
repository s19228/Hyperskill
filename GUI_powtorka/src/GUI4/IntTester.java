package GUI4;

public interface IntTester {

    boolean isValid(int x);

    // interfejsy mogą mieć wypełnione kodem metody statyczne tylko
    static void printValidInts(int [] tab, IntTester tester){
        for (int x : tab){
            if (tester.isValid(x)){
                System.out.print(x + ", ");
            }
        }
        System.out.println();
    }

}
