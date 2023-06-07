package Ch12;

class Company
{
	int n1;
	int n2;
	
	@Override
	public String toString() {
		return "Company [n1=" + n1 + ", n2=" + n2 + "]";
	}

	//싱글톤 패턴 구조
	private static Company Instance = new Company();
	
	//생성자를 private으로 설정 -> 외부에서 객체생성 불가능..
	private Company()
	{
		n1 = 100;
		n2 = 200;
	}
	
	public static Company getInstance()
	{
		if(Instance==null)
			Instance = new Company();
		return Instance;
	}
}

public class C03SingletonPattern {
	public static void main(String[] args) {
		
		Company com1 = Company.getInstance();
		Company com2 = Company.getInstance();
		System.out.println("com1 : "+com1);
		System.out.println("com2 : "+com2);
		System.out.println("com1 toString : "+com1.toString());
		System.out.println("com2 toString : "+com2.toString());
	}

}
