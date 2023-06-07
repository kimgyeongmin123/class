package Ch09;

class ramenRecipe
{
	//순서
	private void step1() {System.out.println("물을 끓인다.");};
	private void step2() {};
	private void step3() {};
	private void step4() {};
	
	public void cooking()
	{
		step1();
		step2();
		step3();
		step4();
	}
}

class Cook
{
	public ramenRecipe Recipe_ramen = new ramenRecipe();
}

public class C03Capsulation {
	public static void main(String[] args) {
		
		Cook hong = new Cook();
		hong.Recipe_ramen.cooking();
		
	}
}
