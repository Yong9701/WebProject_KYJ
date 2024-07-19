package member;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/vsCode/checkIdDuplicate.do")
public class CheckIdDuplicateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        
        // 클라이언트에서 보낸 id 파라미터 가져오기
        String id = request.getParameter("id");
        
        // 여기서는 가상의 메서드를 사용하여 id 중복 확인 로직을 대신합니다.
        boolean isDuplicate = checkId(id);
        
        if (isDuplicate) {
            out.print("duplicate");
        } else {
            out.print("available");
        }
    }
    
    private boolean checkId(String id) {
        MemberDAO dao = new MemberDAO();
        boolean result = dao.ischeckId(id);
        dao.close();
        
        return result;
    }
}