package Ch08;

//클래시 선언시 생성자함수를 하나도 명시하지 않았을때는 디폴트 생성자가 주입이 되나
//하나 이상의 생성자 함수가 명시되면 디폴트생성자는 주입되지 않는다.

class C09Simple
{
	C09Simple(){} //디폴트 생성자
	C09Simple(int x){} //오버로딩된 생성자
}

public class C09ConstructorMain {
	public static void main(String[] args) {
		
		C09Simple obj = new C09Simple();
		
		
	}

}
