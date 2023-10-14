package com.java.Day4;

class SimpleRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getId() + " Value " + i);
        }
    }
}
public class RunnableInterface {
	 public static void main(String args[]) {
	        Thread thread1 = new Thread(new SimpleRunnable());
	        Thread thread2 = new Thread(new SimpleRunnable());

	        thread1.start();
	        thread2.start();
	 }
}
