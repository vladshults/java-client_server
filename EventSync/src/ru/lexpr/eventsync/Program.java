package ru.lexpr.eventsync;

import static java.lang.System.out;

public class Program {
	
	public static void main(String[] args) {
		
		Thread t1,t2;
		
		//final Object sync = new Object();
		class Sync {
			int counter;
		}
		
		Sync sync = new Sync();
		
		(t1 = new Thread(()->{
			for(int i=1; i<=100; i++) {
				out.printf("%s : %d\n", Thread.currentThread().getName(), i);
				if (i == 50) {
					synchronized (sync) {
						sync.counter = i;
						sync.notifyAll();
					}
					/*synchronized (sync) {
					sync.notify();
					}*/
				}
			}
		}, "A")).start();
		
		(t2 = new Thread(()->{
			try {
				synchronized (sync) {
					while(sync.counter < 50) {
						out.println("B is waiting...");
						sync.wait(1);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			for(int i=1; i<=100; i++) {
				out.printf("%s : %d\n", Thread.currentThread().getName(), i);
			}
		}, "B")).start();
		
	}

}
