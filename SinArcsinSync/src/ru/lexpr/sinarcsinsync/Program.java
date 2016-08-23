package ru.lexpr.sinarcsinsync;

public class Program {

	public static void main(String[] args) throws InterruptedException {
		
		class Sync {
			volatile double x = 1d;
			volatile boolean isSin = true;
		}
		
		final Sync s = new Sync();
		
		Thread t1 = new Thread(()->{
			for(int i=0; i < 100; i++) {
				synchronized (s) {
					while (!s.isSin)
						try {
							s.wait();
						} catch (Exception e) {
							e.printStackTrace();
						}
					s.x = Math.sin(s.x);
					System.out.printf("%-3d : %-5.2f ", i, s.x);
					s.isSin = false;
					s.notify();
				}
			}
		});
		
		Thread t2 = new Thread(()->{
			for(int i=0; i < 100; i++) {
				synchronized (s) {
					while (s.isSin)
						try {
							s.wait();
						} catch (Exception e) {
							e.printStackTrace();
						}
					s.x = Math.asin(s.x);
					System.out.printf("%-3d : %-5.2f \n", i, s.x);
					s.isSin = true;
					s.notify();
				}
			}
		});
		
		t1.start();
		t2.start();
	}

}
