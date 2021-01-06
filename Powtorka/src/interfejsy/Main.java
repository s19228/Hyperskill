package interfejsy;

public class Main {

    public static void main(String[] args) {

        class A implements MyInerface{

            int x;


            @Override
            public A method1() {
                System.out.println("Lalala");
                return new A();
            }
        }


        A a = new A();
        a.method1();

        MyInerface.A b = ((MyInerface) () -> null).method1();


    }

}
