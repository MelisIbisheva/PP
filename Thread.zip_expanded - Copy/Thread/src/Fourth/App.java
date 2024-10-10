package Fourth;

public class App {
	private static int count1 = 0;
	private static int count2 = 0;
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				incrementCount1();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				incrementCount2();
			}
		});

		t1.start();
		t2.start();

	}

	public static void incrementCount1() {
		synchronized (lock1) {
			for (int i = 0; i < 1000; i++) {
				count1++;
				System.out.println("Count1= " + count1);
			}
		}
	}

	public static void incrementCount2() {
		synchronized (lock2) {
			for (int i = 0; i < 1000; i++) {
				count2++;
				System.out.println("Count2= " + count2);
			}
		}
	}
}
