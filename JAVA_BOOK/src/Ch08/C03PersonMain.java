package Ch08;

class C03Person {
	//속성(멤버변수)
	String name;
	int age;
	float height;
	double weight;
	
	//기능(멤버함수, 멤버메서드)
	//말하다
	void talk()
	{
		System.out.println(name+"님이 말합니다.");
	}
	
	//걷다
	void walk()
	{
		System.out.println(name+"님이 걷습니다.");
	}
	
	//속성정보확인
	void showInfo()
	{
		System.out.printf("%s %d %f %f\n", name,age,height,weight);
	}
	
}

public class C03PersonMain {
	public static void main(String[] args) {
		C03Person hong = new C03Person();
		
		hong.name = "홍창표";
		hong.age=30;
		hong.height=179;
		hong.weight=300;
		System.out.println(hong.name + hong.age + hong.height + hong.weight);
		hong.talk();
		hong.walk();
		hong.showInfo();
	}
}
