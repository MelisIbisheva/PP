package Second;

public class App {
	private static int counter = 0;

	public static void main(String[] args) {
		process();
		System.out.println(counter);
	}

	public static void increment() {
		synchronized (App.class) {
			counter++;
		}
	}

	public static void process() {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
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
