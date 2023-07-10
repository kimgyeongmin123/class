package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import Domain.Common.Dao.CommentDao;
import Domain.Common.Dao.CommentDaoImpl;
import Domain.Common.Dao.MemberDao;
import Domain.Common.Dao.MemberDaoImpl;
import Domain.Common.Dto.BoardDto;
import Domain.Common.Dto.CommentDto;
import Domain.Common.Dto.MemberDto;

class DaoTests {

	@Test
	void Test1_CommentDaoTest() throws Exception {
		CommentDao dao = CommentDaoImpl.getInstance();
		assertNotNull(dao);

		// 댓글 정보 생성
		CommentDto commentDto = new CommentDto();
		commentDto.setNumber(1); // 보드 번호
		commentDto.setComment("개빡치네");
		commentDto.setId("JWG");

		// 보드 정보 생성
		BoardDto boardDto = new BoardDto();
		boardDto.setNumber(1); // 보드 번호

		int result = dao.insert(boardDto, commentDto);
		assertEquals(1, result); // 삽입된 레코드 수 확인
	}

	@Test
	void Test2_CommentDaoTest() throws Exception {
		CommentDao dao = CommentDaoImpl.getInstance();
		assertNotNull(dao);

		// 보드 정보 생성
		BoardDto boardDto = new BoardDto();
		boardDto.setNumber(1); // 보드 번호

		// 새로운 댓글 생성
		CommentDto commentDto = new CommentDto();
		commentDto.setNumber(boardDto.getNumber()); // 보드 번호

		// 수정할 댓글 정보 설정
		commentDto.setNo(commentDto.getNo()); // 생성된 댓글 번호
		commentDto.setId("JWG");
		commentDto.setComment("수정된 댓글 내용");

		// 댓글 수정
		int updateResult = dao.update(commentDto);
		assertEquals(1, updateResult); // 댓글 수정 결과 확인

	}

	// 회원 저장
	@Test
	void Test1_MemberDaoTest() throws Exception {
		MemberDao dao = MemberDaoImpl.getInstance();
		assertNotNull(dao);

		dao.insert(new MemberDto("망망3", "1234"));

	}

	// 회원 수정 (쓸지 안쓸지 고민중)
//	@Test
//	void Test2_MemberDaoTest() throws Exception{
//		MemberDao dao = MemberDao.getInstance();
//		assertNotNull(dao);
//		
//		dao.update(new MemberDto("망망2","123456"));
//	}

	// 회원 조회
	@Test
	void Test3_MemberDaoTest() throws Exception {
		MemberDao dao = new MemberDaoImpl();
		assertNotNull(dao);

		List<MemberDto> list = dao.select();
		assertNotNull(list);

		list.stream().forEach((dto) -> {
			System.out.println(dto);
		});
	}

	// 회원 삭제
	@Test
	void Test4_MemberDaoTest() throws Exception {
		MemberDao dao = new MemberDaoImpl();
		assertNotNull(dao);
		int result = dao.delete("망망2");
		assertEquals(1, result);
	}

}