package kr.smhrd.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAOMybatis {
	private static SqlSessionFactory sqlSessionFactory; // 프레임워크에서는 변수이름 쓸때 똑같이 불러와서 첫글자만 소문자로

	static { // static 은 초기화 블럭
		try {
			String resource = "kr/smhrd/mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// _static

	public List<BoardVO11> boardList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// mapper에있는 id를 찾아가서 sql문을 처리함 namespace나 id값으로할수잇음
		List<BoardVO11> list = sqlSession.selectList("boardList");
		sqlSession.close(); // 반납

		return list;
	}

	public int boardInsert(BoardVO11 vo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.insert("boardInsert", vo);
		sqlSession.commit();
		sqlSession.close();

		return cnt;
	}

	public int boardDelete(int idx) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.delete("boardDelete", idx);
		sqlSession.commit();
		sqlSession.close();

		return cnt;
	}

	public BoardVO11 boardContent(int idx) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BoardVO11 vo = sqlSession.selectOne("boardContent", idx);
		sqlSession.close();
		return vo;
	}

	public int boardUpdate(UserVO vo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.update("boardUpdate", vo);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

	public UserVO loginMember(UserVO vo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		vo = sqlSession.selectOne("loginMember", vo);
		sqlSession.close();
		return vo;

	}

	public int joinMember(UserVO vo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.insert("join", vo);
		sqlSession.commit();
		sqlSession.close();
		return cnt;

	}

	public int memberupdate(UserVO vo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.update("memberupdate", vo);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

}