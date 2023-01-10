package notice.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.domain.Notice;
import notice.repository.NoticeDAO;

public class updateServlet extends HttpServlet{
	NoticeDAO dao;
	public updateServlet() {
		dao = new NoticeDAO();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		Notice dto = new Notice();
		dto.setNotice_idx(Integer.parseInt(req.getParameter("notice_idx")));
		dto.setTitle(req.getParameter("title"));
		dto.setWriter(req.getParameter("writer"));
		dto.setContent(req.getParameter("content"));
		int result = dao.update(dto);
		PrintWriter out = resp.getWriter();
		out.print("<script>");
		if(result > 0) {
			out.print("alert('수정 완료');");
			out.print("location.href='list.jsp'");
		} else {
			out.print("alert('수정 실패');");
			out.print("history.back()'");
		}
		out.print("</script>");
	}
}
