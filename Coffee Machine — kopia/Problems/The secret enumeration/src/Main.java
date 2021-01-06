public class Main {

    public static void main(String[] args) {
        int counter = 0;

        for (Secret value : Secret.values()){
            if(value.name().startsWith("STAR")){
                counter++;
            }
        }

        System.out.println(counter);

    }

    enum Secret {
        STAR, CRASH, START, // ...
    }

}



