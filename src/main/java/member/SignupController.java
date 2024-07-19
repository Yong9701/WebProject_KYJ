package member;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JSFunction;

public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		MemberDTO dto = new MemberDTO();
		dto.setId(req.getParameter("id"));
		dto.setPass(req.getParameter("pass"));
		dto.setName(req.getParameter("name"));
		dto.setEmail(req.getParameter("email"));
		dto.setTel(req.getParameter("tel"));
		
		MemberDAO dao = new MemberDAO();
		int result = dao.insertMember(dto);
		dao.close();
		
		if (result == 1) {
			JSFunction.alertLocation(resp, "회원가입에 성공했습니다.", "../vsCode/login.jsp");
		}
		else {
			JSFunction.alertLocation(resp, "회원가입에 실패했습니다.", "../vsCode/signup.jsp");
		}
	}

	
}
