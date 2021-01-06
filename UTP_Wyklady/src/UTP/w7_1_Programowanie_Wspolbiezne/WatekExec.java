package UTP.w7_1_Programowanie_Wspolbiezne;

import java.util.concurrent.Executor;

public class WatekExec implements Executor {
    @Override
    public void execute(Runnable command) {
        System.out.println("Egzekutor uruchamia watek?");
    }
}
