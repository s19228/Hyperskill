/**
 *
 *  @author Gryka Konrad S19228
 *
 */

package bezSynchronizacji;

import java.security.SecureRandom;

public class Producer implements Runnable {

    private static final SecureRandom gen = new SecureRandom();
    private final Buffer b;

    public Producer(Buffer b) {
        this.b = b;
    }

    @Override
    public void run() {
        System.out.println("Rozpoczęcie wątku Pocucenta, który rozpoczyna produkcję...");
        while(true) {
            int count = gen.nextInt(100);
            try {
                Thread.sleep(gen.nextInt(2000));
                b.put(count);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
