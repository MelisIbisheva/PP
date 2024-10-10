package First;

public class App {
private static int counter=0;
	public static void main(String[] args) {  
		process();
		System.out.println(counter);

	}
	
public   static   void process(){
	Thread t1= new Thread(new Runnable(){
	    public synchronized void run(){
		    for (int i=0;i<1000;i++){	
				counter++;
			}
		}	
    });
	
	Thread t2= new Thread(new Runnable(){		
	    public synchronized void run(){
	   	    for (int i=0;i<1000;i++){		
		 	    counter++;
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
