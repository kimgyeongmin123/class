package Ch07;

public class C04For {
	public static void main(String[] args) {
		
//		int i = 0; //초기값
//		while (i < 10)//조건식 
//		{
//			System.out.println("HELLO WORLD");
//			i++;//증감연산식
//		}
		
		
//		for(int i=0;i<10;i++) {
//			System.out.println("HELLO WORLD");
//		}
		
		//1부터 10까지 합

//		int sum=0;
//		for(int i=1;i<=10;i++) {
//			sum+=i;
//		}
//		System.out.println("SUM = " + sum);
		
		//1부터 N까지 합
		//N부터 M까지 합
		//구구단 2단
		//구구단 N단
		//구구단 전체
		
//		int dan=9;
//		int i;
//		while(dan>=2)
//		{
//			i=9;
//			while(i>=1) 
//			{
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//				i--;
//			}
//			System.out.println();
//			dan--;
//		}	
//		int i;
//		int dan;
//		for(dan=9;dan>=2;dan--)
//		{
//			for(i=9;i>=1;i--) {
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//			}
//			
//			System.out.println();
//		}
		
		//별찍기
		
//		int i=0;
//		int j=0;
//		
//		for(i=0;i<4;i++) {
//			for(j=0;j<=i;j++)
//			{
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
//		while(i<4)
//		{
//			j=0;
//			while(j<=i) {
//				System.out.print("*");
//				j++;
//			}
//			
//			System.out.println();
//			i++;
//		}
		
		
		
//		Scanner sc = new Scanner(System.in);
//		int n=sc.nextInt();//작은수
//		int m=sc.nextInt();//큰수
//		
//		if(n>m)
//		{
//			int tmp=n;
//			n=m;
//			m=tmp;
//		}
//		int i;
//		int sum=0;
//		for(i=n;i<=m;i++) {
//			sum+=i;
//		}
//		System.out.println("SUM : " + sum);
		
		
		@
		int i=0;
		int j=0;
		int k=0;
		
		for(i=0;i<7;i++) {
			if(i<4)
			{
				//공백
				for(j=0;j<=2-i;j++) {
					System.out.print(" ");
				}
				//별
				for(k=0;k<=2*i;k++) {
					System.out.print("*");
				}
				
			}else 
			{
				//공백
				for(j=0;j<=i-4;j++)
				{
					System.out.print(" ");
				}
				//별
				for(k=0;k<=12-2*i;k++)
				{
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
