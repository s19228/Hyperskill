/**
 *
 *  @author Gryka Konrad S19228
 *
 */

package ReentrantLockAndCondition;

import bezSynchronizacji.Buffer;
import bezSynchronizacji.Consumer;
import bezSynchronizacji.Producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Buffer buffer = new RLBuffer();

        executorService.execute(new Producer(buffer));
        executorService.execute(new Consumer(buffer));

        executorService.shutdown(); //zakończenie aplikacji po zakończeniu wykonywania zadań
        executorService.awaitTermination(15, TimeUnit.SECONDS);




    }



}
