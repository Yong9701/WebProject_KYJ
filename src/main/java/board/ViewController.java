package board;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comment.CommentDAO;
import comment.CommentDTO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.BoardPage;

/*
 내용보기의 매핑은 web.xml이 아닌 어노테이션을 통해 설정한다.
 */
@WebServlet("/vsCode/board-view.do")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 서블릿의 수명주기 메서드 중 전송방식에 상관없이 요청을 처리하고 싶을때는
	 service()를 오버라이딩 하면된다. 해당 메서드의 역할은 요청을 분석한 후
	 doGet() 혹은 doPost()를 호출하는 것이다.
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		BoardDAO dao = new BoardDAO();
		// 파라미터로 전달된 일련번호 받기
		String idx = req.getParameter("idx");
		// 게시물 인출
		BoardDTO dto = dao.selectView(idx);
		dao.close();
		
		String ext = null, fileName = dto.getSfile(), mimeType =null;
	      if(fileName!=null) {
	         ext = fileName.substring(fileName.lastIndexOf(".")+1);
	      }

		String[] extArray1 = {"png", "jpg", "gif"};
	    String[] extArray2 = {"mp3", "wav"};
	    String[] extArray3 = {"mp4", "avi", "wmv"};
	      
	      List<String> mimeList1 = Arrays.asList(extArray1);
	      List<String> mimeList2 = Arrays.asList(extArray2);
	      List<String> mimeList3 = Arrays.asList(extArray3);
	      
	      if (mimeList1.contains(ext)) 
	         mimeType = "img";
	      else if(mimeList2.contains(ext))
	         mimeType = "audio";
	      else if(mimeList3.contains(ext))
	         mimeType = "video";
		
		/*
		 내용의 경우 Enter를 통해 줄바꿈을 하게되므로 웹브라우저 출력시
		 <br>태그로 변경해야한다.
		 */
		dto.setContent(dto.getContent().replace("\r\n", "<br/>"));
		
		// 게시물이 저장된 DTO객체를 request영역에 저장하고 JSP로 포워드한다.
		req.setAttribute("dto", dto);
		req.setAttribute("mimeType", mimeType);
		req.getRequestDispatcher("/vsCode/board-view.jsp").forward(req, resp);
	}

}
