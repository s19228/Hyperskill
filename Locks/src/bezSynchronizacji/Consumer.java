/**
 *
 *  @author Gryka Konrad S19228
 *
 */

package bezSynchronizacji;

import java.security.SecureRandom;

public class Consumer implements Runnable {

    private static final SecureRandom gen = new SecureRandom();
    private final Buffer b;

    public Consumer(Buffer b) {
        this.b = b;
    }

    @Override
    public void run() {
        System.out.println("Rozpoczęcie wątku Konsumenta, który rozpoczyna pobieranie z bufora...");
        while (true) {
            try {
                Thread.sleep(gen.nextInt(2000));
                b.get();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
