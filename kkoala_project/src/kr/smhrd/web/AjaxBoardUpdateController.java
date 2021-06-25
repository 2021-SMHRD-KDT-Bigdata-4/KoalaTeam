package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import kr.smhrd.model.BoardDAOMybatis;
import kr.smhrd.model.BoardVO11;
import kr.smhrd.model.UserVO;

public class AjaxBoardUpdateController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		String birth_date = request.getParameter("birth_date");
		String address = request.getParameter("address");
		
		
				
		UserVO vo = new UserVO(); 
				
		
		vo.setUser_name(user_name);
		vo.setPassword(password);
		vo.setBirth_date(birth_date);
		vo.setAddress(address);
		

		String view = null;
		
		BoardDAOMybatis dao = new BoardDAOMybatis();
		
		int cnt = dao.boardUpdate(vo);
		PrintWriter out = response.getWriter();
		out.println(cnt); // $.ajax() -> 형식적으로 응답 : success
		
		return null;
	}

}
