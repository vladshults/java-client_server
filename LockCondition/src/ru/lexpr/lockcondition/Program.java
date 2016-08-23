package ru.lexpr.lockcondition;

import static java.lang.System.out;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Program {
	
	static int counter = 0;
	
	public static void main(String[] args) {
		
		Thread t1,t2,t3;
		
		Lock sync = new ReentrantLock();
		Condition e50 = sync.newCondition();
		Condition e70 = sync.newCondition();
		
		(t1 = new Thread(()->{
			for(int i=1; i<=100; i++) {
				out.printf("%s : %d\n", Thread.currentThread().getName(), i);
				sync.lock();
				if (i == 50) e50.signal();
				if (i == 70) e70.signal();
				sync.unlock();
			}
		}, "A")).start();
		
		(t2 = new Thread(()->{
			try {
				sync.lock();
				e50.await();
				sync.unlock();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			for(int i=1; i<=100; i++) {
				out.printf("%s : %d\n", Thread.currentThread().getName(), i);
			}
		}, "B")).start();
		
		(t3 = new Thread(()->{
			try {
				sync.lock();
				e70.await();
				sync.unlock();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			for(int i=1; i<=100; i++) {
				out.printf("%s : %d\n", Thread.currentThread().getName(), i);
			}
		}, "C")).start();
	}
}
