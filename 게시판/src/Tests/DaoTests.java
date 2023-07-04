package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import Domain.Common.Dao.MemberDao;
import Domain.Common.Dto.MemberDto;

class DaoTests {

	//회원 저장
	@Test
	void Test1_MemberDaoTest() throws Exception{
		MemberDao dao = MemberDao.getInstance(); 
		assertNotNull(dao);
		
		dao.insert(new MemberDto("망망3","1234"));
		
		
	}
	
	//회원 수정 (쓸지 안쓸지 고민중)
//	@Test
//	void Test2_MemberDaoTest() throws Exception{
//		MemberDao dao = MemberDao.getInstance();
//		assertNotNull(dao);
//		
//		dao.update(new MemberDto("망망2","123456"));
//	}
	
	//회원 조회
	@Test
	void Test3_MemberDaoTest() throws Exception{
		MemberDao dao =new MemberDao();
		assertNotNull(dao);
		
		List<MemberDto> list = dao.select();
		assertNotNull(list);
		
		list.stream().forEach((dto)->{
			System.out.println(dto);
		} );
	}
	
	//회원 삭제
	@Test
	void Test4_MemberDaoTest() throws Exception{
		MemberDao dao =new MemberDao();
		assertNotNull(dao);
		int result = dao.delete("망망2");
		assertEquals(1,result);
	}

}