package Ch08Ex;

import java.util.Scanner;

class Sub
{
	int sub1(int x, int y)
	{
		System.out.println("sub1 실행");
		return x-y;
	}
	
	int sub2(int x, int y)
	{
		System.out.println("sub2 실행");
		if(x<y)
		{
			int tmp = x;
			x = y;
			y = tmp;
		}
		
		return x-y;
	}
	
	int sub3(int x, int y, int z) //100 500 200
	{
		System.out.println("sub3 실행");
		
		int max=x;
		
		if(max<y)
		{ 
			max=y;
			if(max<z)
			{
				max=z;
				return max-x-y;
			}
		return max-x-z;
		}else return max-y-z;
	}
}

class Mul
{
	Scanner sc = new Scanner(System.in);
	
	int mul1(int x, int y)
	{
		System.out.println("mul1 실행");
		return x*y;
	}
	
	int mul2(int x, int y, int z)
	{
		System.out.println("mul2 실행");
		return x*y*z;
	}
	
	void mul3()
	{
		System.out.println("mul3 실행");
		System.out.println("x와 y값을 입력하세요.");
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		System.out.println("mul3 에서의\nx : " + x + "\ny : " + y + "\nx*y : "+ x*y);
	}
}

public class C04SimpleMethod {
	public static void main(String[] args) {
		
		Sub subcal = new Sub();
		Mul mulcal = new Mul();
		
		int r1 = subcal.sub1(200,100);
		int r2 = subcal.sub2(100,200);		//큰수에서 작은수의 뺼셈결과를 반환
		int r3 = subcal.sub3(100,500,200);	//큰수에서 작은수의 뺄셈결과를 반환
		
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		
		int r4 = mulcal.mul1(10,20);		
		int r5 = mulcal.mul2(10,20,30);
		mulcal.mul3();						//내부에서 두개의 값을 받아 곱셈의 결과를 콘솔창에 출력
		
		System.out.println(r4);
		System.out.println(r5);
	}
}
