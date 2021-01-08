import java.util.Arrays;

class Application {

    String name;

    void run(String[] args) {
        System.out.print(this.name + "\n");
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}