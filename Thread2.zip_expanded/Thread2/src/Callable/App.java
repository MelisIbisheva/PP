package Callable;
/*
 The Callable interface is similar to Runnable, in that both are designed
  for classes whose instances are potentially executed by another thread.
   A Runnable, however, does not return a result and cannot throw
    a checked exception.
 */


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Processor implements Callable<String>{
	private int id;
	public Processor(int id){
		this.id=id;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return "id: "+id;
	}	
	
}

public class App {
	

	public static void main(String[] args) {
		ExecutorService executorService =Executors.newFixedThreadPool(5);
		List<Future<String>>list = new ArrayList();
		for(int i=0;i<30;i++ ){
		Future<String> future=executorService.submit(new Processor(i+1));
		list.add(future);
		}
		for (Future<String>future:list){
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		executorService.shutdown();
	}

}
