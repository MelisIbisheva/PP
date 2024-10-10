package MethodSyn2;

public class App {
	public static int count1 = 0;
	public static int count2 = 0;

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
		synchronized (App.class) {
			for (int i = 0; i < 1000; i++) {
				count1++;
				System.out.println("Count1= " + count1);
			}
		}
	}

	public synchronized static void incrementCount2() {
		for (int i = 0; i < 1000; i++) {
			count2++;
			System.out.println("Count2= " + count2);
		}
	}

}
