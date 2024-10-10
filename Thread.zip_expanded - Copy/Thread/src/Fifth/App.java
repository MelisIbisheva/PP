package Fifth;

class Processor {

	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("We are in producer method ...");
			wait();
			System.out.println("Again producer method....");
		}

	}

	public void consume() throws InterruptedException {
		Thread.sleep(1000);
		synchronized (this) {
			notify();
			System.out.println("Consumer method.....");

		}

	}

}

public class App {

	public static void main(String[] args) {
		Processor processor = new Processor();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
