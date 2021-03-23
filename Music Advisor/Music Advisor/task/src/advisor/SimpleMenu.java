package advisor;

import java.util.Scanner;

public class SimpleMenu {

    private static boolean inMenu = false;

    static void run() {

        Scanner in = new Scanner(System.in);
        String option = in.next();
        boolean authorized = false;
        Client client = new Client();

        if (option.equals("auth")) {
            System.out.println("https://accounts.spotify.com/authorize?client_id=" + client.getId() + "&redirect_uri=http://localhost:8080&response_type=code");
            System.out.println("---SUCCESS---");
            authorized = true;
            inMenu = true;
        }

        while (!authorized) {
            System.out.println("Please, provide access for application.");
            option = in.next();
            if (option.equals("auth")) {
                System.out.println("https://accounts.spotify.com/authorize?client_id=" + client.getId() + "&redirect_uri=http://localhost:8080&response_type=code");
                System.out.println("---SUCCESS---");
                authorized = true;
                inMenu = true;
            }
            if (option.equals("exit")) {
                System.out.println("---GOODBYE!---");
                break;
            }
        }

        while (inMenu) {
            option = in.next();
            switch (option) {
                case "new":
                    System.out.println("---NEW RELEASES---");
                    System.out.println("Mountains [Sia, Diplo, Labrinth]\n" +
                            "Runaway [Lil Peep]\n" +
                            "The Greatest Show [Panic! At The Disco]\n" +
                            "All Out Life [Slipknot]");
                    break;
                case "featured":
                    System.out.println("---FEATURED---\n" +
                            "Mellow Morning\n" +
                            "Wake Up and Smell the Coffee\n" +
                            "Monday Motivation\n" +
                            "Songs to Sing in the Shower");
                    break;
                case "categories":
                    System.out.println("---CATEGORIES---");
                    System.out.println("Top Lists\n" +
                            "Pop\n" +
                            "Mood\n" +
                            "Latin");
                    break;
                case "playlists Mood":
                    System.out.println("---MOOD PLAYLISTS---");
                    System.out.println("Walk Like A Badass  \n" +
                            "Rage Beats  \n" +
                            "Arab Mood Booster  \n" +
                            "Sunday Stroll");
                    break;
                case "exit":
                    inMenu = false;
                    break;
                default:
                    System.out.println("You choose a bad option, type once again");
            }
        }

        System.out.println("---GOODBYE!---");

    }

}
