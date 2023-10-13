package com.java.Day3;

// Declar Interface A
interface A {
	void a();

	void b();

	void c();

	void d();
}

//class B implements A
abstract class B implements A {
	public void c() {
		System.out.println("I am c");
	}
}

//Class M extends B
class M extends B {
	public void a() {
		System.out.println("I am a");
	}

	public void b() {
		System.out.println("I am b");
	}

	public void d() {
		System.out.println("I am d");
	}
}

public class Abstraction3 {
	public static void main(String args[]) {
		A a = new M();
		a.a();
		a.b();
		a.c();
		a.d();
	}
}
