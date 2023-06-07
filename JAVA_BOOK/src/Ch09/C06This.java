package Ch09;

//this
//클래스 내에서 사용되는 예약어
//생성되는 개체의 위치정보(메모리주소)를 가져오는데 사용

class A
{
	A getThis()
	{
		return this;
	}
}

class C06Simple
{
	int x;
	int y;
	C06Simple(){
		System.out.println("C06Simple() 호출!");
	}
	C06Simple(int x){
		this.x = x;
		this.y = 0;
		System.out.println("C06Simple(int x) 호출!");
		
	}
	C06Simple(int x, int y){
		this.x = x;
		this.y = y;
		System.out.println("C06Simple(int x, int y) 호출!");
		
	}
}

public class C06This {
	public static void main(String[] args) {
		
		A ob = new A();
		System.out.println(ob);
		System.out.println(ob.getThis());
		
		C06Simple ob1 = new C06Simple();
		C06Simple ob2 = new C06Simple(100);
		C06Simple ob3 = new C06Simple(100,200);
	}
}
