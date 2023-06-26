package Tests.DaoTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import Domain.Common.Dao.BookDao;
import Domain.Common.Dao.LendDao;
import Domain.Common.Dao.MemberDao;
import Domain.Common.Dto.BookDto;
import Domain.Common.Dto.LendDto;
import Domain.Common.Dto.MemberDto;

public class DaoTests {

	@Test
	public void MemberDaoTest1() {
		BookDao dao = new BookDao();
		// 객체연결 여부 확인 Test함수
		assertNotNull(dao); // 낫널인지 확인
	}

	@Test
	public void BookDaoTest2_insert() throws Exception {
		BookDao dao = new BookDao();
		assertNotNull(dao);
		int result = dao.insert(new BookDto(1, "JAVA의 정석", "A출판사", "1111"));
		assertEquals(1, result); // 기대값,실제값을 비교해서 다르면 에러
	}

	@Test
	public void BookDaoTest3_insert_post100() throws Exception {
		BookDao dao = new BookDao();
		assertNotNull(dao);
		int result = 0;
		for (int i = 1; i < 100; i++) {
			result += dao.insert(new BookDto(i + 1, "JAVA의 정석" + i, "A출판사", "1111" + i));
		}
		assertEquals(99, result); // 기대값,실제값을 비교해서 다르면 에러
	}

	@Test
	public void BookDaoTest4_select() throws Exception {
		BookDao dao = new BookDao();
		assertNotNull(dao);

		List<BookDto> list = dao.select();
		assertNotNull(list);

		list.stream().forEach((dto) -> {
			System.out.println(dto);
		});
	}

	@Test
	public void BookDaoTest5_select_bookcode() throws Exception {
		BookDao dao = new BookDao();
		assertNotNull(dao);

		List<BookDto> dto = dao.select(10);
		assertNotNull(dto);

		System.out.println(dto);

	}

	// MemberDao----------------------------------------------------------------------------------
	@Test
	public void MemberDaoTest1_insert() throws Exception {
		MemberDao dao = new MemberDao();
		assertNotNull(dao);
		int result = dao.insert(new MemberDto("user1", "1111", "홍길동", "ROLE_USER"));
		assertEquals(1, result); // 기대값,실제값을 비교해서 다르면 에러
	}

	@Test
	public void MemberDaoTest2_update() throws Exception {
		MemberDao dao = new MemberDao();
		assertNotNull(dao);
		int result = dao.update(new MemberDto("user1", "1234", "hong", "ROLE_MEMBER"));
		assertEquals(1, result); // 기대값,실제값을 비교해서 다르면 에러
	}

	@Test
	public void MemberDaoTest3_delete() throws Exception {
		MemberDao dao = new MemberDao();
		assertNotNull(dao);
		int result = dao.delete("");
		assertEquals(1, result); // 기대값,실제값을 비교해서 다르면 에러
	}

	@Test
	public void MemberDaoTest4_postMember() throws Exception {
		MemberDao dao = new MemberDao();
		assertNotNull(dao);
		int result = 0;
		for (int i = 1; i < 5; i++) {
			result += dao.insert(new MemberDto("user" + i, "1234", "username" + i, "ROLE_USER"));
		}
		for (int i = 6; i < 10; i++) {
			result += dao.insert(new MemberDto("member" + i, "1234", "membername" + i, "ROLE_MEMBER"));
		}
		assertEquals(10, result);
	}

	@Test
	public void MemberDaoTest5_select() throws Exception {
		MemberDao dao = new MemberDao();
		assertNotNull(dao);
		List<MemberDto> list = dao.select();

		list.stream().forEach((dto) -> {
			System.out.println(dto);
		});
	}
	//LendDao----------------------------------------------------------------------------------------
	@Test
	public void LendDaoTest1_insert() throws Exception{
		LendDao dao = new LendDao();
		assertNotNull(dao);
		
		LendDto dto = new LendDto();
		dto.setBookcode(1);
		dto.setId("aab");
		int result = dao.insert(dto);
		
		assertEquals(1,result);
	}
}
