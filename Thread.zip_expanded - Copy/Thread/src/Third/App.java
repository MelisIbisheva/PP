package Third;

public class App {
	public static int count1 = 0;
	public static int count2 = 0;

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				compute();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				compute();
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
		System.out.println("Count1=" + count1 + " - Count2=" + count2);
	}

	public synchronized static void add() {
		count1++;
	}

	public synchronized static void addAgain() {
		count2++;
	}

	public static void compute() {
		for (int i = 0; i < 1000; i++) {
			add();
			addAgain();

		}
	}

}
