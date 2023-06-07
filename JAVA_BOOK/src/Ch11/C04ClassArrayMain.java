package Ch11;

class C04Person
{
	String name;
	int age;
	
	@Override
	public String toString() {
		return "C04Person [name=" + name + ", age=" + age + "]";
	}
}

public class C04ClassArrayMain {
	public static void main(String[] args) {
		
		C04Person list[] = new C04Person[3];	//클래스를 배열로 선언
		
		list[0] = new C04Person();
		list[1] = new C04Person();
		list[2] = new C04Person();
		
		list[0].name="홍학표";
		list[0].age=62;
		list[1].name="홍창표";
		list[1].age=30;
		list[2].name="경망고";
		list[2].age=24;
	}

}
