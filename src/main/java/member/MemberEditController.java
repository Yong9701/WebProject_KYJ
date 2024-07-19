package member;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JSFunction;

@WebServlet("/vsCode/user-edit.do")
public class MemberEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.selectView(id);
		req.setAttribute("id", id);
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/vsCode/user-edit.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPass(pass);
		dto.setName(name);
		dto.setEmail(email);
		dto.setTel(tel);
		
		MemberDAO dao = new MemberDAO();
		int result = dao.updateUser(dto);
		dao.close();
		
		if(result == 1) {
			JSFunction.alertLocation(resp, "정보수정에 성공했습니다.", "../vsCode/user-edit.do?id="+ id);
		} else {
			JSFunction.alertLocation(resp, "정보수정에 실패했습니다.", "../vsCode/user-edit.do?id="+ id);
		}
	}
}
