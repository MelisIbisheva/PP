package Semaphores;
/*Most of the executor implementations in java.util.concurrent use thread pools,
   which consist of worker threads. This kind of thread exists separately 
   from the Runnable and Callable tasks it executes and is often used to
    execute multiple tasks.
    One common type of thread pool is the fixed thread pool. This type of pool
    always has a specified number of threads running; if a thread is somehow
    terminated while it is still in use, it is automatically replaced with a
     new thread
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class App {

	enum Downloader {
		INSTANCE;
		private Semaphore semaphore = new Semaphore(1, true);

		public void downloadData() {
			try {
				semaphore.acquire();
				download();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				semaphore.release();
			}
		}

		private void download() {
			System.out.println("Downloading data from the web.....");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 6; i++) {
			executorService.execute(new Runnable() {
				public void run() {
					Downloader.INSTANCE.downloadData();
				}
			});
		}
	}

}
