package GUI3;

public class ValueWrapper {

    private static int staticValue = 0;
    private int localValue = 1;

    static class StaticProvider {
        int getStaticValue() {
            return staticValue;
        }
    }

    class LocalProvider{

        int getStaticValue(){
            return staticValue;
        }
        int getLocalValue(){
            return localValue;
        }



    }


}
