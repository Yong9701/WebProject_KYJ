package comment;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.BoardPage;

@WebServlet("/vsCode/comm-list.do")
public class CommListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 목록으로 진입은 get방식이므로 doGet() 메서드 오버라이딩
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		CommentDAO dao = new CommentDAO();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int totalCount = dao.selectCount(map);
		
		ServletContext application = getServletContext();
		
		int pageSize = 
				Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
		int blockPage = 
				Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));
		
		int pageNum = 1;
		String pageTemp = req.getParameter("pageNum");
		if (pageTemp != null && !pageTemp.equals(""))
			pageNum = Integer.parseInt(pageTemp);
		
		int start = (pageNum - 1) * pageSize + 1;
		int end = pageNum * pageSize;
		map.put("start", start);
		map.put("end", end);
		
		List<CommentDTO> commLists = dao.selectListPage(map);
		dao.close();
		
		String pagingImg = BoardPage.pagingStr(totalCount, pageSize, blockPage,
				pageNum, "../vsCode/qna-view.do");
		// 페이지번호
		map.put("pagingImg", pagingImg);
		// 전체 게시물의 갯수
		map.put("totalCount", totalCount);
		// 한 페이지에 출력할 게시물의 갯수
		map.put("pageSize", pageSize);
		// 현재 페이지 번호
		map.put("pageNum", pageNum);
		
		// View(JSP페이지)로 전달할 데이터를 request영역에 저장
		req.setAttribute("commLists", commLists);
		req.setAttribute("map", map);
		// 포워드
		req.getRequestDispatcher("/vsCode/qna-view.jsp").forward(req, resp);
	}
	

}
