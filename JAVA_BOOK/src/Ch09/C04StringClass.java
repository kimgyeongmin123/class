package Ch09;

public class C04StringClass {
	public static void main(String[] args) {
		
		String str1 = "java";
		String str2 = "java";
		
		String str3 = new String("java");
		String str4 = new String("java");
		
		System.out.println("str1 = str2 : "+(str1==str2));	//T
		System.out.println("str3 = str4 : "+(str3==str4));	//F
		System.out.println("str1 = str3 : "+(str1==str3));	//F
		System.out.println("str1 = str4 : "+(str1==str4));	//F
		
		//equals 메서드 사용하여 문자열 자체 비교하기
		System.out.println("----------------------");
		System.out.println("str1 == str2 : "+(str1.equals(str2)));
		System.out.println("str3 == str4 : "+(str3.equals(str4)));
		System.out.println("str1 == str3 : "+(str1.equals(str3)));
		System.out.println("str1 == str4 : "+(str1.equals(str4)));
		
	}
}
