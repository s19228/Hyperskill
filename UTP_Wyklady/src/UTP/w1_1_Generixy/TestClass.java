package UTP.w1_1_Generixy;

public class TestClass {

    String name;
    int number;
    boolean value;

    public TestClass(String name, int number, boolean value) {
        this.name = name;
        this.number = number;
        this.value = value;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", value=" + value +
                '}';
    }
}
