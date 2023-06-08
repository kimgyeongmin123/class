package Ch13;

//메서드 오버라이딩(함수 재정의)
//상속관계에서 상위클래스의 메서드를 하위클래스가 재정의(고쳐서사용)하는 것을 허용하는 문법
//메서드의 헤더부분은 동일하게두고 바디({})의 로직을 다르게 함으로써 같은 상위클래스로부터
//물려받은 메서드의 로직을 다양하게 들수있다(다형성)

class Animal
{
	public void Sound()
	{
		System.out.println("소리를 냅니다.");
	}
}

class Dog extends Animal
{
	public void Sound()
	{
		System.out.println("워렁뤙ㄹ우렁뤙뤄!!!월우렁러ㅜㄹ!!!!");
	}
}

class Cat extends Animal
{
	public void Sound()
	{
		System.out.println("우아ㅏ아애애ㅐ애애ㅐ애애앵옹 키야아ㅏ아아");
	}
}

public class C03OverridingMain {
	public static void main(String[] args) {
		
		Animal ani = new Animal();
		Dog poppi = new Dog();
		Cat navi = new Cat();
		
		ani.Sound();
		poppi.Sound();
		navi.Sound();
	}

}
