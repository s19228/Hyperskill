class CreateInstance {

    public static SuperClass create() {
/* create an instance of an anonymous class here,
                                 do not forget ; on the end */

        SuperClass instance = new SuperClass() {

            @Override
            public void method2() {
                System.out.println("method2");;
            }

            @Override
            public void method3() {
                System.out.println("method3");
            }

//            { /* instance initialization block for setting fields */
//                String name = "method1";
//                System.out.println(name);
//            }
        };

        // call the overridden methods
        instance.method2();
        instance.method3();

        return instance;
    }
}

// Don't change the code below

abstract class SuperClass {

    public static void method1() {
        System.out.println("It's a static method.");
    }

    public void method2() {
        System.out.println("It's not a static method.");
    }

    public abstract void method3();
}