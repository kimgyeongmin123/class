package Ch11Ex;

import java.util.Scanner;

//5 명의 학생에 국영수점수를 입력받아 2차원배열 저장
//각 학생의 국영수 점수의 합/평균 구하고
//각 과목당 합/평균 구해보세요.

public class C02Ex {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int score[][] = new int[5][3];	//행 : 5명의 학생, 열 : 국영수
		for(int i=0;i<score.length;i++)
		{
			System.out.println((i+1)+"번째 학생의 국영수 점수를 입력하세요.");
			for(int j=0;j<score[i].length;j++)
			{
				score[i][j] = sc.nextInt();
			}
		}
		
		System.out.println();
		
		//각 학생별(행 별) 국영수 총합/평균
		int stdsum[] = new int[5];
		double stdavg[] = new double[5];
		
		for(int i=0;i<score.length;i++)
		{
			for(int j=0;j<score[i].length;j++)
			{
				stdsum[i] += score[i][j];	//총합
			}
			stdavg[i]=stdsum[i]/3;	//평균
			
			System.out.println((i+1)+"번째 학생의 총합과 평균 : "+stdsum[i]+"  "+stdavg[i]);
		}
		
		System.out.println("--------------------");
		//각 과목(열 별) 국영수 총합/평균
		int subsum[] = new int[3];	//0:국 //1:영 //2:수
		int subavg[] = new int[3];	//국영수 평균
		
		for(int i=0;i<subsum.length;i++)	//3번 반복 0~2
		{
			for(int j=0;j<score[i].length;j++)	//5번 반복 0~4
			{
				subsum[i] += score[j][i];	//국영수 총합
			}
			subavg[i]=subsum[i]/3;	//평균
			
			System.out.println((i+1)+"번째 과목의 총합과 평균 : "+subsum[i]+"  "+subavg[i]);
		}
		
		
		
	}

}
