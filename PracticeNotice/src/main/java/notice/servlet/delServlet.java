package notice.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.repository.NoticeDAO;

public class delServlet extends HttpServlet{
	NoticeDAO dao;
	public delServlet() {
		dao = new NoticeDAO();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		int notice_idx = Integer.parseInt(req.getParameter("notice_idx"));
		int result = dao.delete(notice_idx);
		PrintWriter out = resp.getWriter();
		out.print("<script>");
		if(result > 0) {
			out.print("alert('삭제 완료');");
			out.print("location.href='list.jsp'");
		} else {
			out.print("alert('삭제 실패');");
			out.print("history.back()'");
		}
		out.print("</script>");
	}
}
