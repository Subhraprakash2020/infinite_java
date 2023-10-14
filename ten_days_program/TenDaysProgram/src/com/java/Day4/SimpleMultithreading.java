package com.java.Day4;

class SimpleThread extends Thread {
	//Run thread
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getId() + " Value " + i);
        }
    }
}

public class SimpleMultithreading {
public static void main(String[] args) {
	//Creating object
	 SimpleThread thread1 = new SimpleThread();
     SimpleThread thread2 = new SimpleThread();
     
     //Starting the thread
     thread1.start();
     thread2.start();
}
}

