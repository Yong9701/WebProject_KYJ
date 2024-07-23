package board;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/vsCode/like.do")
public class LikeUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String idx = request.getParameter("idx");
        
        if (idx != null && !idx.isEmpty()) {
            BoardDAO dao = new BoardDAO();
            boolean result = dao.updateLikeCount(idx);
            
            // 클라이언트에게 응답 전송
            response.setContentType("application/json");
            response.getWriter().write("{\"success\": " + result + "}");
        } else {
            response.setContentType("application/json");
            response.getWriter().write("{\"success\": false}");
        }
    }
}
