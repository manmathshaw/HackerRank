package test;

public class InnerClassExample {
	public static void main(String args[]) {
		// Instantiating the outer class 
		Outer_Demo outer = new Outer_Demo();
		// Accessing the display_Inner() method.
		outer.display_Inner();
		// Instantiating the inner class
		Outer_Demo.Inner_Demo inner = outer.new Inner_Demo();
		System.out.println(inner.getNum());
		// Instantiating the static inner class
		Outer_Demo.Nested_Demo nested = new Outer_Demo.Nested_Demo();	 
		nested.my_method();
	}
}

class Outer_Demo {
	private int num = 175;
	// inner class
	public class Inner_Demo {
		public int getNum() {
			System.out.println("This is an inner class");
			return num;
		}
	}
	private class Inner_Demo1 {
		public void print() {
			System.out.println("This is an inner class");
		}
	}
	static class Nested_Demo {
		public void my_method() {
			System.out.println("This is my nested class");
		}
	}
	// Accessing he inner class from the method within
	void display_Inner() {
		Inner_Demo1 inner = new Inner_Demo1();
		inner.print();
	}
}
