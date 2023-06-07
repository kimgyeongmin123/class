package Ch08Ex;

public class C02CarMain {
	public static void main(String[] args) {
		
		//다음 main함수의 코드가 실행될수있도록 C01Car 클래스를 만드세요
		C02Car hongCar = new C02Car();
		hongCar.owner = "홍창표";
		hongCar.speed = 0;
		hongCar.fuel = 100;
		hongCar.Accel();
		hongCar.Break();	
		hongCar.ShowInfo();
	}
}
