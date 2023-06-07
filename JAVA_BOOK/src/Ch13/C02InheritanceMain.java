package Ch13;

class Parent
{
	int x;
	int y;
	Parent()
	{
		System.out.println("Parent() 생성자 호출!");
	}
	Parent(int x)
	{
		this.x = x;
		System.out.println("Parent(int x) 생성자 호출!");
	}
	Parent(int x, int y)
	{
		this.x = x;
		this.y =y;
		System.out.println("Parent(int x, int y) 생성자 호출!");
	}
}

class Son extends Parent
{
	int z;
	Son()
	{
		super();	//상위클래스의 디폴트생성자(Parent())를 호출
		System.out.println("Son() 생성자 호출!");
	}
	Son(int x){
		super(x);
		System.out.println("Son(int x) 생성자 호출!");
		
	}
	Son(int x, int y){
		super(x, y);
	}
	Son(int x, int y, int z){
		super(x, y);	//맨앞에 써줘야한다.
		this.z = z;
	}
	
	@Override
	public String toString() {
		return "Son [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
}

public class C02InheritanceMain {
	public static void main(String[] args) {
		
		Son ob = new Son(5,5,6);
		System.out.println(ob.toString());
	}
}
