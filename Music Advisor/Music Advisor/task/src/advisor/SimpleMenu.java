package advisor;

import java.util.Scanner;

public class SimpleMenu {

    private static boolean inMenu = true;

    static void run() {

        Scanner in = new Scanner(System.in);
        String option;

        while (inMenu) {
            option = in.nextLine();
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
