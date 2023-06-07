package Ch10;

class 냉장고{
	디스플레이 display;
	냉장고(){
		display = new 디스플레이();
	}
	
	void InsertObject(int selectNo, String Object) {
		if(selectNo==1) {
			//냉장실
			display.controller.setSection1(Object);
		}else {
			//냉동실
			display.controller.setSection2(Object);
		}
	}
}
class 디스플레이{
	제어컨트롤러 controller;
	디스플레이(){
		controller = new 제어컨트롤러();
	}
	
	void showInfo() {
		System.out.println("냉장실정보 : " + controller.getSection1());
		System.out.println("냉동실정보 : " + controller.getSection2());
	}
	void setDegreeSection1(int val) {
		controller.setSection1(val);
	}
	void setDegreeSection2(int val) {
		controller.setSection2(val);
	}	
}

class 제어컨트롤러{
	냉장실 section1;
	냉동실 section2;
	
	제어컨트롤러(){
		section1 = new 냉장실();
		section2 = new 냉동실();
		
	}
	
	//냉장실 온도 조절
	void setSection1(int val) {
		section1.degree=val;
	}
	//냉장실 물건 넣기
	void setSection1(String obj) {
		section1.cnt++;
	}
	//냉동실 온도 조절
	void setSection2(int val) {
		section2.degree=val;
	}
	//냉동실 물건 넣기
	void setSection2(String obj) {
		section2.cnt++;
	}
	//냉장실 물건 개수/온도정보 
	String getSection1() {
		return "CNT : "+section1.cnt+"/DEGREE : "+section1.degree;
	}
	//냉동실 물건 개수확인
	String getSection2() {
		return "CNT : "+section2.cnt+"/DEGREE : "+section2.degree;
	}
}


class 냉장실{
	int cnt;
	int degree;
	냉장실(){
		cnt=0;
		degree=10;
	}
}
class 냉동실{
	int cnt;
	int degree;
	냉동실(){
		cnt=0;
		degree=0;
	}
}

public class C03FunctionRef {
	public static void main(String[] args) {
	
		냉장고 ref = new 냉장고();
		ref.display.showInfo();
		System.out.println("---------------");
		ref.display.setDegreeSection1(5);
		ref.display.setDegreeSection2(-10);
		ref.InsertObject(1, "사과");
		ref.InsertObject(1, "배즙");
		ref.InsertObject(2, "고등어");
		ref.display.showInfo();

	}

}