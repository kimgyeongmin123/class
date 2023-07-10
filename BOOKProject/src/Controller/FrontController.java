package Controller;

import java.util.HashMap;
import java.util.Map;

public class FrontController {

	private Map<String,subController> map = new HashMap();
	//초기값 설정
	//사용자요구사항API Controller에 맞게 저장
	// /req_bookinfo에대한 요구사항은 BookController 전달
	
	private void init() {
		//도서정보 요구사항-Controller Mapping()
		// /RequestUri ServiceNo Param
		map.put("/book", new BookController());		
		map.put("/member", new MemberController());
		map.put("/lend", new LendController());
		
	}
	
	public FrontController(){
		init();
	}
	
	//request에 맞는 Controller를 추출,해당컨트롤러 실행
	//request , ServiceNo(1 select,2 insert , 3 update , 4 delete) , param
	public Map<String,Object> execute(String request,int ServiceNo ,Map<String,Object> param) {
		subController controller =map.get(request);
		result = controller.execute(ServiceNo,param);
		 
		  
		  return result;
		  
	}
	
	
}