package kr.smhrd.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardDAO;
import kr.smhrd.model.BoardDAOMybatis;
import kr.smhrd.model.BoardVO11;
import kr.smhrd.model.UserVO;

public class BoardUpdateController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		request.setCharacterEncoding("utf-8");

		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		String birth_date = request.getParameter("birth_date");
		String address = request.getParameter("address");

		int idx = Integer.parseInt(request.getParameter("idx"));

		UserVO vo = new UserVO();

		vo.setUser_name(user_name);
		vo.setPassword(password);
		vo.setBirth_date(birth_date);
		vo.setAddress(address);
		
		String view = null;

		BoardDAOMybatis dao = new BoardDAOMybatis();
		try {
			int cnt = dao.boardUpdate(vo);
			if (cnt > 0) {
//				response.sendRedirect("list.do");
				view = "redirect:/list.do";
			} else {
				throw new ServletException("error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return view;

	}

}
