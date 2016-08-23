package ru.lexpr.joinsync;

import static java.lang.System.out;

public class Program {
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1,t2;
		final Thread main = Thread.currentThread();
		
		(t1 = new Thread(()->{
			for(int i=1; i<=100; i++) {
				out.printf("%s : %d\n", Thread.currentThread().getName(), i);
				out.printf("%s : %s\n", main.getName(), main.getState());
				//if (i == 50) main.interrupt();
				}
		}, "A")).start();
		
		(t2 = new Thread(()->{
			try {
				t1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int i=1; i<=100; i++)
				out.printf("%s : %d\n", Thread.currentThread().getName(), i);
		}, "B")).start();
		
		/*try {
		t1.join();
		} catch(InterruptedException ex) {
			out.println("���� �������� ����");
			out.println(main.isInterrupted());
		}
		*/
		
		t1.join();
		t2.join();
		
		out.println(Thread.currentThread().getName());
		//out.println(main.isInterrupted());
	}
}
