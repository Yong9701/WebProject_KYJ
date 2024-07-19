package qnaboard;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.MemberDAO;
import member.MemberDTO;
import utils.JSFunction;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 1,
		maxRequestSize = 1024 * 1024 * 10
)
public class QnaEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String idx = req.getParameter("idx");
		QnaBoardDAO dao = new QnaBoardDAO();
		QnaBoardDTO dto = dao.selectView(idx);
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/vsCode/qna-edit.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String idx = req.getParameter("idx");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String ofile = req.getParameter("ofile");
		String sfile = req.getParameter("sfile");
		QnaBoardDTO dto = new QnaBoardDTO();
		dto.setIdx(idx);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setOfile(ofile);
		dto.setSfile(sfile);
		
		QnaBoardDAO dao = new QnaBoardDAO();
		int result = dao.updatePost(dto);
		dao.close();
		
		if(result == 1) {
			JSFunction.alertLocation(resp, "정보수정에 성공했습니다.", "../vsCode/qna-view.do?idx="+ idx);
		} else {
			JSFunction.alertLocation(resp, "정보수정에 실패했습니다.", "../vsCode/qna-edit.do?idx="+ idx);
		}
	}
}
