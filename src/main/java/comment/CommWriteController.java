package comment;

import java.io.IOException;

import board.BoardDAO;
import board.BoardDTO;
import fileupload.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JSFunction;

@WebServlet("/vsCode/qna-comm.do")
public class CommWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 글쓰기 페이지로 진입할때는 다른 로직없이 포워드만 진행한다.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String idx = req.getParameter("idx");
		BoardDAO dao = new BoardDAO();
		BoardDTO dto2 = dao.selectView(idx);
		req.setAttribute("idx", idx);
		req.setAttribute("dto2", dto2);
		req.getRequestDispatcher("/vsCode/qna-view.jsp").forward(req, resp);
	}

	/*
	 글쓰기는 post방식의 전송이므로 doPost()에서 요청을 처리한다.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String idx = req.getParameter("idx"); // 댓글이 속하는 게시물의 idx
        String name = req.getParameter("name");
        String comm = req.getParameter("comm");
        
        CommentDTO dto2 = new CommentDTO();
        dto2.setBoardidx(idx); // 댓글이 속하는 게시물의 idx 설정
        dto2.setName(name);
        dto2.setComm(comm);
		System.out.println(idx+", "+ name+ ", "+ comm);
		// DAO를 통해 DB에 값을 입력한다.
		CommentDAO dao = new CommentDAO();
		int result = dao.insertWrite(dto2);
		dao.close();
		
		if (result == 1) {
			resp.sendRedirect("../vsCode/qna-view.do?idx="+ idx);
		}
		else { // 글쓰기 실패
			JSFunction.alertLocation(resp, "댓글 쓰기에 실패했습니다.", "../vsCode/qna-view.do?idx="+ idx);
		}
	}
	
	
}
