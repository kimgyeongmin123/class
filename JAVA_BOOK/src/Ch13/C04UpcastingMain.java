package Ch13;

class Super
{
	int n1;
}

class Sub extends Super
{
	int n2;
}

public class C04UpcastingMain {
	public static void main(String[] args) {
		
		//NoCasting
		Super ob1 = new Super();
		ob1.n1 = 10;
		Sub ob2 = new Sub();
		ob2.n1 = 20;
		ob2.n2 = 20;
		
		//UpCasting 상속받은 모든 객체를 연결
		//상위클래스형 참조변수에 하위객체를 연결
		//왼쪽의 자료형(Super)으로 자동형변환
		Super ob3 = new Sub();
		ob3.n1 = 10;
		
		//DownCasting 업캐스팅을 전제로 한다.
		//하위클래스형 참조변수에 상위클래스형 객체 연결
		//강제형변환
		Sub down = (Sub)ob3;	//자료형이 다르다 컴파일러가 문제가 잇다고 판단하여 강제형변환필요
		down.n1 = 100;
		down.n2 = 200;
		
		
	}

}
