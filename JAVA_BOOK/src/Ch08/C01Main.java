package Ch08;

public class C01Main {
	public static void main(String[] args) {
		
		C01Person mango = new C01Person();
		mango.name="경망고";
		mango.age=5;
		mango.height=10;
		mango.weight=2.56;
		System.out.printf("%s %d %.0f %.2f\n", mango.name,mango.age,mango.height,mango.weight);
	}
}
