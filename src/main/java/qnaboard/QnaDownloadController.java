package qnaboard;

import java.io.IOException;

import fileupload.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/vsCode/qnadownload.do")
public class QnaDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 파일 다운로드 링크를 통해 전달되는 3개의 파라미터 받기
		String ofile = req.getParameter("ofile");
		String sfile = req.getParameter("sfile");
		
		// 다운로드 메서드 호출 및 파일 다운로드
		FileUtil.download(req, resp, "/Uploads", sfile, ofile);
		
	}

}

