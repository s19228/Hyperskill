/**
 *
 *  @author Gryka Konrad S19228
 *
 */

package bezSynchronizacji;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        Buffer buffer = new MyBuffer();

        executorService.execute(new Producer(buffer));
        executorService.execute(new Consumer(buffer));

        if (!executorService.awaitTermination(15, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
            System.exit(-1);
        }
    }
}
