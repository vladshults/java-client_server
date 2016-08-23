package ru.lexpr.datasync;


public class Program {
	public static void main(String[] args) throws InterruptedException {
		long t1 = System.currentTimeMillis();
		double r1 = Integral.singleThread(Math::sin, 0d, Math.PI/2);
		long t2 = System.currentTimeMillis();
		System.out.printf("r1 = %f Time: %dms\n", r1, t2-t1);
		
		long t3 = System.currentTimeMillis();
		double r2 = Integral.multiThread(Math::sin, 0d, Math.PI/2);
		long t4 = System.currentTimeMillis();
		System.out.printf("r2 = %f Time: %dms\n", r2, t4-t3);
	}
}