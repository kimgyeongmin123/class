package Ch05;

import java.util.Scanner;

public class C05문제다 {
	public static void main(String[] args) {
	
		//국어 영어 수학 점수를 입력받아서
		//국어 점수가 40점이상
		//영어 점수가 40점이상
		//수학 점수가 40점이상 이면서 전체평균이 60점이상이면 합격을 출력
		//아니면 불합격을 출력
		//삼항연산자만 이용하기
		
		int kor, eng, math;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("국어 점수 : ");
		kor = sc.nextInt();
		System.out.println("영어 점수 : ");
		eng = sc.nextInt();
		System.out.println("수학 점수 : ");
		math = sc.nextInt();
		
		double avg = (double)(kor+eng+math)/3; 
		
		System.out.print("결과 : ");
		System.out.println((kor>=40 && eng>=40 && math>=40 & avg>=60) ? "합격" : "불합격");
		
	}
}
