package Ch07;

import java.util.Scanner;

public class C01While {
	public static void main(String[] args) {
		//탈출 요건

//		int i=0; //1 탈출 변수
//		while(i<10) //2 탈출 조건식
//		{
//			System.out.println("HELLO WORLD");
//			i++; //3 탈출 연산식
//		}
		
		//1 부터 10까지 합 
		
//		int i=1; 		 
//		int sum=0;		// 누적 합 저장 변수
//		while(i<=10) 	 
//		{
//			System.out.println("i : "+i);
//			sum=sum+i;	 	//sum+=i;
//			i++; 			 
//		}
//		//System.out.println("종료 후 i : "+i);
//		System.out.println("1 부터 10까지 합 : " + sum);
		
		//문제
		//1부터 입력한 정수(N)까지 합 구하기
		
//		Scanner sc = new Scanner(System.in);
//		int n=sc.nextInt();
//		
//		int i=1; 
//		int sum=0;
//		while(i<=n)
//		{
//			sum+=i; //sum = sum+i;
//			i++;
//		}
//		System.out.printf("1부터 %d까지의 합 : %d\n", n,sum);
		
		//문제
		//N,M 을 입력받아서 N부터 M 까지의 합 구하기(N<M)
		
//		Scanner sc = new Scanner(System.in);
//		int n=sc.nextInt();
//		int m=sc.nextInt();
//		
//		if(n>m)
//		{
//			int tmp=n;
//			n=m;
//			m=tmp;
//		}
//		
//		int i=n; //초기값
//		int sum=0;
//		while(i<=m)
//		{
//			sum+=i;
//			i++;
//		}
//		System.out.printf("%d 부터 %d까지의 합 : %d\n",n,m,sum);
		
		//1-n 까지 수중에 짝수/홀수의 합을 각각 출력
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int i=1;	//탈출용 변수
		int sum=0;
		int odd=0;
		int even=0;
		
		while(i<=n)
		{
			System.out.println("i : "+i);
			sum += i;
			if(i%2==0) {
				even+=i;
			}else {
				odd += i;
			}
			i++;	//탈출을 위한 연산
		}
		System.out.println("sum : "+sum);
		System.out.println("짝수합 : "+even);
		System.out.println("홀수합 : "+odd);
		sc.close();
		
		
		
		
		//문제
		//구구단 2단 출력
		
//		int i=1;
//		while(i<10)
//		{
//			
//			System.out.printf("%d x %d = %d\n", 2,i,2*i);
//			i++;
//		}
		
		
		//문제
		//구구단 2단 출력(역순출력)
		
//		int i=9;
//		while(i>=1)
//		{
//			
//			System.out.printf("%d x %d = %d\n", 2,i,2*i);
//			i--;
//		}
		
		//문제
		//구구단 N단 출력(입력받기)
		
//		Scanner sc = new Scanner(System.in);
//		int n=sc.nextInt();
//		
//		int i=1;
//		while(i<10)
//		{
//			
//			System.out.printf("%d x %d = %d\n", n,i,n*i);
//			i++;
//		}
		
		//문제
		//구구단 N단 출력(입력받기,역순출력) (별첨 ...2<=N<=9)
		
//		Scanner sc = new Scanner(System.in);
//		int n=sc.nextInt();
//		
//		int i=9;
//		while(i>0)
//		{
//			
//			System.out.printf("%d x %d = %d\n", n,i,n*i);
//			i--;
//		}
		
		
		//문제
		//프로그램 사용자로부터 양의 정수를 하나 입력 받은 다음, 그 수만큼 3의 배수를 출력하는
		//프로그램을 작성
		//ex. 5를 입력 받았다면 3, 6, 9, 12, 15 를 출력
		
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int i = 1;
//		String stack="";
//		while(i<=n)
//		{
//			if(i<n) {
//				System.out.print(i*3+",");
//			}else {
//				System.out.print(i*3);
//			}
//			i++;
//		}


		//문제
		//1부터 100까지 수중에 짝수의 합과 홀수의 합을 각각 구해서 출력하세요

//		Scanner sc = new Scanner(System.in);
//		int i=1;
//		int evensum=0;
//		int oddsum=0;
//		while(i<=100) {
//			if(i%2==0) {
//				//System.out.println("짝수 i = " + i);
//				evensum+=i; 		// evensum  = evensum + i
//			}else {
//				//System.out.println("홀수 i = " + i);
//				oddsum+=i;			// oddsum = oddsum + i 
//			}
//			i++;
//		}
//		System.out.println("짝수 합 : " + evensum);
//		System.out.println("홀수 합 : " + oddsum);

		
		//문제
		//1부터 N까지 수중에 짝수의 합과 홀수의 합을 각각 구해서 출력하세요

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int i=1;
//		int evensum=0;
//		int oddsum=0;
//		while(i<=n) {
//			if(i%2==0) {	
//				evensum+=i; 		// evensum  = evensum + i
//			}else {
//				oddsum+=i;			// oddsum = oddsum + i 
//			}
//			i++;
//		}
//		System.out.println("짝수 합 : " + evensum);
//		System.out.println("홀수 합 : " + oddsum);
		
		
		
		
		//문제
		//1부터 100까지 수중에 3의 배수는 제외한 합을 구해서 출력해보세요
		
//		Scanner sc = new Scanner(System.in);
//		int i=1;
//		int sum=0;
//		while(i<=100) {
//			if(i%3!=0) {
//				sum+=i; //3배수가 아닌경우 실행코드
//			}
//			i++;
//		}
//		System.out.println(sum);
		
		//문제 
		//문자열을 입력받아서 각문자를 거꾸로 출력해봅시다(같이 풉니다)
		//입력 : apple
		//출력 : elppa
		
		
//		String str = "안녕?";
//		System.out.println("길이 : " + str.length());
//		
//		str = str+"나는 ";
//		System.out.println("길이 : " + str.length());
		
		
		
//		Scanner sc = new Scanner(System.in);
//		
//		String str1 = sc.nextLine();
//	 
//		int len = str1.length()-1;
//		String r="";
//		System.out.println("길이 : " +len);
//		while(len>=0) {
//			//System.out.print(str1.charAt(len)); // O
//			r+=str1.charAt(len);
//			len--;	
//		}
//		System.out.println(r);
		
		//n - m 까지의 합을 구합니다.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두 값을 입력하세요. 띄어쓰기나 엔터로 구분합니다.");
		int n = sc.nextInt();
		int m = sc.nextInt();
		int sum=0;
		
		if(n>m) {
			int tmp =n;
			n = m;
			m = tmp;
		}
		
		while(n<=m)
		{
			sum+=n;
			n++;
		}
		
		System.out.println(sum);
		
		sc.close();
	}
}
