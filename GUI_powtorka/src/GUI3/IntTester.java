package GUI3;

public interface IntTester {

    public boolean isValid(int x);

    public static void printValidInts(int [] tab, IntTester tester){
        for (int x : tab){
            if(tester.isValid(x)){
                System.out.print(x + " ");
            }
        }
        System.out.println();
    }

}
