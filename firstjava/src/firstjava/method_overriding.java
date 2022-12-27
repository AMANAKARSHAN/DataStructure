package firstjava;

public class method_overriding {
	
	void met()
	{
		System.out.println("parent class");
	}



}

class test extends method_overriding{
	
	void met()
	{
		System.out.println("Child class");	
		
	}
	
	public static void main(String[] args) {
		method_overriding t = new method_overriding();
		t.met();

	}
	
}
