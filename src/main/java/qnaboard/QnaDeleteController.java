package qnaboard;

import java.io.IOException;

import fileupload.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.JSFunction;

/*
 비회원제 게시판은 인증절차 없이 누구나 들어올 수 있으므로 수정, 삭제를
 위해서는 본인 확인 절차가 필요하다. 따라서 패스워드를 통해 검증한 후 
 수정 혹은 삭제 처리를 해야한다.
 */
@WebServlet("/vsCode/qna-delete.do")
public class QnaDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 검증 페이지로 진입할때는 링크를 통해서 하게되므로 get방식의 요청을 처리하면된다.
	 진입시 파라미터로 전달되는 mode와 일련번호를 받아야한다.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String idx = req.getParameter("idx");
		QnaBoardDAO dao = new QnaBoardDAO();
		QnaBoardDTO dto = dao.selectView(idx);
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/vsCode/qna-delete.jsp").forward(req, resp);
	}

	// 패스워드 검증 페이지에서 전송한 값을 통해 레코드 검증
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 전송된 파라미터 받기
		String idx = req.getParameter("idx");
		
		QnaBoardDAO dao = new QnaBoardDAO();
		QnaBoardDTO dto = dao.selectView(idx);
		// 게시물 삭제 처리
		int result = dao.deletePost(idx);
		dao.close();
		// 게시물이 삭제되었다면 ..
		if (result == 1) {
			// DB에 저장된 파일명을 인출한 후 ..
			String saveFileName = dto.getSfile();
			// 서버에서 파일을 삭제한다.
			FileUtil.deleteFile(req, "/Uploads", saveFileName);
			JSFunction.alertLocation(resp, "삭제되었습니다.", "../vsCode/qna-list.do");
		}
		else {
			JSFunction.alertLocation(resp, "삭제에 실패했습니다.", "../vsCode/qna-delete.do");
		}
	}
}
