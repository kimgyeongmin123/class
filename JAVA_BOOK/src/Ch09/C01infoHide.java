package Ch09;

//접근한정자
//public	: 모든 클래스에서 접근가능
//default	: 동일 패키지에 속한 클래스에서만 접근가능
//protected	: 동일 패키지 or 상속관계의 하위클래스에서만 접근가능
//private 	: 현재 클래스에서만 접근가능

class C01Person
{
	//속성
	String name;
	private String id;
	private int age;
	private float weight;
	private double height;
	private int salary;
	
	//생성자
	public C01Person(String name, String id, int age, float weight, double height, int salary) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.salary = salary;
	}
	
	//기능
	//Getter and Setter
	void setSalary(int salary) //이녀석을 통해서만 샐러리에 접근할 수 있도록 한다. 선택적으로 하는 것임.
	{
		this.salary=salary;
	}
	
	String getId() //이녀석을 통해서 다른 클래스에서 불러올 수 있도록 한다.
	{
		return id;
	}
	
	int getAge()
	{
		return age;
	}
	
	void setAge(int age)
	{
		this.age = age;
	}
	
	float getWeigth()
	{
		return weight;
	}
	
	void setWeight(float weight)
	{
		this.weight = weight;
	}
	
	double getHeight()
	{
		return height;
	}
	
	void setHeight(double height)
	{
		this.height = height; 
	}
	
}

public class C01infoHide {
	public static void main(String[] args) {
		
		C01Person hong = new C01Person("홍창표", "941001-1111",30,10.1f,178.5,99999);
		hong.name="홍학표";
		hong.setSalary(9000);
		System.out.println(hong.getId());
	}
}
