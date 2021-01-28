public class Main {

    public static void main(String[] args) {
/*        int counter = 0;
        for (Secret sec : Secret.values()) {
            if (sec.name().matches("STAR[A-Z]*")) {
                counter++;
            }
        }
        System.out.println(counter);*/

        int i = 0;
        for (Secret secret : Secret.values()) {
            if (secret.toString().startsWith("STAR")) {
                i++;
            }
        }
        System.out.println(i);

    }
}

/* sample enum for inspiration
   enum Secret {
    STAR, CRASH, START, // ...
}
*/