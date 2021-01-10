package main_package;
import java.util.concurrent.*;

public class SemaphoreDemo {
    private static class Barrier {
        private final int numberOfWorkers;
        private Semaphore semaphore = new Semaphore( );//** blank 1 **/);
        private int counter = //** blank 2 **/;
        private Lock lock = new ReentrantLock();

        public Barrier(int numberOfWorkers) {
            this.numberOfWorkers = numberOfWorkers;
        }

        public void barrier() {
            lock.lock();
            boolean isLastWorker = false;
            try {
                counter++;

                if (counter == numberOfWorkers) {
                    isLastWorker = true;
                }
            } finally {
                lock.unlock();
            }

            if (isLastWorker) {
                semaphore.release();//** blank 3 **/);
            } else {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
