package Ch08Ex;

public class C01Ex {
	
	//다음 클래스의 속성과 기능을 분류해보세요(자유롭게~)
	
	//나무
	//속성 : 뿌리, 잎, 가지, 열매, 나이테
	//기능 : 광합성, 물흡수, 광분해, 합성
	
	//자동차
	//속성 : 바퀴, 창문, 문, 엔진오일, 에어컨
	//기능 : 간다, 멈춘다, 경적을 울린다
	
	//에어컨
	//속성 : 전기, 엔진, 버튼, 리모콘
	//기능 : 바람을 내뿜는다, 바람을 멈춘다
	
	//사람
	//속성 : 좌뇌, 우뇌, 콩팥, 대장, 혈액, 마이오신, 체세포
	//기능 : 소화한다, 생각한다, 혈액순환한다, 유전한다
	
	//다음 main함수의 코드가 실행될수있도록 C01Cal 클래스를 만드세요
	
	public static void main(String[] args) {
		C01Car kimcar = new C01Car();
		kimcar.owner = "김경민";
		kimcar.speed=0;
		kimcar.fuel=100;
		System.out.printf("%s %d %d\n", kimcar.owner,kimcar.speed,kimcar.fuel);
	}
}
