package ru.lexpr.datasync;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*class Sync {
	public volatile int counter = 0;
}
*/

class Sync {
	public volatile int counter = 0;
	
	public int getCounter() {
		return counter;
	}
	
	public synchronized void increment() {
		counter++;
	}
}

public class Program1 {
	
	//static int counter = 0;
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1,t2;
		//final Thread main = Thread.currentThread();
		
		List<Integer> nums = 
				Collections.synchronizedList(new ArrayList<Integer>());
		
		//Object sync = new Object();
		Sync sync = new Sync();
		
		(t1 = new Thread(()->{
			for(int i=1; i<=100000; i++) {
				//out.printf("%s : %d\n", Thread.currentThread().getName(), i);
				//counter++;
				//synchronized (sync) {
				//	sync.counter++;
				//}
				sync.increment();
				nums.add(i);
			}
		}, "A")).start();
		
		(t2 = new Thread(()->{
			for(int i=1; i<=100000; i++) {
				//out.printf("%s : %d\n", Thread.currentThread().getName(), i);
				//counter++;
				//synchronized (sync) {
				//	sync.counter++;
				//}
				sync.increment();
				nums.add(i);
			}
		}, "B")).start();
		
		t1.join();
		t2.join();
		
		double r1 = Integral.multiThread(Math::sin, 0, Math.PI/2);
		
		out.printf("%f \n", r1);
		//out.println(sync.getCounter());
		//out.println(nums.size());
	}
}
