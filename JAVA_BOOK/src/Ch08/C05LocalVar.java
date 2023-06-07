package Ch08;

class C05Simple
{
	int num;	//멤버변수
	
	void Func1()
	{
		num = 5; 
		System.out.println("변수 num : "+num);
		int num=10; //지역변수 생성
		System.out.println("변수 num : "+num);
		num++;  //지역변수 num 증가
		System.out.println("변수 num : "+num);
		this.num++;	//멤버변수 1증가
		System.out.println("변수 num : "+this.num);
		//지역변수는 공간 소멸..
	}
	
	void Func2()
	{
		System.out.println("변수 num : "+num);
		
		if(true)
		{
			int num=20;
			System.out.println("변수 num : "+num);
		}
		System.out.println("변수 num : "+num);
	}
	
	void Func3()
	{
		System.out.println("변수 num : "+num);
		
		while(num>0)
		{
			int num=100;
			System.out.println("변수 num : "+num);
			break;
		}
		System.out.println("변수 num : "+num);
	}
}

public class C05LocalVar {
	public static void main(String[] args) {
		
		C05Simple obj = new C05Simple();
		
		System.out.println("---------------Func1--------------");
		obj.Func1();
		System.out.println("---------------Func2--------------");
		obj.Func2();
		System.out.println("---------------Func3--------------");
		obj.Func3();
	}
}
