package Ch13Ex;

class TV
{
	private int size;
	public TV(int size)
	{
		this.size=size;
	}
	protected int getSize()
	{
		return size;
	}
}

class ColorTV extends TV
{
	int color;
	ColorTV(int inch, int color)
	{
		super(inch);
		this.color = color;
	}
	
	void printProperty()
	{
		System.out.printf("%d인치 %d컬러\n", getSize(), );
	}
}

public class C02UpDownCasting문제 {
	public static void main(String[] args) {
		
		
	}

}
