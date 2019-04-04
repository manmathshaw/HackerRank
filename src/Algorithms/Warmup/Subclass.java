package test;

class Superclass {
	int age;

	Superclass(int age) {
		this.age = age; 		 
	}

	protected void getAge() {
		System.out.println("The value of the variable named age in super class is: " + age);
	}
}

public class Subclass extends Superclass {
	int age;
	Subclass(int age) {
		super(age);
		this.age = age; 	
	}
	public void getAge() throws NullPointerException {
		System.out.println("The value of the variable named age in sub class is: " + age);
	}
	public static void main(String argd[]) {
		Subclass s1 = new Subclass(24);
		Superclass s2 = new Superclass(24);
		Superclass s3 = new Subclass(24);
		s2.getAge();
	}
}