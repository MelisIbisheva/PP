package Lock;
/*A reentrant lock has the same basic behavior as we have seen for
  synchronized blocks, of course there are some extended features!
   -We can make a lock fair: prevent thread starvation Synchronized blocks
   are unfair by default
   - We can check whether the given lock is held or not with reentrant locks
   - We can get the list of threads waiting for the given lock with 
     reentrant locks
   -Synchronized blocks are nicer: we do not need the try- catch-finally block
 
 
 
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {
	private static int counter=0;
	private static Lock lock=new ReentrantLock();

	public static void main(String[] args) {
		Thread t1=new Thread(new Runnable(){
			public void run(){
				increment();	
			}
			
		});
		Thread t2=new Thread(new Runnable(){
			public void run(){
				increment();	
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
		System.out.println("Counter is "+counter);

	}
	public static void increment(){
		lock.lock();
		try {
		for(int i=0;i<100000;i++){
		counter++;
		}}
		finally{
		lock.unlock();
		}
	}

}
