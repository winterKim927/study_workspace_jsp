package notice.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.domain.Notice;
import notice.repository.NoticeDAO;

public class WriteServlet extends HttpServlet{
	NoticeDAO dao;
	public WriteServlet() {
		dao = new NoticeDAO();
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		
		Notice dto = new Notice();
		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setContent(content);
		int result = dao.insert(dto);
		PrintWriter out = resp.getWriter();
		out.print("<script>");
		if(result > 0) {
			out.print("alert('글 등록 완료');");
			out.print("location.href='list.jsp'");
		} else {
			out.print("alert('글 등록 실패');");
			out.print("history.back()'");
		}
		out.print("</script>");
	}
}
