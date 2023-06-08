package Ch14;

class Par1
{	
	void Func()	//완성형 메소드
	{
		
	}
}

class Son1 extends Par1
{
	void Func()	
	{
		System.out.println("Son1에서 재정의한 Func() 호출!");
	}
}

abstract class Par2
{
	abstract void Func();	//추상메서드(미완성된 메서드)
}

class Son2 extends Par2	
{

	@Override
	void Func() {
		System.out.println("Son2에서 강제로 재정의한 Func() 호출!");
		
	}
	
}

public class C01AbstractMain {
	public static void main(String[] args) {
		
		Par1 ob1 = new Par1();	//상위클래스 객체 생성 O
		Son1 ob2 = new Son1();	//하위클래스 객체 생성 O
		Par1 ob3 = ob2;			//UpCasting
		ob3.Func(); 			//상위 참조변수로 재정의한 하위객체 메서드 접근 O
		
//		Par2 ob4 = new Par2();	//추상클래스 객체 생성 X
		Son2 ob5 = new Son2();	//하위클래스 객체 생성(추상메서드를 재정의 해야가능)
		Par2 ob6 = ob5;			//UpCasting
		ob6.Func();
	}
}
