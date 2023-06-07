package Ch10;

class TV
{
	BasicController basicController;
	ExtraController extraController;
	TV()
	{
		basicController = new BasicController();
		extraController = new ExtraController();
	}
	
	class BasicController
	{
		//Basic Controller
	// - ON/OFF
	// - Change channel
	// - SetVolumn
		ONOFF onoff;
		Channel channel;
		Volumn volumn;
		
		
	}
	
	class ONOFF
	{
		void ON() {}
		void OFF() {}
		
	}
	
	class Channel
	{
		void setChannel(Channel channel) {}
	}
	
	class Volumn
	{
		void setVolumn(Volumn channel) {}
	}
	
	class ExtraController
	{
		//Extra Controller
	//Module - InternetSearching
	}
	
}

public class C02FunctionRef {
	public static void main(String[] args) {
		
		
	}
}
