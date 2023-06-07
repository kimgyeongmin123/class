package Ch09;

//캡슐화
//특정 목적을 가지는 기능 구현하는데 있어서 각 과정의 일부나 전부가 외부로의 노출이
//불필요한 경우는 정보은닉(private)을 포함하여 각 과정을 세부기능들의 순서를 지정하여
//사용가능한 함수로 지정하는데 이를 캡슐화라고 한다.

class C02Engine
{
	private void 흡입() {System.out.println("외부로부터 공기를 흡입");}
	private void 압축() {System.out.println("공기를 압축");}
	private void 폭발() {System.out.println("폭발");}
	private void 배기() {System.out.println("배기");}
	
	//캡슐화
	public void EngineStart()
	{
		흡입();
		압축();
		폭발();
		배기();
	}
}

class C02Car
{
	C02Engine engine = new C02Engine();  //자동차 객체를 만드는 순간 엔진클래스로 바로 연결한다.
	void run()
	{
		//핸들기능 활성화
		//사이드미러 활성화
		//엔진 동작
		engine.EngineStart();
		
	}
}

public class C02Capsulation {
	public static void main(String[] args) {
		
		C02Car hongCar = new C02Car();
		hongCar.run();
	}
}
