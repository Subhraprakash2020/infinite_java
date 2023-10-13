package com.java.Day3;

class SimpleThread 	extends Thread{
	public void run() {
		for(int i=0;i<=5;i++) {
			System.out.println(Thread.currentThread().getId()+"value"+i);
		}
	}
}

public class SimpleMultithreading {
	public static void main(String[] args) {
		SimpleThread thread1 = new SimpleThread();
		SimpleThread thread2 = new SimpleThread();
		
		thread1.start();
		thread2.start();
	}
}
